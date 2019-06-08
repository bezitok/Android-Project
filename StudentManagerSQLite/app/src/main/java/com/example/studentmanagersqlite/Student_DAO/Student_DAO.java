package com.example.studentmanagersqlite.Student_DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.studentmanagersqlite.Student_DTO.Student;
import com.example.studentmanagersqlite.Student_Database.Student_Database;

public class Student_DAO {

    Student_Database student_database;
    SQLiteDatabase sqLiteDatabase;

    public Student_DAO(Context context) {
        student_database = new Student_Database(context);
    }

    public void open(){
        sqLiteDatabase = student_database.getWritableDatabase();
    }

    public void close(){
        student_database.close();
    }

    public boolean addStudent(Student student){
        ContentValues contentValues = new ContentValues();

        contentValues.put(Student_Database.Table_Name, student.getStudent_Name());
        contentValues.put(Student_Database.Table_Name, student.getStudent_Code());
        contentValues.put(Student_Database.Table_Name, student.getStudent_DOB());
        contentValues.put(Student_Database.Table_Name, student.getStudent_Class());
        contentValues.put(Student_Database.Table_Name, student.getStudent_Address());

        long id = sqLiteDatabase.insert(Student_Database.Table_Name, null, contentValues);

        if(id != 0){
            return true;
        }else{
            return false;
        }
    }

}
