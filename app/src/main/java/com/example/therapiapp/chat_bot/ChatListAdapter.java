package com.example.therapiapp.chat_bot;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.therapiapp.R;

import java.util.ArrayList;

public class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.ViewHolder> {

    private ArrayList<Message> listdata;

    public ChatListAdapter(ArrayList<Message> listdata) {
        this.listdata = listdata;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.message_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Message message = listdata.get(position);
        holder.text.setText(message.getText());

        int margin = 200;
        if (message.getText().length() < 150) margin = 240;
        if (message.getText().length() < 80) margin = 420;
        if (message.getText().length() < 40) margin = 580;

        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) holder.layout.getLayoutParams();

        if (message.isFloatRight()) params.setMargins(margin,5,8,0);
        else params.setMargins(5,8, margin,0);

        holder.layout.setLayoutParams(params);
    }

    public void addMessage(Message message) {
        this.listdata.add(message);
        this.notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView text;
        public RelativeLayout layout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.text = (TextView) itemView.findViewById(R.id.text);
            layout = (RelativeLayout) itemView;
        }
    }
}
