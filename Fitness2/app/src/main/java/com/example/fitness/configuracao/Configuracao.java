package com.example.fitness.configuracao;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.fitness.R;
import com.example.fitness.entrada.MainActivity;
import com.example.fitness.menu.MenuPrincipal;
import com.example.fitness.usuario.Usuario;
import com.google.gson.Gson;

import org.json.JSONException;

import java.io.IOException;

public class Configuracao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracao);
    }

    public void sairConta (View view){

        SharedPreferences sp = getSharedPreferences("SalvarDadosdoUsuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove("UsuarioAtual");
        editor.apply();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    }

