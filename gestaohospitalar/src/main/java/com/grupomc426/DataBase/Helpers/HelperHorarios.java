package com.grupomc426.DataBase.Helpers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

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

    // TODO controladorConfirmaçao
    public boolean confirmarHorario(Consulta consulta, Agenda agenda) {
        return false;
    }

    public boolean removerHorario(Medico medico, LocalDateTime horario) {
        if (horario.isAfter(LocalDateTime.now())) {
            Map<String, String> mapaHorario = new HashMap<String, String>();
            mapaHorario.put("horario", horario.toString());
            mapaHorario.put("crm", medico.getCrm());
            return db.removerHorario(mapaHorario);
        } else {
            return false;
        }
    }

    public boolean registrarHorario(Medico medico, LocalDateTime horario) {
        if (horario.isAfter(LocalDateTime.now())) {
            Map<String, String> mapaHorario = new HashMap<String, String>();
            mapaHorario.put("horario", horario.toString());
            mapaHorario.put("crm", medico.getCrm());
            mapaHorario.put("cpf", null);
            return db.adicionarHorario(mapaHorario);
        } else {
            return false;
        }
    }

    public boolean reservarHorario(Medico medico, LocalDateTime horario, Pessoa paciente) {
        if (horario.isAfter(LocalDateTime.now())) {
            Map<String, String> mapaHorario = new HashMap<String, String>();
            mapaHorario.put("horario", horario.toString());
            mapaHorario.put("crm", medico.getCrm());
            mapaHorario.put("cpf", paciente.getCPF());
            return db.alterarReservaHorario(mapaHorario);
        } else {
            return false;
        }
    }

    public boolean cancelarHorario(Medico medico, LocalDateTime horario) {
        Map<String, String> mapaHorario = new HashMap<String, String>();
        mapaHorario.put("horario", horario.toString());
        mapaHorario.put("crm", medico.getCrm());
        mapaHorario.put("cpf", null);
        return db.alterarReservaHorario(mapaHorario);
    }

    public Agenda obterAgenda(Medico medico) {
        Map<LocalDateTime, String> horarios = db.obterHorarios(medico.getCrm());
        return new Agenda(medico, horarios);
    }

    @Override
    public boolean tentarLogin(Usuario usuario) {
        // TODO Auto-generated method stub
        return false;
    }
}
