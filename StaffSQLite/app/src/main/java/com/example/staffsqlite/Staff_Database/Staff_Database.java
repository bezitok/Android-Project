package com.example.staffsqlite.Staff_Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Staff_Database extends SQLiteOpenHelper {

    public static final String DB_Name = "Staff_Management";
    public static int VERSION = 1;
    public static String TABLE_NAME = "Staff";
    public static final String staff_ID = "ID";
    public static final  String staff_Name = "Name";
    public static final String staff_Age = "Age";

    public Staff_Database(Context context) {
        super(context, DB_Name, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlite_Query = "Create table " + TABLE_NAME + " ( "
                + staff_ID + " int  primary key, "
                + staff_Name + " text, "
                + staff_Age + " text )";
        db.execSQL(sqlite_Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists " + TABLE_NAME);
        onCreate(db);
    }
}
