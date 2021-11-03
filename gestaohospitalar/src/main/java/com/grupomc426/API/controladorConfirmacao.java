package com.grupomc426.API;

import com.grupomc426.DataBase.HelperDB;
import com.grupomc426.Targets.Usuarios.*;
import com.grupomc426.Targets.Atendimento.*;

public class controladorConfirmacao {
    private HelperDB db;

    public controladorConfirmacao() {
        db = HelperDB.getDB();
    }

    public boolean confirmarHorario(Consulta consulta, Agenda agenda) {
        return db.confirmarHorario(consulta, agenda);        
    }

    public boolean cancelarHorario(Consulta consulta, Agenda agenda) {
        return db.cancelarHorario(consulta, agenda);
    }
}