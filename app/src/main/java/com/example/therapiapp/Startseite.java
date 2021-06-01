package com.example.therapiapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

public class Startseite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startseite);

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

    public void toChatBot(View v) {
        this.startActivity(MainActivity.chatbotIntent);
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