package com.example.administrator.checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBox1 = findViewById(R.id.checkbox1);
        checkBox2 = findViewById(R.id.checkbox2);
        checkBox3 = findViewById(R.id.checkbox3);
        checkBox4 = findViewById(R.id.checkbox4);
        checkBox5 = findViewById(R.id.checkbox5);
        checkBox6 = findViewById(R.id.checkbox6);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String notice = "";
        if(checkBox1.isChecked()){
            notice += checkBox1.getText() + " ";
        }
        if(checkBox2.isChecked()){
            notice += checkBox2.getText() + " ";
        }
        if(checkBox3.isChecked()){
            notice += checkBox3.getText() +" ";
        }
        if(checkBox4.isChecked()){
            notice += checkBox4.getText() + " ";
        }
        if(checkBox5.isChecked()){
            notice += checkBox5.getText() + " ";
        }
        if(checkBox6.isChecked()){
            notice += checkBox6.getText() + " ";
        }

        Toast.makeText(this, "Sở thích của bạn bạn là: "+notice, Toast.LENGTH_LONG).show();
    }


}
