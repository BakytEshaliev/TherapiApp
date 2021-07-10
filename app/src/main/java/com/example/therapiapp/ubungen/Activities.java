package com.example.therapiapp.ubungen;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.therapiapp.BaseActivity;
import com.example.therapiapp.R;
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

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG,"create Ubungen");
        setContentView(R.layout.activity_ubungen_1_2);
        initToolbar("Übungen");

        db = DButil.getInstance();
        dailyActivity = db.getDailyActivity();

        TextView dailyActivityTV = findViewById(R.id.textView128);
        dailyActivityCB = findViewById(R.id.daily_activity);

        if (dailyActivity != null) {
            dailyActivityTV.setText(dailyActivity.getName());
            dailyActivityTV.setOnClickListener(v -> openDailyActivity());
        }
        else {
            dailyActivityCB.setVisibility(View.INVISIBLE);
            dailyActivityTV.setVisibility(View.INVISIBLE);
        }

        recyclerView = findViewById(R.id.recycle);
        ActivitiesAdapter activitiesAdapter = new ActivitiesAdapter(this);
        recyclerView.setAdapter(activitiesAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        closedActivitiesRV = findViewById(R.id.closed_recycle);
        ClosedActivitiesAdapter closedActivitiesAdapter = new ClosedActivitiesAdapter(this);
        closedActivitiesRV.setAdapter(closedActivitiesAdapter);
        closedActivitiesRV.setLayoutManager(new LinearLayoutManager(this));
        notifyClosedActivitiesRV();
        notifyOpenActivitiesRV();

        addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(v -> {
            Bundle b = new Bundle();
            b.putString("from", "U");
            Intent intent = new Intent(this, SelectActivityType.class);
            intent.putExtras(b);
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            this.startActivity(intent);
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"destroy Ubungen");
    }

    public void notifyClosedActivitiesRV(){
        closedActivitiesRV.getAdapter().notifyDataSetChanged();
    }

    public void notifyOpenActivitiesRV(){
        recyclerView.getAdapter().notifyDataSetChanged();
    }

    public void openDailyActivity(){
        Bundle b = new Bundle();
        b.putString("id", dailyActivity.getId());
        b.putString("type", "Q");
        b.putString("from", "U");
        Intent intent = new Intent(this, OpenActivityItem.class);
        intent.putExtras(b);
        startActivity(intent);
    }
}
