package HospitalProject.Targets;

public class Pessoa {
    private String nome;
    private String telefone;
    private String cpf;
    

    public Pessoa(String nome, String telefone, String cpf){
        this.cpf = cpf;
        this.telefone = telefone;
        this.nome = nome;
    }

    public String getCPF() {
        return cpf;
    }
    public String getNome() {
        return nome;
    }
    public String getTelefone() {
        return telefone;
    }
}