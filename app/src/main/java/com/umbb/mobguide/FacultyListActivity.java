package com.umbb.mobguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.umbb.mobguide.adapter.FacultyAdapter;
import com.umbb.mobguide.data.DataProvider;
import com.umbb.mobguide.model.Faculty;

import java.util.ArrayList;

public class FacultyListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_list);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(R.string.faculties_title);
        }

        ArrayList<Faculty> faculties = DataProvider.getFaculties();
        FacultyAdapter adapter = new FacultyAdapter(this, faculties);

        ListView listView = findViewById(R.id.listViewFaculties);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Faculty faculty = faculties.get(position);
            Intent intent = new Intent(FacultyListActivity.this, FacultyDetailActivity.class);
            intent.putExtra("FACULTY_ID", faculty.getId());
            startActivity(intent);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        } else if (id == R.id.action_search) {
            startActivity(new Intent(this, SearchActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
