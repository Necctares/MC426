package com.grupomc426.DataBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.grupomc426.DataBase.Helpers.HelperProntuario;
import com.grupomc426.Targets.Atendimento.Consulta;
import com.grupomc426.Targets.Atendimento.Prontuario;
import com.grupomc426.Targets.Usuarios.Medico;
import com.grupomc426.Targets.Usuarios.Pessoa;
import com.grupomc426.Targets.Usuarios.Usuario;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConsultaDB extends DataBase {

    public boolean adicionarConsulta(Map<String, String> consulta) {
        makeAcess();
        String cmd = "INSERT INTO CONSULTA VALUES (0, '" + consulta.get("medico") + "', '"
                + consulta.get("usuario") + "' , '" + consulta.get("horario") + "');";
        try {
            statement.executeUpdate(cmd);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        closeAcess();
        return true;
    }

    public List<Consulta> obterConsultaMedico(String crm) {
        makeAcess();
        HelperProntuario hp = HelperProntuario.getDB();
        String cmd = "SELECT * FROM CONSULTA WHERE crm = '" + crm + "';";
        List<Consulta> consultas = new ArrayList<Consulta>();
        Medico med = hp.obterMedicoCRM(crm);
        try {
            resultSet = statement.executeQuery(cmd);
            while (resultSet.next()) {
                Pessoa paciente = hp.obterPessoa(resultSet.getString("cpf"));
                Prontuario prontuario = hp.obterProntuario(resultSet.getString("cpf"));
                if (med == null || paciente == null || prontuario == null) {
                    return consultas;
                } else {
                    Consulta consulta = new Consulta(resultSet.getInt("idConsulta"), med,
                            new Usuario(paciente, null, false), prontuario,
                            LocalDateTime.parse(resultSet.getString("data"), DateTimeFormatter.ISO_LOCAL_DATE_TIME));
                    consultas.add(consulta);
                }
            }
            resultSet.close();
            resultSet = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consultas;
    }

    public List<Consulta> obterConsultaPaciente(String cpf) {
        makeAcess();
        HelperProntuario hp = HelperProntuario.getDB();
        String cmd = "SELECT * FROM CONSULTA WHERE cpf = '" + cpf + "';";
        List<Consulta> consultas = new ArrayList<Consulta>();
        Pessoa paciente = hp.obterPessoa(cpf);
        try {
            resultSet = statement.executeQuery(cmd);
            while (resultSet.next()) {
                Medico med = hp.obterMedicoCRM(resultSet.getString("crm"));
                Prontuario prontuario = hp.obterProntuario(cpf);
                if (med == null || paciente == null || prontuario == null) {
                    return consultas;
                } else {
                    Consulta consulta = new Consulta(resultSet.getInt("idConsulta"), med,
                            new Usuario(paciente, null, false), prontuario,
                            LocalDateTime.parse(resultSet.getString("data"), DateTimeFormatter.ISO_LOCAL_DATE_TIME));
                    consultas.add(consulta);
                }
            }
            resultSet.close();
            resultSet = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consultas;
    }
}
