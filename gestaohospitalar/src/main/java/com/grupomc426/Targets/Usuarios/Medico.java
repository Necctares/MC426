package com.grupomc426.Targets.Usuarios;

public class Medico extends Usuario {
    private String crm;
    private String assinatura;    

    public Medico(String nome, String telefone, String cpf_id, String idade, String senha, boolean ehFuncionario,
            String crm, String assinatura) {
        super(nome, telefone, cpf_id, idade, senha, ehFuncionario);
        this.crm = crm;
        this.assinatura = assinatura;
    }

    public String getCrm() {
        return crm;
    }

    public String getAssinatura(){
        return assinatura;
    }
}
