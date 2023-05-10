package com.example.ferrari;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SegundaTela extends AppCompatActivity {

    private TextView textoFerrari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);

        textoFerrari = findViewById(R.id.idFerrari);

        // Pacotes de váriaveis que vem junto com Intent
        Bundle bundle = getIntent().getExtras();

        if(bundle != null){

            // Captura o 'name' passado por parâmetro da MainActivity
            String texto = bundle.getString("modeloFerrari");

            if(texto != null){
                textoFerrari.setText(texto);
            }

            //Toast.makeText(this, "Modelo da Ferrari: " + texto, Toast.LENGTH_LONG).show();
        }


    }
}
