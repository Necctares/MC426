package com.grupomc426.API;

import com.grupomc426.DataBase.HelperDB;
import com.grupomc426.Targets.Atendimento.Agenda;
import com.grupomc426.Targets.Atendimento.Horario;
import com.grupomc426.Targets.Usuarios.Medico;
import com.grupomc426.Targets.Usuarios.Pessoa;


public class controladorConfirmacao {
    private HelperDB db;

    public controladorConfirmacao() {
        db = HelperDB.getDB();
    }

    public boolean confirmarHorario(Medico medico, Pessoa pessoa, Agenda agenda, Horario horario){
        //TODO
        return false;
    }
}
