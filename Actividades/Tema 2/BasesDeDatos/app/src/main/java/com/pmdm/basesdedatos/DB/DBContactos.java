package com.pmdm.basesdedatos.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

import com.pmdm.basesdedatos.entidades.Contactos;

import java.util.ArrayList;

public class DBContactos extends DBHelper{

    Context context;

    public DBContactos(@Nullable Context context) {
        super(context);
        this.context=context;
    }

    public long insertarContacto(String nombre, String telefono, String correo_electronico){
        long id = 0;

        try {
            DBHelper dbHelper = new DBHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("telefono", telefono);
            values.put("correo_electronico", correo_electronico);
            id = db.insert(TABLA_CONTACTOS, null, values);
        }catch (Exception ex){
            ex.toString();
        }
        return id;
    }

    public ArrayList<Contactos> leerContactos(){
        ArrayList<Contactos> resultado = new ArrayList<>();

        try{
            DBHelper dbHelper = new DBHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            Contactos contacto;
            Cursor cursorContactos;

            cursorContactos = db.rawQuery("SELECT * FROM " + TABLA_CONTACTOS, null);

            if(cursorContactos.moveToFirst()){
                do{
                    contacto = new Contactos();
                    contacto.setId(cursorContactos.getInt(0));
                    contacto.setNombre(cursorContactos.getString(1));
                    contacto.setTelefono(cursorContactos.getString(2));
                    contacto.setEmail(cursorContactos.getString(3));
                    resultado.add(contacto);
                }while(cursorContactos.moveToNext());
            }
            cursorContactos.close();
        }catch (Exception ex){
            Log.i("BD", ex.toString());
        }

        return resultado;
    }

    //Metodo sobreescrito para visualizar la informacion de un contacto en concreto.
    public Contactos leerContactos(int id){

        Contactos contacto = new Contactos();

        try{
            DBHelper dbHelper = new DBHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            Cursor cursorContactos;

            cursorContactos = db.rawQuery("SELECT * FROM " + TABLA_CONTACTOS + " WHERE id = " + id, null);

            cursorContactos.moveToFirst();
                    contacto.setId(cursorContactos.getInt(0));
                    contacto.setNombre(cursorContactos.getString(1));
                    contacto.setTelefono(cursorContactos.getString(2));
                    contacto.setEmail(cursorContactos.getString(3));

            cursorContactos.close();
        }catch (Exception ex){
            Log.i("BD", ex.toString());
        }

        return contacto;
    }

    public Contactos actualizarContactos(int id, String nombre, String telefono, String correo){

        Contactos contacto = new Contactos();

        try{

            DBHelper dbHelper = new DBHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("Nombre", nombre);
            values.put("Telefono", telefono);
            values.put("Correo", correo);
///////////////////////////////////////////
            db.update(TABLA_CONTACTOS, values, );
        }catch(Exception error){
            Log.i("BD", error.toString());
        }
    }////

}
