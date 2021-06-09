package com.example.therapiapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.recyclerview.widget.RecyclerView;

import com.example.therapiapp.model.Activity;
import com.example.therapiapp.util.DButil;

import java.util.ArrayList;
import java.util.List;

public class ActivitiesAdapter extends RecyclerView.Adapter<ActivitiesAdapter.ViewHolder> {

    private List<Activity> activities;
    private Activities context;
    private static DButil db;

    public ActivitiesAdapter(Activities context){
        this.context = context;
        db = DButil.getInstance();
        activities = db.getOpenActivities();
    }

    public void removeActivity(Activity activity){
        int pos = activities.indexOf(activity);
        db.closeActivity(activity);
        activities.remove(pos);
        System.out.println("DB:");
        for (Activity a : db.getOpenActivities()){
            System.out.println(a.getName());
        }
        System.out.println("DB close activities:");
        for (Activity a : db.getCloseActivities()){
            System.out.println(a.getName());
        }
        context.notifyClosedActivitiesRV();
        notifyItemRemoved(pos);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(this, LayoutInflater.from(parent.getContext()).inflate(R.layout.item_with_checkbox, parent, false));
    }

    @Override
    public int getItemCount() {
        return activities.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(activities.get(position));
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        private CheckBox checkBox;
        private ActivitiesAdapter adapter;

        public ViewHolder(ActivitiesAdapter adapter, View itemView) {
            super(itemView);
            this.adapter = adapter;
            checkBox = itemView.findViewById(R.id.checkBox11);
        }

        void bind(Activity activity) {
            checkBox.setText(activity.getName());
            checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> adapter.removeActivity(activity));
        }
    }
}
