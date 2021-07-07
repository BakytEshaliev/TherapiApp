package com.example.therapiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.therapiapp.BaseActivity.TAG;

public class NotfallKontakte extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG,"create NotFallKontakte");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notfallkontakt);
        ConstraintLayout constraintLayout = findViewById(R.id.includeNotfall);
        TextView textView = constraintLayout.findViewById(R.id.toolbar_title);
        ImageView imageView = constraintLayout.findViewById(R.id.herzImageView);
        imageView.setVisibility(View.GONE);
        textView.setText("Notfall-Kontakte");
        ImageView img = findViewById(R.id.backImageView);
        ImageView reloadImg = findViewById(R.id.reloadImageView);
        img.setOnClickListener((l)->finish());
        reloadImg.setOnClickListener((l)->{
            finish();
            startActivity(getIntent());
        });

        findViewById(R.id.nktextView1).setOnClickListener(this::makePhoneCall);
        findViewById(R.id.nktextView2).setOnClickListener(this::makePhoneCall);
        findViewById(R.id.nktextView3).setOnClickListener(this::makePhoneCall);
    }
    private void makePhoneCall(View view){
        TextView tv = (TextView)view;
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+tv.getText().toString()));
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"destroy Notfall");
    }
}