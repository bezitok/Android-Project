package com.example.listviewwithcontextmenu;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    EditText editText1, editText2, editText3;
    Button button1, button2, button3;
    ArrayList<Student> studentList = new ArrayList<>();

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
        Student student = new Student();

        student.setStudentImage(R.drawable.baseline_account_circle_black_36);
        student.setName(editText1.getText().toString());
        student.setPhone(Long.parseLong(editText2.getText().toString()));
        student.setAddress(editText3.getText().toString());

        studentList.add(student);
        Toast.makeText(getApplicationContext(), "Thêm thành công", Toast.LENGTH_LONG).show();
    }

    public void ShowAllStudent(View view) {
        Intent intent = new Intent(SecondActivity.this, Information_Screen.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("key", studentList);
        intent.putExtras(bundle);
        startActivity(intent);
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
