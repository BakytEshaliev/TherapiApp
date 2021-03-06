package com.example.therapiapp.tagesbuch;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.therapiapp.R;
import com.example.therapiapp.model.DiaryEntry;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DiaryAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private int layout;
    private List<DiaryEntry> diaryNotes;

    public DiaryAdapter(@NonNull Context context, int resource, List<DiaryEntry> diaryNotes) {
        this.diaryNotes = diaryNotes;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return diaryNotes.size();
    }

    @Override
    public Object getItem(int i) {
        return diaryNotes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.activity_list_item,null);
            viewHolder = new ViewHolder();
            viewHolder.content = convertView.findViewById(R.id.diaryContent);
            viewHolder.date = convertView.findViewById(R.id.diaryDate);
            viewHolder.buttonDel = convertView.findViewById(R.id.buttonDeleteEintrag);
            viewHolder.buttonDel.setOnClickListener((v)->{
                diaryNotes.remove(position);
                notifyDataSetChanged();
                if (diaryNotes.size() == 0) Toast.makeText(v.getContext(), "Es gibt keine Eintr??ge in deinem Tagebuch!",Toast.LENGTH_LONG).show();
            });
            viewHolder.buttonBearb = convertView.findViewById(R.id.buttonBearbeitenEintrag);
            viewHolder.buttonBearb.setOnClickListener((v)->{
                DiaryEntry note = diaryNotes.get(position);
                note.setContent(viewHolder.content.getText().toString());
                Toast.makeText(v.getContext(),"Du hast eine ??nderung an dem Tagebucheintrag vorgenommen.",Toast.LENGTH_SHORT).show();
            });
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        DiaryEntry entry = diaryNotes.get(position);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy \tHH:mm:ss");

        viewHolder.date.setText(entry.getDate().format(formatter));
        viewHolder.content.setText(entry.getContent());
        return convertView;
    }

    static class ViewHolder{
        TextView date;
        EditText content ;
        Button buttonDel;
        Button buttonBearb;
    }
}
