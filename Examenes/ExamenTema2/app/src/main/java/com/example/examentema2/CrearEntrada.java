package com.example.examentema2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.examentema2.SQLite.DBEntradas;

public class CrearEntrada extends AppCompatActivity {

    DBEntradas db = new DBEntradas(CrearEntrada.this);
    EditText seccion, butaca, precio;
    Button guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_entrada);

        seccion.findViewById(R.id.editSeccion);
        butaca.findViewById(R.id.editButaca);
        precio.findViewById(R.id.editPrecio);

        guardar.findViewById(R.id.botonInsertar);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.insertarEntrada(seccion.getText().toString(), Integer.parseInt(butaca.getText().toString()), Integer.parseInt(precio.getText().toString()));
                seccion.setText("");
                butaca.setText("");
                precio.setText("");
            }
        });
    }
}