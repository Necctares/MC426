package com.grupomc426.DataBase.Helpers;

import java.util.HashMap;
import java.util.Map;

import com.grupomc426.DataBase.ConsultaDB;
import com.grupomc426.Targets.Atendimento.Consulta;

public class HelperConsultas implements HelperDB {
    private ConsultaDB db;
    private static HelperConsultas instance = null;

    private HelperConsultas() {
        db = new ConsultaDB();
    }
    
    /* TODO */
    public boolean checkLogin(String id, String senha) {
        return false;
    }

    public static HelperConsultas getDB() {
        if (instance == null) {
            instance = new HelperConsultas();
        }
        return instance;
    }

    public boolean registrarConsulta(Consulta consulta) {
        Map<String, String> mapaConsulta = new HashMap<String, String>();
        mapaConsulta.put("id", Integer.toString(consulta.getID()));
        mapaConsulta.put("medico", consulta.getMedico().getCrm());
        mapaConsulta.put("usuario", consulta.getUsuario().getCPF());
        mapaConsulta.put("horario", consulta.getHorario().toString());
        return db.adicionarConsulta(mapaConsulta);
    }
}
