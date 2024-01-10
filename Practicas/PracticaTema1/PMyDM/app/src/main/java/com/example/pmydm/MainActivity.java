package com.example.pmydm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * MainActivity es la clase principal con la que se iniciara
 * la aplicacion al crearse con el metodo onCreate.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Este metodo inicializa cualquier actividad.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Este metodo esta asignado al unico boton del activity_main.xml,
     * este redirige a otra actividad llamada CrearNota mediante un intent.
     *
     * @param v
     */
    public void abrirNotas(View v){
        Intent i = new Intent(MainActivity.this, CrearNota.class);
        startActivity(i);
    }
}