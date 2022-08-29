package com.example.fitness.entrada;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fitness.R;
import com.example.fitness.database.DBController;
import com.example.fitness.menu.MenuPrincipal;
import com.example.fitness.usuario.Usuario;
import com.google.gson.Gson;

import java.io.IOException;

public class Cadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }
    public void cadastrarUsuario(View V) throws IOException {

        EditText nomeEditText = (EditText) findViewById(R.id.editTextNomeFazCadastro);
        String nome = nomeEditText.getText().toString();

        EditText emailEditText = (EditText) findViewById(R.id.editTextEmailFazCadastro);
        String email = emailEditText.getText().toString();

        EditText senhaEditText = (EditText) findViewById(R.id.editTextSenhaFazCadastro);
        String senha = senhaEditText.getText().toString();

        EditText senha2EditText = (EditText) findViewById(R.id.editTextSenhaFazCadastro2);
        String senha2 = senha2EditText.getText().toString();

        EditText telefoneEditText = (EditText) findViewById(R.id.editTextCelularFazCadastro);
        String telefone = telefoneEditText.getText().toString();
        //comparação de texto é com equals

        if(senha.equals(senha2)) {

            int cadastroFeito = DBController.insertUsuarios(getApplicationContext(), nome, email, senha, telefone);

            if (cadastroFeito == 1) {

            Toast.makeText(getApplicationContext(),"Cadastro Realizado com Sucesso", Toast.LENGTH_SHORT).show();


                String emailUsuario = email ;
                String senhaUsuario = senha;
                String telefoneUsuario = telefone;
                String nomeUsuario = nome;

                SharedPreferences sp = getSharedPreferences("SalvarDadosdoUsuario", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                Usuario usuario = new Usuario(emailUsuario, nomeUsuario, senhaUsuario,telefoneUsuario);
                Gson gson = new Gson();
                String json = gson.toJson(usuario); // myObject - instance of MyObject
                editor.putString("UsuarioAtual",json);
                editor.apply();

            Intent intent = new Intent(this, MenuPrincipal.class);
                startActivity(intent);
                }

                else {
            Toast.makeText(getApplicationContext(), "Cadastro Não Realizado", Toast.LENGTH_SHORT).show();
                }

        }

        else {

            Toast.makeText(getApplicationContext(), "Senhas Não Compatíveis", Toast.LENGTH_SHORT).show();

        }
}


    public void Voltar(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void cadastrar(View view) {
        Intent intent = new Intent(this, MenuPrincipal.class);
        startActivity(intent);
    }
}
