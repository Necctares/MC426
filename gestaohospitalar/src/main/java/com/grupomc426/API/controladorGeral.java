package com.grupomc426.API;

import java.util.List;
import java.time.LocalDateTime;
import com.grupomc426.Targets.Produtos.*;
import com.grupomc426.Targets.Usuarios.*;
import com.grupomc426.Targets.Atendimento.*;

public class controladorGeral {
    private controladorHorarios controladorHorarios;
    private controladorProntuario controladorProntuario;
    private controladorConsulta controladorConfirmacao;

    public controladorGeral() {

        controladorHorarios = new controladorHorarios();
        controladorProntuario = new controladorProntuario();
        controladorConfirmacao = new controladorConsulta();
    }



    ///subcontrolador prontuario

    public boolean registrarConsulta(Medico medico, Usuario usuario, java.time.LocalDateTime horario) {
        return this.controladorProntuario.registrarConsulta(medico, usuario, horario);
    }

    public boolean adicionarMedicamentos(int prontuarioID, List<Medicamento> medicamentos) {
        return this.controladorProntuario.adicionarMedicamentos(prontuarioID, medicamentos);
    }

    public boolean adicionarExames(int prontuarioID, List<Exame> exames) {
        return this.controladorProntuario.adicionarExames(prontuarioID, exames);
    }

    public boolean assinarProntuario(String prontuarioID, Medico medico) {
        return this.controladorProntuario.assinarProntuario(prontuarioID, medico);
    }

    public Prontuario obterProntuario(int prontuarioID) {
        return this.controladorProntuario.obterProntuario(prontuarioID);
    }



    //subcontrolador Horarios

    public boolean registrarHorario(Medico medico, LocalDateTime horario) {
        return this.controladorHorarios.registrarHorario(medico, horario);
    }

    public boolean reservarHorario(Medico medico, LocalDateTime horario, Pessoa pessoa) {
        return this.controladorHorarios.reservarHorario(medico, horario, pessoa);
    }

    public Agenda obterAgenda(Medico medico) {

        return this.controladorHorarios.obterAgenda(medico);
    }



    //subcontrolador Confirmacao
    
    public boolean confirmarHorario(Consulta consulta, Agenda agenda) {
        return this.controladorConfirmacao.confirmarHorario(consulta, agenda);
    }
}