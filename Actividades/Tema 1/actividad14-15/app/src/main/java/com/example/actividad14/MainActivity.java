package com.example.actividad14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void cambiaActividad(View v){
        Intent i = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(i);
    }

    public void llamaActividades(View v){
        Intent sendIntent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(sendIntent);
    }

    public void abrirNavegador(View v){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com/"));
        startActivity(i);
    }

    public void abrirMapa(View v){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo: 35.88891, -5.32022"));
        startActivity(i);
    }

    public void mostrarContactos(View v){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people"));
        startActivity(i);
    }

    public void abrirCamara(View v){
        Intent i = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(i);
    }

    public void abrirTelefono(View v){
        Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:611150500"));
        startActivity(i);
    }

    public void escribirMensaje(View v){
        Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("sms:611150500"));
        startActivity(i);
    }

}