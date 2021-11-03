package com.grupomc426.Targets.Atendimento;

import java.time.LocalDateTime;

import com.grupomc426.Targets.Usuarios.*;

public class Exame {
    private String titulo;
    private String id;
    private Medico medico;
    private Usuario paciente;
    private String anotacoes;
    private String resultado;
    private boolean foiAssinado;
    private String assinatura;
    private LocalDateTime horario;

    public Exame(String titulo, String id, Medico medico, Usuario paciente, String anotacoes, String resultado,
            boolean foiAssinado, String assinatura, LocalDateTime horario) {
        this.medico = medico;
        this.paciente = paciente;
        this.anotacoes = anotacoes;
        this.resultado = resultado;
        this.foiAssinado = foiAssinado;
        this.assinatura = assinatura;
        this.titulo = titulo;
        this.id = id;
        this.horario = horario;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getid(){
        return id;
    }

    public Medico getMedico(){
        return medico;
    }

    public String getAnotacoes(){
        return anotacoes;
    }

    public Usuario getPaciente(){
        return paciente;
    }

    public String getResultado(){
        return resultado;
    }

    public boolean getFoiAssinado(){
        return foiAssinado;
    }

    public String getAssinatura(){
        return assinatura;
    }

    public LocalDateTime getHorario(){
        return horario;
    }
}
