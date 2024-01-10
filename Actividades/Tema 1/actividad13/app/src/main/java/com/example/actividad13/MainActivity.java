package com.example.actividad13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Ciclo de vida", "La aplicacion se ha creado");
    }

    protected void onStart(){
        super.onStart();
        getDelegate().onStart();
        Log.i("Ciclo de vida", "La aplicacion se ha iniciado");
    }

    protected void onResume(){
        super.onResume();
        getDelegate().onPostResume();
        Log.i("Ciclo de vida", "La aplicacion se ha reanudado");
    }

    protected void onPause(){
        super.onPause();
        Log.i("Ciclo de vida", "La aplicacion se ha pausado");

    }

    protected void onStop(){
        super.onStop();
        getDelegate().onStop();
        Log.i("Ciclo de vida", "La aplicacion se ha detenido");
    }

    protected void onDestroy(){
        super.onDestroy();
        getDelegate().onDestroy();
        Log.i("Ciclo de vida", "La aplicacion se ha destruido");
    }

}