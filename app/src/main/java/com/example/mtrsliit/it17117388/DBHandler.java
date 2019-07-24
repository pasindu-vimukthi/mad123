package com.example.mtrsliit.it17117388;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {
    public static final String DATABASENAME= "book.db";

    public DBHandler(Context context) {
        super(context, DATABASENAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String SQL = "CREATE TABLE " + BookInfo.TABLENAME +"("+
                BookInfo.COLUMNNAME_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                BookInfo.COLUMNNAME_BOOKNAME+ " TEXT," +
                BookInfo.COLUMNNAME_AUTHOR_ID+ " INTEGER FOREIGN KEY AUTOINCREMENT,"+
                BookInfo.COLUMNNAME_AUTHOR_NAME+ " TEXT,"+
                BookInfo.COLUMNNAME_BOOK_CATEGORY+" TEXT,"+



                sqLiteDatabase.execSQL(SQLiteDatabase);

        String SQL = "CREATE TABLE " + AuthorInfo.TABLENAME +"("+
                AuthorInfo.COLUMNNAME_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                AuthorInfo.COLUMNNAME_AUTHOR_NAME+ " TEXT," +

                sqLiteDatabase.execSQL(SQLiteDatabase);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addBook(String bname,String authorName,String categry)
    {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new  ContentValues();

        values.put(BookInfo.COLUMNNAME_BOOKNAME,bname);
        values.put(BookInfo.COLUMNNAME_AUTHOR_NAME,authorName);
        values.put(BookInfo.COLUMNNAME_BOOK_CATEGORY,categry);

        long rowID = db.insertOrThrow(BookInfo.TABLENAME,null,values);

        if(rowID >=1)
            return true;
        else
            return false;

        }

    public boolean addAuthor(String name)
    {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new  ContentValues();

        values.put(AuthorInfo.COLUMNNAME_AUTHOR_NAME,name);

        long rowID = db.insertOrThrow(AuthorInfo.TABLENAME,null,values);

        if(rowID >=1)
            return true;
        else
            return false;

    }

    public boolean updateBook(String id,String name,String cat,String authrName)
    {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new  ContentValues();

        values.put(BookInfo.COLUMNNAME_ID,id);
        values.put(BookInfo.COLUMNNAME_BOOKNAME,name);
        values.put(BookInfo.COLUMNNAME_BOOK_CATEGORY,cat);
        values.put(BookInfo.COLUMNNAME_AUTHOR_NAME,authrName);

        String selection = BookInfo.COLUMNNAME_ID + " =?";
        String[] selectionArgs = {id};

        int count = db.update(BookInfo.TABLENAME,values,selection,selectionArgs);
        if(count >=1)
            return true;
        else
            return false;

    }

    public ArrayList searchBook()
    {

        SQLiteDatabase db = getWritableDatabase();

        String[] projection = {
               BookInfo.COLUMNNAME_ID,
                BookInfo.COLUMNNAME_BOOKNAME,
                BookInfo.COLUMNNAME_AUTHOR_ID,
                BookInfo.COLUMNNAME_BOOK_CATEGORY,

        };


        String orderBy = BookInfo.COLUMNNAME_ID + " ASC";

        Cursor cursor = db.query(
                BookInfo.TABLENAME,
                projection,
                null,
                null,
                null,
                null,
                orderBy
        );

        ArrayList<AddBook> list = new ArrayList<>();

        while(cursor.moveToNext())

        {
            AddBook emp = new AddBook();
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(BookInfo.COLUMNNAME_ID));
            String name = cursor.getString(cursor.getColumnIndexOrThrow(BookInfo.COLUMNNAME_BOOKNAME));
            String AuId = cursor.getString(cursor.getColumnIndexOrThrow(BookInfo.COLUMNNAME_AUTHOR_ID));
            String categ = cursor.getString(cursor.getColumnIndexOrThrow(BookInfo.COLUMNNAME_BOOK_CATEGORY));


            list.add(emp);

        }

        return list;






    }}
