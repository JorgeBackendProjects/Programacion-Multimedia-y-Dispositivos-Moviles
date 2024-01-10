package com.pmdm.basesdedatos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.pmdm.basesdedatos.DB.DBContactos;
import com.pmdm.basesdedatos.DB.DBHelper;
import com.pmdm.basesdedatos.adaptadores.ListaContactosAdapter;
import com.pmdm.basesdedatos.entidades.Contactos;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button botonAdd, botonCrear;
    ArrayList<Contactos> listaResultados;
    RecyclerView listaContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaContactos = findViewById(R.id.listaContactos);
        listaContactos.setLayoutManager(new LinearLayoutManager(this));

        DBContactos dbContactos = new DBContactos(MainActivity.this);
        listaResultados = new ArrayList();

        ListaContactosAdapter adapter = new ListaContactosAdapter(dbContactos.leerContactos());
        listaContactos.setAdapter(adapter);

        botonAdd = (Button) findViewById(R.id.botonadd);
        botonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NuevaAct.class);
                startActivity(intent);
            }
        });

        botonCrear = (Button) findViewById(R.id.botoncrear);
        botonCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbHelper = new DBHelper(MainActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if(db != null){
                    Log.i("BD", "Creación correcta.");
                }else Log.i("BD", "Error en la creación de la base de datos");
            }
        });

        listaContactos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, VerActivity.class);
                startActivity(i);
            }
        });

    }


}