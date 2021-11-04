package com.grupomc426.API;

import com.grupomc426.DataBase.Helpers.HelperConsultas;
import com.grupomc426.Targets.Atendimento.*;

public class controladorConsulta {
    private HelperConsultas db;

    public controladorConsulta() {
        db = HelperConsultas.getDB();
    }

    public boolean registrarConsulta(Consulta consulta) {
        return db.registrarConsulta(consulta);
    }
}