package com.example.administrator.ratingbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RatingBar ratingBar;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ratingBar.findViewById(R.id.ratingBar);
        button.findViewById(R.id.button);
        ratingBar.setNumStars(5);
        ratingBar.setRating((float) 3.5);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getApplication(), "Tổng số ngôi sao là: "+ratingBar.getNumStars()+"\n Số sao đánh giá là: "+ratingBar.getRating(), Toast.LENGTH_LONG).show();
    }
}
