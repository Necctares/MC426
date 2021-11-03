package com.grupomc426.Targets.Atendimento;

import java.util.List;
import java.time.LocalDateTime;
import com.grupomc426.Targets.Usuarios.Usuario;

public class Agenda {
    private Usuario usuario;
    private List<LocalDateTime> horarios;

    public Agenda(Usuario usuario) {
        this.usuario = usuario;
    }

    public void adicionarHorario (LocalDateTime horario) {
        horarios.add(horario);
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    public List<LocalDateTime> getHorarios() {
        return horarios;
    }
}