package com.example.sharepreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText1, editText2;
    Button button1, button2;
    SharedPreferences sharedPreferences;
    TextView textView1, textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);

        button1 = findViewById(R.id.buttonSave);
        button2 = findViewById(R.id.buttonLoadData);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        sharedPreferences = this.getSharedPreferences("Thông tin người dùng", MODE_PRIVATE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonSave:
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("user", editText1.getText().toString());
                editor.putString("password", editText2.getText().toString());
                editor.commit();
                break;
            case R.id.buttonLoadData:
                textView1.setText(sharedPreferences.getString("user", ""));
                textView2.setText(sharedPreferences.getString("password", ""));
                break;
        }
    }
}
