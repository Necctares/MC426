package com.grupomc426.Targets.Atendimento;

import java.util.List;
import com.grupomc426.Targets.Usuarios.Medico;

public class Agenda {
    private Medico medico;
    private List<Horario> horarios;

    public Agenda(Medico medico) {
        this.medico = medico;
    }

    public void adicionarHorario (Horario horario) {
        horarios.add(horario);
    }

    public Medico obterMedico() {
        return medico;
    }   
}