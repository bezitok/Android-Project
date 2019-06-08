package com.example.studentmanagersqlite.Student_Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Student_Database extends SQLiteOpenHelper {

    public static final String DB_Name = "Student_Database";
    public static final int DB_Version = 1;
    public static final String Table_Name = "Student";
    public static final String student_ID = "Student_ID";
    public static final String student_Name = "Student_Name";
    public static final String student_Code = "Student_Code";
    public static final String student_DateOfBirth = "Student_DOB";
    public static final String student_Class = "Student_Class";
    public static final String student_Address = "Student_Address";

    public Student_Database(Context context) {
        super(context, DB_Name, null, DB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQLite_Query = ("Create table " + Table_Name + " ( " + student_ID + " integer primary key autoincrement, "
        + student_Name + " text, " + student_Code + " text, " + student_DateOfBirth + " text, " + student_Class + " text, "
        + student_Address + " text )");
        db.execSQL(SQLite_Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists " + Table_Name);
        onCreate(db);
    }
}
