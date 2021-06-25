package com.example.therapiapp;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.net.URLEncoder;

public class Wiki extends BaseActivity {

    private EditText searchEditText;
    private WikiAdapter wikiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG,"create Wiki");
        setContentView(R.layout.activity_wiki);
        initToolbar("Wiki");
        searchEditText = findViewById(R.id.wikiSearchEditText);
        RecyclerView recyclerView = findViewById(R.id.wiki_recycler);
        wikiAdapter = new WikiAdapter(this);
        recyclerView.setAdapter(wikiAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void handleSearch(View view) {
        String query = searchEditText.getText().toString();
        wikiAdapter.setSearchStr(query);
    }
}
