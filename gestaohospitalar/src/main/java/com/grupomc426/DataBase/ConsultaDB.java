package com.grupomc426.DataBase;

import java.util.Map;

import java.sql.SQLException;

public class ConsultaDB extends DataBase {

    public boolean adicionarConsulta(Map<String, String> consulta) {
        makeAcess();
        String cmd = "INSERT INTO CONSULTA VALUES " + consulta.get("id") + consulta.get("medico")
                + consulta.get("usuario") + consulta.get("horario");
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
