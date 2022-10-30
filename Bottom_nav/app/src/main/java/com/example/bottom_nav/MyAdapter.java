package com.example.bottom_nav;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList<news> newsArrayList;

    public MyAdapter(Context context, ArrayList newsArrayList){
        this.context = context;
        this.newsArrayList = newsArrayList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);

        return new MyViewHolder(v);
  }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        news news = newsArrayList.get(position);
        holder.text.setText(news.message);
        holder.img.setImageResource(news.img);
        holder.name.setText(news.name);
    }

    @Override
    public int getItemCount() {
        return newsArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        CircleImageView img;
        TextView  text;
        TextView name;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.profile);
            text = itemView.findViewById(R.id.message);
            name = itemView.findViewById(R.id.name);
        }
    }
}
