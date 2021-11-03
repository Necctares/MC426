package com.grupomc426.Targets.Atendimento;

import com.grupomc426.Targets.Usuarios.*;
import java.time.LocalDateTime;

public class Consulta {
    private int consultaID;
    private Medico medico;
    private Usuario usuario;
    private Prontuario prontuario;
    private LocalDateTime horario;

    public Consulta(int consultaID, Medico medico, Usuario usuario, LocalDateTime horario) {
        this.consultaID = consultaID;
        this.medico = medico;
        this.usuario = usuario;
        this.prontuario = new Prontuario(0, usuario, null, null);
        this.horario = horario;
    }
    
    public int getID(){
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

    public LocalDateTime getHorario() {
        return horario;
    }
}