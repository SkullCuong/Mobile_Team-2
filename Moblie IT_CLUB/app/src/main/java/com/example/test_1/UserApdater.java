package com.example.test_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserApdater extends RecyclerView.Adapter<UserApdater.UserViewHolder> {
    private Context mContext;
    private List<User> mListUser;
    public UserApdater(Context mContext){
        this.mContext = mContext;
    }
    public void setData(List<User> lst){
        this.mListUser = lst;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_home,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = mListUser.get(position);
        if (user == null){
            return;
        }
        holder.imgUser.setImageResource(user.getResultId());
        holder.tvName.setText(user.getName());
    }

    @Override
    public int getItemCount() {
        if (mListUser != null){
            return mListUser.size();
        }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgUser;
        private TextView tvName;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            imgUser = itemView.findViewById(R.id.image_1);
            tvName = itemView.findViewById(R.id.txt_1);
        }


    }
}
