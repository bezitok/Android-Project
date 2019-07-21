package com.example.orderfood.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Create_Database extends SQLiteOpenHelper {

    public static final String DB_NAME = "Order Food";
    public static final int DB_VERSION = 1;

    public static final String TB_ACCOUNT = "ACCOUNT";
    public static final String TB_FOOD = "FOOD";
    public static final String TB_KIND_OF_FOOD = "KIND_OF_FOOD";
    public static final String TB_TABLE = "TABLE_ORDER";
    public static final String TB_ORDER = "ORDERED";
    public static final String TB_DETAIL_ORDER = "DETAIL_ORDER";

    public static final String TB_ACCOUNT_ID = "ID_ACCOUNT";
    public static final String TB_ACCOUNT_USER_NAME = "USER_NAME";
    public static final String TB_ACCOUNT_PASSWORD = "PASSWORD";

    public static final String TB_FOOD_ID = "ID_FOOD";
    public static final String TB_FOOD_NAME = "FOOD_NAME";
    public static final String TB_FOOD_COST = "FOOD_COST";
    public static final String TB_FOOD_ID_KIND_OF_FOOD = "ID_KIND_OF_FOOD";

    public static final String TB_KIND_OF_FOOD_ID = "ID_KIND_OF_FOOD";
    public static final String TB_KIND_OF_FOOD_NAME = "KIND_OF_FOOD_NAME";

    public static final String TB_TABLE_ID = "ID_TABLE";
    public static final String TB_TABLE_NAME = "TABLE_NAME";
    public static final String TB_TABLE_STATUS = "TABLE_STATUS";

    public static final String TB_ORDER_ID = "ID_ORDER";
    public static final String TB_ORDER_ID_STAFF = "ID_STAFF";
    public static final String TB_ORDER_DATE = "ORDER_DATE";
    public static final String TB_ORDER_STATUS = "ORDER_STATUS";
    public static final String TB_ORDER_ID_TABLE = "ID_TABLE";

    public static final String TB_DETAIL_ORDER_ID_ORDER = "ID_ORDER";
    public static final String TB_DETAIL_ORDER_ID_FOOD = "ID_FOOD";
    public static final String TB_DETAIL_ORDER_AMOUNT = "AMOUNT";

    String sqlite_Create_TB_ACCOUNT = "Create table " + TB_ACCOUNT + " ( " +
                                TB_ACCOUNT_ID + " int primary key, " +
                                TB_ACCOUNT_USER_NAME + " text, " +
                                TB_ACCOUNT_PASSWORD + " text " + " ) ";

    String sqlite_Create_TB_FOOD = "Create table " + TB_FOOD + " ( " +
                                TB_FOOD_ID + " int primary key, " +
                                TB_FOOD_NAME + " text, " +
                                TB_FOOD_COST + " text, " +
                                TB_FOOD_ID_KIND_OF_FOOD + " int " + " ) ";

    String sqlite_Create_TB_KIND_OF_FOOD = "Create table " + TB_KIND_OF_FOOD + " ( " +
                                TB_KIND_OF_FOOD_ID + " int primary key, " +
                                TB_KIND_OF_FOOD_NAME + " text " + " ) ";

    String sqlite_Create_TB_TABLE = "Create table " + TB_TABLE + " ( " +
                                TB_TABLE_ID + " int primary key, " +
                                TB_TABLE_NAME + " text, " +
                                TB_TABLE_STATUS + " text " + " ) ";

    String sqlite_Create_TB_ORDER = "Create table " + TB_ORDER + " ( " +
                                TB_ORDER_ID + " int primary key, " +
                                TB_ORDER_ID_STAFF + " int, " +
                                TB_ORDER_DATE + " text, " +
                                TB_ORDER_STATUS + " text, " +
                                TB_ORDER_ID_TABLE + " int " + " ) ";

    String sqlite_Create_TB_DETAIL_ORDER = "Create table " + TB_DETAIL_ORDER + " ( " +
            TB_DETAIL_ORDER_ID_ORDER + " int, " +
            TB_DETAIL_ORDER_ID_FOOD + " int, " +
            TB_DETAIL_ORDER_AMOUNT + " int, " + "primary key " + " ( " +
            TB_DETAIL_ORDER_ID_FOOD + ", " +
            TB_DETAIL_ORDER_ID_ORDER + " ) " + " ) ";



    public Create_Database(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlite_Create_TB_ACCOUNT);
        db.execSQL(sqlite_Create_TB_FOOD);
        db.execSQL(sqlite_Create_TB_KIND_OF_FOOD);
        db.execSQL(sqlite_Create_TB_TABLE);
        db.execSQL(sqlite_Create_TB_ORDER);
        db.execSQL(sqlite_Create_TB_DETAIL_ORDER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public SQLiteDatabase open(){
        return this.getWritableDatabase();
    }
}
