package com.example.staffsqlite.Staff_DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.staffsqlite.Staff_DTO.Staff_DTO;
import com.example.staffsqlite.Staff_Database.Staff_Database;

public class Staff_DAO {

    Staff_Database staff_database;
    SQLiteDatabase sqLiteDatabase;

    public Staff_DAO(Context context){
        staff_database = new Staff_Database(context);
    }



    public void addStaff(Staff_DTO staff){


        sqLiteDatabase = staff_database.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        
        contentValues.put(Staff_Database.staff_Name, staff.getStaff_Name());
        contentValues.put(Staff_Database.staff_Age, staff.getAge());

        sqLiteDatabase.insert(Staff_Database.TABLE_NAME, null, contentValues);
        sqLiteDatabase.close();

    }
}
