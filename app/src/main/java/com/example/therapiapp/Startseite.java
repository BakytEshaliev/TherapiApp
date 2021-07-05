package com.example.therapiapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatDelegate;

public class Startseite extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG,"create Startseite");
        setContentView(R.layout.activity_startseite);
        initToolbar();
//        getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"destroy Startseite");
    }

    public void toChatBot(View v) {
        Intent intent = new Intent(this, ChatBot.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        this.startActivity(intent);
    }

    public void toTagebuch(View v) {
        Intent intent = new Intent(this, Tagebuch.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        this.startActivity(intent);;
    }

    public void toTagesziel(View v) {
        Intent intent = new Intent(this, Tagesziel.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        this.startActivity(intent);;
    }

    public void toUbungen(View v) {
        Intent intent = new Intent(this, Activities.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        this.startActivity(intent);;
    }

    public void toWiki(View v) {
        Intent intent = new Intent(this, Wiki.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        this.startActivity(intent);;
    }
}