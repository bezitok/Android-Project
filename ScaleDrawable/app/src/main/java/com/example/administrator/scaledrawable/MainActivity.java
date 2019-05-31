package com.example.administrator.scaledrawable;

import android.graphics.drawable.ScaleDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.button);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        ScaleDrawable scaleDrawable = (ScaleDrawable) imageView.getDrawable();
        scaleDrawable.setLevel(scaleDrawable.getLevel()+1000);
        if (scaleDrawable.getLevel()==10000){
            Toast.makeText(this,"Chương trình sẽ thoát", Toast.LENGTH_SHORT).show();
            System.exit(1000);
        }
    }
}
