package com.example.orderfood.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.orderfood.DTO.Account_DTO;
import com.example.orderfood.Database.Create_Database;

public class Account_DAO {

    Create_Database create_database;
    SQLiteDatabase sqLiteDatabase;

    public Account_DAO (Context context){
        create_database = new Create_Database(context);

    }

    public void createNewAccount(Account_DTO account){

        sqLiteDatabase = create_database.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(Create_Database.TB_ACCOUNT_USER_NAME, account.getUser_name());
        contentValues.put(Create_Database.TB_ACCOUNT_PASSWORD, account.getPassword());

        sqLiteDatabase.insert(Create_Database.TB_ACCOUNT, null, contentValues);

        sqLiteDatabase.close();
    }

    public boolean processLogin(String userName, String password){

        sqLiteDatabase = create_database.getWritableDatabase();
        sqLiteDatabase = create_database.getReadableDatabase();

        String query = "Select * from " + Create_Database.TB_ACCOUNT + " where " +
                Create_Database.TB_ACCOUNT_USER_NAME + " = " + " '" + userName + "' " + " and " +
                Create_Database.TB_ACCOUNT_PASSWORD + " = " + " '" + password + "' " ;

        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        if(cursor.getCount() != 0){
            return true;
        }else{
            return false;
        }
    }
}