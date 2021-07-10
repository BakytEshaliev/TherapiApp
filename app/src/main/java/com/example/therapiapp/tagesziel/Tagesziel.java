package com.example.therapiapp.tagesziel;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.example.therapiapp.BaseActivity;
import com.example.therapiapp.R;
import com.example.therapiapp.model.Activity;
import com.example.therapiapp.ubungen.OpenActivityItem;
import com.example.therapiapp.ubungen.SelectActivityType;
import com.example.therapiapp.util.DButil;

public class Tagesziel extends BaseActivity {
    private DButil db;
    private CheckBox dailyActivityCB;
    private Activity dailyActivity;
    private Spinner tagesZielSpinner;
    private ImageView tzImageView;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG,"create Tagesziel");
        setContentView(R.layout.activity_tagesziel_1);
        initToolbar("Tagesziel");
        tagesZielSpinner = findViewById(R.id.tagesZielSpinner);
        tzImageView = findViewById(R.id.tzImageView);
        tagesZielSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                switch (selectedItem){
                    case "Jahresübersicht":
                        tzImageView.setImageResource(R.drawable.t2);
                        break;
                    case "Monatsübersicht":
                        tzImageView.setImageResource(R.drawable.t1);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        db = DButil.getInstance();
        dailyActivity = db.getDailyActivity();

        TextView dailyActivityTV = findViewById(R.id.textViewDAinTagesziel);
        dailyActivityCB = findViewById(R.id.daily_activityCBinTagesziel);

        ImageView addButton = findViewById(R.id.addButton2);
        addButton.setOnClickListener(v -> {
            Bundle b = new Bundle();
            b.putString("from", "Z");
            Intent intent = new Intent(this, SelectActivityType.class);
            intent.putExtras(b);
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            this.startActivity(intent);
        });;

        if (dailyActivity != null) {
            dailyActivityTV.setText(dailyActivity.getName());
            dailyActivityTV.setOnClickListener(v -> openDailyActivity());
            addButton.setVisibility(View.INVISIBLE);
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
        b.putString("from", "Z");
        Intent intent = new Intent(this, OpenActivityItem.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        intent.putExtras(b);
        startActivity(intent);
        finish();
    }
}
