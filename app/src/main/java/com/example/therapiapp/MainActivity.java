package com.example.therapiapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anmeldung_1);
        initToolbar();
    }

    public void toStartseite(View v) {
        Intent intent = new Intent(this, AnmeldingErfolgreich.class);
        this.startActivity(intent);
    }
    public void toRegister(View v) {
        Intent intent = new Intent(this, RegisterActivity.class);
        this.startActivity(intent);
    }
}