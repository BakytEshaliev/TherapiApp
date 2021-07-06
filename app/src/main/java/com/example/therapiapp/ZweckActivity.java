package com.example.therapiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ZweckActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appnutzungszweck);
    }
    public void weiterClick(View view){
        Intent intent = new Intent(this,Startseite.class);
        startActivity(intent);
        finish();
    }
}