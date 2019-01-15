package com.kitkatstudio.sqliteadapters.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;

public class DatabaseCreation extends SQLiteOpenHelper {

    public String query = "CREATE TABLE " + DatabaseColumns.TABLE_NAME + " ( " +
            DatabaseColumns.NAME + " TEXT, " +
            DatabaseColumns.EMAIL + " TEXT, " +
            DatabaseColumns.PASSWORD + " TEXT)";

    public DatabaseCreation(Context context) {
        super(context, "student.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}