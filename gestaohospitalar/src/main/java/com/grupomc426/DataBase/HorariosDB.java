package com.grupomc426.DataBase;

import java.util.Map;
import java.util.HashMap;

import java.sql.SQLException;

public class HorariosDB extends DataBase {
    private Map<String, Boolean> horarios = new HashMap<String, Boolean>();

    // TODO Implementar Parte do DB
    // Fizemos uma simulação do DB utilizando uma ArrayList
    public boolean adicionarHorario(Map<String, String> horario) {
        if (horarios.containsKey(horario.get("data"))) {
            return false;
        } else {
            horarios.put(horario.get("data"), true);
            return true;
        }
        /*
         * makeAcess(); String cmd = "INSERT INTO HORARIO VALUES " + horario.get("data")
         * + horario.get("crm") + horario.get("cpf"); try {
         * statement.executeUpdate(cmd); } catch (SQLException e) { e.printStackTrace();
         * } closeAcess();
         */
    }

    // TODO Implementar Parte do DB
    // Fizemos uma simulação do DB utilizando uma ArrayList
    public boolean reservarHorario(Map<String, String> horario) {
        if (horarios.containsKey(horario.get("data"))) {
            if (horarios.get(horario.get("data"))) {
                horarios.replace(horario.get("data"), false);
                return true;
            }
            return false;
        } else {
            return false;
        }
    }

    // TODO Implementar Parte do DB
    // Fizemos uma simulação do DB utilizando uma ArrayList
    public boolean removerHorario(Map<String, String> horario) {
        if (horarios.containsKey(horario.get("data"))) {
            horarios.remove(horario.get("data"));
            return true;
        } else {
            return false;
        }
        /*
         * makeAcess(); String cmd = "REMOVE FROM HORARIO " + "WHERE field = " +
         * horario.get("data") + horario.get("crm") + horario.get("cpf"); try {
         * statement.executeUpdate(cmd); } catch (SQLException e) { e.printStackTrace();
         * return false; } closeAcess(); return true;
         */
    }
}
