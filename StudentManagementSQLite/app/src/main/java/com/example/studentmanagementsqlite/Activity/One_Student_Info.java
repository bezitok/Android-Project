package com.example.studentmanagementsqlite.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.studentmanagementsqlite.R;
import com.example.studentmanagementsqlite.Student_DTO.Student_DTO;

public class One_Student_Info extends AppCompatActivity {

    Student_DTO student;

    TextView textView1, textView2, textView3, textView4, textView5, textView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_student_detail);

        textView1 = findViewById(R.id.one_student_infor_Name);
        textView2 = findViewById(R.id.one_student_infor_Code);
        textView3 = findViewById(R.id.one_student_infor_DOB);
        textView4 = findViewById(R.id.one_student_infor_Class);
        textView5 = findViewById(R.id.one_student_infor_Address);
        textView6 = findViewById(R.id.one_student_infor_School);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        student = bundle.getParcelable(List_Student_Information.studentDetail);


        textView1.setText("Họ tên: " + student.getStudent_Name());
        textView2.setText("Mã sinh viên: " + student.getStudent_Code());
        textView3.setText("Ngày sinh: " + student.getStudent_DOB());
        textView4.setText("Lớp: " + student.getStudent_Class());
        textView5.setText("Quê quán: " + student.getStudent_Address());
        textView6.setText("Trường Đại học Công nghiệp Hà Nội");

    }
}
