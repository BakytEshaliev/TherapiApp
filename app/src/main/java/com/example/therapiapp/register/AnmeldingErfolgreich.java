package com.example.therapiapp.register;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.therapiapp.BaseActivity;
import com.example.therapiapp.R;

public class AnmeldingErfolgreich extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anmeldunf_erfolgreich);
//        initToolbar();
    }

    public void handleWeiter(View view){
        Intent intent = new Intent(this, ZweckActivity.class);
        this.startActivity(intent);
        finish();
    }

}