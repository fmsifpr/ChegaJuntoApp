package com.example.fitness.menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.fitness.R;
import com.example.fitness.grupos.MostraGrupo;

public class MenuGrupo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_grupo);
    }
    public void gruposDisponiveis(View view) {

        Intent intent = new Intent(this, MostraGrupo.class);

        Bundle grupos = new Bundle();

        grupos.putString("grupos", "Grupos Disponiveis");

        intent.putExtras(grupos);

        startActivity(intent);
    }
    public void gruposQueParticipo(View view) {
        Intent intent = new Intent(this, MostraGrupo.class);

        Bundle grupos = new Bundle();

        grupos.putString("grupos", "Grupos que Participo");

        intent.putExtras(grupos);
        startActivity(intent);
    }
    public void gruposCriados(View view) {
        Intent intent = new Intent(this, MostraGrupo.class);

        Bundle grupos = new Bundle();

        grupos.putString("grupos", "Grupos Criados");

        intent.putExtras(grupos);

        startActivity(intent);
    }
    public void criarGrupo(View view) {
        Intent intent = new Intent(this, MostraGrupo.class);
        startActivity(intent);
    }
}
