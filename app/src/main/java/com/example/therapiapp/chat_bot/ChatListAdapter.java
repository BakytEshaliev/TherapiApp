package com.example.therapiapp.chat_bot;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.therapiapp.R;

public class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.ViewHolder> {
    private Message[] listdata;

    // RecyclerView recyclerView;
    public ChatListAdapter(Message[] listdata) {
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
        final Message message = listdata[position];
        holder.time.setText(listdata[position].getTimestamp());
        holder.text.setText(listdata[position].getText());

        if (listdata[position].getText().length() < 150) holder.constraintLayout.setMaxWidth(680);
        if (listdata[position].getText().length() < 80) holder.constraintLayout.setMaxWidth(580);
        if (listdata[position].getText().length() < 40) holder.constraintLayout.setMaxWidth(380);

        if (listdata[position].isFloatRight()) {
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) holder.constraintLayout.getLayoutParams();
            params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,1);
            holder.constraintLayout.setLayoutParams(params);
        }

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"click on item: " + message.getText(),Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView time;
        public TextView text;
        public RelativeLayout relativeLayout;
        public ConstraintLayout constraintLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.time = (TextView) itemView.findViewById(R.id.time);
            this.text = (TextView) itemView.findViewById(R.id.text);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relativeLayout);
            constraintLayout = (ConstraintLayout) itemView.findViewById(R.id.inner_wrapper);
        }
    }
}
