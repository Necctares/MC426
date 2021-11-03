package com.grupomc426.DataBase;

import java.util.List;
import com.grupomc426.Targets.Usuarios.*;
import com.grupomc426.Targets.Atendimento.*;
import com.grupomc426.Targets.Produtos.*;

//TODO Implementar HelperDB
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
        Map<string="", string=""> mapaConsulta = new HashMap<string="", string="">();
        mapaConsulta.put("id", consulta.getId().ToString());
        mapaConsulta.put("medico", consulta.getMedico().getCrm());
        mapaConsulta.put("usuario", consulta.getUsuario().getCPF());
        mapaConsulta.put("horario", consulta.getHorario().ToString());
        return db.adicionarConsulta(mapaConsulta);        
    }
    
    public boolean adicionarMedicamento(Medicamento medicamento) {
        Map<string="", string=""> mapaMedicamento = new HashMap<string="", string="">();
        mapaMedicamento.put("nome", medicamento.getNome());
        mapaMedicamento.put("id", medicamento.getId());
        mapaMedicamento.put("composto", medicamento.getComposto());
        return db.adicionarMedicamento(mapaMedicamento);     
    }

    public boolean adicionarExame(Exame exame) {
        Map<string="", string=""> mapaExame = new HashMap<string="", string="">();
        mapaExame.put("titulo", exame.getTitulo());
        mapaExame.put("id", exame.getId());
        mapaExame.put("medico", exame.getMedico().getCrm());
        mapaExame.put("paciente", exame.getPaciente().GetCPF());
        mapaExame.put("anotacoes", exame.getAnotacoes());
        mapaExame.put("resultado", exame.getResultado());
        mapaExame.put("foiAssinado", exame.getFoiAssinado().ToString());
        mapaExame.put("assinatura", exame.getAssinatura());
        mapaExame.put("horario", exame.getHorario().ToString());
        return db.adicionarExame(mapaExame);
    }
    
    public boolean assinarExame(String exameID, String assinatura) {
        return db.assinarExame(exameID, assinatura);
    }

    // TODO: tratar corretamente.
    public Prontuario obterProntuario(int prontuarioID){
        Prontuario prontuario = db.obterProntuarioID(prontuarioID);
        return prontuario;
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
        return false;
    }

    public boolean reservarHorario(Pessoa pessoa, Horario horario) {
        return false;
    }

    public Agenda obterAgenda(Medico medico) {
        return false;
    }
}