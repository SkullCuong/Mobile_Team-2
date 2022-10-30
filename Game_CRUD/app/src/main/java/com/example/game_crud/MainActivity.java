package com.example.game_crud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton addBtn;
    MyDatabaseHelper db;
    ArrayList<String> id,title,genre;
    MyAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.view);
        addBtn = findViewById(R.id.add);
        addBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                 startActivity(intent);
            }
        });
        db = new MyDatabaseHelper(MainActivity.this);
        id = new ArrayList<>();
        title = new ArrayList();
        genre = new ArrayList<>();
        displayData();
        mAdapter = new MyAdapter(MainActivity.this,id,title,genre);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }
    void displayData(){
        Cursor cursor = db.read();
        while(cursor.moveToNext()){
            id.add(cursor.getString(0));
            title.add(cursor.getString(1));
            genre.add(cursor.getString(2));
        }
    }
}