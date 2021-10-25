package com.grupomc426.API;

import com.grupomc426.DataBase.HelperDB;
import com.grupomc426.Targets.Atendimento.Agenda;
import com.grupomc426.Targets.Atendimento.Horario;
import com.grupomc426.Targets.Usuarios.Medico;
import com.grupomc426.Targets.Usuarios.Pessoa;

public class controladorHorarios {
    private HelperDB db;

    controladorHorarios() {
        db = HelperDB.getDB();
    }

    boolean registrarHorario(Medico medico, Horario horario) {
        //TODO;
        return false;
    }

    boolean reservarHorario(Pessoa pessoa, Horario horario) {
        //TODO;
        return false;
    }

    Agenda obterAgenda(Medico medico) {
        //TODO;
        return null;
    }
}