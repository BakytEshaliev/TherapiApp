package com.example.therapiapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.example.therapiapp.model.DiaryEntry;
import com.example.therapiapp.util.DButil;

import java.time.LocalDateTime;
import java.util.Date;

public class Tagebuch extends BaseActivity{
    private EditText tagesbuchEditText;
    private DButil db;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG,"create Tagebuch");
        setContentView(R.layout.activity_tagesbuch);
        initToolbar("Tagebuch");

//        calendarView.setActivated();
        db = DButil.getInstance();
        tagesbuchEditText = findViewById(R.id.tagesbuchEditText);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void handleSave(View view){
        String tagesbuchNote = tagesbuchEditText.getText().toString();
        if (!tagesbuchNote.isEmpty()){
            db.addToDiary(new DiaryEntry(LocalDateTime.now(),tagesbuchNote));
            Toast.makeText(this,"Du hast einen Eintrag in dein Tagebuch hinzugefügt.",Toast.LENGTH_SHORT).show();
            tagesbuchEditText.setText("");
        }else {
            Toast.makeText(this,"Du hast nichts in dein Tagebuch geschrieben.",Toast.LENGTH_SHORT).show();
        }
    }

    public void showAll(View view) {
        Intent intent = new Intent(this,TagesbuchList.class);
        startActivity(intent);
    }
}
