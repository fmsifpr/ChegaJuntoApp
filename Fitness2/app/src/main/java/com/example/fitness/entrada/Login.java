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
import com.example.fitness.usuario.Usuario;
import com.example.fitness.database.DBController;
import com.example.fitness.menu.MenuPrincipal;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class Login extends AppCompatActivity {

    private DBController dbController = new DBController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
        setContentView(R.layout.activity_login);
    }



    public void onClickLogin(View v) throws IOException, JSONException {

        EditText emailText = (EditText) findViewById(R.id.editTextEmailFazLogin);
        String email = emailText.getText().toString();
        EditText senhaText = (EditText) findViewById(R.id.editTextSenhaFazLogin);
        String senha = senhaText.getText().toString();
        LoginCorreto(email.toUpperCase(),senha);

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

    private void LoginCorreto(String email, String senha) throws IOException, JSONException {
        //confere o usuario

        JSONArray jsonUsuario = dbController.selectUsuario(getApplicationContext()); //método dentro da classe java do bd, método que chama realmente as informações do usuário
        boolean encontrado = false;
        String emailUsuario = "" ;
        String senhaUsuario = "";
        String telefoneUsuario = "";
        String nomeUsuario = "";


        for (int i = 0; i < jsonUsuario.length(); i++) {
            //pega os dados do usuario
            JSONObject UsuarioObject = (JSONObject) jsonUsuario.get(i);
            emailUsuario = UsuarioObject.getString("email");
            nomeUsuario = UsuarioObject.getString("nome");
            senhaUsuario = UsuarioObject.getString("senha");
            telefoneUsuario = UsuarioObject.getString("telefone");

            if (emailUsuario.toUpperCase().equals(email) && senhaUsuario.equals(senha)) {
                encontrado = true;
                break;
            }
        }

        if (encontrado) {

            SharedPreferences sp = getSharedPreferences("SalvarDadosdoUsuario", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            Usuario usuario = new Usuario(emailUsuario, nomeUsuario, senhaUsuario,telefoneUsuario);
            Gson gson = new Gson();
            String json = gson.toJson(usuario); // myObject - instance of MyObject
            editor.putString("UsuarioAtual",json);
            editor.apply();

            Intent intent = new Intent(this, MenuPrincipal.class);
            startActivity(intent);


        }else{
            Toast.makeText(getApplicationContext(),"Login Inválido",Toast.LENGTH_LONG).show();
        }
    }

    public void login(View view) {
        Intent intent = new Intent(this, MenuPrincipal.class);
        startActivity(intent);
    }
}
