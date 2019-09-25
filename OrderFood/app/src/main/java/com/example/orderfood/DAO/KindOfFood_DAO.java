package com.example.orderfood.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.orderfood.DTO.KindOfFood_DTO;
import com.example.orderfood.Database.Create_Database;

import java.util.ArrayList;
import java.util.List;

public class KindOfFood_DAO {

    Create_Database create_database;
    SQLiteDatabase sqLiteDatabase;

    public KindOfFood_DAO(Context context){
        create_database = new Create_Database(context);
    }

    public boolean addKindOfFood(String kindOfFood_Name){
        sqLiteDatabase = create_database.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Create_Database.TB_KIND_OF_FOOD_NAME, kindOfFood_Name);

        long check = sqLiteDatabase.insert(Create_Database.TB_KIND_OF_FOOD, null, contentValues);

        if (check != 0){
            return true;
        }else {
            return false;
        }
    }

    public List<KindOfFood_DTO> getAllKindOfFoodInfo(){

        sqLiteDatabase = create_database.getWritableDatabase();
        sqLiteDatabase = create_database.getReadableDatabase();

        List<KindOfFood_DTO> list = new ArrayList<>();

        String query = "Select * from " + Create_Database.TB_KIND_OF_FOOD;

        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            KindOfFood_DTO kindOfFood = new KindOfFood_DTO();

            kindOfFood.setId_KindOfFood(cursor.getInt(cursor.getColumnIndex(Create_Database.TB_KIND_OF_FOOD_ID)));
            kindOfFood.setKindOfFoof_Name(cursor.getString(cursor.getColumnIndex(Create_Database.TB_KIND_OF_FOOD_NAME)));

            list.add(kindOfFood);
            cursor.moveToNext();
        }

        return list;
    }

    public String getKindOfFoodImage(int id){

        sqLiteDatabase = create_database.getWritableDatabase();
        sqLiteDatabase = create_database.getReadableDatabase();

        String image = "";


        List<KindOfFood_DTO> list = new ArrayList<>();

        String query = "Select * from "  + Create_Database.TB_FOOD + " where " + Create_Database.TB_FOOD_ID
                + " = '" + id + "' " + " and " + Create_Database.TB_FOOD_IMAGE + " != ''" + " order by "
                + Create_Database.TB_FOOD_ID + " limit 1 ";

        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()){


            image = cursor.getString(cursor.getColumnIndex(Create_Database.TB_FOOD_IMAGE));

            cursor.moveToNext();
        }

        return image;
    }
}
