package com.example.sqlite.Staff;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Staff_Database extends SQLiteOpenHelper {

    public static final String DB_QuanLYNhanVien = "QuanLyNhanVien";
    public static final int DB_Version = 1;
    public static final String Table_NhanVien = "NhanVien";
    public static final String ID_NhanVien = "_id";
    public static final String TenNhanVien = "TenNhanVien";

    public Staff_Database(Context context) {
        super(context, DB_QuanLYNhanVien, null, DB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String cauTruyVan = "Create table " + Table_NhanVien + "(" + ID_NhanVien +"integer primary key autoincrement, " + TenNhanVien + " text)";
        db.execSQL(cauTruyVan);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + Table_NhanVien);
        onCreate(db);
    }
}
