package com.example.therapiapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.therapiapp.chat_bot.ChatListAdapter;
import com.example.therapiapp.chat_bot.Message;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class ChatBot extends BaseActivity {

    public static boolean chatBotPrivacyPolicyAcceptedForSave = false;
    public static boolean chatBotPrivacyPolicyAcceptedForUse = false;
    public static ArrayList<Message> messages = new ArrayList<>();;
    public static boolean listFilled = false;

    private static HashMap<String, String> QAMap;

    private RecyclerView recyclerView;
    private ChatListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_bot);
        initToolbar("Chatbot");

        if (!ChatBot.chatBotPrivacyPolicyAcceptedForSave) askForDataSavePermission();
        if (!ChatBot.chatBotPrivacyPolicyAcceptedForUse) askForDataUsePermission();

        if (!ChatBot.listFilled) {
            ChatBot.messages.add(new Message(false, "Hallo! Ich bin dein Persönlicher Chatbot. Hier können Hinweise bzgl. der Benutzung folgen und inwiefern der Bot auf Nachrichten der Nutzer*innen reagiert."));
            ChatBot.messages.add(new Message(false, "Bitte erzähle mir hier, wofür du die App nutzen mõchtest!"));
            ChatBot.messages.add(new Message(false, "Der Chatbot könnte fragen, ob der Nutzer den Depressionstest mit ihm Durchführen möchte, oder aber lieber über seinen Tag reden möchte."));
            ChatBot.messages.add(new Message(true, "Hi! Okay."));
        }
        ChatBot.listFilled = true;

        if (QAMap == null) fillQAMap();

        recyclerView = (RecyclerView) findViewById(R.id.messagesRecyclerView);
        adapter = new ChatListAdapter(ChatBot.messages);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        EditText input = (EditText) findViewById(R.id.inputMessage);
        input.setOnKeyListener((v, keyCode, event) -> {
            if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                // Perform action on key press
                if (!input.getText().toString().equals("")) {
                    sendMessage();
                } else System.out.println("none");
                return true;
            }
            return false;
        });

        AndroidNetworking.initialize(getApplicationContext());
    }

    private void sendMessage() {
        EditText input = (EditText) findViewById(R.id.inputMessage);
        String text = input.getText().toString();
        input.setText("");
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                adapter.addMessage(new Message(true, text));
                getAnswer(text);
                recyclerView.smoothScrollToPosition(adapter.getItemCount() - 1);
            }
        }, 1000);
    }

    private void getAnswer(String question) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                if (QAMap.containsKey(question)) {
                    adapter.addMessage(new Message(false, QAMap.get(question)));
                    recyclerView.smoothScrollToPosition(adapter.getItemCount() - 1);
                    return;
                }
                AndroidNetworking.get("https://uselessfacts.jsph.pl/random.json")
//              .addPathParameter("id", "2")
//              .addQueryParameter("q", "question")
                        .build()
                        .getAsJSONObject(new JSONObjectRequestListener() {
                            @Override
                            public void onResponse(JSONObject response) {
                                adapter.addMessage(new Message(false, "Interessante Fakt!"));
                                recyclerView.smoothScrollToPosition(adapter.getItemCount() - 1);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    public void run() {
                                        try {
                                            adapter.addMessage(new Message(false, response.getString("text")));
                                        } catch (JSONException e) {
                                            adapter.addMessage(new Message(false, "Es ist ein Fehler beim Server!"));
                                            recyclerView.smoothScrollToPosition(adapter.getItemCount() - 1);
                                        }
                                        recyclerView.smoothScrollToPosition(adapter.getItemCount() - 1);
                                    }
                                }, 1000);
                            }
                            @Override
                            public void onError(ANError anError) {
                                adapter.addMessage(new Message(false, "Tut mir leid, aber ich verstehe Sie nicht!"));
                                recyclerView.smoothScrollToPosition(adapter.getItemCount() - 1);
                            }
                        });
            }
        }, 1000);
    }

    private void askForDataSavePermission() {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        ChatBot.chatBotPrivacyPolicyAcceptedForSave = true;
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        finish();
                        break;
                }
            }
        };
        String message = "Bitte lies dir die folgende Hinweise genau durch und stimme dem nur zu, wenn du das möchtest. \n\nStimmst Du zu, dass deine Daten auf einem Server gespeichert werden, damit der Chatbot dem entsprechend auf deine Antworten reagieren kann? Diese Einstellung kann jederzeit unter deinen Einstellungen aktiviert oder deaktiviert werden.";
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Hinweis").setMessage(message).setPositiveButton("Ja", dialogClickListener)
                .setNegativeButton("Nein", dialogClickListener).show();
    }

    private void askForDataUsePermission() {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        ChatBot.chatBotPrivacyPolicyAcceptedForUse = true;
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        finish();
                        break;
                }
            }
        };
        String message = "Bitte lies dir die folgende Hinweise genau durch und stimme dem nur zu, wenn du das möchtest. \n\nStimmst Du zu, dass der von dir angegebene Arzt auf deine Daten zugreifen kann und diese zur Unterstutzung deiner Behandlung nutzen darf?";
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Hinweis").setMessage(message).setPositiveButton("Ja", dialogClickListener)
                .setNegativeButton("Nein", dialogClickListener).show();
    }

    private void fillQAMap() {
        QAMap = new HashMap<>();
        QAMap.put("Hi", "Hallo");
    }
}