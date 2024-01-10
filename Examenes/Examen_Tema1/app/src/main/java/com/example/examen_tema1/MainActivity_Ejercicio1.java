package com.example.examen_tema1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.examen_tema1.R;

public class MainActivity_Ejercicio1 extends AppCompatActivity {

    Button formButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ejercicio1);

        findViewById(R.id.textoActividad1).setVisibility(View.VISIBLE);
    }

    public void abrirFormulario(){
        findViewById(R.id.inputNumeroProyectos).setVisibility(View.VISIBLE);

        //findViewById(R.id.textoActividad1).toString().substring() == findViewById(R.id.inputNumeroProyectos).toString();
    }
}