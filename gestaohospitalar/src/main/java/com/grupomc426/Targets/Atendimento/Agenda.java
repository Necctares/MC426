package com.grupomc426.Targets.Atendimento;

import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import com.grupomc426.Targets.Usuarios.Usuario;

public class Agenda {
    private Usuario usuario;
    private Map<LocalDateTime, String> horarios;

    public Agenda(Usuario usuario, Map<LocalDateTime, String> horarios) {
        this.usuario = usuario;
        this.horarios = horarios;
    }

    public void adicionarHorario(LocalDateTime horario, String cpf) {
        horarios.put(horario, cpf);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Map<LocalDateTime, String> getHorarios() {
        return horarios;
    }

    public List<LocalDateTime> getHorariosLivres() {
        List<LocalDateTime> horariosLivres = new ArrayList<>();
        for (Map.Entry<LocalDateTime, String> entry : horarios.entrySet()) {
            if (entry.getValue() == null) {
                horariosLivres.add(entry.getKey());
            }
        }
        return horariosLivres;
    }

    public List<LocalDateTime> getHorariosReservados() {
        List<LocalDateTime> horariosReservados = new ArrayList<>();
        for (Map.Entry<LocalDateTime, String> entry : horarios.entrySet()) {
            if (entry.getValue() != null) {
                horariosReservados.add(entry.getKey());
            }
        }
        return horariosReservados;
    }
}