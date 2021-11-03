package com.grupomc426.Targets.Atendimento;

import java.util.List;

import com.grupomc426.Targets.Usuarios.Usuario;

public class Prontuario {
    private int prontuarioID;
    private Usuario paciente;
    private List<Exame> exames;
    private List<String> anotacoes;

    public Prontuario(int prontuarioID, Usuario paciente, List<Exame> exames, List<String> anotacoes) {
        this.prontuarioID = prontuarioID;
        this.paciente = paciente;
        this.exames = exames;
        this.anotacoes = anotacoes;
    }

    public int getProntuarioID() {
        return prontuarioID;
    }

    public Usuario getPaciente() {
        return paciente;
    }

    public List<Exame> getExames() {
        return exames;
    }

    public List<String> getAnotacoes() {
        return anotacoes;
    }
}