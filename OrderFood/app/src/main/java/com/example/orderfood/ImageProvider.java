package com.example.orderfood;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

import com.example.orderfood.Database.Create_Database;

public class ImageProvider extends ContentProvider {

    public static final String AUTHOR = "com.example.orderfood.ImageProvider";
    public static final String URI_TABLE_FOOD_IMAGE = "content://" + AUTHOR + "/" + Create_Database.TB_FOOD + "/" + Create_Database.TB_FOOD_IMAGE;

    public static UriMatcher uriMatcher;

    @Override
    public boolean onCreate() {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHOR, Create_Database.TB_FOOD, 1);
        uriMatcher.addURI(AUTHOR, Create_Database.TB_FOOD + "/" + Create_Database.TB_FOOD_IMAGE + "/#" , 2);
        return false;
    }


    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
