package com.example.therapiapp;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.therapiapp.chat_bot.Message;
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

    public void removeActivity(Activity activity){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                int pos = activities.indexOf(activity);
                if (pos != -1) {
                    db.closeActivity(activity);
                    activities.remove(activity);
                    System.out.println("DB:");
                    for (Activity a : db.getOpenActivities()) {
                        System.out.println(a.getName());
                    }
                    System.out.println("DB close activities:");
                    for (Activity a : db.getCloseActivities()) {
                        System.out.println(a.getName());
                    }
                    context.notifyClosedActivitiesRV();
                    notifyDataSetChanged();
                }
            }
        }, 1000);
        Toast.makeText(context,"Good job!",Toast.LENGTH_SHORT).show();

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


    public static class ViewHolderOpen extends RecyclerView.ViewHolder {

        private CheckBox checkBox;
        private ActivitiesAdapter adapter;

        public ViewHolderOpen(ActivitiesAdapter adapter, View itemView) {
            super(itemView);
            this.adapter = adapter;
            checkBox = itemView.findViewById(R.id.checkBox11);
        }

        void bind(Activity activity) {
            checkBox.setText(activity.getName());
            checkBox.setChecked(false);
            checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> adapter.removeActivity(activity));
        }
    }
}
