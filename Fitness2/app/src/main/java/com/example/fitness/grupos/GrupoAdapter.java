package com.example.fitness.grupos;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fitness.R;
import com.example.fitness.modalidade.Modalidade;

import java.util.List;

public class GrupoAdapter extends BaseAdapter {
private final List<Grupo> grupos;
private final Activity activity;

public GrupoAdapter(List<Grupo> grupos, Activity activity){

    this.grupos = grupos;
    this.activity = activity;
}

    @Override
    public int getCount() {
        return grupos.size();
    }

    @Override
    public Object getItem(int position) {
        return grupos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = activity.getLayoutInflater().inflate(R.layout.layout_mostra_grupos_img, parent, false );
        Grupo grupo = grupos.get(position);

        ImageView iconeModalidade = (ImageView) view.findViewById(R.id.imageViewMostraGrupoimg);
        TextView nomeGrupo = (TextView) view.findViewById(R.id.textViewNomeDoGrupoimg);
        TextView localizacaoGrupo = (TextView) view.findViewById(R.id.textViewLocalizacaoGrupoimg);
        TextView modalidadeGrupo = (TextView) view.findViewById(R.id.textViewNomeModalidadeimg);
        TextView dataGrupo = (TextView) view.findViewById(R.id.textViewDataGrupoimg);
        TextView horarioGrupo = (TextView) view.findViewById(R.id.textHorarioGrupoimg);

        nomeGrupo.setText(grupo.getNome());
        localizacaoGrupo.setText(grupo.getLocalizacao());
        modalidadeGrupo.setText(grupo.getModalidade_nome());
        dataGrupo.setText(grupo.getData());
        horarioGrupo.setText(grupo.getHorainicio());

        if (grupo.getModalidade_nome().equals(Modalidade.BASQUETE.getValor())){

            iconeModalidade.setImageResource(R.drawable.basket);

        }
        else if (grupo.getModalidade_nome().equals(Modalidade.BOXE.getValor())){

            iconeModalidade.setImageResource(R.drawable.boxe);

        }else if (grupo.getModalidade_nome().equals(Modalidade.CALISTENIA.getValor())){

            iconeModalidade.setImageResource(R.drawable.calistenia);

        }else if (grupo.getModalidade_nome().equals(Modalidade.CAMINHADA.getValor())){

            iconeModalidade.setImageResource(R.drawable.caminhada);

        }else if (grupo.getModalidade_nome().equals(Modalidade.CICLISMO.getValor())){

            iconeModalidade.setImageResource(R.drawable.cliclismo);

        }else if (grupo.getModalidade_nome().equals(Modalidade.CORRIDA.getValor())){

            iconeModalidade.setImageResource(R.drawable.corrida);

        }else if (grupo.getModalidade_nome().equals(Modalidade.CROSSFIT.getValor())){

            iconeModalidade.setImageResource(R.drawable.crossfit);

        }else if (grupo.getModalidade_nome().equals(Modalidade.DANCA.getValor())){

            iconeModalidade.setImageResource(R.drawable.danca);

        }else if (grupo.getModalidade_nome().equals(Modalidade.FUTEBOLAMERICANO.getValor())){

            iconeModalidade.setImageResource(R.drawable.americano);

        }else if (grupo.getModalidade_nome().equals(Modalidade.FUTEBOLDEAREIA.getValor())){

            iconeModalidade.setImageResource(R.drawable.futebolareia);

        }else if (grupo.getModalidade_nome().equals(Modalidade.FUTEBOLDECAMPO.getValor())){

            iconeModalidade.setImageResource(R.drawable.futsal);

        }else if (grupo.getModalidade_nome().equals(Modalidade.FUTEBOLDERUA.getValor())){

            iconeModalidade.setImageResource(R.drawable.futsal);

        }else if (grupo.getModalidade_nome().equals(Modalidade.FUTSAL.getValor())){

            iconeModalidade.setImageResource(R.drawable.futsal);

        }else if (grupo.getModalidade_nome().equals(Modalidade.FUTVOLEI.getValor())){

            iconeModalidade.setImageResource(R.drawable.futevolei);

        }else if (grupo.getModalidade_nome().equals(Modalidade.HANDEBOL.getValor())){

            iconeModalidade.setImageResource(R.drawable.handebol);

        }else if (grupo.getModalidade_nome().equals(Modalidade.JIUJITSU.getValor())){

            iconeModalidade.setImageResource(R.drawable.jiujitsu);

        }else if (grupo.getModalidade_nome().equals(Modalidade.KARATE.getValor())){

            iconeModalidade.setImageResource(R.drawable.karate);

        }else if (grupo.getModalidade_nome().equals(Modalidade.KRAVMAGA.getValor())){

            iconeModalidade.setImageResource(R.drawable.kravmaga);

        }else if (grupo.getModalidade_nome().equals(Modalidade.MEDITACAO.getValor())){

            iconeModalidade.setImageResource(R.drawable.meditacao);

        }else if (grupo.getModalidade_nome().equals(Modalidade.MUAYTHAI.getValor())){

            iconeModalidade.setImageResource(R.drawable.muaythai);

        }else if (grupo.getModalidade_nome().equals(Modalidade.NATACAO.getValor())){

            iconeModalidade.setImageResource(R.drawable.natacao);

        }else if (grupo.getModalidade_nome().equals(Modalidade.PARKOUR.getValor())){

        iconeModalidade.setImageResource(R.drawable.parkour);

    }else if (grupo.getModalidade_nome().equals(Modalidade.PATINS.getValor())){

        iconeModalidade.setImageResource(R.drawable.patins);

    }else if (grupo.getModalidade_nome().equals(Modalidade.RUGBY.getValor())){

        iconeModalidade.setImageResource(R.drawable.americano);

    }else if (grupo.getModalidade_nome().equals(Modalidade.SKATE.getValor())){

        iconeModalidade.setImageResource(R.drawable.skate);

    }else if (grupo.getModalidade_nome().equals(Modalidade.SLACKLINE.getValor())){

        iconeModalidade.setImageResource(R.drawable.slackline);

    }else if (grupo.getModalidade_nome().equals(Modalidade.TENIS.getValor())){

        iconeModalidade.setImageResource(R.drawable.tenis);

    }else if (grupo.getModalidade_nome().equals(Modalidade.TENISDEMESA.getValor())){

        iconeModalidade.setImageResource(R.drawable.tenisdemesa);

    }else if (grupo.getModalidade_nome().equals(Modalidade.TREINOAOARLIVRE.getValor())){

        iconeModalidade.setImageResource(R.drawable.treinoaoarlivre);

    }else if (grupo.getModalidade_nome().equals(Modalidade.TRILHA.getValor())){

        iconeModalidade.setImageResource(R.drawable.trilha);

    }else if (grupo.getModalidade_nome().equals(Modalidade.VOLEIBOL.getValor())){

        iconeModalidade.setImageResource(R.drawable.volei);

    }else if (grupo.getModalidade_nome().equals(Modalidade.VOLEIDEAREIA.getValor())){

        iconeModalidade.setImageResource(R.drawable.volei);

    }else if (grupo.getModalidade_nome().equals(Modalidade.XADREZ.getValor())){

            iconeModalidade.setImageResource(R.drawable.xadrez);

        }else if (grupo.getModalidade_nome().equals(Modalidade.YOGA.getValor())){

            iconeModalidade.setImageResource(R.drawable.yoga);

        }
        return view;
    }
}
