package com.grupomc426.DataBase.Helpers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.grupomc426.DataBase.HorariosDB;
import com.grupomc426.Targets.Atendimento.Agenda;
import com.grupomc426.Targets.Atendimento.Consulta;
import com.grupomc426.Targets.Usuarios.Medico;
import com.grupomc426.Targets.Usuarios.Pessoa;
import com.grupomc426.Targets.Usuarios.Usuario;

public class HelperHorarios implements HelperDB {
    private HorariosDB db;
    private static HelperHorarios instance = null;

    private HelperHorarios() {
        db = new HorariosDB();
    }

    public static HelperHorarios getDB() {
        if (instance == null) {
            instance = new HelperHorarios();
        }
        return instance;
    }

    /* TODO */
    public boolean checkLogin(String id, String senha) {
        return false;
    }

    // TODO controladorConfirmaçao
    public boolean confirmarHorario(Consulta consulta, Agenda agenda) {
        return false;
    }

    public boolean cancelarHorario(Consulta consulta, Agenda agenda) {
        return false;
    }

    // TODO controladorHorarios
    public boolean registrarHorario(Medico medico, LocalDateTime horario) {
        Map<String, String> mapaHorario = new HashMap<String, String>();
        mapaHorario.put("horario", horario.toString());
        mapaHorario.put("crm", medico.getCrm());
        mapaHorario.put("cpf", null);
        return db.adicionarHorario(mapaHorario);
    }

    public boolean reservarHorario(Medico medico, LocalDateTime horario, Pessoa paciente) {
        Map<String, String> mapaHorario = new HashMap<String, String>();
        mapaHorario.put("horario", horario.toString());
        mapaHorario.put("crm", medico.getCrm());
        mapaHorario.put("cpf", paciente.getCPF());
        return db.removerHorario(mapaHorario);
    }

    public Agenda obterAgenda(Medico medico) {
        return null;
    }

    @Override
    public boolean tentarLogin(Usuario usuario) {
        // TODO Auto-generated method stub
        return false;
    }
}
