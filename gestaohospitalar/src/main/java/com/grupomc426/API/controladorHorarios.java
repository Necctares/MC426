package com.grupomc426.API;

import com.grupomc426.DataBase.HelperDB;
import com.grupomc426.Targets.Atendimento.*;
import com.grupomc426.Targets.Usuarios.*;

public class controladorHorarios {
    private HelperDB db;

    public controladorHorarios() {
        db = HelperDB.getDB();
    }

    public boolean registrarHorario(Medico medico, java.time.LocalDateTime horario) {
        return db.registrarHorario(medico, horario);
    }

    public boolean reservarHorario(Medico medico, java.time.LocalDateTime horario, Pessoa pessoa) {
        return db.reservarHorario(medico, horario, pessoa);
    }
    //OBTER AGENDA É PEGAR A TABELA DO MEDICO E DOS HORARIOS
    public Agenda obterAgenda(Medico medico) {
        return db.obterAgenda(medico);
    }
}