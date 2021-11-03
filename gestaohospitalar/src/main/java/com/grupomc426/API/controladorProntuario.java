package com.grupomc426.API;

import java.util.List;

import com.grupomc426.DataBase.HelperDB;
import com.grupomc426.Targets.Atendimento.*;
import com.grupomc426.Targets.Produtos.*;
import com.grupomc426.Targets.Usuarios.*;

public class controladorProntuario {
    private HelperDB db;

    public controladorProntuario() {
        db = HelperDB.getDB();
    }

    public boolean registrarConsulta(Medico medico, Usuario pessoa, Horario horario) {
        Consulta consulta = new Consulta(medico, pessoa, horario);
        return db.registrarConsulta(consulta);
    }

    public boolean adicionarMedicamentos(int prontuarioID, List<Medicamento> medicamentos) {
        for(Medicamento medicamento : medicamentos){
            if(db.adicionarMedicamento(prontuarioID, medicamento) == false){
                return false;
            }
        }
        return true;
    }

    public boolean adicionarExames(int prontuarioID, List<Exame> exames) {
        for(Exame exame : exames){
            if(db.adicionarExame(prontuarioID, exame) == false){
                return false;
            }
        }
        return true;
    }

    public boolean assinarProntuario(String prontuarioID, Medico medico) {
        return db.assinarProntuario(prontuarioID, medico);
    }

    public Prontuario obterProntuario(int prontuarioID) {
        return db.obterProntuario(prontuarioID);
    } 
}