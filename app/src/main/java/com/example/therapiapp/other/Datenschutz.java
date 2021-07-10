package com.example.therapiapp.other;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.TextView;

import com.example.therapiapp.BaseActivity;
import com.example.therapiapp.R;

public class Datenschutz extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datenschutz);
        ConstraintLayout constraintLayout = findViewById(R.id.includeDatenschutz);
        TextView textView = constraintLayout.findViewById(R.id.toolbar_title);
        textView.setText("Datenschutz");
    }
}