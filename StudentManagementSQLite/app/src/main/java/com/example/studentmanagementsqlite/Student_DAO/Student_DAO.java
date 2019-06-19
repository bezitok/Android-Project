package com.example.studentmanagementsqlite.Student_DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.studentmanagementsqlite.Database.Student_Database;
import com.example.studentmanagementsqlite.Student_DTO.Student_DTO;

import java.util.ArrayList;
import java.util.List;

public class Student_DAO {

    Student_Database student_database;
    SQLiteDatabase sqLiteDatabase;
    String[] column_Student_Database = {Student_Database.student_ID, Student_Database.student_Name,
            Student_Database.student_Code, Student_Database.student_DOB, Student_Database.student_Class, Student_Database.student_Address};

    public Student_DAO(Context context){
        student_database = new Student_Database(context);
    }

    public void addStudent(Student_DTO student){
        sqLiteDatabase = student_database.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Student_Database.student_Name, student.getStudent_Name());
        contentValues.put(Student_Database.student_Code, student.getStudent_Code());
        contentValues.put(Student_Database.student_DOB, student.getStudent_DOB());
        contentValues.put(Student_Database.student_Class, student.getStudent_Class());
        contentValues.put(Student_Database.student_Address, student.getStudent_Address());

        sqLiteDatabase.insert(Student_Database.TB_NAME, null, contentValues);
        sqLiteDatabase.close();
    }

    public Student_DTO getStudentByID(int id){

        sqLiteDatabase = student_database.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(Student_Database.TB_NAME, new String[]
                { Student_Database.student_ID, Student_Database.student_Name, Student_Database.student_Code, Student_Database.student_DOB, Student_Database.student_Class, Student_Database.student_Address},
                Student_Database.student_ID + " = ? ",
                new String[] {String.valueOf(id)}, null, null, null, null);
        if (cursor != null){
            cursor.moveToFirst();
        }

        Student_DTO student = new Student_DTO(cursor.getString(1), cursor.getString(2),
                cursor.getString(3), cursor.getString(4), cursor.getString(5));

        cursor.close();
        sqLiteDatabase.close();
        return student;
    }

    public ArrayList<Student_DTO> getALLStudent(){

        ArrayList<Student_DTO> listStudent = new ArrayList<>();



        sqLiteDatabase = student_database.getWritableDatabase();
        sqLiteDatabase = student_database.getReadableDatabase();

        String sqlite_Query = "Select * from " + Student_Database.TB_NAME;

        Cursor cursor = sqLiteDatabase.rawQuery(sqlite_Query, null);

//        Cursor cursor = sqLiteDatabase.query(Student_Database.TB_NAME, column_Student_Database, null, null, null, null, null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()){

            Student_DTO student = new Student_DTO();

            student.setStudent_ID(cursor.getInt(0));
            student.setStudent_Name(cursor.getString(1));
            student.setStudent_Code(cursor.getString(2));
            student.setStudent_DOB(cursor.getString(3));
            student.setStudent_Class(cursor.getString(4));
            student.setStudent_Address(cursor.getString(5));

            listStudent.add(student);
            cursor.moveToNext();
        }

        return listStudent;
    }

    public int editStudent(Student_DTO student){
        sqLiteDatabase = student_database.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(Student_Database.student_Name, student.getStudent_Name());
        contentValues.put(Student_Database.student_Code, student.getStudent_Code());
        contentValues.put(Student_Database.student_DOB, student.getStudent_DOB());
        contentValues.put(Student_Database.student_Class, student.getStudent_Class());
        contentValues.put(Student_Database.student_Address, student.getStudent_Address());

        return sqLiteDatabase.update(Student_Database.TB_NAME, contentValues, Student_Database.student_ID + " = ? ",
                new String[] {String.valueOf(student.getStudent_ID())});
    }

    public int deleteStudent(Student_DTO student){
        sqLiteDatabase = student_database.getWritableDatabase();
        return sqLiteDatabase.delete(Student_Database.TB_NAME, Student_Database.student_ID + "=?" , new String[] {String.valueOf(student.getStudent_ID())});
    }

}
