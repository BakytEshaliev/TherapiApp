package com.example.therapiapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Startseite extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startseite);
        initToolbar();
    }

    public void toChatBot(View v) {
        Intent intent = new Intent(this, ChatBot.class);
        this.startActivity(intent);
    }

    public void toTagebuch(View v) {
        Intent intent = new Intent(this, Tagebuch.class);
        this.startActivity(intent);;
    }

    public void toTagesziel(View v) {
        Intent intent = new Intent(this, Tagesziel.class);
        this.startActivity(intent);;
    }

    public void toUbungen(View v) {
        Intent intent = new Intent(this, Activities.class);
        this.startActivity(intent);;
    }

    public void toWiki(View v) {
        Intent intent = new Intent(this, Wiki.class);
        this.startActivity(intent);;
    }
}