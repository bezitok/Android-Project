package com.example.studentmanagementsqlite.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Student_Database extends SQLiteOpenHelper {

    public static final String DB_NAME = "Student_Database";
    public static final String TB_NAME = "Student";
    public static final String student_ID = "ID";
    public static final String student_Name = "Student_Name";
    public static final String student_Code = "Student_Code";
    public static final String student_DOB = "Student_DOB";
    public static final String student_Class = "Student_Class";
    public static final String student_Address = "Student_Address";
    public static final int VERSION = 1;

    public Student_Database(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlite_Query = "Create table " + TB_NAME + " ( " +
                student_ID + " integer primary key , " +
                student_Name + " text, " +
                student_Code + " text, " +
                student_DOB + " text, " +
                student_Class + " text, " +
                student_Address + " text " + " ) ";

        db.execSQL(sqlite_Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists " + TB_NAME);
        onCreate(db);
    }
}
