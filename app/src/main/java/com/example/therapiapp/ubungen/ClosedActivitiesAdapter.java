package com.example.therapiapp.ubungen;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.therapiapp.R;
import com.example.therapiapp.model.Activity;
import com.example.therapiapp.util.DButil;

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

    public void openClosedActivity(int pos){
        Activity activity = activities.get(pos);
        Bundle b = new Bundle();
        b.putString("id", activity.getId());
        b.putString("type", "Q");
        Intent intent = new Intent(context, ActivityItem.class);
        intent.putExtras(b);
        context.startActivity(intent);
    }

    public static class ClosedActivitiesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private CheckBox checkBox;
        private ClosedActivitiesAdapter adapter;
        private TextView textView;

        public ClosedActivitiesViewHolder(ClosedActivitiesAdapter adapter, View itemView) {
            super(itemView);
            this.adapter = adapter;
            checkBox = itemView.findViewById(R.id.checkBox111);
            textView = itemView.findViewById(R.id.textView733);
            itemView.setOnClickListener(this);
        }

        void bind(Activity activity) {
            textView.setText(activity.getName());
            checkBox.setChecked(true);
        }

        @Override
        public void onClick(View view) {
            adapter.openClosedActivity(getAdapterPosition());
        }
    }
}

