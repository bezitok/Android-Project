package com.example.animationalpha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView, imageView1, imageView2, imageView3, imageView4;
    Animation animation1, animation2, animation3, animation4, animation5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.vidic);
        imageView1 = findViewById(R.id.rio);
        imageView2 = findViewById(R.id.nedved);
        imageView3 = findViewById(R.id.nedved1);
        imageView4 = findViewById(R.id.beckham);

        animation1 = AnimationUtils.loadAnimation(this, R.anim.alpha_animation);

        animation2 = AnimationUtils.loadAnimation(this, R.anim.rotate_animation);

        animation3 = AnimationUtils.loadAnimation(this, R.anim.scale_big_animation);

        animation4 = AnimationUtils.loadAnimation(this, R.anim.scale_small_animation);

        animation5 = AnimationUtils.loadAnimation(this, R.anim.translate_animation);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animation1);
            }
        });

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animation2);
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animation3);
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animation4);
            }
        });

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animation5);
            }
        });
    }
}
