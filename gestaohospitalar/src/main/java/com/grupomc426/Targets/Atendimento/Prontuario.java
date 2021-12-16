package com.grupomc426.Targets.Atendimento;

import java.util.List;

import com.grupomc426.Targets.Usuarios.Usuario;

public class Prontuario {
    private String cpf;
    private Usuario paciente;
    private List<Exame> exames;
    private List<String> anotacoes;

    public Prontuario(String cpf, Usuario paciente, List<Exame> exames, List<String> anotacoes) {
        this.cpf = cpf;
        this.paciente = paciente;
        this.exames = exames;
        this.anotacoes = anotacoes;
    }

    public String getCpfID() {
        return cpf;
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