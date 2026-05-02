package com.umbb.mobguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.button.MaterialButton;
import com.umbb.mobguide.data.DataProvider;
import com.umbb.mobguide.model.Department;

public class DepartmentDetailActivity extends AppCompatActivity {

    private Department department;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_detail);

        // ── Toolbar ──────────────────────────────────
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // ── Load data ────────────────────────────────
        int deptId = getIntent().getIntExtra("DEPARTMENT_ID", -1);
        department = DataProvider.getDepartmentById(deptId);

        if (department == null) {
            Toast.makeText(this, "Department not found", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(department.getName());
        }

        // ── Populate views ───────────────────────────
        TextView tvName        = findViewById(R.id.tvDeptName);
        TextView tvDescription = findViewById(R.id.tvDeptDescription);
        TextView tvEmail       = findViewById(R.id.tvDeptEmail);
        TextView tvPhone       = findViewById(R.id.tvDeptPhone);

        tvName.setText(department.getName());
        tvDescription.setText(department.getDescription());
        tvEmail.setText(department.getEmail());
        tvPhone.setText(department.getPhone());

        // ── Specialties ──────────────────────────────
        LinearLayout specialtiesContainer = findViewById(R.id.specialtiesContainer);
        for (String specialty : department.getSpecialties()) {
            TextView tvSpecialty = new TextView(this);
            tvSpecialty.setText("• " + specialty);
            tvSpecialty.setTextSize(14f);
            tvSpecialty.setPadding(0, 8, 0, 8);
            tvSpecialty.setTextColor(getResources().getColor(R.color.text_primary, null));
            specialtiesContainer.addView(tvSpecialty);
        }

        // ── Action buttons ───────────────────────────
        MaterialButton btnCall  = findViewById(R.id.btnCall);
        MaterialButton btnEmail = findViewById(R.id.btnEmail);
        MaterialButton btnSms   = findViewById(R.id.btnSms);

        btnCall.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL,
                    Uri.parse("tel:" + department.getPhone()));
            startActivity(intent);
        });

        btnEmail.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO,
                    Uri.parse("mailto:" + department.getEmail()));
            intent.putExtra(Intent.EXTRA_SUBJECT, "Inquiry — " + department.getName());
            startActivity(Intent.createChooser(intent, getString(R.string.send_email)));
        });

        btnSms.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("smsto:" + department.getPhone()));
            intent.putExtra("sms_body", getString(R.string.sms_default_body));
            startActivity(intent);
        });
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
