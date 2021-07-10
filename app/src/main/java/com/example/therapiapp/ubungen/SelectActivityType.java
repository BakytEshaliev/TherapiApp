package com.example.therapiapp.ubungen;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.example.therapiapp.BaseActivity;
import com.example.therapiapp.R;
import com.example.therapiapp.ubungen.NewActivities;

public class SelectActivityType extends BaseActivity {
    private String from;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG,"create SelectActivityType");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubungen_type_select);

        Bundle bundle = getIntent().getExtras();
        from = bundle.getString("from");


        Button gegenStressBtn = findViewById(R.id.gegen_stress);
        gegenStressBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, NewActivities.class);
            Bundle b = new Bundle();
            b.putString("type", "Stress");
            b.putString("from", from);
            intent.putExtras(b);
            this.startActivity(intent);;
        });

        Button gegenDepressionBtn = findViewById(R.id.gegen_depression);
        gegenDepressionBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, NewActivities.class);
            Bundle b = new Bundle();
            b.putString("type", "Depression");
            b.putString("from", from);
            intent.putExtras(b);
            this.startActivity(intent);;
        });

        initToolbar("Übungen");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"destroy SelectActivityType");
    }
}
