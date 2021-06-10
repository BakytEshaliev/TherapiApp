package com.example.therapiapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.therapiapp.model.Activity;
import com.example.therapiapp.util.DButil;

public class Activities extends BaseActivity {
    private RecyclerView recyclerView;
    private RecyclerView closedActivitiesRV;
    private CheckBox dailyActivityCB;
    private Activity dailyActivity;
    private ImageView addButton;
    //protected CardView dailyActivityCV;
    private DButil db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubungen_1_2);
        initToolbar("Übungen");

        db = DButil.getInstance();
        dailyActivity = db.getDailyActivity();
        dailyActivityCB = findViewById(R.id.daily_activity);

        if (dailyActivity != null) {
            dailyActivityCB.setText(dailyActivity.getName());
            dailyActivityCB.setOnCheckedChangeListener((buttonView, isChecked) -> closeDailyActivity());
        }
        else {
            dailyActivityCB.setVisibility(View.INVISIBLE);
        }

        recyclerView = findViewById(R.id.recycle);
        ActivitiesAdapter activitiesAdapter = new ActivitiesAdapter(this);
        recyclerView.setAdapter(activitiesAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        closedActivitiesRV = findViewById(R.id.closed_recycle);
        ClosedActivitiesAdapter closedActivitiesAdapter = new ClosedActivitiesAdapter(this);
        closedActivitiesRV.setAdapter(closedActivitiesAdapter);
        closedActivitiesRV.setLayoutManager(new LinearLayoutManager(this));

        addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, SelectActivityType.class);
            this.startActivity(intent);;
        });
    }

    public void notifyClosedActivitiesRV(){
        closedActivitiesRV.getAdapter().notifyDataSetChanged();
    }

    public void notifyOpenActivitiesRV(){
        recyclerView.getAdapter().notifyDataSetChanged();
    }

    public void closeDailyActivity(){
        db.closeActivity(dailyActivity);
        notifyClosedActivitiesRV();
        db.deleteDailyActivity();
        dailyActivityCB.setVisibility(View.INVISIBLE);
    }
}
