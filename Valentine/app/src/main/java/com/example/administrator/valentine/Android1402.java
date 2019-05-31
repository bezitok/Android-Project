package com.example.administrator.valentine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Android1402 extends AppCompatActivity implements View.OnClickListener {

    Button button1, button2, button3;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android1402);
        button1 = findViewById(R.id.btnClickMe1);
        button2 = findViewById(R.id.btnClickMe2);
        button3 = findViewById(R.id.btnClickMe3);
        textView = findViewById(R.id.text);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int controID = v.getId();
        switch (controID){
            case R.id.btnClickMe1:
                textView.setText("Hello World");
                break;
            case R.id.btnClickMe2:
                textView.setText("Happy New Year");
                break;
            case R.id.btnClickMe3:
                textView.setText("Wonderful Hall");
                break;
            default:
                break;
        }
    }
}
