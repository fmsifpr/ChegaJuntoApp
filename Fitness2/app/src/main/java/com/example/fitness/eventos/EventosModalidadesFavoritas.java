package com.example.fitness.eventos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.fitness.R;
import com.example.fitness.filtros.FiltrosGrupo;

public class EventosModalidadesFavoritas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos_modalidades_favoritas);
    }
    public void filtrarEventosFavoritos(View view) {
        Intent intent = new Intent(this, FiltrosGrupo.class);
        startActivity(intent);
    }
}
