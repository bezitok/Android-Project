package com.example.studentmanagersqlite.Student_DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.studentmanagersqlite.Student_DTO.Student;
import com.example.studentmanagersqlite.Student_Database.Student_Database;

import java.util.ArrayList;
import java.util.List;

public class Student_DAO {

    Student_Database student_database;
    SQLiteDatabase sqLiteDatabase;
    String [] allColumns = {"",""};

    public Student_DAO(Context context) {
        student_database = new Student_Database(context);
    }

    public void open() {
        sqLiteDatabase = student_database.getWritableDatabase();
    }

    public void close() {
        student_database.close();
    }

    public boolean addStudent(Student student) {

        ContentValues contentValues = new ContentValues();

        contentValues.put(Student_Database.Table_Name, student.getStudent_Name());
        contentValues.put(Student_Database.Table_Name, student.getStudent_Code());
        contentValues.put(Student_Database.Table_Name, student.getStudent_DOB());
        contentValues.put(Student_Database.Table_Name, student.getStudent_Class());
        contentValues.put(Student_Database.Table_Name, student.getStudent_Address());

        long id  = sqLiteDatabase.insert(Student_Database.Table_Name, null, contentValues);

        sqLiteDatabase.close();

        if(id != 0){
            return true;
        }else {
            return false;
        }
    }

    public Student getStudent(int studentID) {
        SQLiteDatabase db = student_database.getReadableDatabase();

        Cursor cursor = db.query(Student_Database.Table_Name, null, Student_Database.student_ID
                + " = ? ", new String[]{String.valueOf(studentID)}, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        Student student = new Student(cursor.getString(1),
                cursor.getString(2), cursor.getString(3),
                cursor.getString(4), cursor.getString(5));

        return student;
    }

    public List<Student> getAllStudent() {
        List<Student> studentList = new ArrayList<>();
        sqLiteDatabase = student_database.getWritableDatabase();

        String sqliteQuery = "Select * from " + Student_Database.Table_Name;

        Cursor cursor = sqLiteDatabase.rawQuery(sqliteQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Student student = new Student();

                student.setStudent_ID(cursor.getInt(0));
                student.setStudent_Name(cursor.getString(1) + "");
                student.setStudent_Code(cursor.getString(2));
                student.setStudent_DOB(cursor.getString(3));
                student.setStudent_Class(cursor.getString(4));
                student.setStudent_Address(cursor.getString(5));

                studentList.add(student);
            } while (cursor.moveToNext());
        }

        sqLiteDatabase.close();
        return studentList;
    }

    public int EditStudent(Student student) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(Student_Database.student_Name, student.getStudent_Name());
        contentValues.put(Student_Database.student_Code, student.getStudent_Code());
        contentValues.put(Student_Database.student_DateOfBirth, student.getStudent_DOB());
        contentValues.put(Student_Database.student_Class, student.getStudent_Class());
        contentValues.put(Student_Database.student_Address, student.getStudent_Address());

        return sqLiteDatabase.update(Student_Database.Table_Name,
                contentValues, Student_Database.student_ID + " = ?",
                new String[]{String.valueOf(student.getStudent_ID())});
    }

    public int DeleteStudent(int id) {
        return sqLiteDatabase.delete(Student_Database.Table_Name,
                Student_Database.student_ID + " = ? ", new String[]{String.valueOf(id)});
    }
}
