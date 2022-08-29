package com.example.fitness.grupos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.fitness.modalidade.Modalidade;
import com.example.fitness.R;

import java.util.ArrayList;

public class EscolherModalidadeGrupo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolher_modalidade_grupo);

        ListView listamodalidadesgrupos = (ListView) findViewById(R.id.listViewModalidadesGrupo);

        final ArrayList<String> grupos = preencherModalidades();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, grupos);

        listamodalidadesgrupos.setAdapter(arrayAdapter);

        listamodalidadesgrupos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String modalidade = grupos.get(position).toString();

                Intent intent = new Intent(getApplicationContext(), CriarGrupo.class);

                startActivity(intent);

                Bundle modalidadegrupo = new Bundle();

                modalidadegrupo.putString("chavemodalidade", modalidade);

                intent.putExtras(modalidadegrupo);

                startActivity(intent);
            }
        });
    }

    private ArrayList<String> preencherModalidades(){
        ArrayList<String> dados = new ArrayList<String>();

        dados.add(Modalidade.BASQUETE.getValor());
        dados.add(Modalidade.BOXE.getValor());
        dados.add(Modalidade.CALISTENIA.getValor());
        dados.add(Modalidade.CAMINHADA.getValor());
        dados.add(Modalidade.CICLISMO.getValor());
        dados.add(Modalidade.CORRIDA.getValor());
        dados.add(Modalidade.CROSSFIT.getValor());
        dados.add(Modalidade.DANCA.getValor());
        dados.add(Modalidade.FUTEBOLAMERICANO.getValor());
        dados.add(Modalidade.FUTEBOLDEAREIA.getValor());
        dados.add(Modalidade.FUTEBOLDECAMPO.getValor());
        dados.add(Modalidade.FUTSAL.getValor());
        dados.add(Modalidade.FUTSAL.getValor());
        dados.add(Modalidade.FUTVOLEI.getValor());
        dados.add(Modalidade.HANDEBOL.getValor());
        dados.add(Modalidade.JIUJITSU.getValor());
        dados.add(Modalidade.KARATE.getValor());
        dados.add(Modalidade.KRAVMAGA.getValor());
        dados.add(Modalidade.MEDITACAO.getValor());
        dados.add(Modalidade.MUAYTHAI.getValor());
        dados.add(Modalidade.NATACAO.getValor());
        dados.add(Modalidade.PARKOUR.getValor());
        dados.add(Modalidade.PATINS.getValor());
        dados.add(Modalidade.RUGBY.getValor());
        dados.add(Modalidade.SKATE.getValor());
        dados.add(Modalidade.SLACKLINE.getValor());
        dados.add(Modalidade.TENIS.getValor());
        dados.add(Modalidade.TENISDEMESA.getValor());
        dados.add(Modalidade.TREINOAOARLIVRE.getValor());
        dados.add(Modalidade.TRILHA.getValor());
        dados.add(Modalidade.VOLEI.getValor());
        dados.add(Modalidade.VOLEIBOL.getValor());
        dados.add(Modalidade.VOLEIDEAREIA.getValor());
        dados.add(Modalidade.XADREZ.getValor());
        dados.add(Modalidade.YOGA.getValor());

        return dados;
    }
}
