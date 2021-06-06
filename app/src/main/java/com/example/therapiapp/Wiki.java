package com.example.therapiapp;

import android.os.Bundle;

public class Wiki extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wiki);
        initToolbar();
    }
}
