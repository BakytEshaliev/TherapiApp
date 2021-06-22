package com.example.therapiapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.therapiapp.model.Activity;
import com.example.therapiapp.model.WikiModel;
import com.example.therapiapp.model.enum_model.WikiType;
import com.example.therapiapp.util.DButil;

import java.util.ArrayList;
import java.util.List;

public class WikiAdapter extends RecyclerView.Adapter<WikiAdapter.WikiViewHolder> {
    private List<WikiModel> allWiki;
    private String searchStr;
    private Wiki context;
    private static DButil db;

    public WikiAdapter(Wiki context){
        this.context = context;
        db = DButil.getInstance();
        allWiki = db.getAllWiki();
    }

    @Override
    public WikiAdapter.WikiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.wiki_card_view, parent, false);
        return new WikiViewHolder(this, view);
    }

    @Override
    public int getItemCount() {
        return allWiki.size();
    }

    @Override
    public void onBindViewHolder(WikiViewHolder holder, int position) {
        holder.bind(allWiki.get(position));
    }

    public void openWiki(int pos) {
        WikiModel wikiModel = allWiki.get(pos);
        Bundle b = new Bundle();
        b.putString("name",wikiModel.getName());
        b.putString("description",wikiModel.getDescription());
        b.putString("source", wikiModel.getSource());
        Intent intent = new Intent(context, WikiItem.class);
        intent.putExtras(b);
        context.startActivity(intent);
    }

    public void setSearchStr(String searchStr){
        allWiki = db.getAllWiki();
        if (!searchStr.trim().equals("")) {
            List<WikiModel> searchWiki = new ArrayList<>();
            for (WikiModel wikiModel : allWiki) {
                if (wikiModel.getName().trim().toLowerCase().contains(searchStr.trim().toLowerCase())
                        || wikiModel.getDescription().trim().toLowerCase().contains(searchStr.trim().toLowerCase()))
                    searchWiki.add(wikiModel);
            }
            allWiki = searchWiki;
        }
        notifyDataSetChanged();
    }


    public class WikiViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView textView;
        private ImageView imageView;
        private WikiAdapter adapter;

        public WikiViewHolder(WikiAdapter adapter, View itemView) {
            super(itemView);
            this.adapter = adapter;
            imageView = itemView.findViewById(R.id.sub);
            textView = itemView.findViewById(R.id.wiki_name);
            itemView.setOnClickListener(this);
        }

        void bind(WikiModel wikiModel) {
            textView.setText(wikiModel.getName());
            if (wikiModel.getType().equals(WikiType.SUB)){
                imageView.setPadding(100,0,0,0);
                textView.setPadding(100,0,0,0);
            }
            else
                imageView.setVisibility(View.INVISIBLE);
            //textView.setOnCheckedChangeListener((buttonView, isChecked) -> adapter.openWiki(wikiModel));
        }

        @Override
        public void onClick(View view){
            openWiki(getLayoutPosition());
        }
    }
}
