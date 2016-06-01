package com.example.master.miaplicacion2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView lblPregunta;
    //EditText txtRespuesta;
    Button btnSi;
    Button btnNo;
    String cadena;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblPregunta = (TextView)findViewById(R.id.lblpregunta);
        btnSi = (Button) findViewById(R.id.btnSi);
        btnNo = (Button) findViewById(R.id.btnNo);

        btnSi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadena = "si";
                controlador.interaccion(lblPregunta, cadena);
            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               cadena = "no";
                controlador.interaccion(lblPregunta, cadena);
            }
        });
    }

    //controlador.interaccion(lblPregunta, txtRespuesta);

}
