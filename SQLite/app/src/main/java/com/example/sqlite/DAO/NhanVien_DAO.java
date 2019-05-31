package com.example.sqlite.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.sqlite.DTO.Staff;
import com.example.sqlite.Staff.Staff_Database;

public class NhanVien_DAO {

    SQLiteDatabase sqLiteDatabase;
    Staff_Database staff_database;

    public NhanVien_DAO(Context context) {
        staff_database = new Staff_Database(context);
    }

    public void open(){
        sqLiteDatabase = staff_database.getWritableDatabase();
    }

    public void close(){
        sqLiteDatabase.close();
    }

    public boolean addStaff(Staff staff){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Staff_Database.Table_NhanVien, staff.getStaff_Name());
        long id = sqLiteDatabase.insert(Staff_Database.Table_NhanVien, null, contentValues);

        if(id != 0){
            return true;
        }else{
            return false;
        }
    }
}
