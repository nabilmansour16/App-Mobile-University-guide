package com.umbb.mobguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import com.umbb.mobguide.data.DataProvider;
import com.umbb.mobguide.model.Department;
import com.umbb.mobguide.model.Faculty;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    // Simple result wrapper to hold a label + type + id
    private ArrayList<SearchResult> allResults = new ArrayList<>();
    private ArrayList<SearchResult> filteredResults = new ArrayList<>();
    private SearchResultAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // ── Toolbar ──────────────────────────────────
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(R.string.search_title);
        }

        // ── Build flat search index ───────────────────
        for (Faculty f : DataProvider.getFaculties()) {
            allResults.add(new SearchResult(f.getName(),
                    getString(R.string.search_type_faculty), "FACULTY", f.getId(), -1));
            for (Department d : f.getDepartments()) {
                allResults.add(new SearchResult(d.getName(),
                        getString(R.string.search_type_department), "DEPARTMENT",
                        f.getId(), d.getId()));
            }
        }
        filteredResults.addAll(allResults);

        // ── Adapter ───────────────────────────────────
        adapter = new SearchResultAdapter(this, filteredResults);
        ListView listView = findViewById(R.id.listViewSearchResults);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            SearchResult result = filteredResults.get(position);
            Intent intent;
            if ("FACULTY".equals(result.type)) {
                intent = new Intent(this, FacultyDetailActivity.class);
                intent.putExtra("FACULTY_ID", result.facultyId);
            } else {
                intent = new Intent(this, DepartmentDetailActivity.class);
                intent.putExtra("DEPARTMENT_ID", result.departmentId);
            }
            startActivity(intent);
        });

        // ── SearchView ────────────────────────────────
        SearchView searchView = findViewById(R.id.searchView);
        searchView.setIconifiedByDefault(false);
        searchView.requestFocus();

        androidx.appcompat.widget.SearchView.SearchAutoComplete searchAutoComplete = searchView.findViewById(androidx.appcompat.R.id.search_src_text);
        if (searchAutoComplete != null) {
            searchAutoComplete.setTextColor(android.graphics.Color.BLACK);
            searchAutoComplete.setHintTextColor(android.graphics.Color.DKGRAY);
        }

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filter(query);
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return true;
            }
        });
    }

    private void filter(String query) {
        filteredResults.clear();
        if (query == null || query.trim().isEmpty()) {
            filteredResults.addAll(allResults);
        } else {
            String lower = query.toLowerCase().trim();
            for (SearchResult r : allResults) {
                if (r.name.toLowerCase().contains(lower)) {
                    filteredResults.add(r);
                }
            }
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // ── Inner classes ─────────────────────────────────

    static class SearchResult {
        String name;
        String typeLabel;
        String type;      // "FACULTY" or "DEPARTMENT"
        int facultyId;
        int departmentId;

        SearchResult(String name, String typeLabel, String type,
                     int facultyId, int departmentId) {
            this.name = name;
            this.typeLabel = typeLabel;
            this.type = type;
            this.facultyId = facultyId;
            this.departmentId = departmentId;
        }
    }
}
