package com.example.orderfood.LoginAndSignIn.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Staff_Database extends SQLiteOpenHelper {

    public static String TB_Staff = "Staff";
    public static String TB_Food = "Food";
    public static String TB_KindOfFood = "Kind_Of_Food";
    public static String TB_Ordered_Table = "Ordered_Table";
    public static String TB_Order = "Ordered";
    public static String TB_OrderDetail = "Order_Detail";

    public static String TB_Staff_ID = "Staff_ID";
    public static String TB_Staff_UserName = "Staff_User_Name";
    public static String TB_Staff_Password = "Staff_Password";
    public static String TB_Staff_Sex = "Staff_Sex";
    public static String TB_Staff_Date_Of_Birth = "Staff_Date_Of_Birth";
    public static String TB_Staff_Identity_Card = "Staff_Identity_Card";

    public static String TB_Food_ID = "Food_ID";
    public static String TB_Food_Name = "Food_Name";
    public static String TB_Food_Price = "Food_Price";
    public static String TB_Food_KindOfFood_ID = "Kind_Of_Food_ID";

    public static String TB_KindOfFood_ID = "Kind_Of_Food_ID";
    public static String TB_KindOfFood_Name = "Kind_Of_Food_Name";

    public static String TB_Ordered_Table_ID = "Ordered_Table_ID";
    public static String TB_Ordered_Table_Name = "Ordered_Table_Name";
    public static String TB_Ordered_Table_Status = "Ordered_Table_Status";

    public static String TB_Order_ID = "Order_ID";
    public static String TB_Order_Staff_Name = "Order_Staff_Name";
    public static String TB_Order_Date = "Order_Date";
    public static String TB_Order_Status = "Order_Status";
    public static String TB_Order_Table_ID = "Order_Table_ID";

    public static String TB_OrderDetail_ID = "Order_Detail_ID";
    public static String TB_OrderDetail_KindOfFood_ID = "Order_Detail_Kind_Of_Food_ID";
    public static String TB_OrderDetail_Count = "Count";

    public Staff_Database(Context context) {
        super(context, "Staff_Database", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tb_Staff = "Create table " + TB_Staff + "(" + TB_Staff_ID + "integer primary key autoincrement, " + TB_Staff_UserName + "text, " + TB_Staff_Password + "text, " + TB_Staff_Sex + "text, " + TB_Staff_Date_Of_Birth + "text, " + TB_Staff_Identity_Card + "integer" + ")";
        String tb_Food = "Create table " + TB_Food + "(" + TB_Food_ID + "integer primary key autoincrement, " + TB_Food_Name + "text, " + TB_Food_Price + "integer, " + TB_Food_KindOfFood_ID + "integer" + ")";
        String tb_KindOfFood = "Create table " + TB_KindOfFood + "(" + TB_KindOfFood_ID + "integer primary key autoincrement, " + TB_KindOfFood_Name + "text" + ")";
        String tb_OrderedTable = " Create table " + TB_Ordered_Table + " ( " + TB_Ordered_Table_ID + "integer primary key autoincrement, " + TB_Ordered_Table_Name + "text, " + TB_Ordered_Table_Status + "text" + " ) ";
        String tb_Order = "Create table " + TB_Order + " ( " + TB_Order_ID + " integer primary key autoincrement, " + TB_Order_Staff_Name + "text, " + TB_Order_Date + "text, " + TB_Order_Status + "text, " + TB_Order_Table_ID + "integer" + ")";
        String tb_OrderDetail = "Create table " + TB_OrderDetail + "(" + TB_OrderDetail_ID + "integer, " + TB_OrderDetail_KindOfFood_ID + "integer, " + TB_OrderDetail_Count + "integer, " + " primary key (" + TB_OrderDetail_ID + ", " + TB_OrderDetail_KindOfFood_ID + ")" + ")";

        db.execSQL(tb_Staff);
        db.execSQL(tb_Food);
        db.execSQL(tb_KindOfFood);
        db.execSQL(tb_OrderedTable);
        db.execSQL(tb_Order);
        db.execSQL(tb_OrderDetail);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public SQLiteDatabase open(){
        return getWritableDatabase();
    }
}
