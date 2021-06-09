package com.example.therapiapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.therapiapp.model.Activity;
import com.example.therapiapp.util.DButil;

import java.util.ArrayList;
import java.util.List;

public class ClosedActivitiesAdapter extends RecyclerView.Adapter<ClosedActivitiesAdapter.ClosedActivitiesViewHolder> {

    private List<Activity> activities;
    private static DButil db;

    public ClosedActivitiesAdapter(){
        db = DButil.getInstance();
        activities = db.getCloseActivities();
    }

    @Override
    public ClosedActivitiesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ClosedActivitiesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.closed_activity_item, parent, false));
    }

    @Override
    public int getItemCount() {
        return activities.size();
    }

    @Override
    public void onBindViewHolder(ClosedActivitiesViewHolder holder, int position) {
        holder.bind(activities.get(position));
    }

    public static class ClosedActivitiesViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public ClosedActivitiesViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.closed_activity);
        }

        void bind(Activity activity) {
            textView.setText(activity.getName());
        }
    }
}

