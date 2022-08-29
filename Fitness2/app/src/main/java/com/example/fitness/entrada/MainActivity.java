package com.example.fitness.entrada;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.fitness.R;
import com.example.fitness.menu.MenuPrincipal;
import com.example.fitness.usuario.Usuario;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sp = getSharedPreferences("SalvarDadosdoUsuario", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sp.getString("UsuarioAtual", "");
        Usuario usuario = gson.fromJson(json, Usuario.class);
        String email = null;

        if (usuario!= null){
            String emailLogado = usuario.getEmail();

            if (emailLogado != null) {
                email = UsuarioEmail();
                Intent intent = new Intent(this, MenuPrincipal.class);
                startActivity(intent);
            }
        }
    }
    public String UsuarioEmail(){
        //recebe o email
        SharedPreferences sp = getSharedPreferences("SalvarDadosdoUsuario", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sp.getString("UsuarioAtual", "");
        Usuario usuario = gson.fromJson(json, Usuario.class);
        String email = usuario.getEmail();
        return email;
    }
    public void login(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
    public void cadastro(View view) {
        Intent intent = new Intent(this, Cadastro.class);
        startActivity(intent);
    }
    public void sobre(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

}
