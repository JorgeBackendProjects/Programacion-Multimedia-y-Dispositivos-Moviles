package com.example.programaciontema1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botonPrincipal = (Button) findViewById(R.id.botonPrincipal);
        botonPrincipal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                ImageView img = (ImageView) findViewById(R.id.ImagenJava);
                if(img.getVisibility() == View.INVISIBLE){
                    img.setVisibility(View.VISIBLE);
                }else{
                    img.setVisibility(View.INVISIBLE);
                }


                /*TextView texto = (TextView) findViewById(R.id.TextoPrincipal);
                texto.setText("El texto ha cambiado");*/

            }


        });
    }
}