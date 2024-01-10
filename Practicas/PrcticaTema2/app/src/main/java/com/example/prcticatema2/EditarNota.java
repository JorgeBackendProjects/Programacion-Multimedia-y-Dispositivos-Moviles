package com.example.prcticatema2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.prcticatema2.BaseDatos.DBNotas;
import com.example.prcticatema2.Entidades.Notas;

/**
 * Esta clase se usa para editar una nota.
 */
public class EditarNota extends AppCompatActivity {

    EditText nombre, descripcion, fecha, telefono;
    Notas nota;
    Button guardar, cancelar;

    boolean correcto = false;
    int id = 0;

    /**
     * Este método que crea y abre la actividad mediante un ID
     * concreto permitirá modificar y guardar los cambios o
     * cancelar y volver a la anterior actividad.
     *
     * @param savedInstanceState
     */
    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_notas);

        nombre = findViewById(R.id.viewNombre);
        descripcion = findViewById(R.id.viewDescripcion);
        fecha = findViewById(R.id.viewFecha);
        telefono = findViewById(R.id.viewTelefono);

        if(savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if(extras == null){
                id = Integer.parseInt(null);
            }else{
                id = extras.getInt("ID");
            }
        }else{
            id = (int) savedInstanceState.getSerializable("ID");
        }

        DBNotas dbNotas = new DBNotas(EditarNota.this);
        nota = dbNotas.verNota(id);

        if(nota != null){
            nombre.setText(nota.getNombre());
            descripcion.setText(nota.getDescripcion());
            fecha.setText(nota.getFecha());
            telefono.setText(nota.getTelefono());
        }

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!nombre.getText().toString().equals("") && !descripcion.getText().toString().equals("") && !fecha.getText().toString().equals("") && !telefono.getText().toString().equals("")){
                    correcto = dbNotas.editarNota(id, nombre.getText().toString(), descripcion.getText().toString(), fecha.getText().toString(), telefono.getText().toString());

                    if(correcto){
                        Log.i("BD", "Registro modificado correctamente");
                        verRegistro();
                    }else{
                        Log.i("BD", "Error al modificar registro");
                    }

                }else{
                    Log.i("BD", "No se han rellenado los datos");
                }
            }
        });
    }

    /**
     * Este método lleva de vuelta a la actividad anterior.
     */
    @SuppressLint("NewApi")
    private void verRegistro(){
        Intent intent = new Intent(this, VisualizarNotas.class);
        intent.putExtra("ID", id);

        startActivity(intent);
    }
}