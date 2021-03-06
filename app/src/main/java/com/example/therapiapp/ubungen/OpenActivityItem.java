package com.example.therapiapp.ubungen;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.example.therapiapp.BaseActivity;
import com.example.therapiapp.R;
import com.example.therapiapp.tagesziel.Tagesziel;
import com.example.therapiapp.model.Activity;
import com.example.therapiapp.util.DButil;

public class OpenActivityItem extends BaseActivity {
    private Activity activity;
    private DButil db;
    private EditText content;
    private String from;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubungen_4);
        initToolbar("Übungen");

        TextView name = findViewById(R.id.activityName);
        content = findViewById(R.id.activityContent);
        Button buttonWeiter = findViewById(R.id.button20);
        Button buttonAbrechen = findViewById(R.id.button19);
        ImageView questionImage = findViewById(R.id.imageView8);

        buttonWeiter.setOnClickListener(v -> weiterBtn());
        buttonAbrechen.setOnClickListener(v -> abrechenBtn());
        questionImage.setOnClickListener(v -> questionBtn());

        db = DButil.getInstance();

        Bundle b = getIntent().getExtras();
        String id = b.getString("id");
        from = b.getString("from");

        activity = db.findOpenActivityById(id);

        String nameStr = activity.getName();

        name.setText(nameStr);
    }

    private void weiterBtn(){
        activity.setContent(content.getText().toString());
        db.closeActivity(activity);
        db.removeOpenActivity(activity);
        switch (from) {
            case "Z": {
                Intent intent = new Intent(this, Tagesziel.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            }
            case "U": {
                Intent intent = new Intent(this, Activities.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            }
        }
        finish();
    }

    private void abrechenBtn(){
        db.removeOpenActivity(activity);
        switch (from) {
            case "Z": {
                Intent intent = new Intent(this, Tagesziel.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            }
            case "U": {
                Intent intent = new Intent(this, Activities.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            }
        }
        finish();
    }

    private void questionBtn(){
        Bundle b = new Bundle();
        b.putString("id", activity.getId());
        b.putString("type", "Q");
        Intent intent = new Intent(this, ActivityItem.class);
        intent.putExtras(b);
        startActivity(intent);
    }
}
