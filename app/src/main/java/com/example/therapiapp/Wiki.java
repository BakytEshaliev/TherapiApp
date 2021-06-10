package com.example.therapiapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Wiki extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wiki);
        initToolbar("Wiki");

        RecyclerView recyclerView = findViewById(R.id.wiki_recycler);
        WikiAdapter wikiAdapter = new WikiAdapter(this);
        recyclerView.setAdapter(wikiAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
