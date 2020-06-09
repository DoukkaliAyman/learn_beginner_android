package com.learn.storage.sqLite.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.learn.storage.sqLite.Model.Persone;
import com.learn.storage.sqLite.Utils.Utils_db;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    public DatabaseHandler(@Nullable  Context context) {
        super(context, Utils_db.DATABASE_NAME, null, Utils_db.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_PEOPLE_TABLE = "CREATE TABLE " + Utils_db.DATABASE_TABLE
                + "( " + Utils_db.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Utils_db.KEY_NAME + " TEXT, "
                + Utils_db.KEY_LNAME + " TEXT, "
                + Utils_db.KEY_ADDRESS + " TEXT, "
                + Utils_db.KEY_AGE + " TEXT )"
                ;
        db.execSQL(CREATE_PEOPLE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + Utils_db.DATABASE_TABLE);
        onCreate(db);
    }

    public void addPersone(Persone persone){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Utils_db.KEY_NAME,persone.getName());
        contentValues.put(Utils_db.KEY_LNAME,persone.getLname());
        contentValues.put(Utils_db.KEY_ADDRESS,persone.getAddress());
        contentValues.put(Utils_db.KEY_AGE,persone.getAge());

        database.insert(Utils_db.DATABASE_TABLE,null,contentValues);
        database.close();

    }

    public Persone getpersone(int id){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.query(Utils_db.DATABASE_TABLE, new String[]{Utils_db.KEY_ID,Utils_db.KEY_NAME,Utils_db.KEY_LNAME,Utils_db.KEY_ADDRESS,Utils_db.KEY_AGE},Utils_db.KEY_ID + "=?",new String[]{String.valueOf(id)},null,null,null,null);

        if (cursor != null)
            cursor.moveToFirst();
            Persone persone = new Persone(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    Integer.parseInt(cursor.getString(4))
                    );

        return persone;
    }

    public List<Persone> gatAllPersones (){
        SQLiteDatabase database = this.getReadableDatabase();
        List<Persone> personeList = new ArrayList<Persone>();
        String getAll = "SELECT * FROM " + Utils_db.DATABASE_TABLE;
        Cursor cursor = database.rawQuery(getAll,null);

        if ( cursor.moveToFirst())
            do {
                Persone persone = new  Persone();
                persone.setId(Integer.parseInt(cursor.getString(0)));
                persone.setName(cursor.getString(1));
                persone.setLname(cursor.getString(2));
                persone.setAddress(cursor.getString(3));
                persone.setAge(Integer.parseInt(cursor.getString(4)));
                personeList.add(persone);
            }while (cursor.moveToNext());
            return personeList;
    }
    public int updatePersone(Persone persone){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Utils_db.KEY_NAME,persone.getName());
        contentValues.put(Utils_db.KEY_LNAME,persone.getLname());
        contentValues.put(Utils_db.KEY_ADDRESS,persone.getAddress());
        contentValues.put(Utils_db.KEY_AGE,persone.getAge());
        int result = database.update(Utils_db.DATABASE_TABLE,contentValues,Utils_db.KEY_ID + "=?",
                new String[]{
                        String.valueOf(persone.getId())
                });
        database.close();
     return    result;
    }
    public  void dropPerson(Persone persone){
            SQLiteDatabase database = this.getWritableDatabase();
        database.delete(Utils_db.DATABASE_TABLE,Utils_db.KEY_ID + "=?",
                new String[]{
                        String.valueOf(persone.getId())
                });
        database.close();

    }

    public int countPerson(){
        SQLiteDatabase database = this.getWritableDatabase();

        String getAll = "SELECT * FROM " + Utils_db.DATABASE_TABLE;
        Cursor cursor = database.rawQuery(getAll,null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }
}
