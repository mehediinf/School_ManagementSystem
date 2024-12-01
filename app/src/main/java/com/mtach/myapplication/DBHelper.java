package com.mtach.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "p_db", null, 10);

    }

    public static final String TAB_CONTACT = "contact";
    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    public static final String COL_PHONE="phone";
    public static final String COL_EMAIL = "email";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+TAB_CONTACT+"("+COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+COL_NAME+" TEXT,"+COL_PHONE+" TEXT,"+COL_EMAIL+" TEXT) ");

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TAB_CONTACT);
        onCreate(sqLiteDatabase);

    }
}
