package com.example.therapiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    public static final MenuPopup mainMenuPopup = new MenuPopup();
    public static Intent startseiteIntent;
    public static Intent chatbotIntent;

    public static Context myContext;

    public static boolean chatBotPrivacyPolicyAcceptedForSave = false;
    public static boolean chatBotPrivacyPolicyAcceptedForUse = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        startseiteIntent = new Intent(MainActivity.this, Startseite.class);
        chatbotIntent = new Intent(MainActivity.this, ChatBot.class);

        myContext = MainActivity.this;

        // for testing purposes, go to Startseite activity after 10 seconds
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                MainActivity.this.startActivity(startseiteIntent);
                MainActivity.this.finish();
            }
        }, 2000);
    }
}