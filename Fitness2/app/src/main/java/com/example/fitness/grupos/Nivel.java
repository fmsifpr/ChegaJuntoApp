package com.example.fitness.grupos;

public enum Nivel {
    INICIANTE("Basquete"),
    ITERMEDIARIO("Basquete"),
    AVANCADO("Basquete");

    private String valor;

    Nivel(String novoValor) {
        this.valor = novoValor;
    }

    public String getValor() {
        return valor;
    }
}
