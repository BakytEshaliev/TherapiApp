package com.example.therapiapp;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class KontactFormular extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontact_formular);
        initToolbar();
    }

    public void abbrechen(View v) {
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}