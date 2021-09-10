package com.grupomc426.DataBase;

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

            startTables();

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
    }

    private void startTables() throws SQLException {

        String cmd = "CREATE TABLE IF NOT EXISTS PESSOA " + "(nome VARCHAR(100), " + " telefone VARCHAR(13), " +
        "(cpf INTEGER not NULL, " + " age INTEGER, " + " PRIMARY KEY ( cpf ))";
        statement.executeUpdate(cmd);
    }

    void makeAcess() {
        System.out.println("Conectando ao banco de dados...");
        try {
            connection = DriverManager.getConnection(DB_URL + "HOSPITAL", USER, PASS);
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

    void adicionarPessoa(String pessoaValues){
        makeAcess();
        String cmd = "INSERT INTO PESSOA VALUES " + pessoaValues;
        try {
            statement.executeUpdate(cmd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeAcess();
    }

    void removerPessoa(String pessoaValues){
        makeAcess();
        String cmd = "REMOVE FROM PESSOA " + "WHERE cpf = " + pessoaValues;
        try {
            statement.executeUpdate(cmd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeAcess();
    }
}