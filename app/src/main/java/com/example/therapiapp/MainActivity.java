package com.example.therapiapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anmeldung_1);
    }

    public void toStartseite(View v) {
        Intent intent = new Intent(this, Startseite.class);
        this.startActivity(intent);
    }
}