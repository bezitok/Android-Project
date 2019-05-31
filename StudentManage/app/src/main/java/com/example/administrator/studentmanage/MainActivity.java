package com.example.administrator.studentmanage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.buttonMainActivity1);
        button2 = findViewById(R.id.buttonMainActivity2);
    }

    public void Continue(View view) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }

    public void Exit(View view) {
        Toast.makeText(this, "Chương trình sẽ thoát", Toast.LENGTH_SHORT).show();
        finish();
    }
}