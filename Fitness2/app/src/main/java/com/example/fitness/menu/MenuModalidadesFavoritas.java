package com.example.fitness.menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.fitness.eventos.EventosModalidadesFavoritas;
import com.example.fitness.grupos.MostraGrupo;
import com.example.fitness.modalidade.EscolherModalidadesFavoritas;
import com.example.fitness.R;
import com.example.fitness.modalidade.VerModalidadesFavoritas;

public class MenuModalidadesFavoritas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_modalidades_favoritas);
    }
    public void gruposDasModalidadesFavoritas(View view) {
        Intent intent = new Intent(this, MostraGrupo.class);
        startActivity(intent);
    }
    public void eventosDasModalidadesFavoritas(View view) {
        Intent intent = new Intent(this, EventosModalidadesFavoritas.class);
        startActivity(intent);
    }
    public void verModalidadesFavoritas(View view) {
        Intent intent = new Intent(this, VerModalidadesFavoritas.class);
        startActivity(intent);
    }
    public void definirModalidadesFavoritas(View view) {
        Intent intent = new Intent(this, EscolherModalidadesFavoritas.class);
        startActivity(intent);
    }
}
