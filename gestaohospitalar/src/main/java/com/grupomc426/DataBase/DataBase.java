package com.grupomc426.DataBase;

import java.util.Map;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class DataBase {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/";
    static final String USER = "teste";
    static final String PASS = "123456789";
    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    void startDB() {
        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Conectando ao banco de dados...");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Criando banco de dados...");
            statement = connection.createStatement();

            String cmd = "CREATE DATABASE IF NOT EXISTS HOSPITAL";
            statement.executeUpdate(cmd);

            System.out.println("Banco de dados criado com sucesso...");
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Finalizado");
        startTables();
    }

    private void startTables() {
        makeAcess();
        String create_pessoa = "CREATE TABLE IF NOT EXISTS PESSOA " + "(nome VARCHAR(100), " + " telefone VARCHAR(13), "
                + "cpf VARCHAR(13) not NULL, " + " age INTEGER, " + " PRIMARY KEY ( cpf ))";
        String create_usuario = "CREATE TABLE IF NOT EXISTS USUARIO "
                + "(id INTEGER not NULL, senha VARCHAR(30) not NULL, ehFuncionario TINYINT, PRIMARY KEY(id))";
        String create_Medico = "CREATE TABLE IF NOT EXISTS MEDICO "
                + "(crm INTEGER not NULL, cpf INTEGER not NULL, assinatura TEXT, " + " PRIMARY KEY(crm))";
        String create_medicamentos = "CREATE TABLE IF NOT EXISTS MEDICAMENTO " + "(nome VARCHAR(40), "
                + " id INTEGER not NULL," + " compostoAtivo VARCHAR(40), " + " PRIMARY KEY ( id ))";
        String create_medUsados = "CREATE TABLE IF NOT EXISTS MEDICAMENTOS_USADOS "
                + "(idExame INTEGER, idMedicamento INTEGER not NULL, cpf INTEGER not NULL, "
                + " numUso INTEGER not NULL, PRIMARY KEY (idExame, idMedicamento, cpf))";
        String create_exames = "CREATE TABLE IF NOT EXISTS EXAME "
                + "(idExame INTEGER not NULL, cpf INTEGER not NULL, titulo VARCHAR(45), crm INTEGER not NULL, anotacoes TEXT, "
                + "resultado TEXT, assinatura TEXT, data DATETIME, PRIMARY KEY (idExame))";
        String create_anotacoes = "CREATE TABLE IF NOT EXISTS ANOTACAO "
                + "(cpf INTEGER not NULL, id INTEGER not NULL, anotacao TEXT, PRIMARY KEY(id))";
        String create_consulta = "CREATE TABLE IF NOT EXISTS CONSULTA "
                + "(idConsulta INTEGER not NULL, crm INTEGER not NULL, cpf INTEGER not NULL, data DATETIME not NULL, PRIMARY KEY(idConsulta))";
        String create_horario = "CREATE TABLE IF NOT EXISTS HORARIO " + "(data DATETIME not NULL, crm INTEGER not NULL, cpf INTEGER not NULL"
                + "PRIMARY KEY(data, crm))";
        try {
            statement.executeUpdate(create_pessoa);
            statement.executeUpdate(create_usuario);
            statement.executeUpdate(create_Medico);
            statement.executeUpdate(create_medicamentos);
            statement.executeUpdate(create_medUsados);
            statement.executeUpdate(create_exames);
            statement.executeUpdate(create_anotacoes);
            statement.executeUpdate(create_consulta);
            statement.executeUpdate(create_horario);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeAcess();
    }

    void makeAcess() {
        System.out.println("Conectando ao banco de dados...");
        try {
            connection = DriverManager.getConnection(DB_URL + "HOSPITAL", USER, PASS);
            statement = connection.createStatement();
            System.out.println("Conexao estabelecida com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void closeAcess() {
        System.out.println("Encerrando acesso ao banco de dados...");
        try {
            if (statement != null)
                statement.close();
        } catch (SQLException se2) {
            se2.printStackTrace();
        }
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        statement = null;
        connection = null;
        System.out.println("Conexao encerrada com sucesso.");
    }

    void adicionarPessoa(String pessoaValues) {
        makeAcess();
        String cmd = "INSERT INTO PESSOA VALUES " + pessoaValues;
        try {
            statement.executeUpdate(cmd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeAcess();
    }

    void removerPessoa(String pessoaValues) {
        makeAcess();
        String cmd = "REMOVE FROM PESSOA " + "WHERE cpf = " + pessoaValues;
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

    public boolean adicionarProntuario(Map<String, String> prontuario) {
        makeAcess();
        String cmd = "INSERT INTO PRONTUARIO VALUES " + prontuario.get("id") + prontuario.get("medico")
                + prontuario.get("paciente") + prontuario.get("anotacoes") + prontuario.get("resultado")
                + prontuario.get("foiAssinado") + prontuario.get("assinatura") + prontuario.get("data");
        try {
            statement.executeUpdate(cmd);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        closeAcess();
        return true;
    }

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

    public boolean assinarProntuario(String prontuarioID, String assinatura) {
        makeAcess();
        String cmd = "UPDATE PRONTUARIO SET assinatura=" + assinatura + "WHERE idProntuario=" + prontuarioID;
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
    public boolean obterProntuario(int prontuarioID) {
        // proxima parte, fazer na GUI
        return true;
    }

    // TODO
    public boolean removerHorario(Map<String, String> horario) {
        makeAcess();
        String cmd = "REMOVE FROM HORARIO " + "WHERE field = " + horario.get("data") + horario.get("crm") + horario.get("cpf");
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