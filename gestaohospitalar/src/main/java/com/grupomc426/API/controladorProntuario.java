package com.grupomc426.API;

import java.util.List;
import java.time.LocalDateTime;

import com.grupomc426.DataBase.HelperDB;
import com.grupomc426.Targets.Atendimento.*;
import com.grupomc426.Targets.Produtos.*;
import com.grupomc426.Targets.Usuarios.*;

public class controladorProntuario {
    private HelperDB db;

    public controladorProntuario() {
        db = HelperDB.getDB();
    }

    public boolean registrarConsulta(Medico medico, Usuario pessoa, LocalDateTime horario) {
        Consulta consulta = new Consulta(-1, medico, pessoa, null, horario);
        return db.registrarConsulta(consulta);
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

    public boolean assinarProntuario(String prontuarioID, Medico medico) {
        return db.assinarProntuario(prontuarioID, medico.getCrm());
    }

    public Prontuario obterProntuario(int prontuarioID) {
        return db.obterProntuario(prontuarioID);
    } 
}