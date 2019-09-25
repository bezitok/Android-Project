package com.example.orderfood.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.orderfood.DTO.Food_DTO;
import com.example.orderfood.Database.Create_Database;

public class Food_DAO {

    Create_Database create_database;
    SQLiteDatabase sqLiteDatabase;

    public Food_DAO(Context context){
        create_database = new Create_Database(context);
    }

    public boolean addFood(Food_DTO food){
        sqLiteDatabase = create_database.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Create_Database.TB_FOOD_NAME, food.getFoodName());
        contentValues.put(Create_Database.TB_FOOD_COST, food.getFoodCost());
        contentValues.put(Create_Database.TB_FOOD_ID_KIND_OF_FOOD, food.getId_KindOfFood());
        contentValues.put(Create_Database.TB_FOOD_IMAGE, food.getFoodImage());

        long check = sqLiteDatabase.insert(Create_Database.TB_FOOD, null, contentValues);
        if (check != 0){
            return true;
        }else
            return false;
    }

}
