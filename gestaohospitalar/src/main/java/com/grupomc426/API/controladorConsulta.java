package com.grupomc426.API;

import java.util.List;

import com.grupomc426.DataBase.Helpers.HelperConsultas;
import com.grupomc426.Targets.Atendimento.*;

public class controladorConsulta {
    private HelperConsultas db;

    public controladorConsulta() {
        db = HelperConsultas.getDB();
    }

    public boolean adicionarConsulta(Consulta consulta) {
        return db.adicionarConsulta(consulta);
    }

    public List<Consulta> obterConsultaMedico(String crm) {
        return db.obterConsultaMedico(crm);
    }

    public List<Consulta> obterConsultaPaciente(String cpf) {
        return db.obterConsultaPaciente(cpf);
    }
}