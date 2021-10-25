package com.grupomc426.Targets.Atendimento;

import com.grupomc426.Targets.Usuarios.Medico;
import com.grupomc426.Targets.Usuarios.Usuario;

public class Exame {
    private String titulo;
    private String id;
    private Medico medico;
    private Usuario paciente;
    private String anotacoes;
    private String resultado;
    private boolean foiAssinado;
    private String assinatura;

    public Exame(String titulo, String id, Medico medico, Usuario paciente, String anotacoes, String resultado,
            boolean foiAssinado, String assinatura) {
        this.medico = medico;
        this.paciente = paciente;
        this.anotacoes = anotacoes;
        this.resultado = resultado;
        this.foiAssinado = foiAssinado;
        this.assinatura = assinatura;
        this.titulo = titulo;
        this.id = id;
    }
}
