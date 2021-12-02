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
            if(!db.adicionarMedicamento(prontuarioID, medicamento)){
                return false;
            }
        }
        return true;
    }

    public List<Medicamento> pegarMedicamento(int prontuarioID){
        return db.pegarMedicamento(prontuarioID);
    }

    public boolean removerMedicamento(int objID){
        return db.removerMedicamento(objID);
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
    
    public boolean operacaoCadastro(ACAO operacao, Usuario usuario) throws IllegalArgumentException {
        return db.operacaoCadastro(operacao, usuario);
    }

    public boolean tentarLogin(Usuario usuario) {
        return db.tentarLogin(usuario);
    }
}