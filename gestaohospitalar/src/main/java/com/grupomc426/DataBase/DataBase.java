package com.grupomc426.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/";
    static final String USER = "teste";
    static final String PASS = "123456789";
    protected Connection connection = null;
    protected Statement statement = null;
    protected PreparedStatement preparedStatement = null;
    protected ResultSet resultSet = null;

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
        String create_pessoa = "CREATE TABLE IF NOT EXISTS PESSOA " + "(nome VARCHAR(100), " + " telefone VARCHAR(11), "
                + "cpf VARCHAR(13) not NULL, " + " year INTEGER, " + " PRIMARY KEY ( cpf ));";
        String create_usuario = "CREATE TABLE IF NOT EXISTS USUARIO "
                + "(id VARCHAR(13) not NULL PRIMARY KEY, senha VARCHAR(30) not NULL, ehFuncionario TINYINT);";
        String create_Medico = "CREATE TABLE IF NOT EXISTS MEDICO "
                + "(crm VARCHAR(7) not NULL, cpf VARCHAR(13) not NULL, assinatura TEXT, " + " PRIMARY KEY(crm));";
        String create_medicamentos = "CREATE TABLE IF NOT EXISTS MEDICAMENTO " + "(id INTEGER not NULL AUTO_INCREMENT, "
                + "nome VARCHAR(40)," + " compostoAtivo VARCHAR(40), " + "PRIMARY KEY ( id ));";
        String create_medUsados = "CREATE TABLE IF NOT EXISTS MEDICAMENTOS_USADOS "
                + "(id_uso INTEGER not NULL AUTO_INCREMENT, cpf VARCHAR(13) not NULL, idMedicamento INTEGER not NULL, "
                + " numUso INTEGER not NULL, PRIMARY KEY (id_uso));";
        String create_exames = "CREATE TABLE IF NOT EXISTS EXAME "
                + "(idExame INTEGER not NULL AUTO_INCREMENT, cpf VARCHAR(13) not NULL, titulo VARCHAR(45), crm VARCHAR(7) not NULL, anotacoes TEXT, "
                + "resultado TEXT, assinatura TEXT, data TEXT, PRIMARY KEY (idExame));";
        String create_anotacoes = "CREATE TABLE IF NOT EXISTS ANOTACAO "
                + "(cpf VARCHAR(13) not NULL, id INTEGER not NULL AUTO_INCREMENT, anotacao TEXT, PRIMARY KEY(id));";
        String create_consulta = "CREATE TABLE IF NOT EXISTS CONSULTA "
                + "(idConsulta INTEGER not NULL AUTO_INCREMENT, crm VARCHAR(7) not NULL, cpf VARCHAR(13) not NULL, data TEXT not NULL, PRIMARY KEY(idConsulta));";
        String create_horario = "CREATE TABLE IF NOT EXISTS HORARIO "
                + "(data TEXT not NULL, crm VARCHAR(7) not NULL, cpf VARCHAR(13) not NULL, " + "id_horario INTEGER not NULL AUTO_INCREMENT, PRIMARY KEY(id_horario));";
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

    // TODO
    boolean checarLogin() {
        return false;
    }
}