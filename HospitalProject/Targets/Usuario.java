package HospitalProject.Targets;

public class Usuario extends Pessoa{

    private String id;
    private String senha;
    private boolean ehFuncionario;

    Usuario(String nome, String telefone, String cpf, String idade, String senha, boolean ehFuncionario) {
        super(nome, telefone, cpf, idade);
        this.id = cpf;
        this.senha = senha;
        this.ehFuncionario = ehFuncionario;
    }
}