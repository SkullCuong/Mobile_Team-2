package com.example.cus_list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends ArrayAdapter<User> {
    public ListAdapter( Context context, ArrayList<User> users) {
      super(context,R.layout.list_item,users);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        User user = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        ImageView imageView = convertView.findViewById(R.id.profile);
        TextView name = convertView.findViewById(R.id.name);
        TextView message = convertView.findViewById(R.id.message);
        TextView time =  convertView.findViewById(R.id.time);

        imageView.setImageResource(user.imageid);
        name.setText(user.name);
        message.setText(user.message);
        time.setText(user.time);

        return convertView;
    }
}
