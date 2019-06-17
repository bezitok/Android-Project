package com.example.studentmanagementsqlite.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.studentmanagementsqlite.Adapter.Custom_Adapter;
import com.example.studentmanagementsqlite.R;
import com.example.studentmanagementsqlite.Student_DAO.Student_DAO;
import com.example.studentmanagementsqlite.Student_DTO.Student_DTO;

import java.util.ArrayList;

public class List_Student_Information extends AppCompatActivity {

    ListView listView;

    ArrayList<Student_DTO> studentList;
    Student_DAO student_dao;
    Custom_Adapter custom_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_student_information);

        listView = findViewById(R.id.listView);

        studentList.addAll(student_dao.getALLStudent());

        if(custom_adapter!=null){
            custom_adapter.notifyDataSetChanged();
        }else {
            custom_adapter = new Custom_Adapter(List_Student_Information.this, R.layout.one_student_listview, studentList);
            listView.setAdapter(custom_adapter);
        }

    }
}
