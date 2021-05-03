package com.example.vintest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
    private static final String TAG = "DBHelper";

    public DBHelper(Context context) {
        super(context, "userData3.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table tbl_user " +
                        "(id integer primary key AUTOINCREMENT, name text , email text, cno text, address text, subject text, password text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tbl_user");
        onCreate(db);
    }

    public boolean insertUser (String name, String email, String cno, String address, String subject, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("cno", cno);
        contentValues.put("address", address);
        contentValues.put("subject", subject);
        contentValues.put("password", password);
        long result= db.insert("tbl_user", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }

    public  boolean validateUser(String name, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM tbl_user WHERE name = '" + name +  "' and password  = '" + password + "'";
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }


    public Cursor getdata()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from tbl_user", null);
        return cursor;

    }

}
