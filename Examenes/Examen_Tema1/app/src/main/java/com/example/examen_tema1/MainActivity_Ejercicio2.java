package com.example.examen_tema1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity_Ejercicio2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ejercicio2);
    }

    public void abrirActividad(){
        Intent i = new Intent(MainActivity_Ejercicio2.this, Activity_Ejercicio2.class);
        startActivity(i);
    }
}