package com.grupomc426.API;

import java.util.List;

import com.grupomc426.DataBase.HelperDB;
import com.grupomc426.Targets.Atendimento.Exame;
import com.grupomc426.Targets.Atendimento.Prontuario;
import com.grupomc426.Targets.Produtos.Medicamento;
import com.grupomc426.Targets.Usuarios.Medico;
import com.grupomc426.Targets.Usuarios.Pessoa;

public class controladorProntuario {
    private HelperDB db;

    public controladorProntuario() {
        db = HelperDB.getDB();
    }

    public boolean registrarConsulta(Medico medico, Pessoa pessoa) {
        // TODO:
        return false;
    }

    public boolean adicionarMedicamentos(String prontuarioID, List<Medicamento> medicamentos) {
        // TODO:
        return false;
    }

    public boolean adicionarExames(String prontuarioID, List<Exame> exames) {
        // TODO:
        return false;
    }

    public boolean assinarExame(String exameID, Medico medico) {
        // TODO:
        return false;
    }

    public Prontuario obterProntuario(String prontuarioID) {
        // TODO:
        return null;
    }
}
