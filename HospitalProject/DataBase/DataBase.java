package HospitalProject.DataBase;

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
        System.out.println("Conexao encerrada com sucesso.");
    }

    public void adicionarPessoa(String cadastro){

    }

    public void removerPessoa(String cpf){

    }
}