package com.example.fitness.grupos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fitness.R;
import com.example.fitness.modalidade.Modalidade;
import com.google.gson.Gson;

public class AbrirGrupo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abrir_grupo);

        Bundle bundle = getIntent().getExtras();
        String jsonSelecionado = bundle.getString("grupo_selecionado");
        Grupo grupoSelecionado = new Gson().fromJson(jsonSelecionado, Grupo.class);


        ImageView iconeModalidade = (ImageView) findViewById(R.id.imageViewGrupoSelecionado);
        TextView nomeGrupo = (TextView) findViewById(R.id.textViewNomeGrupoSelecionado);
        TextView localizacaoGrupo = (TextView) findViewById(R.id.textViewLocalizacaoGrupoSelecionado);
        TextView modalidadeGrupo = (TextView) findViewById(R.id.textViewModalidadeGrupoSelecionado);
        TextView dataGrupo = (TextView) findViewById(R.id.textViewDataGrupoSelecionado);
        TextView horaInicialGrupo = (TextView) findViewById(R.id.textViewHoraInicialGrupoSelecionado);
        TextView horaFinalGrupo = (TextView) findViewById(R.id.textViewHoraFinalGrupoSelecionado);
        TextView custoGrupo = (TextView) findViewById(R.id.textViewCustoGrupoSelecionado);
        TextView nivelGrupo = (TextView) findViewById(R.id.textViewNivelGrupoSelecionado);
        TextView descricaoGrupo = (TextView) findViewById(R.id.textViewDescricaoGrupoSelecionado);


        nomeGrupo.setText(grupoSelecionado.getNome());
        localizacaoGrupo.setText(grupoSelecionado.getLocalizacao());
        modalidadeGrupo.setText(grupoSelecionado.getModalidade_nome());
        dataGrupo.setText(grupoSelecionado.getData());
        horaInicialGrupo.setText(grupoSelecionado.getHorainicio());
        horaFinalGrupo.setText(grupoSelecionado.getHorafinal());
        custoGrupo.setText(grupoSelecionado.getCusto());
        nivelGrupo.setText(grupoSelecionado.getNivel());
        descricaoGrupo.setText(grupoSelecionado.getDescricao());

        if (grupoSelecionado.getModalidade_nome().equals(Modalidade.BASQUETE.getValor())){

            iconeModalidade.setImageResource(R.drawable.basket);

        }
        else if (grupoSelecionado.getModalidade_nome().equals(Modalidade.BOXE.getValor())){

            iconeModalidade.setImageResource(R.drawable.boxe);

        }else if (grupoSelecionado.getModalidade_nome().equals(Modalidade.CALISTENIA.getValor())){

            iconeModalidade.setImageResource(R.drawable.calistenia);

        }else if (grupoSelecionado.getModalidade_nome().equals(Modalidade.CAMINHADA.getValor())){

            iconeModalidade.setImageResource(R.drawable.caminhada);

        }else if (grupoSelecionado.getModalidade_nome().equals(Modalidade.CICLISMO.getValor())){

            iconeModalidade.setImageResource(R.drawable.cliclismo);

        }else if (grupoSelecionado.getModalidade_nome().equals(Modalidade.CORRIDA.getValor())){

            iconeModalidade.setImageResource(R.drawable.corrida);

        }else if (grupoSelecionado.getModalidade_nome().equals(Modalidade.CROSSFIT.getValor())){

            iconeModalidade.setImageResource(R.drawable.crossfit);

        }else if (grupoSelecionado.getModalidade_nome().equals(Modalidade.DANCA.getValor())){

            iconeModalidade.setImageResource(R.drawable.danca);

        }else if (grupoSelecionado.getModalidade_nome().equals(Modalidade.FUTEBOLAMERICANO.getValor())){

            iconeModalidade.setImageResource(R.drawable.americano);

        }else if (grupoSelecionado.getModalidade_nome().equals(Modalidade.FUTEBOLDEAREIA.getValor())){

            iconeModalidade.setImageResource(R.drawable.futebolareia);

        }else if (grupoSelecionado.getModalidade_nome().equals(Modalidade.FUTEBOLDECAMPO.getValor())){

            iconeModalidade.setImageResource(R.drawable.futsal);

        }else if (grupoSelecionado.getModalidade_nome().equals(Modalidade.FUTEBOLDERUA.getValor())){

            iconeModalidade.setImageResource(R.drawable.futsal);

        }else if (grupoSelecionado.getModalidade_nome().equals(Modalidade.FUTSAL.getValor())){

            iconeModalidade.setImageResource(R.drawable.futsal);

        }else if (grupoSelecionado.getModalidade_nome().equals(Modalidade.FUTVOLEI.getValor())){

            iconeModalidade.setImageResource(R.drawable.futevolei);

        }else if (grupoSelecionado.getModalidade_nome().equals(Modalidade.HANDEBOL.getValor())){

            iconeModalidade.setImageResource(R.drawable.handebol);

        }else if (grupoSelecionado.getModalidade_nome().equals(Modalidade.JIUJITSU.getValor())){

            iconeModalidade.setImageResource(R.drawable.jiujitsu);

        }else if (grupoSelecionado.getModalidade_nome().equals(Modalidade.KARATE.getValor())){

            iconeModalidade.setImageResource(R.drawable.karate);

        }else if (grupoSelecionado.getModalidade_nome().equals(Modalidade.KRAVMAGA.getValor())){

            iconeModalidade.setImageResource(R.drawable.kravmaga);

        }else if (grupoSelecionado.getModalidade_nome().equals(Modalidade.MEDITACAO.getValor())){

            iconeModalidade.setImageResource(R.drawable.meditacao);

        }else if (grupoSelecionado.getModalidade_nome().equals(Modalidade.MUAYTHAI.getValor())){

            iconeModalidade.setImageResource(R.drawable.muaythai);

        }else if (grupoSelecionado.getModalidade_nome().equals(Modalidade.NATACAO.getValor())){

            iconeModalidade.setImageResource(R.drawable.natacao);

        }else if (grupoSelecionado.getModalidade_nome().equals(Modalidade.PARKOUR.getValor())){

            iconeModalidade.setImageResource(R.drawable.parkour);

        }else if (grupoSelecionado.getModalidade_nome().equals(Modalidade.PATINS.getValor())){

            iconeModalidade.setImageResource(R.drawable.patins);

        }else if (grupoSelecionado.getModalidade_nome().equals(Modalidade.RUGBY.getValor())){

            iconeModalidade.setImageResource(R.drawable.americano);

        }else if (grupoSelecionado.getModalidade_nome().equals(Modalidade.SKATE.getValor())){

            iconeModalidade.setImageResource(R.drawable.skate);

        }else if (grupoSelecionado.getModalidade_nome().equals(Modalidade.SLACKLINE.getValor())){

            iconeModalidade.setImageResource(R.drawable.slackline);

        }else if (grupoSelecionado.getModalidade_nome().equals(Modalidade.TENIS.getValor())){

            iconeModalidade.setImageResource(R.drawable.tenis);

        }else if (grupoSelecionado.getModalidade_nome().equals(Modalidade.TENISDEMESA.getValor())){

            iconeModalidade.setImageResource(R.drawable.tenisdemesa);

        }else if (grupoSelecionado.getModalidade_nome().equals(Modalidade.TREINOAOARLIVRE.getValor())){

            iconeModalidade.setImageResource(R.drawable.treinoaoarlivre);

        }else if (grupoSelecionado.getModalidade_nome().equals(Modalidade.TRILHA.getValor())){

            iconeModalidade.setImageResource(R.drawable.trilha);

        }else if (grupoSelecionado.getModalidade_nome().equals(Modalidade.VOLEIBOL.getValor())){

            iconeModalidade.setImageResource(R.drawable.volei);

        }else if (grupoSelecionado.getModalidade_nome().equals(Modalidade.VOLEIDEAREIA.getValor())){

            iconeModalidade.setImageResource(R.drawable.volei);

        }else if (grupoSelecionado.getModalidade_nome().equals(Modalidade.XADREZ.getValor())){

            iconeModalidade.setImageResource(R.drawable.xadrez);

        }else if (grupoSelecionado.getModalidade_nome().equals(Modalidade.YOGA.getValor())){

            iconeModalidade.setImageResource(R.drawable.yoga);

        }
    }

}
