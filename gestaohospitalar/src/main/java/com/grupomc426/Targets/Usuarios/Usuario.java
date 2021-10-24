package com.grupomc426.Targets.Usuarios;

public class Usuario extends Pessoa{

    private String id;
    private String senha;
    private boolean ehFuncionario;

    public Usuario(String nome, String telefone, String cpf_id, String idade, String senha, boolean ehFuncionario) {
        super(nome, telefone, cpf_id, idade);
        this.id = cpf_id;
        this.senha = senha;
        this.ehFuncionario = ehFuncionario;
    }
}