package com.example.fitness.grupos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitness.R;
import com.example.fitness.database.DBController;
import com.example.fitness.filtros.FiltrosGrupo;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class MostraGrupo extends AppCompatActivity {
    String mostraGrupo;
    private ArrayList<Grupo> grupos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostra_grupos);
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener(){

            public void onItemClick(AdapterView<?> listView, View itemView, int position, long id) {
                Grupo grupoSelecionado = grupos.get(position);

                Intent intentMenuGrupo = getIntent();

                Bundle menugrupo = intentMenuGrupo.getExtras();

                if (menugrupo != null) {

                    String grupo = menugrupo.getString("grupos");
                    //colocar o nome da modalidade no campo textview do novo grupo
                    mostraGrupo = grupo.toString();
                    Toast.makeText(getApplicationContext(), mostraGrupo, Toast.LENGTH_SHORT).show();

                    TextView mostragrupo = (TextView) findViewById(R.id.textViewNomeMostraAlgumaCoisa);
                    mostragrupo.setText(mostraGrupo);

                }

                Bundle bundle = new Bundle();

                bundle.putString("grupo_selecionado", new Gson().toJson(grupoSelecionado));

                Intent intent = new Intent(getApplicationContext(), AbrirGrupo.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        };

        try {
            if(mostraGrupo.equals("Grupos Disponíveis")){
                addGrupos();
            } else if(mostraGrupo.equals("Grupos que Participo")){
                addGrupos();
            } else if(mostraGrupo.equals("Grupos Criados")){
                addGrupos();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        GrupoAdapter adapter = new GrupoAdapter(grupos, this);
        ListView listView = (ListView) findViewById(R.id.listvViewGrupo);
        listView.setOnItemClickListener(itemClickListener);
        listView.setAdapter(adapter);

    }


    private ArrayList<Grupo> addGrupos() throws IOException, JSONException {

        JSONArray jsonArray = DBController.selectAllGrupo(this);
        grupos = new ArrayList<Grupo>();

        for (int i = 0; i < jsonArray.length(); i++) {

            JSONObject object = jsonArray.getJSONObject(i);

            String nome = object.getString("nome");
            String localizacao = object.getString("localizacao");
            String modalidade = object.getString("modalidade_nome");
            String data = object.getString("data");
            String horarioinicial = object.getString("horainicio");
            String horariofinal = object.getString("horafinal");
            String custo = object.getString("custo");
            String nivel = object.getString("nivel");
            String descricao = object.getString("descricao");
            String usuario = object.getString("usuario_email");

            Grupo grupo = new Grupo();
            grupo.setNome(nome);
            grupo.setLocalizacao(localizacao);
            grupo.setModalidade_nome(modalidade);
            grupo.setData(data);
            grupo.setHorainicio(horarioinicial);
            grupo.setHorafinal(horariofinal);
            grupo.setCusto(custo);
            grupo.setNivel(nivel);
            grupo.setDescricao(descricao);
            grupo.setUsuario_email(usuario);

            grupos.add(grupo);
        }
        return grupos;
    }

//https://www.youtube.com/watch?reload=9&v=KQCQn3yFOrs
    public void filtrarGrupo(View view) {
        Intent intent = new Intent(this, FiltrosGrupo.class);
        startActivity(intent);
    }

    public void criarGrupo(View view) {
        Intent intent = new Intent(this, EscolherModalidadeGrupo.class);
        startActivity(intent);
    }
}
