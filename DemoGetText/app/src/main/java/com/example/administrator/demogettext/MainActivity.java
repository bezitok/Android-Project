package com.example.administrator.demogettext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.buttonClick);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(editText.getText().equals("")){
            Toast.makeText(this, "Không được để trống", Toast.LENGTH_LONG).show();
        }else{
            textView.setText("Chuỗi vừa nhập: "+editText.getText());
        }
    }
}
