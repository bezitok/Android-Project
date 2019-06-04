package com.example.listviewwithcontextmenu;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class SecondActivity extends AppCompatActivity {

    EditText editText1, editText2, editText3;
    Button button1, button2, button3;
    List<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        editText1 = findViewById(R.id.editText_Name_Student);
        editText2 = findViewById(R.id.editText_Name_PhoneNumber);
        editText3 = findViewById(R.id.editText_Name_Address);

        button1 = findViewById(R.id.button_Confirm);
        button2 = findViewById(R.id.button_ShowAll);
        button3 = findViewById(R.id.button_Exit);
    }


    public void ConfirmStudent(View view) {
    }

    public void ShowAllStudent(View view) {
    }

    public void Exit(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alert");
        builder.setMessage("Bạn chắc chắn muốn thoát chứ?");
        builder.setCancelable(false);

        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                new CountDownTimer(3000, 1000){
                    @Override
                    public void onTick(long millisUntilFinished) {
                        Toast.makeText(SecondActivity.this, "Chương trình sẽ thoát trong " + (millisUntilFinished/1000) + " giây nữa", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFinish() {
                        Toast.makeText(SecondActivity.this, "Chương trình đã thoát", Toast.LENGTH_LONG).show();
                        finish();
                    }
                }.start();
            }
        });

        builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
