package com.example.fitness.usuario;

public class Usuario {

    private String email;
    private String nome;
    private String senha;
    private String telefone;


    public Usuario(String email, String nome, String senha, String telefone){
       this.email=email;
       this.nome=nome;
       this.senha=senha;
       this.telefone=telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
