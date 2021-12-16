package com.grupomc426.Targets.Usuarios;

public class Medico extends Usuario {
    private String crm;
    private String assinatura;    

    public Medico(Usuario usuario, String crm, String assinatura) {
        super(usuario, usuario.getSenha(), usuario.getEhFuncionario());
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