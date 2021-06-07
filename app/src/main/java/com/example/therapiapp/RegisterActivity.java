package com.example.therapiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

public class RegisterActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registrierung_1);
        initToolbar();
    }

    public void toDatenschutz(View view){
        Intent intent = new Intent(this, Datenschutz.class);
        this.startActivity(intent);
    }
    public void abbrechen(View view){
        finish();
    }

    public void toRegistrieren(View view){
        Intent intent = new Intent(this, Registrierung2.class);
        this.startActivity(intent);
    }

}