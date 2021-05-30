package com.example.therapiapp;

import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

public class Startseite extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startseite);

        Toolbar toolbar = findViewById(R.id.start_seite_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("therapieapp");

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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.startseite_menu, menu);
        return true;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.chat_bot:
                System.out.println("chat_bot");
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
                System.out.println("kontakte");
                return true;
            case R.id.einstellungen:
                System.out.println("einstellungen");
                return true;
            default:
                return false;
        }
    }

    public void toChatBot(View v) {
        System.out.println("chat_bot");
    }

    public void toTagebuch(View v) {
        System.out.println("tagebuch");
    }

    public void toTagesziel(View v) {
        System.out.println("tagesziel");
    }

    public void toUbungen(View v) {
        System.out.println("ubungen");
    }

    public void toWiki(View v) {
        System.out.println("wiki");
    }

    public void toKontakte(View v) {
        System.out.println("kontakte");
    }

    public void toEinstellungen(View v) {
        System.out.println("einstellungen");
    }
}