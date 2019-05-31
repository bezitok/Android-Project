package com.example.administrator.togglebutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ToggleButton toggleButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toggleButton = findViewById(R.id.toggleButton1);
        toggleButton.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if(toggleButton.isChecked()){
            Toast.makeText(this,"Bạn đã bật chế độ thông minh", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"Bạn đã tắt chế độ thông minh", Toast.LENGTH_LONG).show();
        }
    }
}
