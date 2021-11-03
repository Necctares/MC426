package com.grupomc426.Targets.Atendimento;

import com.grupomc426.Targets.Usuarios.*;

public class Consulta {
    private int consultaID;
    private Medico medico;
    private Usuario usuario;
    private Prontuario prontuario;
    private Horario horario;

    public Consulta(int consultaID, Medico medico, Usuario usuario, Horario horario) {
        this.consultaID = consultaID;
        this.medico = medico;
        this.usuario = usuario;
        this.prontuario = new Prontuario(0, usuario, null, null);
        this.horario = horario;
    }
    
    public int getConsultaID(){
        return consultaID;
    }

    public Prontuario getProntuario() {
        return prontuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Medico getMedico() {
        return medico;
    }

    public Horario getHorario() {
        return horario;
    }
}