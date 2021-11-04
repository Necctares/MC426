package com.grupomc426.DataBase;

import java.util.Map;

import java.sql.SQLException;

public class HorariosDB extends DataBase{

    public boolean adicionarHorario(Map<String, String> horario) {
        makeAcess();
        String cmd = "INSERT INTO HORARIO VALUES " + horario.get("data") + horario.get("crm");
        try {
            statement.executeUpdate(cmd);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        closeAcess();
        return true;
    }

    // TODO
    public boolean removerHorario(Map<String, String> horario) {
        makeAcess();
        String cmd = "REMOVE FROM HORARIO " + "WHERE field = " + horario.get("data") + horario.get("crm")
                + horario.get("cpf");
        try {
            statement.executeUpdate(cmd);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        closeAcess();
        return true;
    }
}
