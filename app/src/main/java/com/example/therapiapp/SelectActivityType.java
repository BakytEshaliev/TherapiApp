package com.example.therapiapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class SelectActivityType extends BaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubungen_type_select);

        Button gegenStressBtn = findViewById(R.id.gegen_stress);
        gegenStressBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, NewActivities.class);
            Bundle b = new Bundle();
            b.putString("type", "Stress");
            intent.putExtras(b);
            this.startActivity(intent);;
        });

        Button gegenDepressionBtn = findViewById(R.id.gegen_depression);
        gegenDepressionBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, NewActivities.class);
            Bundle b = new Bundle();
            b.putString("type", "Depression");
            intent.putExtras(b);
            this.startActivity(intent);;
        });

        initToolbar("Übungen");
    }
}
