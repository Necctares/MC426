package HospitalProject.DataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import HospitalProject.Targets.*;

//TODO Implementar HelperDB
public class HelperDB{
    private DataBase db;
    private static HelperDB instance;

    public HelperDB(){
        if(instance == null){
            instance = new HelperDB();
        }
    }

    public static HelperDB getDB(){
        if(instance == null){
            instance = new HelperDB();
        }
        return instance;
    }

    /**
     * Criei inicialmente para testar o DB
     */
    public void startDB(){
        db.startDB();
        db.makeAcess();
        db.closeAcess();
    }

    public void operacaoCadastro(ACAO operacao, Pessoa pessoa){
        if(operacao == ACAO.ADICIONAR){
            if(isDigit(pessoa.getCPF()) && isDigit(pessoa.getTelefone()))  {
                String cadastro = "(" + pessoa.getNome() + "," + pessoa.getTelefone() + "," + pessoa.getCPF() + ")";
                db.adicionarPessoa(cadastro);
            }    
        }
        else if(operacao == ACAO.REMOVER){
            if(isDigit(pessoa.getCPF()) && isDigit(pessoa.getTelefone()))  {
                db.removerPessoa(pessoa.getCPF());
            }    
        }
        /*quando colocar detecçao de erro no GUI para telefone e cpf serem apenas numeros tirar os daqui*/
    }

    public Pessoa buscarPessoa(){
        return new Pessoa(null, null, null);
    }

    public boolean checkLogin(String id, String senha){
        
        return false;
    }

    public boolean isDigit(String s) {
    for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);
        if (ch < 48 || ch > 57)
            return false;
    }
        return true;
    }
}