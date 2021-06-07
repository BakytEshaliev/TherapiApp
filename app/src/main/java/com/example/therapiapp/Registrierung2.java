package com.example.therapiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Registrierung2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiry_registrierung_2);
//        TextView bestaetigenTextView = findViewById(R.id.bestaetigenTextView);


    }

    public void handleBestaetigen(View view){
        System.out.println("Bestaetigen");
    }

}