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

        //Recebe como parâmetro a tela em que está e a tela em que quer ir
        Intent intent = new Intent(MainActivity.this, SegundaTela.class);

        // Passando parâmetro entre as telas
        intent.putExtra("modeloFerrari", "Ferrari 456");

        startActivity(intent);
    }
}
