package com.example.therapiapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Kontakte extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontakte);
        initToolbar("Kontakte");

        findViewById(R.id.kontakte1TextView).setOnClickListener(this::makePhoneCall);
        findViewById(R.id.kontakte2TextView).setOnClickListener(this::makePhoneCall);
        findViewById(R.id.kontakte3TextView).setOnClickListener(this::makePhoneCall);
        findViewById(R.id.kontakte4TextView).setOnClickListener(this::makePhoneCall);
    }
    private void makePhoneCall(View view){
        TextView tv = (TextView)view;
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+tv.getText().toString()));
        startActivity(intent);
    }

    public void showNotfallkontakte(View view) {
        Intent intent = new Intent(this,NotfallKontakte.class);
        startActivity(intent);
    }
}