package com.example.therapiapp.tagesbuch;

import androidx.annotation.RequiresApi;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.therapiapp.BaseActivity;
import com.example.therapiapp.R;
import com.example.therapiapp.tagesbuch.DiaryAdapter;
import com.example.therapiapp.util.DButil;

public class TagesbuchList extends BaseActivity {

    private ListView listView;
    private DButil db;
    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tagesbuch_list);
        db = DButil.getInstance();

        Log.i("Info", String.valueOf(db.getDiary().size()));
        listView = findViewById(R.id.tagesbuchListView);


        listView.setAdapter(new DiaryAdapter(this, android.R.layout.simple_list_item_1, db.getDiary()));
    }


}