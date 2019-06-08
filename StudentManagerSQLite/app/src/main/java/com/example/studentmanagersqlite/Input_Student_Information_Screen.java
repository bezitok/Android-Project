package com.example.studentmanagersqlite;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.studentmanagersqlite.Student_DAO.Student_DAO;
import com.example.studentmanagersqlite.Student_Database.Student_Database;

import com.example.studentmanagersqlite.Student_DTO.Student;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Input_Student_Information_Screen extends AppCompatActivity {

    EditText editText1, editText2, editText3, editText4, editText5;
    Student_DAO student_dao;
    DatePickerDialog datePickerDialog;
    List<Student> studentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_student_information);

        editText1 = findViewById(R.id.input_student_editText1);
        editText2 = findViewById(R.id.input_student_editText2);
        editText3 = findViewById(R.id.input_student_editText3);
        editText4 = findViewById(R.id.input_student_editText4);
        editText5 = findViewById(R.id.input_student_editText5);

        student_dao = new Student_DAO(Input_Student_Information_Screen.this);
        student_dao.open();
    }

    public void AddStudent(View view) {
        //Kiểm tra xem các trường đã được điền hay chưa
        if (editText1.getText().toString().isEmpty()
                | editText2.getText().toString().isEmpty()
                | editText3.getText().toString().isEmpty()
                | editText4.getText().toString().isEmpty()
                | editText5.getText().toString().isEmpty()) {

            AlertDialog.Builder builder = new AlertDialog.Builder(Input_Student_Information_Screen.this);
            builder.setTitle("Warning");
            builder.setMessage("Các trường không được bỏ trống");
            builder.setPositiveButton("OK", null);
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }else {
            Student student = new Student();

            student.setStudent_Name(editText1.getText().toString());
            student.setStudent_Code(editText2.getText().toString());
            student.setStudent_DOB(editText3.getText().toString());
            student.setStudent_Class(editText4.getText().toString());
            student.setStudent_Address(editText5.getText().toString());

            studentList.add(student);
            boolean check = student_dao.addStudent(student);
            if(check){
                Toast.makeText(Input_Student_Information_Screen.this, "Thêm thành công", Toast.LENGTH_LONG).show();
            }
            student_dao.close();
        }
    }

    public void ShowAllStudent(View view) {

    }

    public void Exit(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Input_Student_Information_Screen.this);
        builder.setTitle("Exit");
        builder.setMessage("Bạn chắc chắn muốn thoát chứ?");
        builder.setCancelable(false);
        builder.setPositiveButton("No", null);
        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new CountDownTimer(3000, 1000) {

                    @Override
                    public void onTick(long millisUntilFinished) {
                        Toast.makeText(Input_Student_Information_Screen.this, "Chương trình sẽ thoát trong " + millisUntilFinished/1000 + " giây", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFinish() {
                        Toast.makeText(Input_Student_Information_Screen.this, "Chương trình đã thoát", Toast.LENGTH_LONG).show();
                        finish();
                    }
                }.start();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void Student_GetDOB(View view) {
        editText3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                datePickerDialog = new DatePickerDialog(Input_Student_Information_Screen.this, AlertDialog.THEME_DEVICE_DEFAULT_DARK, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        editText3.setText(dayOfMonth + "/" + (month+1) + "/" + year);
                    }
                }, year, month, day);
                datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
                datePickerDialog.show();
            }
        });
    }
}
