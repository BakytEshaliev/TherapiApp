package com.example.therapiapp.other;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.therapiapp.BaseActivity;
import com.example.therapiapp.R;

public class Hilfe extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(BaseActivity.TAG,"create Hilfe");
        setContentView(R.layout.activity_hilfe);
        initToolbar("Hilfe");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(BaseActivity.TAG,"destroy Hilfe");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuItem item = menu.findItem(R.id.hilfeButtonToolBar);
        item.setVisible(false);
        return true;
    }

    public void toKontaktFormular(View v) {
        Intent intent = new Intent(this, KontactFormular.class);
        this.startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}