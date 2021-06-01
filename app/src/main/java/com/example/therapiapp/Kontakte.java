package com.example.therapiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;

public class Kontakte extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontakte);

        Toolbar toolbar = findViewById(R.id.start_seite_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        toolbar.setNavigationIcon(R.drawable.ic_menu_button);
        toolbar.setNavigationOnClickListener(v -> {
            PopupMenu popup = new PopupMenu(this, v);
            MenuInflater inflater = popup.getMenuInflater();
            inflater.inflate(R.menu.nav_popup, popup.getMenu());
            popup.setOnMenuItemClickListener(MainActivity.mainMenuPopup);
            popup.show();
        });
    }

    public void toProfil(View v) {
        Intent intent = new Intent(this, Profil.class);
        this.startActivity(intent);
    }

    public void toHilfe(View v) {
        Intent intent = new Intent(this, Hilfe.class);
        this.startActivity(intent);
    }
}