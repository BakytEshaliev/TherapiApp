package com.example.therapiapp;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.therapiapp.model.Activity;
import com.example.therapiapp.util.DButil;

import java.util.ArrayList;
import java.util.List;

public class NewActivities extends BaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubungen_2);
        initToolbar("Übungen");

        Bundle b = getIntent().getExtras();
        String type = b.getString("type");

        DButil db = DButil.getInstance();

        List<Activity> activities = new ArrayList<>();

        switch (type){
            case "Stress":
                activities = db.getActivitiesAgainstStress();
                break;
            case "Depression":
                activities = db.getActivitiesAgainstDepression();
        }

        RecyclerView recyclerView = findViewById(R.id.recycle_view_activities_with_type);
        NewActivitiesAdapter newActivitiesAdapter = new NewActivitiesAdapter(this, activities);
        recyclerView.setAdapter(newActivitiesAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
