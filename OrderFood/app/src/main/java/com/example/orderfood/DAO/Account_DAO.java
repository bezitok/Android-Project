package com.example.orderfood.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.orderfood.DTO.Account_DTO;
import com.example.orderfood.Database.Create_Database;

public class Account_DAO {

    Create_Database create_database;
    SQLiteDatabase sqLiteDatabase;

    public Account_DAO (Context context){
        create_database = new Create_Database(context);
        sqLiteDatabase = create_database.open();
    }

    public void createNewAccount(Account_DTO account){

        ContentValues contentValues = new ContentValues();

        contentValues.put(Create_Database.TB_ACCOUNT_ID, account.getId_account());
        contentValues.put(Create_Database.TB_ACCOUNT_USER_NAME, account.getUser_name());
        contentValues.put(Create_Database.TB_ACCOUNT_PASSWORD, account.getPassword());
        sqLiteDatabase.insert(Create_Database.TB_ACCOUNT, null, contentValues);

        sqLiteDatabase.close();
    }

}
