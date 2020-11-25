package com.akanksha.noteapp;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

    LayoutInflater inflater;
    List<Note> notes;

    NoteAdapter(Context context, List<Note> notes){
        this.inflater = LayoutInflater.from(context);
        this.notes = notes;
    }

    @NonNull
    @Override
    public NoteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.custom_list_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteAdapter.ViewHolder holder, int position) {
        String title = notes.get(position).getTitle();
        String date = notes.get(position).getDate();
        String time = notes.get(position).getTime();
        holder.sample_title.setText(title);
        holder.sample_date.setText(date);
        holder.sample_time.setText(time);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView sample_title,sample_date,sample_time;
        ImageView sample_photo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sample_title = itemView.findViewById(R.id.sample_title);
            sample_date = itemView.findViewById(R.id.sample_date);
            sample_time = itemView.findViewById(R.id.sample_time);
            sample_photo = itemView.findViewById(R.id.img);
        }
    }
}
