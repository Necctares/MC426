package com.grupomc426.DataBase.Helpers;

import java.util.HashMap;
import java.util.Map;

import com.grupomc426.DataBase.ACAO;
import com.grupomc426.DataBase.ProntuarioDB;
import com.grupomc426.Targets.Atendimento.Exame;
import com.grupomc426.Targets.Atendimento.Prontuario;
import com.grupomc426.Targets.Produtos.Medicamento;
import com.grupomc426.Targets.Usuarios.Usuario;

public class HelperProntuario implements HelperDB {
    private ProntuarioDB db;
    private static HelperProntuario instance = null;

    //Constantes
    private final int MAX_CARACTER_CPF = 11;
    private final int MAX_CARACTER_NOME = 100;

    private HelperProntuario() {
        db = new ProntuarioDB();
    }

    public static HelperProntuario getDB() {
        if (instance == null) {
            instance = new HelperProntuario();
        }
        return instance;
    }

    public boolean isDigit(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch < 48 || ch > 57)
                return false;
        }
        return true;
    }

    public boolean operacaoCadastro(ACAO operacao, Usuario usuario) {
        if (operacao == ACAO.ADICIONAR) {
            if (ehUsuarioValido(usuario)) {
                String cadastro = "('" + usuario.getNome() + "', '" + usuario.getTelefone() + "', '" 
                        + usuario.getCPF() + "', " + usuario.getIdade() + ")";
                db.adicionarPessoa(cadastro);
                cadastro = "('" + usuario.getID() + "', '" + usuario.getSenha() + "', '"
                        + usuario.getEhFuncionario() + ")";
                db.adicionarUsuario(cadastro);
                return true;
            }
        } else if (operacao == ACAO.REMOVER) {
            if (isDigit(usuario.getCPF()) && isDigit(usuario.getTelefone())) {
                db.removerPessoa(usuario.getCPF());
                db.removerUsuario(usuario.getID());
                return true;
            }
        }
        return false;
        /*
         * quando colocar detecçao de erro no GUI para telefone e cpf serem apenas
         * numeros tirar os daqui
         */
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
        mapaExame.put("horario", exame.getHorario().toString());
        return db.adicionarExame(mapaExame);
    }

    public boolean assinarExame(String exameId, String assinatura) {
        return db.assinarExame(exameId, assinatura);
    }

    public Prontuario obterProntuario(int prontuarioId) {
        String prontuario = db.obterProntuario(prontuarioId);
        Prontuario novoProntuario = null;
        // TODO
        return novoProntuario;
    }

    @Override
    public boolean checkLogin(Usuario usuario) {
        if (!usuario.getID().isEmpty() && !usuario.getSenha().isEmpty()) {
            String senha = db.obterSenha(usuario.getID());
            if (usuario.getSenha() == senha)
                return true;
        }
        return false;
    }

    private boolean ehUsuarioValido(Usuario usuario) {
        if (ehCPFValido(usuario.getCPF()) && ehNomeValido(usuario.getNome())){
            return true;
        }
        return false;
    }

    private boolean ehCPFValido(String CPF) {
        if(isDigit(CPF) && CPF.length() <= MAX_CARACTER_CPF) {
            return true;
        }
        return false;
    }

    private boolean ehNomeValido(String nome) {
        if(isDigit(nome) && nome.length() <= MAX_CARACTER_NOME) {
            return true;
        }
        return false;
    }
}