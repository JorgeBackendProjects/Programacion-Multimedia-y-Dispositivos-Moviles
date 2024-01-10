package com.example.examen_tema1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Activity_Ejercicio2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2);
    }

    public void abrirActividad(){
        Intent i = new Intent(Activity_Ejercicio2.this, MainActivity_Ejercicio2.class);
        startActivity(i);
    }
}