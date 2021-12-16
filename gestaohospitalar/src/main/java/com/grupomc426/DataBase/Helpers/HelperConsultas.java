package com.grupomc426.DataBase.Helpers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.grupomc426.DataBase.ConsultaDB;
import com.grupomc426.Targets.Atendimento.Consulta;
import com.grupomc426.Targets.Usuarios.Usuario;

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

    public boolean adicionarConsulta(Consulta consulta) {
        Map<String, String> mapaConsulta = new HashMap<String, String>();
        mapaConsulta.put("medico", consulta.getMedico().getCrm());
        mapaConsulta.put("usuario", consulta.getUsuario().getCPF());
        mapaConsulta.put("horario", consulta.getHorario().toString());
        return db.adicionarConsulta(mapaConsulta);
    }

    public List<Consulta> obterConsultaMedico(String crm) {
        List<Consulta> consulta = db.obterConsultaMedico(crm);
        if (consulta.size() > 0) {
            return consulta;
        } else {
            return null;
        }
    }

    public List<Consulta> obterConsultaPaciente(String cpf) {
        List<Consulta> consulta = db.obterConsultaPaciente(cpf);
        if (consulta.size() > 0) {
            return consulta;
        } else {
            return null;
        }
    }

    @Override
    public boolean tentarLogin(Usuario usuario) {
        // TODO Auto-generated method stub
        return false;
    }
}
