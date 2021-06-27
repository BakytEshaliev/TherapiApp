package com.example.therapiapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.example.therapiapp.model.Activity;
import com.example.therapiapp.util.DButil;

public class Tagesziel extends BaseActivity {
    private DButil db;
    private CheckBox dailyActivityCB;
    private Activity dailyActivity;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG,"create Tagesziel");
        setContentView(R.layout.activity_tagesziel_1);
        initToolbar("Tagesziel");

        db = DButil.getInstance();
        dailyActivity = db.getDailyActivity();

        TextView dailyActivityTV = findViewById(R.id.textViewDAinTagesziel);
        dailyActivityCB = findViewById(R.id.daily_activityCBinTagesziel);

        if (dailyActivity != null) {
            dailyActivityTV.setText(dailyActivity.getName());
            dailyActivityTV.setOnClickListener(v -> openDailyActivity());
        }
        else {
            dailyActivityCB.setVisibility(View.INVISIBLE);
            dailyActivityTV.setText("Du hast heute keine Aufgaben. Such dir eine Aufgabe aus oder ruhe dich aus :)");
            dailyActivityTV.setEnabled(false);
        }
    }

    public void openDailyActivity(){
        Bundle b = new Bundle();
        b.putString("id", dailyActivity.getId());
        b.putString("type", "Q");
        Intent intent = new Intent(this, OpenActivityItem.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        intent.putExtras(b);
        startActivity(intent);
        finish();
    }
}
