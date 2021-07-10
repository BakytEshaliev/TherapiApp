package com.example.therapiapp.ubungen;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.therapiapp.BaseActivity;
import com.example.therapiapp.R;
import com.example.therapiapp.model.Activity;
import com.example.therapiapp.util.DButil;

import java.util.ArrayList;
import java.util.List;

public class NewActivities extends BaseActivity {
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG,"create Gegendepression");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubungen_2);
        initToolbar("Übungen");

        Bundle b = getIntent().getExtras();
        String type = b.getString("type");
        String from = b.getString("from");

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
        NewActivitiesAdapter newActivitiesAdapter = new NewActivitiesAdapter(this, activities, from);
        recyclerView.setAdapter(newActivitiesAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"destroy Gegendepression");
    }
}
