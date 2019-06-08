package com.example.studentmanagersqlite.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.studentmanagersqlite.R;
import com.example.studentmanagersqlite.Student_DTO.Student;

public class One_Student_Information extends AppCompatActivity {

    Student student;
    TextView textView1, textView2, textView3, textView4, textView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_student_information);

        textView1 = findViewById(R.id.one_student_information_textView1);
        textView2 = findViewById(R.id.one_student_information_textView2);
        textView3 = findViewById(R.id.one_student_information_textView3);
        textView4 = findViewById(R.id.one_student_information_textView4);
        textView5 = findViewById(R.id.one_student_information_textView5);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        student = bundle.getParcelable("student Selected");

        textView1.setText("Họ tên: " + student.getStudent_Name());
        textView2.setText("Mã học viên: " + student.getStudent_Code());
        textView3.setText("Ngày sinh: " + student.getStudent_DOB());
        textView3.setText("Lớp: " + student.getStudent_Class());
        textView5.setText("Quê quán: " + student.getStudent_Address());
    }
}
