package com.example.therapiapp;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.therapiapp.chat_bot.Message;
import com.example.therapiapp.model.Activity;
import com.example.therapiapp.util.DButil;

import java.util.ArrayList;
import java.util.List;

public class ClosedActivitiesAdapter extends RecyclerView.Adapter<ClosedActivitiesAdapter.ClosedActivitiesViewHolder> {

    private List<Activity> activities;
    private Activities context;
    private static DButil db;

    public ClosedActivitiesAdapter(Activities context){
        this.context = context;
        db = DButil.getInstance();
        activities = db.getCloseActivities();
    }

    @Override
    public ClosedActivitiesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ClosedActivitiesViewHolder(this, LayoutInflater.from(parent.getContext()).inflate(R.layout.item_with_checkbox_1, parent, false));
    }

    @Override
    public int getItemCount() {
        return activities.size();
    }

    @Override
    public void onBindViewHolder(ClosedActivitiesViewHolder holder, int position) {
        holder.bind(activities.get(position));
    }

    public void openActivity(Activity activity){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                int pos = activities.indexOf(activity);
                if (pos != -1) {
                    db.openActivity(activity);
                    activities.remove(activity);
                    context.notifyOpenActivitiesRV();
                    notifyDataSetChanged();
                }
            }
        }, 1000);

    }

    public static class ClosedActivitiesViewHolder extends RecyclerView.ViewHolder {

        private CheckBox checkBox;
        private ClosedActivitiesAdapter adapter;

        public ClosedActivitiesViewHolder(ClosedActivitiesAdapter adapter, View itemView) {
            super(itemView);
            this.adapter = adapter;
            checkBox = itemView.findViewById(R.id.checkBox111);
        }

        void bind(Activity activity) {
            checkBox.setText(activity.getName());
            checkBox.setChecked(true);
            checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> adapter.openActivity(activity));
        }
    }
}

