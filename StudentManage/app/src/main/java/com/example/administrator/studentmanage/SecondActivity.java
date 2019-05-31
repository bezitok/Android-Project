package com.example.administrator.studentmanage;

import android.content.Intent;
import android.os.Bundle;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    EditText editText1, editText2, editText3;
    Button button1, button2;
    ArrayList<Student> studentList = new ArrayList<>();

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        editText1 = findViewById(R.id.secondActivityEditText1);
        editText2 = findViewById(R.id.secondActivityEditText2);
        editText3 = findViewById(R.id.secondActivityEditText3);
        button1 = findViewById(R.id.secondActivityButton1);
        button2 = findViewById(R.id.secondActivityButton2);

    }

    public void AddStudent(View view) {
        Student student = new Student();
        student.setStudentImage(R.drawable.icons8anonymousmask48);
        student.setStudentName(editText1.getText().toString());
        student.setStudentAge(Integer.parseInt(editText2.getText().toString()));
        student.setStudentAddress(editText3.getText().toString());

        studentList.add(student);
        Toast.makeText(this, "Thêm thành công", Toast.LENGTH_SHORT).show();
    }


    public void ShowStudentInformation(View view) {
        Intent intent = new Intent(SecondActivity.this, Third_Activity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("key", studentList);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}