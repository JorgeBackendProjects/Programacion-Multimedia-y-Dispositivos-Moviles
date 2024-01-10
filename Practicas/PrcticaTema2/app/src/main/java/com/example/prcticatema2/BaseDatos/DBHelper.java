package com.example.prcticatema2.BaseDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Esta clase que hereda de SQLiteOpenHelper se usa para crear la base de datos y sus tablas.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "notas.db";
    public static final String TABLA_NOTAS = "t_notas";

    /**
     * Constructor por parámetros que recibe el nombre y la versión de la DB.
     *
     * @param context Contexto de la clase en que se use.
     */
    public DBHelper(Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    /**
     * Este método permite crear una tabla en la base de datos.
     *
     * @param sqLiteDatabase
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLA_NOTAS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "descripcion TEXT NOT NULL," +
                "fecha TEXT NOT NULL," +
                "telefono TEXT NOT NULL)");
    }

    /**
     * Este método permite eliminar una tabla de la base de datos.
     *
     * @param sqLiteDatabase
     * @param i
     * @param i1
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLA_NOTAS);
        onCreate(sqLiteDatabase);
    }
}