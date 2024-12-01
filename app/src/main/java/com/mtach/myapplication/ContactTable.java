package com.mtach.myapplication;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ContactTable extends DBHelper{
    public ContactTable(@Nullable Context context) {
        super(context);
    }


    public void InsertContact(ContactModel cm){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_NAME,cm.getName());
        cv.put(COL_PHONE,cm.getPhone());
        cv.put(COL_EMAIL,cm.getEmail());

        db.insert(TAB_CONTACT,null,cv);

        db.close();


    }

    @SuppressLint("Range")
    public ArrayList<ContactModel> ReadContacts() {

        ArrayList<ContactModel> contacts = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(TAB_CONTACT,null,null,null,null,null,COL_NAME);

        if (cursor.moveToFirst()){
            do{
                ContactModel cm = new ContactModel();
                cm.setId(cursor.getInt(cursor.getColumnIndex(COL_ID)));
                cm.setName(cursor.getString(cursor.getColumnIndex(COL_NAME)));
                cm.setPhone(cursor.getString(cursor.getColumnIndex(COL_PHONE)));
                cm.setEmail(cursor.getString(cursor.getColumnIndex(COL_EMAIL)));
                contacts.add(cm);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return contacts;
    }

    public void UpdateContact(ContactModel cm){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_NAME,cm.getName());
        cv.put(COL_PHONE,cm.getPhone());
        cv.put(COL_EMAIL,cm.getEmail());

        db.update(TAB_CONTACT,cv,COL_ID+" = ?",new String[]{String.valueOf(cm.getId())});
        db.close();


    }

    public void DeleteContact(int id){

        SQLiteDatabase db = getWritableDatabase();

        db.delete(TAB_CONTACT,COL_ID+" = ?",new String[]{String.valueOf(id)});
        db.close();


    }



}
