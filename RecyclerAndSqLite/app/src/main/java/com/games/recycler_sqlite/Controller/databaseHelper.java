package com.games.recycler_sqlite.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.games.recycler_sqlite.Model.Data;
import com.games.recycler_sqlite.Utilis.utilis;

import java.util.ArrayList;
import java.util.List;

public class databaseHelper extends SQLiteOpenHelper {
    public databaseHelper(@Nullable  Context context) {
        super(context,utilis.DATABASE_NAME,null,utilis.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + utilis.DATABASE_TABLE  +" ("
                + utilis.COLOUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + utilis.COLOUMN_NAME + " TEXT,"
                + utilis.COLOUMN_LNAME + " TEXT,"
                + utilis.COLOUMN_DESCRIPTION + " TEXT,"
                + utilis.COLOUMN_AGE + " TEXT,"
                + utilis.COLOUMN_TIME_STAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                +  " )" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ utilis.DATABASE_TABLE);
        onCreate(db);
    }


    public List <Data> getAllData() {
        List<Data> allData = new ArrayList<>();
        String query = "SELECT * FROM "+ utilis.DATABASE_TABLE +
                " ORDER BY " + utilis.COLOUMN_TIME_STAMP + " DESC";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery( query ,null);
        if(cursor.moveToFirst())
            do{
                Data data = new Data();
                data.setId(cursor.getInt(cursor.getColumnIndex(utilis.COLOUMN_ID)));
                data.setName( cursor.getString(cursor.getColumnIndex(utilis.COLOUMN_NAME)));
                data.setLname( cursor.getString(cursor.getColumnIndex(utilis.COLOUMN_LNAME)));
                data.setAge(cursor.getString(cursor.getColumnIndex(utilis.COLOUMN_AGE)));
                data.setDescription( cursor.getString(cursor.getColumnIndex(utilis.COLOUMN_DESCRIPTION)));
                data.setTimeStamp(cursor.getString(cursor.getColumnIndex(utilis.COLOUMN_TIME_STAMP)));

                allData.add(data);

            }while (cursor.moveToNext());
        db.close();
        return allData;
    }


    public  long insertData(Data data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(utilis.COLOUMN_NAME , data.getName());
        cv.put(utilis.COLOUMN_LNAME , data.getLname());
        cv.put(utilis.COLOUMN_DESCRIPTION , data.getDescription());
        cv.put(utilis.COLOUMN_AGE , data.getAge());

        long id = db.insert(utilis.DATABASE_TABLE , null , cv);
        db.close();
        return  id;
    }


   public void deleteData(Data data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(utilis.DATABASE_TABLE,  utilis.COLOUMN_ID + " =?",
                new String[]{String.valueOf(data.getId())});
        db.close();
    }

}
