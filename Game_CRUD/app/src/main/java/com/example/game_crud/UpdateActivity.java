package com.example.game_crud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {
    EditText title_input, genre_input;
    Button  UpdateBtn,DeleteBtn;
    String id, title, genre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        title_input = findViewById(R.id.input_title2);
        genre_input = findViewById(R.id.input_genre2);
        getIntentData();
        DeleteBtn = findViewById(R.id.delete_btn);
        UpdateBtn = findViewById(R.id.update_btn);
        UpdateBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MyDatabaseHelper mydb = new MyDatabaseHelper(UpdateActivity.this);
                mydb.update(id,title_input.getText().toString(),genre_input.getText().toString());
            }
        });
        DeleteBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MyDatabaseHelper mydb = new MyDatabaseHelper(UpdateActivity.this);
                mydb.delete(id);
            }
        });



    }
    void getIntentData(){
        id = getIntent().getStringExtra("Id");
        title = getIntent().getStringExtra("Title");
        genre = getIntent().getStringExtra("Genre");
        title_input.setText(title);
        genre_input.setText(genre);
    }
}