package com.example.therapiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;

public class ChatBot extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        if (MainActivity.chatBotPrivacyPolicyAcceptedForSave) {
            if (MainActivity.chatBotPrivacyPolicyAcceptedForUse) {
                setContentView(R.layout.activity_chat_bot);
            } else setContentView(R.layout.activity_chat_bot_privacy_use);
        } else setContentView(R.layout.activity_chat_bot_privacy_save);

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

    public void acceptPrivacyPolicySave(View v) {
        MainActivity.chatBotPrivacyPolicyAcceptedForSave = true;
        this.startActivity(MainActivity.chatbotIntent);
    }

    public void declinePrivacyPolicySave(View v) {
        this.startActivity(MainActivity.startseiteIntent);
    }

    public void acceptPrivacyPolicyUse(View v) {
        MainActivity.chatBotPrivacyPolicyAcceptedForUse = true;
        this.startActivity(MainActivity.chatbotIntent);
    }

    public void declinePrivacyPolicyUse(View v) {
        this.startActivity(MainActivity.startseiteIntent);
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