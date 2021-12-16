package com.grupomc426.DataBase;

import java.util.Map;

import com.grupomc426.API.controladorProntuario;
import com.grupomc426.Targets.Usuarios.Pessoa;

import java.util.HashMap;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.sql.SQLException;

public class HorariosDB extends DataBase {

    public boolean adicionarHorario(Map<String, String> horario) {
        makeAcess();
        String cmd = "INSERT INTO HORARIO VALUES ('" + horario.get("data")
                + "','" + horario.get("crm") + "','" + horario.get("cpf") + "', 0);";
        try {
            statement.executeUpdate(cmd);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        closeAcess();
        return true;
    }

    public Map<String, String> obterMedicos() {
        makeAcess();
        controladorProntuario cdb = new controladorProntuario();
        String cmd = "SELECT * FROM MEDICO;";
        Map<String, String> medicos = new HashMap<String, String>();
        try {
            resultSet = statement.executeQuery(cmd);
            while (resultSet.next()) {
                Pessoa pessoa = cdb.obterPessoa(resultSet.getString("cpf"));
                if (pessoa != null) {
                    medicos.put(resultSet.getString("crm"), pessoa.getNome());
                }
            }
            resultSet.close();
            resultSet = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeAcess();
        return medicos;
    }

    public boolean alterarReservaHorario(Map<String, String> horario) {
        makeAcess();
        String cmd = "UPDATE HORARIO SET cpf = " + horario.get("cpf") + "WHERE field = " +
                horario.get("data") + horario.get("crm");
        try {
            statement.executeUpdate(cmd);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        closeAcess();
        return true;
    }

    public boolean removerHorario(Map<String, String> horario) {
        makeAcess();
        String cmd = "REMOVE FROM HORARIO " + "WHERE field = " +
                horario.get("data") + horario.get("crm");
        try {
            statement.executeUpdate(cmd);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        closeAcess();
        return true;
    }

    public Map<LocalDateTime, String> obterHorarios(String crm) {
        makeAcess();
        String cmd = "SELECT * FROM HORARIO H WHERE H.crm = '" + crm + "';";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        Map<LocalDateTime, String> horarios = new HashMap<LocalDateTime, String>();
        try {
            resultSet = statement.executeQuery(cmd);
            while (resultSet.next()) {
                horarios.put(LocalDateTime.parse(resultSet.getString("data"), formatter), resultSet.getString("cpf"));
            }
            resultSet.close();
            resultSet = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeAcess();
        return horarios;
    }
}
