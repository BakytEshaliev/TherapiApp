package com.example.therapiapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Kontakte extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontakte);
        initToolbar("Kontakte");
    }
    public void showNotfallkontakte(View view) {
        Intent intent = new Intent(this,NotfallKontakte.class);
        startActivity(intent);
    }
}