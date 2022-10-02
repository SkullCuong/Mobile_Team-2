package com.example.test_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.test_1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    //init variable
    private EditText Email,Password;
    private Button btnLogin;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // assign variable

        Email = findViewById(R.id.TxtEmail);
        Password = findViewById(R.id.TxtPassword);
        btnLogin = findViewById(R.id.btnLogin);
    }

    private  boolean checkEmail(){
        String email = Email.getText().toString();
        if(email.isEmpty()){
            return false;
        }else if(email.equals("admin")){
            return true;
        }
        return false;
    }
    private  boolean checkPassword(){
        String pass = Password.getText().toString();
        if(pass.isEmpty()){
            return false;
        }
        else if(pass.equals("1234")){
            return true;
        }
        return false;
    }
   public void confirmLogin(View v){
        if(!checkEmail() || !checkPassword() ){
            return;
        }
        else{
            Intent intent = new Intent(MainActivity.this,com.example.test_1.Home.class);
            startActivity(intent);
        }
   }
}