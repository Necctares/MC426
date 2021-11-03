package com.grupomc426.DataBase;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.grupomc426.Targets.Usuarios.*;
import com.grupomc426.Targets.Atendimento.*;
import com.grupomc426.Targets.Produtos.*;

public class HelperDB{
    private DataBase db;
    private static HelperDB instance = null;

    private HelperDB(){
       db = new DataBase();
    }

    public static HelperDB getDB(){
        if(instance == null){
            instance = new HelperDB();
        }
        return instance;
    }

    /**
     * Criei inicialmente para testar o DB
     */
    public void startDB(){
        db.startDB();
        db.makeAcess();
        db.closeAcess();
    }

    public void operacaoCadastro(ACAO operacao, Pessoa pessoa){
        if(operacao == ACAO.ADICIONAR){
            if(isDigit(pessoa.getCPF()) && isDigit(pessoa.getTelefone()))  {
                String cadastro = "('" + pessoa.getNome() + "', '" + pessoa.getTelefone() + "', '" + pessoa.getCPF() + "', " + pessoa.getIdade() + ")";
                db.adicionarPessoa(cadastro);
            }    
        }
        else if(operacao == ACAO.REMOVER){
            if(isDigit(pessoa.getCPF()) && isDigit(pessoa.getTelefone()))  {
                db.removerPessoa(pessoa.getCPF());
            }    
        }
        /*quando colocar detecçao de erro no GUI para telefone e cpf serem apenas numeros tirar os daqui*/
    }

    /* TODO*/
    public boolean checkLogin(String id, String senha){
        return false;
    }

    public boolean isDigit(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch < 48 || ch > 57)
                return false;
        }
        return true;
    }
    
    public boolean registrarConsulta(Consulta consulta) {
        Map<String, String> mapaConsulta = new HashMap<String, String>();
        mapaConsulta.put("id", Integer.toString(consulta.getID()));
        mapaConsulta.put("medico", consulta.getMedico().getCrm());
        mapaConsulta.put("usuario", consulta.getUsuario().getCPF());
        mapaConsulta.put("horario", consulta.getHorario().toString());
        return db.adicionarConsulta(mapaConsulta);        
    }
    
    public boolean adicionarMedicamento(Medicamento medicamento) {
        Map<String, String> mapaMedicamento = new HashMap<String, String>();
        mapaMedicamento.put("nome", medicamento.getNome());
        mapaMedicamento.put("id", medicamento.getID());
        mapaMedicamento.put("composto", medicamento.getComposto());
        return db.adicionarMedicamento(mapaMedicamento);
    }

    public boolean adicionarExame(Exame exame) {
        Map<String, String> mapaExame = new HashMap<String, String>();
        mapaExame.put("titulo", exame.getTitulo());
        mapaExame.put("id", exame.getid());
        mapaExame.put("medico", exame.getMedico().getCrm());
        mapaExame.put("paciente", exame.getPaciente().getCPF());
        mapaExame.put("anotacoes", exame.getAnotacoes());
        mapaExame.put("resultado", exame.getResultado());
        mapaExame.put("foiAssinado", Boolean.toString(exame.getFoiAssinado()));
        mapaExame.put("assinatura", exame.getAssinatura());
        mapaExame.put("horario", exame.getHorario().ToString());
        return db.adicionarExame(mapaExame);
    }
    
    public boolean assinarProntuario(String prontuarioID, String assinatura) {
        return db.assinarProntuario(prontuarioID, assinatura);
    }

    /* TODO*/
    public Prontuario obterProntuario(int prontuarioID){
        return null;
    }


    
    //TODO controladorConfirmaçao
    public boolean confirmarHorario(Consulta consulta, Agenda agenda){
        return false;
    }
    
    public boolean cancelarHorario(Consulta consulta, Agenda agenda){
        return false;
    }
    

    
    //TODO controladorHorarios
    public boolean registrarHorario(Medico medico, Horario horario) {
        Map<String, String> mapaMedico = new HashMap<String, String>();
        mapaMedico.put("crm", medico.getCrm());
        Map<String, String> mapaHorario = new HashMap<String, String>();
        mapaHorario.put("ano", Integer.toString(horario.getAno()));
        mapaHorario.put("mes", Integer.toString(horario.getMes()));
        mapaHorario.put("dia", Integer.toString(horario.getDia()));
        mapaHorario.put("hora", Integer.toString(horario.getHora()));
        mapaHorario.put("minuto", Integer.toString(horario.getMinuto()));
        return db.adicionarHorario(mapaMedico, mapaHorario);
    }

    public boolean reservarHorario(Medico medico, Horario horario) {
        Map<String, String> mapaMedico = new HashMap<String, String>();
        mapaMedico.put("crm", medico.getCrm());
        Map<String, String> mapaHorario = new HashMap<String, String>();
        mapaHorario.put("ano", Integer.toString(horario.getAno()));
        mapaHorario.put("mes", Integer.toString(horario.getMes()));
        mapaHorario.put("dia", Integer.toString(horario.getDia()));
        mapaHorario.put("hora", Integer.toString(horario.getHora()));
        mapaHorario.put("minuto", Integer.toString(horario.getMinuto()));
        return db.removerHorario(mapaMedico, mapaHorario);
    }

    public Agenda obterAgenda(Medico medico) {
        return null;
    }
}