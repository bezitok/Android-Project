package com.example.viewflipper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ViewFlipper viewFlipper;
    float toaDo1, toaDo2;
    ImageButton imageButton1, imageButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewFlipper = findViewById(R.id.viewFlipper);
        viewFlipper.setFlipInterval(2000);
        viewFlipper.setInAnimation(MainActivity.this, android.R.anim.fade_in);
        viewFlipper.setOutAnimation(MainActivity.this, android.R.anim.fade_out);

        imageButton1 = findViewById(R.id.previousButton);
        imageButton2 = findViewById(R.id.nextButton);
        imageButton1.setOnClickListener(this);
        imageButton2.setOnClickListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                toaDo1 =  event.getX();
                break;
            case MotionEvent.ACTION_UP:
                toaDo2 = event.getX();

            if(toaDo1<toaDo2){
                viewFlipper.showPrevious();
            }else{
                viewFlipper.showNext();
            }
        }

        return super.onTouchEvent(event);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.previousButton:
                viewFlipper.showPrevious();
                break;
            case R.id.nextButton:
                viewFlipper.showNext();
                break;
        }
    }
}
