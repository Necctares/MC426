package com.grupomc426.API;

import java.util.List;
import com.grupomc426.Targets.Produtos.*;
import com.grupomc426.Targets.Usuarios.*;
import com.grupomc426.Targets.Atendimento.*;

public class controladorGeral {
    private controladorHorarios controladorHorarios;
    private controladorProntuario controladorProntuario;
    private controladorConfirmacao controladorConfirmacao;

    public controladorGeral() {

        controladorHorarios = new controladorHorarios();
        controladorProntuario = new controladorProntuario();
        controladorConfirmacao = new controladorConfirmacao();
    }



    ///subcontrolador prontuario

    public boolean registrarConsulta(Medico medico, Usuario usuario, Horario horario) {
        return this.controladorProntuario.registrarConsulta(medico, usuario, horario);
    }

    public boolean adicionarMedicamentos(String prontuarioID, List<Medicamento> medicamentos) {
        return this.controladorProntuario.adicionarMedicamentos(prontuarioID, medicamentos);
    }

    public boolean adicionarExames(String prontuarioID, List<Exame> exames) {
        return this.controladorProntuario.adicionarExames(prontuarioID, exames);
    }

    public boolean assinarExame(String exameID, Medico medico) {
        return this.controladorProntuario.assinarExame(exameID, medico);
    }

    public Prontuario obterProntuario(int prontuarioID) {
        return this.controladorProntuario.obterProntuario(prontuarioID);
    }



    //subcontrolador Horarios

    public boolean registrarHorario(Medico medico, Horario horario) {
        return this.controladorHorarios.registrarHorario(medico, horario);
    }

    public boolean reservarHorario(Pessoa pessoa, Horario horario) {

        return this.controladorHorarios.reservarHorario(pessoa, horario);
    }

    public Agenda obterAgenda(Medico medico) {

        return this.controladorHorarios.obterAgenda(medico);
    }



    //subcontrolador Confirmacao
    
    public boolean confirmarHorario(Consulta consulta, Agenda agenda) {
        return this.controladorConfirmacao.confirmarHorario(consulta, agenda);
    }
}