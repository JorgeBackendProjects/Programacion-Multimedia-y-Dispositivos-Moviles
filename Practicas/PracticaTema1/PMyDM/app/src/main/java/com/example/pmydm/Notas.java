package com.example.pmydm;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;

import java.util.GregorianCalendar;

/**
 * Esta clase representa una nota y sus atributos, esta nos servira
 * posteriormente para usarla en las bases de datos.
 */
public class Notas extends Activity {

    private String nombre, descripcion, fechaYHora, telefonoContacto;

    /**
     * Constructor por parametros de los atributos de una nota.
     *
     * @param no String nombre,
     * @param des String descripcion,
     * @param fyh String fecha y Hora,
     * @param con String telefono.
     */
    public Notas(String no, String des, String fyh, String con){

        nombre = no;
        descripcion = des;
        fechaYHora = fyh;
        telefonoContacto = con;
    }

}
