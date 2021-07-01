package com.example.therapiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registrierung2 extends BaseActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiry_registrierung_2);
//        initToolbar();

        editText = findViewById(R.id.editTextNumber);

    }

    public void handleBestatigen(View view) {
        Editable text = editText.getText();
        if (text.toString().equals("12345")){
            Intent intent = new Intent(this,MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            Toast.makeText(view.getContext(), "Sie haben den Code bestätigt", Toast.LENGTH_SHORT).show(); text.clear();
        } else
            Toast.makeText(view.getContext(), "Sie haben den falschen Code eingegeben", Toast.LENGTH_SHORT).show();

    }
    public void codeSenden(View view){
        Toast.makeText(view.getContext(), "Überprüfen Sie Ihre E-Mail", Toast.LENGTH_SHORT).show();
    }

}