package com.example.examentema2.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "GestorEntradas.db";
    public static final String TABLE_ENTRADAS = "tabla_entradas";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_ENTRADAS +
                "(CODIGO INTEGER PRIMARY KEY AUTOINCREMENT," +
                "SECCION TEXT NOT NULL," +
                "BUTACA INTEGER NOT NULL," +
                "PRECIO INTEGER NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
