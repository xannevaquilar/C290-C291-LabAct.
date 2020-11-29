package com.ucucite.edu.sqliteapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{
    public DBHelper(Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("Create Table Userdetails(name TEXT, contact TEXT, idnum TEXT primary key, address TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {
        DB.execSQL("Drop Table if exists Userdetails");
    }

    public Boolean insertuserdata (String name, String contact, String idnum, String address){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("contact", contact);
        contentValues.put("idnum", idnum);
        contentValues.put("address", address);
        long result=DB.insert("Userdetails", null, contentValues);

        if (result==-1){
            return false;
        }else{
            return true;
        }
    }

    public Boolean updateuserdata (String name, String contact, String idnum, String address){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("contact", contact);
        contentValues.put("idnum", idnum);
        contentValues.put("address", address);
        Cursor cursor = DB.rawQuery("Select * from Userdetails where name=?", new String[] {name});

        if (cursor.getCount()>0) {
            long result = DB.update("Userdetails", contentValues, "name=?", new String[]{name});

            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else{
            return false;
        }
    }


    public Boolean deletedata (String name){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails where name=?", new String[] {name});

        if (cursor.getCount()>0) {
            long result = DB.delete("Userdetails",  "name=?", new String[]{name});

            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else{
            return false;
        }

    }

    public Cursor getdata (){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails", null);
        return cursor;

    }


}


