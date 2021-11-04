package com.grupomc426.Targets.Usuarios;

public class Usuario extends Pessoa{

    private String id;
    private String senha;
    private boolean ehFuncionario;

    public Usuario(Pessoa pessoa, String senha, boolean ehFuncionario) {
        super(pessoa.getNome(), pessoa.getTelefone(), pessoa.getCPF(), pessoa.getIdade());
        this.id = pessoa.getCPF();
        this.senha = senha;
        this.ehFuncionario = ehFuncionario;
    }

    
    public String getID(){
        return id;
    }
    
    public String getSenha(){
        return senha;
    }
    
    public boolean getEhFuncionario(){
        return ehFuncionario;
    }
}