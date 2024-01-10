package com.example.examentema2.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.examentema2.Entidad.Entrada;

import java.util.ArrayList;

public class DBEntradas extends DBHelper{

    Context context;

    public DBEntradas(Context context) {
        super(context);
        this.context = context;
    }

    public Entrada leerEntrada(int codigo){
        Entrada entrada = new Entrada();

        try {
            DBHelper dbHelper = new DBHelper(context);
            SQLiteDatabase sql = dbHelper.getWritableDatabase();
            Cursor cursor = sql.rawQuery("SELECT * FROM " + TABLE_ENTRADAS + " WHERE CODIGO = '" + codigo + "'", null, null);

            if(cursor.moveToFirst()) {
                entrada = new Entrada();
                entrada.setCodigo(cursor.getInt(0));
                entrada.setSeccion(cursor.getString(1));
                entrada.setnButaca(cursor.getInt(2));
                entrada.setPrecio(cursor.getInt(3));
            }

            sql.close();

        }catch(Exception e){
            Log.i("BD", e.toString());
        }

        return entrada;
    }

    public ArrayList<Entrada> leerEntradas(){

        ArrayList<Entrada> entradas = new ArrayList<>();
        Entrada entrada = new Entrada();

        try {
            DBHelper dbHelper = new DBHelper(context);
            SQLiteDatabase sql = dbHelper.getWritableDatabase();
            Cursor cursor = sql.rawQuery("SELECT * FROM " + TABLE_ENTRADAS, null, null);

            if(cursor.moveToFirst()) {
                do{
                    entrada = new Entrada();
                    entrada.setCodigo(cursor.getInt(0));
                    entrada.setSeccion(cursor.getString(1));
                    entrada.setnButaca(cursor.getInt(2));
                    entrada.setPrecio(cursor.getInt(3));

                }while(cursor.moveToNext());
            }

            sql.close();

        }catch(Exception e){
            Log.i("BD", e.toString());
        }

        return entradas;
    }

    public long insertarEntrada(String seccion, int nButaca, int precio){
        long codigo = 0;

        try {
            DBHelper dbHelper = new DBHelper(context);
            SQLiteDatabase sql = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put("SECCION", seccion);
            values.put("BUTACA", nButaca);
            values.put("PRECIO", precio);

            codigo = sql.insert(TABLE_ENTRADAS, null, values);

            if(codigo != 0){
                Log.i("BD", "CORRECTO");
            }else{
                Log.i("BD", "INCORRECTO");
            }

            sql.close();

        }catch(Exception e){
            Log.i("BD", e.toString());
        }

        return codigo;
    }

    public boolean actualizarEntrada(int codigo, String seccion, int nButaca, int precio){
        boolean comp = false;

        try {
            DBHelper dbHelper = new DBHelper(context);
            SQLiteDatabase sql = dbHelper.getWritableDatabase();

            sql.execSQL("UPDATE " + TABLE_ENTRADAS + " SET SECCION = '" + seccion + "', BUTACA = '" + nButaca + "', PRECIO = '" + precio + "' WHERE CODIGO = '" + codigo + "'");
            comp = true;

            sql.close();

        }catch(Exception e){
            Log.i("BD", e.toString());
        }

        return comp;
    }

    public boolean borrarEntrada(int codigo){

        boolean comp = false;

        try {
            DBHelper dbHelper = new DBHelper(context);
            SQLiteDatabase sql = dbHelper.getWritableDatabase();

            sql.execSQL("DELETE FROM " + TABLE_ENTRADAS + " WHERE CODIGO = '" + codigo + "'");

            comp = true;

            sql.close();

        }catch(Exception e){
            Log.i("BD", e.toString());
        }

        return comp;
    }

}
