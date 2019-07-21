package com.example.usingsqlite.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.usingsqlite.DTO.Company_DTO;
import com.example.usingsqlite.Database.Company_Database;

import java.util.ArrayList;
import java.util.List;

public class Company_DAO {

    Company_Database company_database;
    SQLiteDatabase sqLiteDatabase;

    public Company_DAO(Context context){
        company_database = new Company_Database(context);
    }

    public void addCompany(Company_DTO company){
        sqLiteDatabase = company_database.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Company_Database.Company_Name, company.getCompany_Name());
        contentValues.put(Company_Database.Company_Address, company.getCompany_Address());

        sqLiteDatabase.insert(Company_Database.TB_NAME, null, contentValues);
        sqLiteDatabase.close();
    }

    public List<Company_DTO> getAllCompany(){
        List<Company_DTO> listCompany = new ArrayList<>();

        sqLiteDatabase = company_database.getReadableDatabase();

        String query = "Select * from " + Company_Database.TB_NAME;

        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Company_DTO company = new Company_DTO();
            company.setID(cursor.getInt(0));
            company.setCompany_Name(cursor.getString(1));
            company.setCompany_Address(cursor.getString(2));
            listCompany.add(company);
            cursor.moveToNext();
        }

        return listCompany;
    }

    public int removeCompany(Company_DTO company){
        sqLiteDatabase = company_database.getWritableDatabase();
        return sqLiteDatabase.delete(Company_Database.TB_NAME, Company_Database.ID + " = " + company.getID(), null);
    }
}
