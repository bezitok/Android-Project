package com.example.orderfood.LoginAndSignIn.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.orderfood.LoginAndSignIn.DTO.Staff_DTO;
import com.example.orderfood.LoginAndSignIn.Database.Staff_Database;

public class Staff_DAO {

    SQLiteDatabase database;

    public Staff_DAO(Context context) {
        Staff_Database staff_database = new Staff_Database(context);
        database = staff_database.open();
    }

    public long Add_Staff(Staff_DTO staff_dto){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Staff_Database.TB_Staff_UserName, staff_dto.getStaff_UserName());
        contentValues.put(Staff_Database.TB_Staff_Password, staff_dto.getStaff_Password());
        contentValues.put(Staff_Database.TB_Staff_Sex, staff_dto.getStaff_Sex());
        contentValues.put(Staff_Database.TB_Staff_Date_Of_Birth, staff_dto.getStaff_Date_Of_Birth());
        contentValues.put(Staff_Database.TB_Staff_Identity_Card, staff_dto.getStaff_Identity_Card());

        long check = database.insert(Staff_Database.TB_Staff, null, contentValues);
         return check;
    }
}
