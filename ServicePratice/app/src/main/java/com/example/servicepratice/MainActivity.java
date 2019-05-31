package com.example.servicepratice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button1, button2;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
    }

    public void PlayMusic(View view) {
        intent = new Intent(MainActivity.this, Music.class);
        startService(intent);
    }

    public void Stop(View view) {
        stopService(intent);
    }
}
