package com.grupomc426.API;

import java.util.Map;

import com.grupomc426.DataBase.Helpers.HelperHorarios;
import com.grupomc426.Targets.Atendimento.*;
import com.grupomc426.Targets.Usuarios.*;

public class controladorHorarios {
    private HelperHorarios db;

    public controladorHorarios() {
        db = HelperHorarios.getDB();
    }

    public Map<String, String> obterMedicos(){
        return db.obterMedicos();
    }

    public boolean registrarHorario(Medico medico, java.time.LocalDateTime horario, Pessoa paciente) {
        return db.registrarHorario(medico, horario, paciente);
    }

    public boolean reservarHorario(Medico medico, java.time.LocalDateTime horario, Pessoa pessoa) {
        return db.reservarHorario(medico, horario, pessoa);
    }
    
    //OBTER AGENDA É PEGAR A TABELA DO MEDICO E DOS HORARIOS
    public Agenda obterAgenda(Medico medico) {
        return db.obterAgenda(medico);
    }
}