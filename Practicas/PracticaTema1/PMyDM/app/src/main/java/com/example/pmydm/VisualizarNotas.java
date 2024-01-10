package com.example.pmydm;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import java.time.LocalDate;

/**
 * Esta clase VisualizarNotas recoge y muestra los datos introducidos
 * en los campos EditText de la actividad activity_crear_nota.xml;
 * ademas permite llamar y mandar un sms al numero de telefono asociado.
 */
@RequiresApi(api = Build.VERSION_CODES.O)
public class VisualizarNotas extends AppCompatActivity {

    TextView titulo, descripcion, fechayHora, telefono;
    LocalDate fechaActual = LocalDate.now();

    /**
     * En este metodo que crea y abre la actividad recogemos
     * los datos en atributos TextView para mostrarlos en pantalla.
     *
     * Estos se recogen mediante un bundle y se guardan en su EditText
     * correspondiente, posteriormente le hacemos setText a cada uno.
     *
     * Tambien aniade una comprobacion de fecha de la nota, en la que si
     * coincide con la fecha de la nota sonara una alarma.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_notas);
        Log.i("Errores", "Hemos llegado a la actividad VisualizarNotas");

        titulo = findViewById(R.id.textTitulo);
        descripcion = findViewById(R.id.textDescripcion);
        fechayHora = findViewById(R.id.textFechayHora);
        telefono = findViewById(R.id.textTelefono);

        Bundle datos = new Bundle();
        datos = getIntent().getExtras();

        String titulo2, descripcion2, fechayhora2, telefono2;
        titulo2 = datos.getString("Titulo");
        descripcion2 = datos.getString("Descripcion");
        fechayhora2 = datos.getString("Fecha y Hora");
        telefono2 = datos.getString("Telefono Contacto");

        titulo.setText(titulo2);
        descripcion.setText(descripcion2);
        fechayHora.setText(fechayhora2);
        telefono.setText(telefono2);

        if(fechayhora2.substring(0, 2) == fechaActual.toString().subSequence(0,2) && fechayhora2.substring(3, 5) == fechaActual.toString().subSequence(3,5) && fechayhora2.substring(6, 8) == fechaActual.toString().subSequence(6,8)){
            startService(new Intent(VisualizarNotas.this, Alarma.class));
            stopService(new Intent(VisualizarNotas.this, Alarma.class));
        }
    }

    /**
     * Este metodo asociado al botonLlamada de la actividad activity_visualizar_notas.xml
     * abre el dial del telefono con el numero recogido de la nota en el campo telefono.
     *
     * @param view botonLlamar
     */
    public void realizarLlamada(View view){
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + telefono.getText().toString()));
        startActivity(intent);
    }

    /**
     * Este metodo asociado al botonMensaje de la actividad activity_visualizar_notas.xml
     * abre una actividad para escribir un SMS al numero recogido de la nota en el campo telefono.
     *
     * @param view botonMensaje
     */
    public void mandarMensaje(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + telefono.getText().toString()));
        startActivity(intent);
    }


}