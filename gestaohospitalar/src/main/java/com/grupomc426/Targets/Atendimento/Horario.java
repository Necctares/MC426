package com.grupomc426.Targets.Atendimento;

public class Horario {
    private int ano, mes, dia, hora, minuto;

    public Horario(int ano, int mes, int dia, int hora, int minuto) {
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
        this.hora = hora;
        this.minuto = minuto;
    }

    public int getAno() {
        return ano;
    }
    
    public int getMes(){
        return mes;
    }
    
    public int getDia(){
        return dia;
    }
    
    public int getHora(){
        return hora;
    }
    
    public int getMinuto(){
        return minuto;
    }

    @Override
    public String ToString(){
        String output = String.format("%d-%d-%d %d:%d", ano, mes, dia, hora, minuto);
        return output;
    }
}