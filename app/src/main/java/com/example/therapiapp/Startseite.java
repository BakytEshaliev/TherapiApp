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
}