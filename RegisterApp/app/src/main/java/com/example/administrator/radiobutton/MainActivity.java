package com.example.administrator.radiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    RadioButton radioButton1, radioButton2;
    Button button;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        button = findViewById(R.id.buttonRegister);
        radioGroup = findViewById(R.id.radioGroup);

        int id = radioGroup.getCheckedRadioButtonId();
        RadioButton view = findViewById(id);
        String chuoi = (String) view.getText();
        Toast.makeText(this,chuoi,Toast.LENGTH_SHORT).show();

        button.setOnClickListener(this);

        radioButton1.isChecked();
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Bạn đã đăng ký thành công", Toast.LENGTH_SHORT).show();
    }
}
