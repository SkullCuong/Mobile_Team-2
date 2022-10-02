package com.example.bottom_nav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    private Button btnLogin;
    private EditText Username;
    private EditText Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.btnLogin);
        Username = findViewById(R.id.user);
        Password = findViewById(R.id.password);
        this.setTitle("Login Page");
        btnLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                checkLogin();
            }
        });
    }

    public void checkLogin(){
        String name = Username.getText().toString();
        String password = Password.getText().toString();
        if(name.equals("admin") && password.equals("1234")){
            Intent intent = new Intent(Login.this, com.example.bottom_nav.MainActivity.class);
            startActivity(intent);
        }
    }
}