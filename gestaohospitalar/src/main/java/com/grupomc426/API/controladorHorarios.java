package com.grupomc426.API;

import com.grupomc426.DataBase.HelperDB;
import com.grupomc426.Targets.Atendimento.Agenda;
import com.grupomc426.Targets.Atendimento.Horario;
import com.grupomc426.Targets.Usuarios.Medico;
import com.grupomc426.Targets.Usuarios.Pessoa;

public class controladorHorarios {
    private HelperDB db;

    public controladorHorarios() {
        db = HelperDB.getDB();
    }

    public boolean registrarHorario(Medico medico, Horario horario) {
        //TODO;
        return false;
    }

    public boolean reservarHorario(Pessoa pessoa, Horario horario) {
        //TODO;
        return false;
    }

    public Agenda obterAgenda(Medico medico) {
        //TODO;
        return null;
    }
}