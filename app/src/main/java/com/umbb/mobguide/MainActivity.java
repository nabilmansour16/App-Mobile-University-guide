package com.umbb.mobguide;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.button.MaterialButton;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialButton btnExplore = findViewById(R.id.btnExplore);
        btnExplore.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FacultyListActivity.class);
            startActivity(intent);
        });

        MaterialButton btnLangEn = findViewById(R.id.btnLangEn);
        MaterialButton btnLangAr = findViewById(R.id.btnLangAr);
        
        btnLangEn.setOnClickListener(v -> setLocale("en"));
        btnLangAr.setOnClickListener(v -> setLocale("ar"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_lang_ar) {
            setLocale("ar");
            return true;
        } else if (id == R.id.action_lang_en) {
            setLocale("en");
            return true;
        } else if (id == R.id.action_search) {
            startActivity(new Intent(this, SearchActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setLocale(String lang) {
        androidx.core.os.LocaleListCompat appLocale = androidx.core.os.LocaleListCompat.forLanguageTags(lang);
        androidx.appcompat.app.AppCompatDelegate.setApplicationLocales(appLocale);
    }
}
