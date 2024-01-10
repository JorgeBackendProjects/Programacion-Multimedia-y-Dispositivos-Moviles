package com.example.prcticatema2;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.prcticatema2.BaseDatos.DBNotas;

/**
 * La clase CrearNota servira como una actividad para crear un
 * formulario y posteriormente recoger y visualizar los datos.
 */
public class CrearNota extends AppCompatActivity {

    EditText titulo, descripcion, fecha, telefono;
    Button botonAtras, botonCrear;

    /**
     * Este metodo crea la actividad y permite crear
     * una nota o volver a la anterior actividad.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_nota);

        titulo = findViewById(R.id.inputTitulo);
        descripcion = findViewById(R.id.inputDescripcion);
        fecha = findViewById(R.id.inputFechayHora);
        telefono = findViewById(R.id.inputContacto);

        botonCrear = findViewById(R.id.botonLlamar);
        botonCrear.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                DBNotas dbNotas = new DBNotas(CrearNota.this);
                long id = dbNotas.insertarNota(titulo.getText().toString(), descripcion.getText().toString(), fecha.getText().toString(), telefono.getText().toString());

                if(id > 0){
                    Log.i("BD", "Correcto");

                    titulo.setText("");
                    descripcion.setText("");
                    fecha.setText("");
                    telefono.setText("");
                }else{
                    Log.i("BD", "Incorrecto");

                    titulo.setText("");
                    descripcion.setText("");
                    fecha.setText("");
                    telefono.setText("");
                }
            }

        });

        botonAtras = findViewById(R.id.botonAtras);
        botonAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CrearNota.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

}