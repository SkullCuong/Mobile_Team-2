package com.example.test_1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.test_1.databinding.ActivityMainBinding;

public class Navbar extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_navbar);


}