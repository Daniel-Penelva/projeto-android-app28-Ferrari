package com.example.ferrari;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SegundaTela extends AppCompatActivity {

    ImageView image;
    TextView title, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);

        image = findViewById(R.id.imageIcone2);
        title = findViewById(R.id.textTitulo2);
        description = findViewById(R.id.textDescricao);

        // Pacotes de váriaveis que vem junto com Intent
        Bundle bundle = getIntent().getExtras();

        if(bundle != null){

            // Captura a 'chave' passado por parâmetro da MainActivity
            String textTitulo = bundle.getString("titulo");
            String textDescricao = bundle.getString("descricao");
            int imgIcone = bundle.getInt("icone");

            // Setando os valores capturados pela chave para atualizar os componentes
            title.setText(textTitulo);
            description.setText(textDescricao);
            image.setImageResource(imgIcone);
        }
    }
}
