package com.umbb.mobguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.button.MaterialButton;
import com.umbb.mobguide.adapter.DepartmentAdapter;
import com.umbb.mobguide.data.DataProvider;
import com.umbb.mobguide.model.Department;
import com.umbb.mobguide.model.Faculty;

import java.util.ArrayList;

public class FacultyDetailActivity extends AppCompatActivity {

    private Faculty faculty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_detail);

        // ── Toolbar ──────────────────────────────────
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // ── Load data ────────────────────────────────
        int facultyId = getIntent().getIntExtra("FACULTY_ID", -1);
        faculty = DataProvider.getFacultyById(facultyId);

        if (faculty == null) {
            Toast.makeText(this, "Faculty not found", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(faculty.getName());
        }

        // ── Populate views ───────────────────────────
        TextView tvName        = findViewById(R.id.tvFacultyName);
        TextView tvDescription = findViewById(R.id.tvFacultyDescription);
        TextView tvAddress     = findViewById(R.id.tvFacultyAddress);
        TextView tvEmail       = findViewById(R.id.tvFacultyEmail);
        TextView tvPhone       = findViewById(R.id.tvFacultyPhone);

        tvName.setText(faculty.getName());
        tvDescription.setText(faculty.getDescription());
        tvAddress.setText(faculty.getAddress());
        tvEmail.setText(faculty.getEmail());
        tvPhone.setText(faculty.getPhone());

        // ── Action buttons ───────────────────────────
        MaterialButton btnCall   = findViewById(R.id.btnCall);
        MaterialButton btnEmail  = findViewById(R.id.btnEmail);
        MaterialButton btnSms    = findViewById(R.id.btnSms);
        MaterialButton btnLocate = findViewById(R.id.btnLocate);

        btnCall.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL,
                    Uri.parse("tel:" + faculty.getPhone()));
            startActivity(intent);
        });

        btnEmail.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO,
                    Uri.parse("mailto:" + faculty.getEmail()));
            intent.putExtra(Intent.EXTRA_SUBJECT, "Inquiry — " + faculty.getName());
            startActivity(Intent.createChooser(intent, getString(R.string.send_email)));
        });

        btnSms.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("smsto:" + faculty.getPhone()));
            intent.putExtra("sms_body", getString(R.string.sms_default_body));
            startActivity(intent);
        });

        btnLocate.setOnClickListener(v -> {
            String uri = String.format("geo:%f,%f?q=%f,%f(%s)",
                    faculty.getLatitude(), faculty.getLongitude(),
                    faculty.getLatitude(), faculty.getLongitude(),
                    Uri.encode(faculty.getName()));
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            intent.setPackage("com.google.android.apps.maps");
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                // Fallback: open in browser
                String mapsUrl = "https://maps.google.com/?q=" +
                        faculty.getLatitude() + "," + faculty.getLongitude();
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(mapsUrl)));
            }
        });

        // ── Departments list ─────────────────────────
        ArrayList<Department> departments = faculty.getDepartments();
        android.widget.LinearLayout llDepartments = findViewById(R.id.llDepartments);
        DepartmentAdapter deptAdapter = new DepartmentAdapter(this, departments);

        for (int i = 0; i < deptAdapter.getCount(); i++) {
            android.view.View view = deptAdapter.getView(i, null, llDepartments);
            final int position = i;
            view.setOnClickListener(v -> {
                Department dept = departments.get(position);
                Intent intent = new Intent(FacultyDetailActivity.this,
                        DepartmentDetailActivity.class);
                intent.putExtra("DEPARTMENT_ID", dept.getId());
                startActivity(intent);
            });
            llDepartments.addView(view);

            if (i < deptAdapter.getCount() - 1) {
                android.view.View divider = new android.view.View(this);
                android.widget.LinearLayout.LayoutParams params = new android.widget.LinearLayout.LayoutParams(
                        android.widget.LinearLayout.LayoutParams.MATCH_PARENT, 1);
                divider.setLayoutParams(params);
                divider.setBackgroundColor(getResources().getColor(R.color.divider));
                llDepartments.addView(divider);
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
