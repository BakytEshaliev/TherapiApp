package com.example.therapiapp;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Activities extends BaseActivity {
    private RecyclerView recyclerView;
    private RecyclerView closedActivitiesRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubungen_1_2);
        initToolbar();

        recyclerView = findViewById(R.id.recycle);
        ActivitiesAdapter activitiesAdapter = new ActivitiesAdapter(this);
        recyclerView.setAdapter(activitiesAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        closedActivitiesRV = findViewById(R.id.closed_recycle);
        ClosedActivitiesAdapter closedActivitiesAdapter = new ClosedActivitiesAdapter();
        closedActivitiesRV.setAdapter(closedActivitiesAdapter);
        closedActivitiesRV.setLayoutManager(new LinearLayoutManager(this));
    }

    public void notifyClosedActivitiesRV(){
        closedActivitiesRV.getAdapter().notifyDataSetChanged();
    }
}
