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

public class NewActivitiesAdapter extends RecyclerView.Adapter<NewActivitiesAdapter.NewActivitiesViewHolder> {
    private List<Activity> activities;
    private NewActivities context;
    private static DButil db;

    public NewActivitiesAdapter(NewActivities context, List<Activity> activities){
        this.context = context;
        db = DButil.getInstance();
        this.activities = activities;
    }

    @Override
    public NewActivitiesAdapter.NewActivitiesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NewActivitiesViewHolder(this, LayoutInflater.from(parent.getContext()).inflate(R.layout.item_with_checkbox_1, parent, false));
    }

    @Override
    public int getItemCount() {
        return activities.size();
    }

    @Override
    public void onBindViewHolder(NewActivitiesViewHolder holder, int position) {
        holder.bind(activities.get(position));
    }

    public void openActivity(int pos) {
        Activity activity = activities.get(pos);
        Bundle b = new Bundle();
        b.putString("id", activity.getId());
        b.putString("type", "N");
        Intent intent = new Intent(context, ActivityItem.class);
        intent.putExtras(b);
        context.startActivity(intent);
    }

    public class NewActivitiesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private CheckBox checkBox;
        private NewActivitiesAdapter adapter;
        private TextView textView;

        public NewActivitiesViewHolder(NewActivitiesAdapter adapter, View itemView) {
            super(itemView);
            this.adapter = adapter;
            checkBox = itemView.findViewById(R.id.checkBox111);
            textView = itemView.findViewById(R.id.textView733);
            itemView.setOnClickListener(this);
        }

        void bind(Activity activity) {
            textView.setText(activity.getName());
            checkBox.setChecked(false);
        }

        @Override
        public void onClick(View view) {
            adapter.openActivity(getAdapterPosition());
        }
    }
}
