package com.example.therapiapp.chat_bot;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.therapiapp.BaseActivity;
import com.example.therapiapp.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ChatBot extends BaseActivity {

    public static boolean chatBotPrivacyPolicyAcceptedForSave = false;
    public static boolean chatBotPrivacyPolicyAcceptedForUse = false;
    public static ArrayList<Message> messages = new ArrayList<>();;
    public static boolean listFilled = false;

    private List<QA> qas = new ArrayList<>();
    private boolean askForTest = false;
    private PhqTest phqTest = null;

    private RecyclerView recyclerView;
    private ChatListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG,"create ChatBot");
        setContentView(R.layout.activity_chat_bot);
        initToolbar("Chatbot");

        if (!ChatBot.chatBotPrivacyPolicyAcceptedForSave) askForDataSavePermission();
        if (!ChatBot.chatBotPrivacyPolicyAcceptedForUse) askForDataUsePermission();

        if (!ChatBot.listFilled) {
            ChatBot.messages.add(new Message(false, "Hallo! Ich bin dein persönlicher Chatbot, Genki. Du kannst mit mir über deine Gefühle, Probleme oder auch Erfolge sprechen! Ich versuche dir so gut wie möglich zu helfen - jedoch bin ich noch in der Entwicklung und antworte daher nur eingeschränkt."));
            ChatBot.messages.add(new Message(false, "Wenn du mit mir den PHQ-9 Test durchführen möchtest, dann zögere nicht mir dies zu schreiben!"));
            ChatBot.messages.add(new Message(false, "Du kannst mich auch nach interessanten Fakten fragen, schreibe mir dafür einfach \"Facts\"."));
            ChatBot.messages.add(new Message(false, "Ich freue mich schon darauf, dich besser kennenzulernen! \uD83D\uDE0A"));

        }
        ChatBot.listFilled = true;

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
        readJsonFromFile();
    }

    private void readJsonFromFile() {
        String jsonString;
        try {
            InputStream is = getApplicationContext().getAssets().open("qa.json");

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            jsonString = new String(buffer, "UTF-8");

            Gson gson = new Gson();
            Type listQAType = new TypeToken<List<QA>>(){}.getType();

            this.qas = gson.fromJson(jsonString, listQAType);
        } catch (IOException e) {
            e.printStackTrace();
            this.qas = new ArrayList<>();
        }
    }

    private String getAnswerForQuestionFromFile(String question) {
        if (qas.size() == 0) return "";
        for (QA qa:qas) {
            if (question.equalsIgnoreCase(qa.getQ())) return qa.getA();
        }
        return "";
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

    private void addPhq9PrepAnswers() {
        String[] answers = new String[] {
                "überhaupt nicht",
                "an einzelnen Tagen",
                "an mehr als der Hälfte der Tage",
                "beinahe jeden Tag"
        };
        LinearLayout ll = findViewById(R.id.prepAnsView);
        for (String a:answers) {
            Button b = new Button(this);
            b.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
            b.setText(a);
            b.setBackgroundColor(Color.WHITE);
            b.setOnClickListener(v -> {
                System.out.println("clicked: " + a);
                EditText input = (EditText) findViewById(R.id.inputMessage);
                input.setText(a);
                sendMessage();
                ll.removeAllViews();
            });
            ll.addView(b);
        }
        recyclerView.smoothScrollToPosition(adapter.getItemCount() - 1);
    }

    private void getAnswer(String question) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                EditText input = (EditText) findViewById(R.id.inputMessage);
                if (phqTest != null) {
                    String phqQuestion = phqTest.getAnswerFor(question);
                    if (phqQuestion.equals("exit")) {
                        input.setEnabled(true);
                        adapter.addMessage(new Message(false, phqTest.getResult()));
                        phqTest = null;
                        recyclerView.smoothScrollToPosition(adapter.getItemCount() - 1);
                        return;
                    }
                    input.setEnabled(false);
                    addPhq9PrepAnswers();
                    adapter.addMessage(new Message(false, phqQuestion));
                    recyclerView.smoothScrollToPosition(adapter.getItemCount() - 1);
                    return;
                }
                input.setEnabled(true);

                if (askForTest) {
                    if (question.equals("Ja") || question.equals("ja")) {
                        phqTest = new PhqTest();
                        getAnswer("PHQ-9");
                    } else if (question.equals("Nein") || question.equals("nein")) {
                        phqTest = new PhqTest();
                        adapter.addMessage(new Message(false, "Okay"));
                        recyclerView.smoothScrollToPosition(adapter.getItemCount() - 1);
                    }
                    askForTest = false;
                    return;
                }

                if (question.equals("PHQ-9") || question.equals("phq-9") || question.equals("phq9") ||
                        question.equals("PHQ9") || question.equals("PHQ") || question.equals("phq") ||
                        question.equals("test") || question.equals("PHQ 9") || question.equals("phq 9")) {
                    askForTest = true;
                    adapter.addMessage(new Message(false, "Möchtest du den PHQ 9 Test mit mir durchführen? Bitte beachte, dass dieser Test keine fachliche Diagnose ersetzen kann und soll. Suche dafür bitte einen echten Psychologen auf."));
                    recyclerView.smoothScrollToPosition(adapter.getItemCount() - 1);
                    return;
                }

                if (question.equals("Fact")) {
                    AndroidNetworking.get("https://uselessfacts.jsph.pl/random.json")
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
                                    adapter.addMessage(new Message(false, "Tut mir leid, aber ich verstehe dich nicht!"));
                                    recyclerView.smoothScrollToPosition(adapter.getItemCount() - 1);
                                }
                            });
                    return;
                }

                String a = getAnswerForQuestionFromFile(question);
                if (!a.equals("")) {
                    adapter.addMessage(new Message(false, a));
                    recyclerView.smoothScrollToPosition(adapter.getItemCount() - 1);
                    return;
                }

                adapter.addMessage(new Message(false, "Leider verstehe ich dich nicht."));
                recyclerView.smoothScrollToPosition(adapter.getItemCount() - 1);
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
        String message = "Bitte lies dir die folgende Hinweise genau durch und stimme dem nur zu, wenn du das möchtest. \n\nStimmst du zu, dass deine Daten auf einem Server gespeichert werden, damit der Chatbot dem entsprechend auf deine Antworten reagieren kann? Diese Einstellung kann jederzeit unter deinen Einstellungen aktiviert oder deaktiviert werden.";
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
        String message = "Bitte lies dir die folgende Hinweise genau durch und stimme dem nur zu, wenn du das möchtest. \n\nStimmst du zu, dass der von dir angegebene Arzt auf deine Daten zugreifen kann und diese zur Unterstützung deiner Behandlung nutzen darf?";
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Hinweis").setMessage(message).setPositiveButton("Ja", dialogClickListener)
                .setNegativeButton("Nein", dialogClickListener).show();
    }
}