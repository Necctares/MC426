package com.grupomc426.Targets.Produtos;

public class Medicamento {
    private int id;
    private int objId;
    private String nome;
    private String composto;
    private int numUso;

    public Medicamento(int id, String nome, String composto, int numUso, int objId){
        this.id = id;
        this.nome = nome;
        this.composto = composto;
        this.numUso = numUso;
        this.objId = objId;
    }

    public int getID(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public String getComposto(){
        return composto;
    }

    public int getNumUso(){
        return numUso;
    }

    public int getObjId(){
        return objId;
    }
}
