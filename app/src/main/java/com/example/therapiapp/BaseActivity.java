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

    public static final String TAG = "State";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void initToolbar() {
        configureBottomToolbar("TherapieApp");
    }

    protected void initToolbar(String toolbarTitle) {
        configureBottomToolbar(toolbarTitle);
    }

    private void configureBottomToolbar(String title) {
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

        TextView titleTextView = (TextView) findViewById(R.id.toolbar_title);
        titleTextView.setText(title);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.startseite:
                intent = new Intent(this, Startseite.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                this.startActivity(intent);
                return true;
            case R.id.chat_bot:
                intent = new Intent(this, ChatBot.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                this.startActivity(intent);
                return true;
            case R.id.tagebuch:
                intent = new Intent(this, Tagebuch.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                this.startActivity(intent);;
                return true;
            case R.id.tagesziel:
                intent = new Intent(this, Tagesziel.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                this.startActivity(intent);;
                return true;
            case R.id.ubungen:
                intent = new Intent(this, Activities.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                this.startActivity(intent);;
                return true;
            case R.id.wiki:
                intent = new Intent(this, Wiki.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                this.startActivity(intent);;
                return true;
            case R.id.kontakte:
                intent = new Intent(this, Kontakte.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                this.startActivity(intent);
                return true;
            case R.id.einstellungen:
                intent = new Intent(this, Einstellungen.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                this.startActivity(intent);
                return true;
            default:
                return false;
        }
    }
    public void back(View view){
        onBackPressed();
    }


    public void handleReload(View view){
        finish();
        startActivity(getIntent());
    }
    public void handleHerzClick(View view){
        Intent intent = new Intent(this,NotfallKontakte.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
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
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                this.startActivity(intent);
                return true;
            case "profil":
                intent = new Intent(this, Profil.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                this.startActivity(intent);
                return true;
            default:
                return false;
        }
    }
}
