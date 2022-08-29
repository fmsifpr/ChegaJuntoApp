package com.example.fitness.grupos;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitness.R;
import com.example.fitness.database.DBController;
import com.example.fitness.usuario.Usuario;
import com.google.gson.Gson;

import java.io.IOException;

public class CriarGrupo extends AppCompatActivity {

    String modalidade_nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_grupo);

        Intent intentModalidade = getIntent();

        Bundle modalidadegrupo = intentModalidade.getExtras();


        if (modalidadegrupo != null) {

            String modalidade = modalidadegrupo.getString("chavemodalidade");
            //colocar o nome da modalidade no campo textview do novo grupo
             modalidade_nome = modalidade.toString();
            Toast.makeText(getApplicationContext(), modalidade_nome, Toast.LENGTH_SHORT).show();

            TextView modalidadeGrupo = (TextView) findViewById(R.id.textViewModalidadeGrupo);
            modalidadeGrupo.setText(modalidade_nome);
        }
    }

    public void inserirGrupos(View V) throws IOException {

        EditText nomeEditText = (EditText) findViewById(R.id.editTextCriarGrupoNome);
        String nome = nomeEditText.getText().toString();

        EditText horainicioEditText = (EditText) findViewById(R.id.editTextCriarGrupoHorarioInicio);
        String horainicio = horainicioEditText.getText().toString();

        EditText horafinalEditText = (EditText) findViewById(R.id.editTextCriarGrupoHorarioTermino);
        String horafinal = horafinalEditText.getText().toString();

        EditText custoEditText = (EditText) findViewById(R.id.editTextCriarGrupoCusto);
        String custo = custoEditText.getText().toString();

        EditText localizacaoEditText = (EditText) findViewById(R.id.editTextCriarGrupoLocalizacao);
        String localizacao = localizacaoEditText.getText().toString();

        EditText descricaoEditText = (EditText) findViewById(R.id.editTextCriarGrupoDescricao);
        String descricao = descricaoEditText.getText().toString();

        EditText datadiaEditText = (EditText) findViewById(R.id.editTextCriarGrupoDataDia);
        String datadia = datadiaEditText.getText().toString();

        EditText datamesEditText = (EditText) findViewById(R.id.editTextCriarGrupoDataMes);
        String datames = datamesEditText.getText().toString();

        EditText dataanoEditText = (EditText) findViewById(R.id.editTextCriarGrupoDataAno);
        String dataano = dataanoEditText.getText().toString();

        String data = dataano + "-" + datames + "-" + datadia;

        CheckBox niveliniciante = (CheckBox) findViewById(R.id.checkBoxNivelIniciante);

        CheckBox nivelintermediario = (CheckBox) findViewById(R.id.checkBoxNivelIntermediario);

        CheckBox nivelavancado = (CheckBox) findViewById(R.id.checkBoxNivelAvancado);

        String nivel = null;

        if(niveliniciante.isChecked()){

            nivel = "Iniciante";

        } else if(nivelintermediario.isChecked()){

            nivel = "Intermediário";

        } else if(nivelavancado.isChecked()) {

            nivel = "Avançado";

        }

        SharedPreferences sp = getSharedPreferences("SalvarDadosdoUsuario", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sp.getString("UsuarioAtual", "");
        Usuario usuario = gson.fromJson(json, Usuario.class);
        String emailUsuario = usuario.getEmail();
        String usuario_email = emailUsuario;

        //comparação de texto é com equals

        if(nome==null  || datadia==null || datames==null || dataano==null|| horainicio==null || horafinal==null || nivel==null || localizacao==null
                || descricao==null || modalidade_nome==null || usuario_email==null) {

            Toast.makeText(getApplicationContext(), "Algum Dado Não Foi Preenchido", Toast.LENGTH_SHORT).show();

        } else {

            data = dataano + "-" + datames + "-" + datadia;

            int cadastroFeito = DBController.insertGrupos(getApplicationContext(), nome, data, horainicio, horafinal,
                    custo, nivel, localizacao, descricao, modalidade_nome, usuario_email);

            if (cadastroFeito == 1) {

                Toast.makeText(getApplicationContext(),"Grupo Criado com Sucesso", Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(this, MostraGrupo.class);
                startActivity(intent);
            }

            else {
                Toast.makeText(getApplicationContext(), "Não foi possível criar o Grupo", Toast.LENGTH_SHORT).show();
            }
        }
    }
}