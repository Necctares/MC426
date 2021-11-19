package com.grupomc426.API;

import java.util.List;

import com.grupomc426.DataBase.ACAO;
import com.grupomc426.DataBase.Helpers.HelperProntuario;
import com.grupomc426.Targets.Atendimento.*;
import com.grupomc426.Targets.Produtos.*;
import com.grupomc426.Targets.Usuarios.*;

public class controladorProntuario {
    private HelperProntuario db;

    public controladorProntuario() {
        db = HelperProntuario.getDB();
    }

    public boolean adicionarMedicamentos(int prontuarioID, List<Medicamento> medicamentos) {
        for(Medicamento medicamento : medicamentos){
            if(!db.adicionarMedicamento(medicamento)){
                return false;
            }
        }
        return true;
    }

    public boolean adicionarExames(int prontuarioID, List<Exame> exames) {
        for(Exame exame : exames){
            if(!db.adicionarExame(exame)){
                return false;
            }
        }
        return true;
    }

    public boolean assinarExame(String exameID, Medico medico) {
        return db.assinarExame(exameID, medico.getCrm());
    }

    public Prontuario obterProntuario(int prontuarioID) {
        return db.obterProntuario(prontuarioID);
    }
    
    public boolean operacaoCadastro(ACAO operacao, Usuario usuario){
        return db.operacaoCadastro(operacao, usuario);
    }
}