package com.grupomc426.Targets.Usuarios;

public class Pessoa {
    private String nome;
    private String telefone;
    private String cpf;
    private String idade;
    
    public Pessoa(String nome, String telefone, String cpf, String idade){
        this.cpf = cpf;
        this.telefone = telefone;
        this.nome = nome;
        this.idade = idade;
    }

    public String getCPF() {
        return cpf;
    }
    public String getNome() {
        return nome;
    }
    public String getTelefone() {
        return telefone;
    }
    public String getIdade() {
        return idade;
    }
}