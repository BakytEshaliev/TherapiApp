package com.example.therapiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class NotfallKontakte extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notfallkontakt);
        ConstraintLayout constraintLayout = findViewById(R.id.includeNotfall);
        TextView textView = constraintLayout.findViewById(R.id.toolbar_title);
        textView.setText("Notfall-Kontakte");
        ImageView img = findViewById(R.id.backImageView);
        img.setOnClickListener((l)->finish());
    }


}