package com.example.pmydm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * La clase CrearNota servira como una actividad para crear un
 * formulario y posteriormente recoger y visualizar los datos.
 */
public class CrearNota extends AppCompatActivity {

    EditText titulo, descripcion, fechayHora, contacto;
    Button botonCrear;

    /**
     * Este metodo crea la actividad y aniade un boton previamente creado
     * en activity_crear_nota.xml para asignarle el metodo crearNota();
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_nota);

        botonCrear = findViewById(R.id.botonLlamar);

        botonCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crearNota();
            }
        });
    }

    /**
     * Este metodo permite recoger los datos introducidos en los EditText para
     * mandar los resultados mediante los extras de un intent a la clase VisualizarNotas.
     *
     * Posteriormente abrira la actividad activity_visualizar_notas.xml.
     */
    public void crearNota(){

        titulo = findViewById(R.id.inputTitulo);
        descripcion = findViewById(R.id.inputDescripcion);
        fechayHora = findViewById(R.id.inputFechayHora);
        contacto = findViewById(R.id.inputContacto);

        Intent i = new Intent(CrearNota.this, VisualizarNotas.class);
        i.putExtra("Titulo", titulo.getText().toString());
        i.putExtra("Descripcion", descripcion.getText().toString());
        i.putExtra("Fecha y Hora", fechayHora.getText().toString());
        i.putExtra("Telefono Contacto", contacto.getText().toString());
        startActivity(i);
    }


}