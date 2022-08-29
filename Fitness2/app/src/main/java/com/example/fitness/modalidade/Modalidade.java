package com.example.fitness.modalidade;

public enum Modalidade {

    BASQUETE("Basquete"),
    BOXE("Boxe"),
    CALISTENIA("Calistenia"),
    CAMINHADA("Caminhada"),
    CICLISMO("Ciclismo"),
    CORRIDA("Corrida"),
    CROSSFIT("CrossFit"),
    DANCA("Dança"),
    FUTEBOLAMERICANO("Futebol Americano"),
    FUTEBOLDEAREIA("Futebol de Areia"),
    FUTEBOLDECAMPO("Futebol de Campo"),
    FUTEBOLDERUA("Futebol de Rua"),
    FUTSAL("Futsal"),
    FUTVOLEI("FutVolei"),
    HANDEBOL("Handebol"),
    JIUJITSU("Jiu-Jitsu"),
    KARATE("Karatê"),
    KRAVMAGA("Krav Magá"),
    MEDITACAO("Meditação"),
    MUAYTHAI("Muay Thai"),
    NATACAO("Natação"),
    PARKOUR("Parkour"),
    PATINS("Patins"),
    RUGBY("Rugby"),
    SKATE("Skate"),
    SLACKLINE("Slackline"),
    TENIS("Tênis"),
    TENISDEMESA("Tênis de Mesa"),
    TREINOAOARLIVRE("Treino ao Ar Livre"),
    TRILHA("Trilha"),
    VOLEI("Volei"),
    VOLEIBOL("Voleibol"),
    VOLEIDEAREIA("Volei de Areia"),
    XADREZ("Xadrez"),
    YOGA("Yoga");

    private String valor;

    Modalidade(String novoValor) {
        this.valor = novoValor;
    }

    public String getValor() {
        return valor;
    }
}
