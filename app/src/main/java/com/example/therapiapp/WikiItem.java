package com.example.therapiapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class WikiItem extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wiki_info);
        initToolbar("Wiki");

        TextView name = findViewById(R.id.wiki_name_in_info);
        TextView description = findViewById(R.id.wiki_descriprion);
        TextView source = findViewById(R.id.wiki_source);

        Bundle b = getIntent().getExtras();
        String nameStr = b.getString("name");
        String descriptionStr = b.getString("description");
        String sourceStr = b.getString("source");

        name.setText(nameStr);
        description.setText(descriptionStr);
        source.setText(sourceStr);
    }
}
