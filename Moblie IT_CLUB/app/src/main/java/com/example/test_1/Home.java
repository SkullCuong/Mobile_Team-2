package com.example.test_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    private RecyclerView rvcUser;
    private UserApdater userApdater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        rvcUser = findViewById(R.id.rcv_user);
        userApdater = new UserApdater(this);
        LinearLayoutManager linearLayout = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rvcUser.setLayoutManager(linearLayout);
        userApdater.setData(getListUser());
        rvcUser.setAdapter(userApdater);
    }
    private List<User> getListUser(){
        List<User> list = new ArrayList<>();
        list.add(new User(R.drawable.p1,"Phu Cuong"));
        list.add(new User(R.drawable.p2,"Ds1"));
        list.add(new User(R.drawable.p3,"DS2"));
        list.add(new User(R.drawable.p4,"DS3"));
        return list;
    }
}