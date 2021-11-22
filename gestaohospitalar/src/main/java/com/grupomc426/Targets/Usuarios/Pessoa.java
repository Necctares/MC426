package com.grupomc426.Targets.Usuarios;

public class Pessoa {
    private String nome;
    private String telefone;
    private String cpf;
    private String anoNascimento;
    
    public Pessoa(String nome, String telefone, String cpf, String anoNascimento){
        this.cpf = cpf;
        this.telefone = telefone;
        this.nome = nome;
        this.anoNascimento = anoNascimento;
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
    public String getAnoNascimento() {
        return anoNascimento;
    }
}