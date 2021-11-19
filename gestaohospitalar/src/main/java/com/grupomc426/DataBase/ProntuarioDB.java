package com.grupomc426.DataBase;

import java.util.Map;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProntuarioDB extends DataBase{

    public void adicionarPessoa(String pessoaValues) {
        makeAcess();
        String cmd = "INSERT INTO PESSOA VALUES " + pessoaValues;
        try {
            statement.executeUpdate(cmd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeAcess();
    }

    public void adicionarUsuario(String usuarioValues) {
        makeAcess();
        String cmd = "INSERT INTO USUARIO VALUES " + usuarioValues;
        try {
            statement.executeUpdate(cmd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeAcess();
    }

    public void removerPessoa(String pessoaValues) {
        makeAcess();
        String cmd = "REMOVE FROM PESSOA " + "WHERE cpf = " + pessoaValues;
        try {
            statement.executeUpdate(cmd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeAcess();
    }

    public void removerUsuario(String usuarioValues) {
        makeAcess();
        String cmd = "REMOVE FROM USUARIO WHERE id = " + usuarioValues;
        try {
            statement.executeUpdate(cmd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeAcess();
    }

    public boolean adicionarMedicamento(Map<String, String> medicamento) {
        makeAcess();
        String cmd = "INSERT INTO CONSULTA VALUES " + medicamento.get("nome") + medicamento.get("id")
                + medicamento.get("composto");
        try {
            statement.executeUpdate(cmd);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        closeAcess();
        return true;
    }

    public boolean adicionarExame(Map<String, String> exame) {
        makeAcess();
        String cmd = "INSERT INTO EXAME VALUES " + exame.get("titulo") + exame.get("id") + exame.get("medico")
                + exame.get("paciente") + exame.get("anotacoes") + exame.get("resultado") + exame.get("foiAssinado")
                + exame.get("assinatura") + exame.get("data");
        try {
            statement.executeUpdate(cmd);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        closeAcess();
        return true;
    }

    public boolean assinarExame(String exameID, String assinatura) {
        makeAcess();
        String cmd = "UPDATE EXAME SET assinatura=" + assinatura + "WHERE idExame=" + exameID;
        try {
            statement.executeUpdate(cmd);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        closeAcess();
        return true;
    }

    /* TODO */
    public String obterProntuario(int prontuarioID) {
        String prontuario = null;
        return prontuario;
    }

    public String obterSenha(String id) {
        String senha = null;
        makeAcess();
        String cmd = "SELECT senha FROM USUARIO WHERE id = " + id;

        try {
            ResultSet rs = statement.executeQuery(cmd);
            
            while(rs.next()) {
                senha = rs.getString("senha");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        closeAcess();
        return senha;
    }
}
