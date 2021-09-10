package HospitalProject.Targets;

public class Usuario extends Pessoa{

    private String id;
    private String senha;

    Usuario(String nome, String telefone, String cpf, String id, String senha) {
        super(nome, telefone, cpf);
        this.id = id;
        this.senha = senha;
    }
}