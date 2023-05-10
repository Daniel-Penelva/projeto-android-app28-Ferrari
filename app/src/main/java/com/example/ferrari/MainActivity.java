package com.example.ferrari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irSegundaTela(View view){

        Toast.makeText(this, "Clicou na tela", Toast.LENGTH_LONG).show();

        //Recebe como parâmetro a tela em que está e a tela em que quer ir
        Intent intent = new Intent(MainActivity.this, SegundaTela.class);
        startActivity(intent);
    }
}
