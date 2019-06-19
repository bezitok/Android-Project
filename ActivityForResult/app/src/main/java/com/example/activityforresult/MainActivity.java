package com.example.activityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int REQUEST_CODE = 1;

    EditText editText1, editText2;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn_send);
        editText1 = findViewById(R.id.text1);
        editText2 = findViewById(R.id.text2);
        textView = findViewById(R.id.text3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("num1", Integer.parseInt(editText1.getText().toString()));
                intent.putExtra("num2", Integer.parseInt(editText2.getText().toString()));
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(REQUEST_CODE == requestCode){
            if(requestCode == RESULT_OK){
                int ressult = data.getIntExtra("result", 0);
                textView.setText(ressult);
            }
        }
    }
}
