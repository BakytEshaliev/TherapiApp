package com.example.therapiapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

public abstract class BaseActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
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
            popup.setOnMenuItemClickListener(this);
            popup.show();
        });
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.startseite:
                Intent intent = new Intent(this, Startseite.class);
                this.startActivity(intent);
                return true;
            case R.id.chat_bot:
                intent = new Intent(this, ChatBot.class);
                this.startActivity(intent);
                return true;
            case R.id.tagebuch:
                System.out.println("tagebuch");
                return true;
            case R.id.tagesziel:
                System.out.println("tagesziel");
                return true;
            case R.id.ubungen:
                System.out.println("ubungen");
                return true;
            case R.id.wiki:
                System.out.println("wiki");
                return true;
            case R.id.kontakte:
                intent = new Intent(this, Kontakte.class);
                this.startActivity(intent);
                return true;
            case R.id.einstellungen:
                System.out.println("einstellungen");
                return true;
            default:
                return false;
        }
    }
    public void back(View view){
        onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_bottom_items_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        String selectedMenuIdString = (String) item.getTitleCondensed();
        switch (selectedMenuIdString) {
            case "hilfe":
                Intent intent = new Intent(this, Hilfe.class);
                this.startActivity(intent);
                return true;
            case "profil":
                intent = new Intent(this, Profil.class);
                this.startActivity(intent);
                return true;
            default:
                return false;
        }
    }
}
