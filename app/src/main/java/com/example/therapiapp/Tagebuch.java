package com.example.therapiapp;

import android.os.Bundle;

public class Tagebuch extends BaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tagesbuch);
        initToolbar();
    }
}
