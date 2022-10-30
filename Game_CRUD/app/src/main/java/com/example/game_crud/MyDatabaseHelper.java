package com.example.game_crud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private Context context;
    public static final String DATABASE_NAME ="Game.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME ="Game_Lib";
    public static final String COLUMN_ID ="_id";
    public static final String COLUMN_NAME ="name";
    public static final String COLUMN_Genre ="genre";
    public MyDatabaseHelper(@Nullable Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE "+ TABLE_NAME +" (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                COLUMN_NAME + " TEXT, " + COLUMN_Genre +" TEXT); ";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    void addGame(String title, String genre){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME,title);
        cv.put(COLUMN_Genre,genre);
        long result = db.insert(TABLE_NAME,null,cv);
        if(result == -1 ){
            Toast.makeText(context,"FAILED",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context,"Success",Toast.LENGTH_SHORT).show();
        }
    }
    Cursor read(){
        String query = "SELECT * FROM "+ TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }
    void update(String id,String title,String genre){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME,title);
        cv.put(COLUMN_Genre,genre);
        long result = db.update(TABLE_NAME,cv,"_id=?",new String[]{id});
        if(result == -1 ){
            Toast.makeText(context,"FAILED",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context,"Success",Toast.LENGTH_SHORT).show();
        }

    }
    void delete(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME,"_id=?",new String[]{id});
        if(result == -1 ){
            Toast.makeText(context,"FAILED",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context,"Success",Toast.LENGTH_SHORT).show();
        }

    }
}
