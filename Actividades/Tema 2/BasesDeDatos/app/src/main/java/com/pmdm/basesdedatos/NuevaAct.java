package com.pmdm.basesdedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.pmdm.basesdedatos.DB.DBContactos;

public class NuevaAct extends AppCompatActivity {

    EditText txtNombre, txtTelefono, txtCorreo;
    Button botonInsertar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtTelefono = (EditText) findViewById(R.id.txtTelefono);
        txtCorreo = (EditText) findViewById(R.id.txtEmail);
        botonInsertar = (Button) findViewById(R.id.botonEntrada);

        botonInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBContactos dbContactos = new DBContactos(NuevaAct.this);
                long id = dbContactos.insertarContacto(txtNombre.getText().toString(), txtTelefono.getText().toString(), txtCorreo.getText().toString());
                if(id > 0){
                    Log.i("BD", "Correcto.");
                    limpiar();
                }else{
                    Log.i("BD", "Incorrecto");
                    limpiar();
                }
            }
        });
    }

    private void limpiar(){
        txtNombre.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
    }
}