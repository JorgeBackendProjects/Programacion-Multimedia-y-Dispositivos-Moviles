package com.example.examen_tema1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Intent i = new Intent(MainActivity.this, MyService.class);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //EJERCICIO 3
        int numeroProyectos = Integer.parseInt(findViewById(R.id.inputNumeroProyectos).toString());
        MyService ms = new MyService();
        ms.onStart(i, numeroProyectos);
    }

    public void abrirActividad1(){
        Intent i = new Intent(MainActivity.this, MainActivity_Ejercicio1.class);
        startActivity(i);
    }

    public void abrirActividad2(){
        Intent i = new Intent(MainActivity.this, MainActivity_Ejercicio2.class);
        startActivity(i);
    }


}