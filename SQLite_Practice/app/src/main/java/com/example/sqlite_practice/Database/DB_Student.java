package com.example.sqlite_practice.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DB_Student extends SQLiteOpenHelper {

    public static final String DB_NAME = "Student Management";
    public static final String TABLE_NAME = "Student";
    public static final String ID = "ID";
    public static final String NAME = "Name";
    public static final String CLASS = "Class";
    public static final int DB_VERSION = 1;
    Context context;

    public DB_Student(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlQuery = "Create table " + TABLE_NAME + " ( " +
                ID + " integer primary key autoincrement, " +
                NAME + " text not null, " +
                CLASS + " text " + " ) ";
        db.execSQL(sqlQuery);
        Toast.makeText(context, "Create successfully", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sqlQuery = "Drop table if exists " + TABLE_NAME ;
        db.execSQL(sqlQuery);
        onCreate(db);
        Toast.makeText(context, "Drop successfully", Toast.LENGTH_SHORT).show();
    }
}
