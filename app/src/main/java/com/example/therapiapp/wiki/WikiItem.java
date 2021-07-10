package com.example.therapiapp.wiki;

import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.therapiapp.BaseActivity;
import com.example.therapiapp.R;

public class WikiItem extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wiki_info);
        initToolbar("Wiki");

        TextView name = findViewById(R.id.wiki_name_in_info);
        TextView description = findViewById(R.id.wiki_descriprion);
        TextView source = findViewById(R.id.wiki_source);
        source.setPaintFlags(source.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        Bundle b = getIntent().getExtras();
        String nameStr = b.getString("name");
        String descriptionStr = b.getString("description");
        String sourceStr = b.getString("source");

        name.setText(nameStr);
        description.setText(descriptionStr);
        source.setText(sourceStr);
    }

    public void openBrowser(View view) {
        TextView tv = (TextView)view;
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(tv.getText().toString()));
        startActivity(intent);
    }
}
