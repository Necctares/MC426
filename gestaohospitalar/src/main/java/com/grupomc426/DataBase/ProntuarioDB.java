package com.grupomc426.DataBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.grupomc426.Targets.Produtos.Medicamento;
import com.grupomc426.Targets.Usuarios.Medico;
import com.grupomc426.Targets.Usuarios.Pessoa;
import com.grupomc426.Targets.Usuarios.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProntuarioDB extends DataBase {

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

    public Pessoa obterPessoa(String cpf) {
        makeAcess();
        String cmd = "SELECT * FROM PESSOA P WHERE P.cpf = '" + cpf + "';";
        Pessoa pessoa = null;
        try {
            resultSet = statement.executeQuery(cmd);
            if (resultSet.next()) {
                pessoa = new Pessoa(resultSet.getString("nome"), resultSet.getString("telefone"),
                        resultSet.getString("cpf"), resultSet.getString("year"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeAcess();
        return pessoa;
    }

    public Medico obterMedico(String crm) {
        makeAcess();
        String cmd = "SELECT * FROM MEDICO M WHERE M.crm = " + crm + ";";
        Medico medico = null;
        try {
            resultSet = statement.executeQuery(cmd);
            if (resultSet.next()) {
                String assinatura = resultSet.getString("assinatura");
                String cpf = resultSet.getString("cpf");

                cmd = "SELECT * FROM PESSOA P WHERE P.cpf = '" + cpf + "';";
                resultSet = statement.executeQuery(cmd);

                if (resultSet.next()) {
                    Pessoa pessoa = new Pessoa(resultSet.getString("nome"), resultSet.getString("telefone"),
                            resultSet.getString("cpf"), resultSet.getString("year"));
                    medico = new Medico(new Usuario(pessoa, null, true), crm, assinatura);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeAcess();
        return medico;
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

    public boolean adicionarMedicamento(int prontuarioID, Map<String, String> medicamento) {
        makeAcess();
        String cmd = "INSERT INTO MEDICAMENTOS_USADOS VALUES " + Integer.toString(prontuarioID) + ", "
                + medicamento.get("id")
                + ", " + medicamento.get("numUso") + ";";
        try {
            statement.executeUpdate(cmd);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        closeAcess();
        return true;
    }

    public List<Medicamento> pegarMedicamento(int prontuarioID) {
        makeAcess();
        String cmd = "SELECT MU.id_uso, MU.numUso, ME.id, ME.nome, ME.compostoAtivo FROM MEDICAMENTOS_USADOS MU, MEDICAMENTO ME WHERE MU.idProntuario = "
                + Integer.toString(prontuarioID)
                + " AND MU.idMedicamento = ME.id;";
        List<Medicamento> resultado = new ArrayList<Medicamento>();
        try {
            resultSet = statement.executeQuery(cmd);
            while (resultSet.next()) {
                Medicamento novo = new Medicamento(resultSet.getInt("id"), resultSet.getString("nome"),
                        resultSet.getString("compostoAtivo"), resultSet.getInt("numUso"), resultSet.getInt("id_uso"));
                resultado.add(novo);
            }
            resultSet.close();
            resultSet = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeAcess();
        return resultado;
    }

    public boolean removerMedicamento(int objID) {
        makeAcess();
        String cmd = "DELETE FROM MEDICAMENTOS_USADOS MU WHERE MU.id_uso = " + Integer.toString(objID) + ";";
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
    public String obterProntuario(String cpf) {
        String prontuario = null;
        return prontuario;
    }

    public String obterSenha(String id) {
        String senha = null;
        makeAcess();
        String cmd = "SELECT senha FROM USUARIO WHERE id = " + id;

        try {
            ResultSet rs = statement.executeQuery(cmd);

            while (rs.next()) {
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