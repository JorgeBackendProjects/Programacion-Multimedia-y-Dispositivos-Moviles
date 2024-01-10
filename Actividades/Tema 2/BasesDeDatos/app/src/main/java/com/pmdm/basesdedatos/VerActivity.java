package com.pmdm.basesdedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.pmdm.basesdedatos.DB.DBContactos;
import com.pmdm.basesdedatos.entidades.Contactos;

public class VerActivity extends AppCompatActivity {

    private TextView nombre, telefono, correo;
    private DBContactos contactosDB;
    private Contactos contacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver);

        Bundle datos = getIntent().getExtras();
        int id = datos.getInt("ID");
        contactosDB = new DBContactos(VerActivity.this);

        contacto = new Contactos(contactosDB.leerContactos(id));

        Log.i("BD", contacto.toString());

        nombre = findViewById(R.id.nombreText);
        telefono = findViewById(R.id.telefonoText);
        correo = findViewById(R.id.correoText);

        nombre.setText(contacto.getNombre().toString());
        telefono.setText(contacto.getTelefono().toString());
        correo.setText(contacto.getEmail().toString());

        //TIENE QUE BUSCAR LA ID QUE LE PASA EL INTENT Y SACAR LOS DATOS DE LA DB
    }

}