package com.example.sqlite_practice.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.sqlite_practice.DTO.Student_DTO;
import com.example.sqlite_practice.Database.DB_Student;

public class Student_DAO {

    Context context;
    SQLiteDatabase sqLiteDatabase;
    DB_Student db_student;


    public Student_DAO(Context context) {
        DB_Student db_student = new DB_Student(context);
    }

    public void open(){
        sqLiteDatabase = db_student.getWritableDatabase();
    }

    public boolean addStudent(Student_DTO student_dto){

        ContentValues contentValues = new ContentValues();
        contentValues.put(DB_Student.TABLE_NAME, student_dto.getName());
        long id = sqLiteDatabase.insert(DB_Student.TABLE_NAME, null, contentValues);
        if(id != 0){
            return true;
        }else
            return false;
    }
}
