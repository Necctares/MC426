package com.grupomc426.Targets.Produtos;

public class Medicamento {
    private String id;
    private String nome;
    private String composto;

    public Medicamento(String id, String nome, String composto){
        this.id = id;
        this.nome = nome;
        this.composto = composto;
    }

    public String getID(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public String getComposto(){
        return composto;
    }
}
