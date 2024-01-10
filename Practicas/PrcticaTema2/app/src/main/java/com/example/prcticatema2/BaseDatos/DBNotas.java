package com.example.prcticatema2.BaseDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.prcticatema2.Entidades.Notas;

import java.util.ArrayList;

/**
 * Esta clase que hereda de DBHelper se usa para
 * hacer operaciones CRUD en una tabla en concreto.
 */
public class DBNotas extends DBHelper{

    Context context;

    /**
     * Constructor por parámetros que inicializa un objeto
     * DBHelper mediante super() con el contexto de la clase.
     *
     * @param cont Contexto de la clase.
     */
    public DBNotas(@Nullable Context cont){
        super(cont);
        this.context=context;
    }

    /**
     * Este método permite insertar una nueva fila en la tabla.
     *
     * @param nombre
     * @param descripcion
     * @param fecha
     * @param telefono
     *
     * @return Devuelve un long con el id de la fila.
     */
    public long insertarNota(String nombre, String descripcion, String fecha, String telefono){

        long id = 0;

        try {

            DBHelper dbHelper = new DBHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put("nombre", nombre);
            values.put("descripcion", descripcion);
            values.put("fecha", fecha);
            values.put("telefono", telefono);

            id = db.insert(TABLA_NOTAS, null, values);

        }catch (Exception ex){
            ex.toString();
        }

        return id;
    }

    /**
     * Este método permite hacer una consulta global de la tabla seleccionada.
     *
     * @return Devuelve los resultados en un ArrayList.
     */
    public ArrayList<Notas> leerNotas(){

        ArrayList<Notas> resultado = new ArrayList<Notas>();

        try{

            DBHelper dbHelper = new DBHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            Notas nota;
            Cursor cursorNotas;

            cursorNotas = db.rawQuery("SELECT * FROM " + TABLA_NOTAS, null);

            if(cursorNotas.moveToFirst()){
                do{
                    nota = new Notas();
                    nota.setNombre(cursorNotas.getString(0));
                    nota.setDescripcion(cursorNotas.getString(1));
                    nota.setFecha(cursorNotas.getString(2));
                    nota.setTelefono(cursorNotas.getString(3));

                    resultado.add(nota);
                }while(cursorNotas.moveToNext());
            }

            cursorNotas.close();

        }catch (Exception ex){
            Log.i("BD", ex.toString());
        }

        return resultado;
    }

    /**
     * Este método permite hacer una consulta atómica mediante un ID y mostrar el resultado.
     *
     * @param id Identificador.
     *
     * @return Devuelve un objeto de la clase Notas inicializado con los resultados obtenidos.
     */
    public Notas verNota(int id){

        Notas nota = new Notas();

        try{
            DBHelper dbHelper = new DBHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            Cursor cursorNotas;

            cursorNotas = db.rawQuery("SELECT * FROM " + TABLA_NOTAS + " WHERE id = " + id + " LIMIT 1", null);

            if(cursorNotas.moveToFirst()){

                nota = new Notas();
                nota.setId(cursorNotas.getInt(0));
                nota.setNombre(cursorNotas.getString(1));
                nota.setDescripcion(cursorNotas.getString(2));
                nota.setFecha(cursorNotas.getString(3));
                nota.setTelefono(cursorNotas.getString(4));
            }

            cursorNotas.close();

        }catch (Exception ex){
            Log.i("BD", ex.toString());
        }

        return nota;
    }

    /**
     * Este método permite editar una nota mediante un ID concreto y los nuevos datos.
     *
     * @param id
     * @param nombre
     * @param descripcion
     * @param fecha
     * @param telefono
     *
     * @return Devuelve true si se ha modificado correctamente.
     */
    public boolean editarNota(int id, String nombre, String descripcion, String fecha, String telefono){

        boolean correcto = false;
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        try {

            db.execSQL("UPDATE " + TABLA_NOTAS + " SET nombre = '" + nombre + "', descripcion = '" + descripcion + "', fecha = '" + fecha + "', telefono = '" + telefono + "' WHERE id = '" + id + "' ");
            correcto=true;

        }catch (Exception ex){

            ex.toString();
            correcto=false;

        }finally {
            db.close();
        }

        return correcto;
    }

    /**
     * Este método permite eliminar una fila de la tabla mediante un ID en concreto.
     *
     * @param id
     *
     * @return Devuelve true si se ha eliminado correctamente.
     */
    public boolean eliminarNota(int id){

        boolean correcto = false;
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        try {

            db.execSQL("DELETE FROM " + TABLA_NOTAS + "WHERE id = '" + id + "'");
            correcto=true;

        }catch (Exception ex){

            ex.toString();
            correcto=false;

        }finally {
            db.close();
        }

        return correcto;
    }

}
