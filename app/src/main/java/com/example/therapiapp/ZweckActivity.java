package com.example.therapiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class ZweckActivity extends BaseActivity {
    private CheckBox zweckZB1;
    private CheckBox zweckZB2;
    private CheckBox zweckZB3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appnutzungszweck);
        zweckZB1 = findViewById(R.id.zweckCheckBox1);
        zweckZB2 = findViewById(R.id.zweckCheckBox2);
        zweckZB3 = findViewById(R.id.zweckCheckBox3);
    }
    public void weiterClick(View view){
        if (isSelected()){
            Intent intent = new Intent(this,Startseite.class);
            startActivity(intent);
            finish();
        }else Toast.makeText(this,"Wähle mindestens ein Zweck!",Toast.LENGTH_SHORT).show();
    }

    private boolean isSelected(){
        return zweckZB1.isChecked() || zweckZB2.isChecked() || zweckZB3.isChecked();
    }
}