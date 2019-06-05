package com.example.listviewwithcontextmenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

public class One_Student_Detail extends AppCompatActivity  {

    ArrayList<Student> studentList = new ArrayList<>();
    int position;
    TextView textView1, textView2, textView3, textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_one_student);

        textView1 = findViewById(R.id.detail_student_textView1);
        textView2 = findViewById(R.id.detail_student_textView2);
        textView3 = findViewById(R.id.detail_student_textView3);
        textView4 = findViewById(R.id.detail_student_textView4);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        studentList = bundle.getParcelableArrayList("studentList");

        textView1.setText("Họ tên: " + studentList.get(position).getName());
        textView2.setText("Số điện thoại: " + studentList.get(position).getPhone());
        textView3.setText("Quê quán: " + studentList.get(position).getAddress());
        textView4.setText("Trường Đại học Công nghiệp Hà Nội");
    }

}
