package com.example.usingsqlite.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Company_Database extends SQLiteOpenHelper {

    public static final String DB_NAME = "Company_Database";
    public static final int DB_VERSION = 1;
    public static final String TB_NAME = "Company";
    public static final String ID = "ID";
    public static final String Company_Name = "Name";
    public static final String Company_Address = "Address";

    public Company_Database(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqliteQuery = "Create table " + TB_NAME + " ( " +
                ID + " int primary key, " +
                Company_Name + " text, " +
                Company_Address + " text" + " ) ";

        db.execSQL(sqliteQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists " + TB_NAME);
        onCreate(db);
    }
}
