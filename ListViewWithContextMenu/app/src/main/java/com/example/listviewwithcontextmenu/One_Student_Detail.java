package com.example.listviewwithcontextmenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class One_Student_Detail extends AppCompatActivity  {

    ArrayList<Student> studentArrayList = new ArrayList<>();
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

        if ((studentArrayList = bundle.getParcelableArrayList("studentList")) == null){
            Log.e("Lỗi nè", "Có lỗi");
        }else{
            textView1.setText("Họ tên: " + studentArrayList.get(position).getName());
            textView2.setText("Số điện thoại: " + studentArrayList.get(position).getPhone());
            textView3.setText("Quê quán: " + studentArrayList.get(position).getAddress());
            textView4.setText("Trường Đại học Công Nghiệp Hà Nội");
        }

    }

}
