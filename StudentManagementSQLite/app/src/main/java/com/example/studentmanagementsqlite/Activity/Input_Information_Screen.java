package com.example.studentmanagementsqlite.Activity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.studentmanagementsqlite.Adapter.Custom_Adapter;
import com.example.studentmanagementsqlite.R;
import com.example.studentmanagementsqlite.Student_DAO.Student_DAO;
import com.example.studentmanagementsqlite.Student_DTO.Student_DTO;

import java.util.ArrayList;
import java.util.Calendar;

public class Input_Information_Screen extends AppCompatActivity {

    EditText editText_Name, editText_Code, editText_DOB, editText_Class, editText_Address;
    Button button_Confirm, button_Show;
    TextView textView_Exit;
    ArrayList<Student_DTO> studentList;
    Student_DAO student_dao;
    DatePickerDialog datePickerDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_information_screen);

        editText_Name = findViewById(R.id.input_screen_editText_Name);
        editText_Code = findViewById(R.id.input_screen_editText_Code);
        editText_DOB = findViewById(R.id.input_screen_editText_DOB);
        editText_Class = findViewById(R.id.input_screen_editText_Class);
        editText_Address = findViewById(R.id.input_screen_editText_Address);

        button_Confirm = findViewById(R.id.input_screen_button_Confirm);
        button_Show = findViewById(R.id.input_screen_button_Show);
        textView_Exit = findViewById(R.id.input_screen_textView_Exit);

        student_dao = new Student_DAO(Input_Information_Screen.this);

    }

    public void Confirm(View view){

        String student_Name = editText_Name.getText().toString();
        String student_Code = editText_Code.getText().toString();
        String student_DOB = editText_DOB.getText().toString();
        String student_Class = editText_Class.getText().toString();
        String student_Address = editText_Address.getText().toString();

        if(student_Name.isEmpty() || student_Code.isEmpty() || student_DOB.isEmpty() ||
                student_Class.isEmpty() || student_Address.isEmpty()){

            AlertDialog.Builder builder = new AlertDialog.Builder(Input_Information_Screen.this);
            builder.setCancelable(false);
            builder.setTitle("Warning");
            builder.setMessage("Các trường không được để trống");
            builder.setNegativeButton("OK", null);

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }else{

            Student_DTO student = new Student_DTO();

            student.setStudent_Name(editText_Name.getText().toString());
            student.setStudent_Code(editText_Code.getText().toString());
            student.setStudent_DOB(editText_DOB.getText().toString());
            student.setStudent_Class(editText_Class.getText().toString());
            student.setStudent_Address(editText_Address.getText().toString());

            student_dao.addStudent(student);

            Toast.makeText(Input_Information_Screen.this, "Thêm thành công", Toast.LENGTH_LONG).show();
        }

    }

    public void ShowAll(View view) {
        student_dao = new Student_DAO(Input_Information_Screen.this);
        studentList = student_dao.getALLStudent();
        if(studentList.isEmpty()){
            Intent intent = new Intent(Input_Information_Screen.this, Empty_List_Student.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(Input_Information_Screen.this, List_Student_Information.class);
            startActivity(intent);
        }
    }

    public void Exit(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(Input_Information_Screen.this);
        builder.setTitle("Alert");
        builder.setMessage("Bạn chắc chắn muốn thoát chứ?");
        builder.setCancelable(false);

        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new CountDownTimer(3000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        Toast.makeText(Input_Information_Screen.this, "Chương trình sẽ thoát trong " + millisUntilFinished/1000 + " giây ", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFinish() {
                        Toast.makeText(Input_Information_Screen.this, "Chương trình đã thoát", Toast.LENGTH_LONG).show();
                        finish();
                    }
                }.start();
            }
        });

        builder.setPositiveButton("No", null);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void Get_Student_DOB(View view) {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        datePickerDialog = new DatePickerDialog(Input_Information_Screen.this, DatePickerDialog.THEME_DEVICE_DEFAULT_DARK, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                editText_DOB.setText(dayOfMonth + "/" + (month+1) + "/" + year);
            }
        }, year, month, day);
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePickerDialog.show();

    }


}
