package com.example.activityforresult;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int REQUEST_CODE = 1;

    Button button;
    EditText editText1, editText2;
    TextView textView;
    public static final String numberA = "num1";
    public static final String numberB = "num2";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn_edit);
        textView = findViewById(R.id.textView);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int num1 = Integer.parseInt(editText1.getText().toString());
                int num2 = Integer.parseInt(editText2.getText().toString());

                Intent intent = new Intent(MainActivity.this, Output.class);
                intent.putExtra(numberA, num1);
                intent.putExtra(numberB, num2);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE ){
            if(resultCode == RESULT_OK && data != null){
                int kq = data.getIntExtra(Output.RESULT, 0);
                textView.setText("Kết quả: "+String.valueOf(kq));
            }
        }
    }


}
