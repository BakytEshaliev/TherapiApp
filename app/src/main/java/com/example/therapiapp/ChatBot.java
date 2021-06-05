package com.example.therapiapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;

public class ChatBot extends BaseActivity {

    public static boolean chatBotPrivacyPolicyAcceptedForSave = false;
    public static boolean chatBotPrivacyPolicyAcceptedForUse = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_bot);
        initToolbar();

        if (!ChatBot.chatBotPrivacyPolicyAcceptedForSave) askForDataSavePermission();
        if (!ChatBot.chatBotPrivacyPolicyAcceptedForUse) askForDataUsePermission();
    }

    private void askForDataSavePermission() {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        ChatBot.chatBotPrivacyPolicyAcceptedForSave = true;
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        finish();
                        break;
                }
            }
        };
        String message = "Bitte lies dir die folgende Hinweise genau durch und stimme dem nur zu, wenn du das möchtest. \n\nStimmst Du zu, dass deine Daten auf einem Server gespeichert werden, damit der Chatbotdementsprechend auf deine Antworten reagieren kann? Diese Einstellung kann jederzeit unter deinen Einstellungen aktiviert oder deaktiviert werden.";
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Hinweis").setMessage(message).setPositiveButton("Ja", dialogClickListener)
                .setNegativeButton("Nein", dialogClickListener).show();
    }

    private void askForDataUsePermission() {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        ChatBot.chatBotPrivacyPolicyAcceptedForUse = true;
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        finish();
                        break;
                }
            }
        };
        String message = "Bitte lies dir die folgende Hinweise genau durch und stimme dem nur zu, wenn du das möchtest. \n\nStimmst Du zu, dass der von dir angegebene Aurzt auf deine Daten zugreifen kann und diese zur Unterstutzung deiner Behandlung nutzen darf?";
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Hinweis").setMessage(message).setPositiveButton("Ja", dialogClickListener)
                .setNegativeButton("Nein", dialogClickListener).show();
    }
}