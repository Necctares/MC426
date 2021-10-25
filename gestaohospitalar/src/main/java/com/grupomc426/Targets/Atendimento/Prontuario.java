package com.grupomc426.Targets.Atendimento;

import java.util.List;

import com.grupomc426.Targets.Usuarios.Usuario;

public class Prontuario {
    private Usuario paciente;
    private List<Exame> exames;
    private List<String> anotacoes;

    public Prontuario(Usuario paciente, List<Exame> exames, List<String> anotacoes) {
        this.paciente = paciente;
        this.exames = exames;
        this.anotacoes = anotacoes;
    }
}
