package com.example.orderfood.Activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.orderfood.Database.Create_Database;
import com.example.orderfood.R;

public class MainActivity extends AppCompatActivity {

    RelativeLayout parent, rellay1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parent = findViewById(R.id.parent);
        rellay1 = findViewById(R.id.rellay1);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                rellay1.setVisibility(View.VISIBLE);
            }
        }, 2000);

    }

    public void Login(View view) {

    }

    public void Create(View view) {
        Intent intent = new Intent(MainActivity.this, Sign_In.class);
        startActivity(intent);
    }
}
