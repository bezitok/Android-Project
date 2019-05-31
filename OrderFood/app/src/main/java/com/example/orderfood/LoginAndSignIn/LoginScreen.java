package com.example.orderfood.LoginAndSignIn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.orderfood.R;

public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

    }

    public void Login(View view) {
        Intent intent = new Intent(getApplicationContext(), SignIn_Screen.class);
        startActivity(intent);
//        finish();
    }
}
