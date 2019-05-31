package com.example.administrator.transitiondrawable;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView textView;
    TransitionDrawable transitionDrawable;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        transitionDrawable = (TransitionDrawable) textView.getBackground();
    }
    public void BatDau (View view){
        transitionDrawable.reverseTransition(3000);
    }

}


