package com.example.bottom_nav;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.bottom_nav.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment(),"Home Page");
        binding.bottomNavigationView.setOnItemSelectedListener(item ->{
            switch(item.getItemId()){
                case R.id.home:
                    replaceFragment(new HomeFragment(),"Home Page");
                    break;
                case R.id.setting:
                    replaceFragment(new SettingFragment(),"Setting Page");
                    break;
                case R.id.profile:
                    replaceFragment(new ProfileFragment(),"Profile Page");
                    break;
            }
            return true;
        });
    }
    private void replaceFragment(Fragment fragment, String text){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        this.setTitle(text);
        fragmentTransaction.commit();
    }
}