package com.example.therapiapp.other;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.therapiapp.BaseActivity;
import com.example.therapiapp.R;

public class KontactFormular extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontact_formular);
        initToolbar("Feedback");

        String[] arraySpinner = new String[] {
                "Feedback", "Problem", "Fehler"
        };
        Spinner s = (Spinner) findViewById(R.id.spinnerKontakt);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
    }

    public void sendFeedback(View v) {
        EditText text = (EditText) findViewById(R.id.editTextTextMultiLine);
        Spinner s = (Spinner) findViewById(R.id.spinnerKontakt);
        if (text.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(),"Bitte fülle das Formular aus!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(),"Bitte warten!", Toast.LENGTH_LONG).show();
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    text.setText("");
                    finish();
                    Toast.makeText(getApplicationContext(),"Vielen Dank für deine " + s.getSelectedItem().toString() + ". Wir haben deine Nachricht erhalten!", Toast.LENGTH_LONG).show();
                }
            }, 3000);
        }
    }

    public void abbrechen(View v) {
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}