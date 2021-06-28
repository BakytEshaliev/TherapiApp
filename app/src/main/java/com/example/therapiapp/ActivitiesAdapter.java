package com.example.therapiapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.therapiapp.model.Activity;
import com.example.therapiapp.util.DButil;

import java.util.List;

public class ActivitiesAdapter extends RecyclerView.Adapter<ActivitiesAdapter.ViewHolderOpen> {

    private List<Activity> activities;
    private Activities context;
    private static DButil db;

    public ActivitiesAdapter(Activities context){
        this.context = context;
        db = DButil.getInstance();
        activities = db.getOpenActivities();
    }

    @Override
    public ViewHolderOpen onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolderOpen(this, LayoutInflater.from(parent.getContext()).inflate(R.layout.item_with_checkbox, parent, false));
    }

    @Override
    public int getItemCount() {
        return activities.size();
    }

    @Override
    public void onBindViewHolder(ViewHolderOpen holder, int position) {
        holder.bind(activities.get(position));
    }


    public void openActivity(int layoutPosition) {
        Activity activity = activities.get(layoutPosition);
        Bundle b = new Bundle();
        b.putString("id", activity.getId());
        Intent intent = new Intent(context, OpenActivityItem.class);
        intent.putExtras(b);
        context.startActivity(intent);
    }


    public static class ViewHolderOpen extends RecyclerView.ViewHolder implements View.OnClickListener {

        private CheckBox checkBox;
        private ActivitiesAdapter adapter;
        private TextView textView;

        public ViewHolderOpen(ActivitiesAdapter adapter, View itemView) {
            super(itemView);
            this.adapter = adapter;
            checkBox = itemView.findViewById(R.id.checkBox11);
            textView = itemView.findViewById(R.id.textView73);
            itemView.setOnClickListener(this);
        }

        void bind(Activity activity) {
            textView.setText(activity.getName());
            checkBox.setChecked(false);
        }

        @Override
        public void onClick(View view) {
            adapter.openActivity(getLayoutPosition());
        }
    }
}
