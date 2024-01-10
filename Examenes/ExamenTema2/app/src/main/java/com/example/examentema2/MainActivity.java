package com.example.examentema2;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.examentema2.Adaptador.ListaEntradasAdapter;
import com.example.examentema2.Entidad.Entrada;
import com.example.examentema2.SQLite.DBEntradas;
import com.example.examentema2.SQLite.DBHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Entrada> entradas;
    RecyclerView listaEntradas;
    Button crearDB, nuevaE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper dbhelper = new DBHelper(MainActivity.this);
        SQLiteDatabase sql = dbhelper.getWritableDatabase();

        DBEntradas dbEntradas = new DBEntradas(MainActivity.this);
        ListaEntradasAdapter adapter = new ListaEntradasAdapter();

        listaEntradas = new RecyclerView(MainActivity.this);
        listaEntradas.setLayoutManager(new LinearLayoutManager(this));

        crearDB.findViewById(R.id.botonCrearDB);
        crearDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbHelper = new DBHelper(MainActivity.this);
                SQLiteDatabase sql = dbHelper.getWritableDatabase();
            }
        });

        nuevaE.findViewById(R.id.botonNuevaE);
        nuevaE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CrearEntrada.class);
                startActivity(i);
            }
        });
    }
}