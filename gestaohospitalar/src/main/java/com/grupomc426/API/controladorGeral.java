package com.grupomc426.API;

import java.util.List;
import com.grupomc426.Targets.Atendimento.Exame;
import com.grupomc426.Targets.Atendimento.Prontuario;
import com.grupomc426.Targets.Produtos.Medicamento;
import com.grupomc426.Targets.Usuarios.Medico;
import com.grupomc426.Targets.Usuarios.Pessoa;
import com.grupomc426.Targets.Atendimento.Agenda;
import com.grupomc426.Targets.Atendimento.Horario;

public class controladorGeral {
    private controladorHorarios controladorHorarios;
    private controladorProntuario controladorProntuario;
    private controladorConfirmacao controladorConfirmacao;

    public controladorGeral() {

        controladorHorarios = new controladorHorarios();
        controladorProntuario = new controladorProntuario();
        controladorConfirmacao = new controladorConfirmacao();
    }


    ///sub controlador prontuario
    public boolean registrarConsulta(Medico medico, Pessoa pessoa) {
        return this.controladorProntuario.registrarConsulta(medico, pessoa);
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

    public Prontuario obterProntuario(String prontuarioID) {
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

    public boolean confirmarHorario(Medico medico, Pessoa pessoa, Agenda agenda, Horario horario){
        return this.controladorConfirmacao.confirmarHorario(medico, pessoa, agenda, horario);
    }




}
