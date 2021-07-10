package com.example.therapiapp.other;

import android.os.Bundle;

import com.example.therapiapp.BaseActivity;
import com.example.therapiapp.R;

public class Einstellungen extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_einstellungen);
        initToolbar();
    }
}
