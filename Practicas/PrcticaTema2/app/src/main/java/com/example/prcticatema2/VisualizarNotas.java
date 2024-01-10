package com.example.prcticatema2;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.prcticatema2.BaseDatos.DBNotas;
import com.example.prcticatema2.Entidades.Notas;

/**
 * Esta clase permite editar y borrar una nota, además de llamar o mandar
 * un mensaje al contacto asociado y volver a la activiad anterior.
 */
@RequiresApi(api = Build.VERSION_CODES.O)
public class VisualizarNotas extends AppCompatActivity {

    DBNotas dbNotas = new DBNotas(VisualizarNotas.this);
    EditText titulo, descripcion, fechayHora, telefono;
    Button atras, editar, borrar, llamar, sms;
    Notas nota;
    int id = 0;

    /**
     * En este metodo crea y abre la actividad y permite ver la información de una nota en concreto.
     *
     * Implementa las funciones recitadas anteriormente.
     *
     * @param savedInstanceState
     */
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_notas);

        titulo = findViewById(R.id.textTitulo);
        descripcion = findViewById(R.id.textDescripcion);
        fechayHora = findViewById(R.id.textFechayHora);
        telefono = findViewById(R.id.textTelefono);

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

        nota = dbNotas.verNota(id);

        if(nota != null){
            titulo.setText(nota.getNombre());
            descripcion.setText(nota.getDescripcion());
            fechayHora.setText(nota.getFecha());
            telefono.setText(nota.getTelefono());

            titulo.setInputType(InputType.TYPE_NULL);
            descripcion.setInputType(InputType.TYPE_NULL);
            fechayHora.setInputType(InputType.TYPE_NULL);
            telefono.setInputType(InputType.TYPE_NULL);

        }

        atras = findViewById(R.id.botonRetroceder);
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(VisualizarNotas.this, MainActivity.class);
                startActivity(i);
            }
        });

        editar = findViewById(R.id.botonEditar);
        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VisualizarNotas.this, EditarNota.class);
                intent.putExtra("ID", id);
                startActivity(intent);
            }
        });

        borrar = findViewById(R.id.botonBorrado);
        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(VisualizarNotas.this);
                builder.setMessage("¿Desea eliminar la nota?")
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if(dbNotas.eliminarNota(id)){
                                    Intent intent = new Intent(VisualizarNotas.this, MainActivity.class);
                                    startActivity(intent);
                                }
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).show();
            }
        });

        llamar = findViewById(R.id.botonLlamada);
        llamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + telefono.getText().toString()));
                startActivity(intent);
            }
        });

        sms = findViewById(R.id.botonMensaje);
        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + telefono.getText().toString()));
                startActivity(intent);
            }
        });
    }


}