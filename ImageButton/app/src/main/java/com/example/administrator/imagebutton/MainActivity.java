package com.example.administrator.imagebutton;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButton = findViewById(R.id.imageButton);
        //Cách lấy ảnh trong thư mục raw

//        InputStream inputStream = getResources().openRawResource(R.raw.progress); Tạo 1 luồng InputStream
//        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
//        imageButton.setImageBitmap(bitmap);


        //Cách set ảnh cho imageButton bằng folder asset

        try {
            InputStream inputStream = this.getAssets().open("lightoff.png");
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            imageButton.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void OutputNotification(View view) {
        Toast.makeText(this, "Click here", Toast.LENGTH_SHORT).show();
    }
}
