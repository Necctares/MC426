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

    // Constantes
    private final int MAX_CARACTER_CPF = 11;
    private final int MAX_CARACTER_NOME = 100;
    private final int MAX_CARACTER_TELEFONE = 11;
    private final int MAX_CARACTER_ANONASCIMENTO = 4;
    private final int MAX_CARACTER_SENHA = 30;
    private final int MIN_CARACTER_SENHA = 8;

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

    public boolean operacaoCadastro(ACAO operacao, Usuario usuario) throws IllegalArgumentException {
        if (operacao == ACAO.ADICIONAR) {
            if (ehUsuarioValido(usuario)) {
                String cadastro = "('" + usuario.getNome() + "', '" + usuario.getTelefone() + "', '" + usuario.getCPF()
                        + "', " + usuario.getAnoNascimento() + ")";
                db.adicionarPessoa(cadastro);
                cadastro = "('" + usuario.getID() + "', '" + usuario.getSenha() + "', '" + usuario.getEhFuncionario()
                        + ")";
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
    public boolean tentarLogin(Usuario usuario) {
        if (!usuario.getID().isEmpty() && !usuario.getSenha().isEmpty()) {
            String senha = db.obterSenha(usuario.getID());
            if (usuario.getSenha() == senha)
                return true;
        }
        return false;
    }

    private boolean ehUsuarioValido(Usuario usuario) throws IllegalArgumentException {
        if (ehCPFValido(usuario.getCPF()) && ehNomeValido(usuario.getNome()) && ehTelefoneValido(usuario.getTelefone())
                && ehAnoDeNascimentoValido(usuario.getAnoNascimento()) && ehSenhaValida(usuario.getSenha())) {
            return true;
        }
        return false;
    }

    private boolean ehCPFValido(String CPF) throws IllegalArgumentException {
        if (isDigit(CPF) && CPF.length() == MAX_CARACTER_CPF) {
            return true;
        }
        throw new IllegalArgumentException("Parametros do CPF sao invalidos, por favor, digite corretamente.");
    }

    private boolean ehNomeValido(String nome) throws IllegalArgumentException {
        if (nome.matches("[a-zA-Z]+") && nome.length() > MAX_CARACTER_NOME) {
            return true;
        }
        throw new IllegalArgumentException("Parametros do nome sao invalidos, por favor, digite corretamente.");
    }

    private boolean ehTelefoneValido(String telefone) throws IllegalArgumentException {
        if (isDigit(telefone) && telefone.length() == MAX_CARACTER_TELEFONE) {
            return true;
        }
        throw new IllegalArgumentException("Parametros do telefone sao invalidos, por favor, digite corretamente.");
    }

    private boolean ehAnoDeNascimentoValido(String anoNascimento) throws IllegalArgumentException {
        if (isDigit(anoNascimento) && anoNascimento.length() == MAX_CARACTER_ANONASCIMENTO) {
            return true;
        }
        throw new IllegalArgumentException("Ano de nascimento invalido, por favor, digite corretamente.");
    }

    private boolean ehSenhaValida(String senha) throws IllegalArgumentException {
        if (senha.matches("^[a-zA-Z0-9]*$") && senha.length() <= MAX_CARACTER_SENHA
                && senha.length() >= MIN_CARACTER_SENHA) {
            return true;
        }
        throw new IllegalArgumentException("Parametros da senha sao invalidos, por favor, digite corretamente.");
    }
}