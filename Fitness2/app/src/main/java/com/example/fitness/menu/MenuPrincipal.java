package com.example.fitness.menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.fitness.configuracao.Configuracao;
import com.example.fitness.eventos.MostraEventos;
import com.example.fitness.R;

public class MenuPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
//        info();
    }

//    public void info(){ //chamar por exemplo nome do usuário no sharedpreferences
//
//        SharedPreferences sp = getSharedPreferences("SalvarDadosdoUsuario", Context.MODE_PRIVATE);
//        Gson gson = new Gson();
//        String json = sp.getString("UsuarioAtual", "");
//        Usuario usuario = gson.fromJson(json, Usuario.class);
//        //Toda vez que precisar pegar uma coisa nova basta dar nome a string e fazer o get do que quer lá na classe Usuário
//        String nomeUsuario = usuario.getNome();
//        TextView nomeEditText = (TextView) findViewById(R.id.textViewNomeDoUsuarioMenuPrincipal);
//        nomeEditText.setText(nomeUsuario);
//        //Buscando Nome do Usuário
//    }
    public void menuGrupo(View view) {
        Intent intent = new Intent(this, MenuGrupo.class);
        startActivity(intent);
    }
    public void menuModalidadesFavoritas(View view) {
        Intent intent = new Intent(this, MenuModalidadesFavoritas.class);
        startActivity(intent);
    }
    public void eventos(View view) {
        Intent intent = new Intent(this, MostraEventos.class);
        startActivity(intent);
    }
    public void configuracao(View view) {
        Intent intent = new Intent(this, Configuracao.class);
        startActivity(intent);
    }
}
