package com.example.therapiapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.therapiapp.chat_bot.ChatListAdapter;
import com.example.therapiapp.chat_bot.Message;

public class ChatBot extends BaseActivity {

    public static boolean chatBotPrivacyPolicyAcceptedForSave = true;
    public static boolean chatBotPrivacyPolicyAcceptedForUse = true;

    private ChatListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_bot);
        initToolbar();

        if (!ChatBot.chatBotPrivacyPolicyAcceptedForSave) askForDataSavePermission();
        if (!ChatBot.chatBotPrivacyPolicyAcceptedForUse) askForDataUsePermission();

        Message[] messages = new Message[] {
                new Message(false, "Hallo! Ich bin dein Persönlicher Chatbot. Hier können Hinweise bzgl. der Benutzung folgen und inwiefern der Bot auf Nachrichten der Nutzer*innen reagiert."),
                new Message(false, "Bitte erzähle mir hier, wofür du die App nutzen mõchtest!"),
                new Message(false, "Der Chatbot könnte fragen, ob der Nutzer den Depressionstest mit ihm Durchführen möchte, oder aber lieber über seinen Tag reden möchte."),
                new Message(true, "Hi! Okay."),
        };

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.messagesRecyclerView);
        adapter = new ChatListAdapter(messages);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        adapter.notifyDataSetChanged();
//    }

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