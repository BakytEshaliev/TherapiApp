package com.example.therapiapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.therapiapp.model.Activity;
import com.example.therapiapp.util.DButil;

public class ActivityItem extends BaseActivity {
    private DButil db;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubungen_3);
        initToolbar("Übungen");

        TextView name = findViewById(R.id.activityName);
        TextView description = findViewById(R.id.activityDiscription);
        Button button = findViewById(R.id.button19);

        Bundle b = getIntent().getExtras();
        String id = b.getString("id");
        String type = b.getString("type");

        button.setOnClickListener(v -> openActivity());

        if (type.equals("Q")) {
            button.setVisibility(View.INVISIBLE);
            button.setEnabled(false);
        }



        db = DButil.getInstance();
        activity = db.findActivityById(id);

        String nameStr = activity.getName();
        String descriptionStr = activity.getDescription();

        name.setText(nameStr);
        description.setText(descriptionStr);
    }

    private void openActivity() {
        Activity newActivity = new Activity(activity.getName(), activity.getDescription());
        db.openActivity(newActivity);
        Intent intent = new Intent(this, Activities.class);
        startActivity(intent);
        finish();
    }
}
