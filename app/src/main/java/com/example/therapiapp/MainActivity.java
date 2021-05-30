package com.example.therapiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // for testing purposes, go to Startseite activity after 10 seconds
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent startSeite = new Intent(MainActivity.this, Startseite.class);
                MainActivity.this.startActivity(startSeite);
                MainActivity.this.finish();
            }
        }, 2000);
    }
}