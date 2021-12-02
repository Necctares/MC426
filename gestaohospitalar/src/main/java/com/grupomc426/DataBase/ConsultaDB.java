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

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ConsultaDB extends DataBase {

    public boolean adicionarConsulta(Map<String, String> consulta) {
        makeAcess();
        String cmd = "INSERT INTO CONSULTA VALUES " + consulta.get("medico") + ", "
                + consulta.get("usuario") + ", " + consulta.get("horario") + ";";
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
        String cmd = "SELECT * FROM CONSULTA C WHERE C.crm = " + crm + ";";
        List<Consulta> consultas = new ArrayList<Consulta>();
        try {
            resultSet = statement.executeQuery(cmd);
            while (resultSet.next()) {
                Medico med = hp.obterMedico(crm);
                Pessoa paciente = hp.obterPessoa(resultSet.getString("cpf"));
                Prontuario prontuario = hp.obterProntuario(resultSet.getString("cpf"));
                if (med == null || paciente == null || prontuario == null) {
                    return consultas;
                } else {
                    Consulta consulta = new Consulta(resultSet.getInt("idConsulta"), med,
                            new Usuario(paciente, null, false), prontuario,
                            LocalDateTime.parse(resultSet.getString("data")));
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
        String cmd = "SELECT * FROM CONSULTA C WHERE C.cpf = " + cpf + ";";
        List<Consulta> consultas = new ArrayList<Consulta>();
        try {
            resultSet = statement.executeQuery(cmd);
            while (resultSet.next()) {
                Medico med = hp.obterMedico(resultSet.getString("crm"));
                Pessoa paciente = hp.obterPessoa(cpf);
                Prontuario prontuario = hp.obterProntuario(cpf);
                if (med == null || paciente == null || prontuario == null) {
                    return consultas;
                } else {
                    Consulta consulta = new Consulta(resultSet.getInt("idConsulta"), med,
                            new Usuario(paciente, null, false), prontuario,
                            LocalDateTime.parse(resultSet.getString("data")));
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
