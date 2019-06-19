package com.example.activityforresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class Output extends AppCompatActivity {

    TextView textView1, textView2;
    Button button;
    int num1, num2;
    int RESULT_CODE = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);

        button = findViewById(R.id.btn_result);

        Intent intent = getIntent();
        num1 = intent.getIntExtra("num1", 0);
        num2 = intent.getIntExtra("num2", 0);

        textView1.setText(num1);
        textView2.setText(num2);

        Intent intent1 = new Intent();
        int result = num1*num2;
        intent1.putExtra("result", result);
        setResult(RESULT_CODE, intent1);
        finish();
    }
}
