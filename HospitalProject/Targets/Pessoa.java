package HospitalProject.Targets;

public class Pessoa {
    private String nome;
    private String telefone;
    private String cpf;
    private String idade;

    Pessoa(String nome, String telefone, String cpf){
        this.cpf = cpf;
        this.telefone = telefone;
        this.nome = nome;
    }
}