package com.example.cus_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.cus_list.databinding.ActivityMainBinding;
import com.example.cus_list.databinding.ActivityUserBinding;

public class UserActivity extends AppCompatActivity {
    ActivityUserBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();
        if(intent != null){
            String name = intent.getStringExtra("name");
            String phone = intent.getStringExtra("phone");
            String country = intent.getStringExtra("country");
            int imageId = intent.getIntExtra("imageId",R.drawable.nn);
            binding.name.setText(name);
            binding.country.setText(country);
            binding.phone.setText(phone);
            binding.profile.setImageResource(imageId);


        }


    }
}