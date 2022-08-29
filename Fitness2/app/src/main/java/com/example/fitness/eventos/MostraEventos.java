package com.example.fitness.eventos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.fitness.R;
import com.example.fitness.filtros.FiltrosGrupo;

public class MostraEventos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);
    }
    public void filtrarEvento(View view) {
        Intent intent = new Intent(this, FiltrosGrupo.class);
        startActivity(intent);
    }
}
