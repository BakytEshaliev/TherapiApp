package com.example.therapiapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChatBot extends BaseActivity {

    public static boolean chatBotPrivacyPolicyAcceptedForSave = false;
    public static boolean chatBotPrivacyPolicyAcceptedForUse = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (ChatBot.chatBotPrivacyPolicyAcceptedForSave) {
            if (ChatBot.chatBotPrivacyPolicyAcceptedForUse) {
                setContentView(R.layout.activity_chat_bot);
            } else setContentView(R.layout.activity_chat_bot_privacy_use);
        } else setContentView(R.layout.activity_chat_bot_privacy_save);
        initToolbar();
    }

    public void acceptPrivacyPolicySave(View v) {
        ChatBot.chatBotPrivacyPolicyAcceptedForSave = true;
        Intent intent = new Intent(this, ChatBot.class);
        this.startActivity(intent);
    }

    public void declinePrivacyPolicySave(View v) {
        finish();
    }

    public void acceptPrivacyPolicyUse(View v) {
        ChatBot.chatBotPrivacyPolicyAcceptedForUse = true;
        Intent intent = new Intent(this, ChatBot.class);
        this.startActivity(intent);
    }

    public void declinePrivacyPolicyUse(View v) {
        finish();
    }
}