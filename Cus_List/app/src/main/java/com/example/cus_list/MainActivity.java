package com.example.cus_list;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cus_list.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageId = {R.drawable.n1, R.drawable.nn,R.drawable.images,R.drawable.download};
        String[] name ={"Cuong","Khang","Phi","Loi"};
        String[] message = {"Chao","Chao","Chao","Chao",};
        String[] time ={"2","3","4","5"};
        String[] phone ={"0972913303","0972913308","0972913309","0972913302"};
        String[] country= {"Vn","Vn","Vn","Vn"};
        ArrayList<User> users = new ArrayList<>();

        for (int i = 0; i < imageId.length; i++){
            User user = new User(name[i],message[i],time[i],phone[i],country[i],imageId[i]);
            users.add(user);
        }
        ListAdapter listAdapter = new ListAdapter(MainActivity.this,users);
        binding.listView.setAdapter(listAdapter);
        binding.listView.setClickable(true);
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,UserActivity.class);
                intent.putExtra("name",name[position]);
                intent.putExtra("phone",phone[position]);
                intent.putExtra("Country",country[position]);
                intent.putExtra("imageId",imageId[position]);
                startActivity(intent);
            }
        });
    }

}