package com.example.therapiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Registrierung2 extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiry_registrierung_2);
        initToolbar();



    }

    public void handleBestaetigen(View view){
        Toast.makeText(this,"Sie haben den Code bestätigt",Toast.LENGTH_SHORT).show();
    }

}