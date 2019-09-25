package com.example.orderfood.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.orderfood.DTO.Table_DTO;
import com.example.orderfood.Database.Create_Database;

import java.util.ArrayList;
import java.util.List;

public class Table_DAO {

    SQLiteDatabase sqLiteDatabase;
    Create_Database create_database;

    public Table_DAO(Context context){
        create_database = new Create_Database(context);
    }

    public boolean addTable(String tableName){

        sqLiteDatabase = create_database.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(Create_Database.TB_TABLE_NAME, tableName);
        contentValues.put(Create_Database.TB_TABLE_STATUS, "false");

        long check = sqLiteDatabase.insert(Create_Database.TB_TABLE, null, contentValues);

        if (check != 0) {
            return true;
        }else {
            return false;
        }
    }

    public List<Table_DTO> getAllTableInfo(){

        sqLiteDatabase = create_database.getWritableDatabase();
        sqLiteDatabase = create_database.getReadableDatabase();

        List<Table_DTO> tableList = new ArrayList<>();

        String query = "Select * from " + Create_Database.TB_TABLE;

        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            Table_DTO table = new Table_DTO();
            table.setId_table(cursor.getInt(cursor.getColumnIndex(Create_Database.TB_TABLE_ID)));
            table.setTableName(cursor.getString(cursor.getColumnIndex(Create_Database.TB_TABLE_NAME)));
            tableList.add(table);
            cursor.moveToNext();
        }

        return tableList;
    }
}
