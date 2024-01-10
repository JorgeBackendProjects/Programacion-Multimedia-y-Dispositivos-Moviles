package com.example.prcticatema2;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prcticatema2.Adaptadores.ListaNotasAdapter;
import com.example.prcticatema2.BaseDatos.DBHelper;
import com.example.prcticatema2.BaseDatos.DBNotas;
import com.example.prcticatema2.Entidades.Notas;

import java.util.ArrayList;

/**
 * MainActivity es la clase principal con la que se iniciara
 * la aplicacion al crearse con el metodo onCreate.
 */
public class MainActivity extends AppCompatActivity {

    ArrayList<Notas> notas;
    RecyclerView listaNotas;
    Button db, crear;

    /**
     * Este metodo inicializa cualquier actividad.
     *
     * @param savedInstanceState
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaNotas = findViewById(R.id.listado);
        listaNotas.setLayoutManager(new LinearLayoutManager(this));

        DBNotas dbNotas = new DBNotas(MainActivity.this);
        notas = new ArrayList<Notas>();

        ListaNotasAdapter adapter = new ListaNotasAdapter(dbNotas.leerNotas());
        listaNotas.setAdapter(adapter);

        db = findViewById(R.id.openButton);
        db.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CrearNota.class);
                startActivity(intent);
            }
        });

        crear = findViewById(R.id.crearDB);
        crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbHelper = new DBHelper(MainActivity.this);
                SQLiteDatabase dbs = dbHelper.getWritableDatabase();

                if(db != null){
                    Log.i("BD", "Se ha creado la DB");
                }else {
                    Log.i("BD", "Error en la creación de la DB");
                }
            }
        });
    }

}