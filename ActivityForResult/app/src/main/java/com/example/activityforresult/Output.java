package com.example.activityforresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Output extends AppCompatActivity {

    TextView textView;
    Button button;
    int num1, num2;
    public static final String RESULT = "result";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);

        button = findViewById(R.id.btn_confirm);
        textView = findViewById(R.id.text_result);

        Intent intent = getIntent();
        num1 = intent.getIntExtra(MainActivity.numberA, 0);
        num2 = intent.getIntExtra(MainActivity.numberB, 0);

        int kq = num1*num2;
        textView.setText(String.valueOf(kq));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = num1*num2;
                Intent intent1 = new Intent();
                intent1.putExtra(RESULT, result);
                setResult(RESULT_OK, intent1);
                finish();
            }
        });
    }

}
