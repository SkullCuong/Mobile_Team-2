package com.example.game_crud;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;



public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList id, title, genre;
    int position;
    public MyAdapter(Context context, ArrayList id, ArrayList title, ArrayList genre){
        this.context = context;
        this.id = id;
        this.title = title;
        this.genre= genre;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,int position) {
        holder.id_txt.setText(String.valueOf(id.get(position)));
        holder.title_txt.setText(String.valueOf(title.get(position)));
        holder.genre_txt.setText(String.valueOf(genre.get(position)));
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("Id",String.valueOf(id.get(position)));
                intent.putExtra("Title",String.valueOf(title.get(position)));
                intent.putExtra("Genre",String.valueOf(genre.get(position)));
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView id_txt, title_txt, genre_txt;
        LinearLayout mainLayout;
        public MyViewHolder(@NonNull View view){
            super(view);
            id_txt = itemView.findViewById(R.id.id_txt);
            title_txt = itemView.findViewById(R.id.title_txt);
            genre_txt = itemView.findViewById(R.id.genre_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}