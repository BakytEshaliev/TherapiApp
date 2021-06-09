package com.example.therapiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AnmeldingErfolgreich extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anmeldunf_erfolgreich);
        initToolbar();
        MainActivity.setAnmeldungErfolgreich(true);
    }

    public void handleWeiter(View view){
        Intent intent = new Intent(this, Startseite.class);
        this.startActivity(intent);
    }

}