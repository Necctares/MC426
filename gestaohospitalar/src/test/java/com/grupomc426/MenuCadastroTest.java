package com.grupomc426;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.grupomc426.GUI.MenuCadastro;

class MenuCadastroTest {

    @Test
    void usuarioCadastroValido() {
        String nomeTeste = "Jose da Silva";
        String esperado = "Ok";

        String telefoneValido = "11987654321";
        String cpfValido = "11111111111";
        String anoValido = "1999";
        String senhaValida = "senha123";

        MenuCadastro menu = new MenuCadastro();
        menu.getUsuarioCadastro().setText(nomeTeste);
        menu.getTelefoneCadastro().setText(telefoneValido);
        menu.getCpfCadastro().setText(cpfValido);
        menu.getNascimentoCadastro().setText(anoValido);
        menu.getSenhaCadastro().setText(senhaValida);
        assertEquals(esperado, menu.botaoConfirmarActionPerformed(null));
    }

    @Test
    void usuarioCadastroComNumeros() {
        String nomeTeste = "a1b2c3d4";
        String esperado = "Nome inválido! Use apenas letras e espaço.";

        String telefoneValido = "11987654321";
        String cpfValido = "11111111111";
        String anoValido = "1999";
        String senhaValida = "senha123";

        MenuCadastro menu = new MenuCadastro();
        menu.getUsuarioCadastro().setText(nomeTeste);
        menu.getTelefoneCadastro().setText(telefoneValido);
        menu.getCpfCadastro().setText(cpfValido);
        menu.getNascimentoCadastro().setText(anoValido);
        menu.getSenhaCadastro().setText(senhaValida);
        assertEquals(esperado, menu.botaoConfirmarActionPerformed(null));
    }

    @Test
    void usuarioCadastroMaisDe100Caracteres() {
        String nomeTeste = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String esperado = "Nome inválido! Use apenas letras e espaço.";

        String telefoneValido = "11987654321";
        String cpfValido = "11111111111";
        String anoValido = "1999";
        String senhaValida = "senha123";

        MenuCadastro menu = new MenuCadastro();
        menu.getUsuarioCadastro().setText(nomeTeste);
        menu.getTelefoneCadastro().setText(telefoneValido);
        menu.getCpfCadastro().setText(cpfValido);
        menu.getNascimentoCadastro().setText(anoValido);
        menu.getSenhaCadastro().setText(senhaValida);
        assertEquals(esperado, menu.botaoConfirmarActionPerformed(null));
    }



    @Test
    void telefoneCadastroValido() {
        String telefoneTeste = "11987654321";
        String esperado = "Ok";

        String nomeValido = "Jose da Silva";
        String cpfValido = "11111111111";
        String anoValido = "1999";
        String senhaValida = "senha123";

        MenuCadastro menu = new MenuCadastro();
        menu.getUsuarioCadastro().setText(nomeValido);
        menu.getTelefoneCadastro().setText(telefoneTeste);
        menu.getCpfCadastro().setText(cpfValido);
        menu.getNascimentoCadastro().setText(anoValido);
        menu.getSenhaCadastro().setText(senhaValida);
        assertEquals(esperado, menu.botaoConfirmarActionPerformed(null));
    }

    @Test
    void telefoneCadastroComSimbolos() {
        String telefoneTeste = "(11) 98765-4321";
        String esperado = "Telefone inválido! Inclua seu DDD e número de telefone, e digite apenas números.";

        String nomeValido = "Jose da Silva";
        String cpfValido = "11111111111";
        String anoValido = "1999";
        String senhaValida = "senha123";

        MenuCadastro menu = new MenuCadastro();
        menu.getUsuarioCadastro().setText(nomeValido);
        menu.getTelefoneCadastro().setText(telefoneTeste);
        menu.getCpfCadastro().setText(cpfValido);
        menu.getNascimentoCadastro().setText(anoValido);
        menu.getSenhaCadastro().setText(senhaValida);
        assertEquals(esperado, menu.botaoConfirmarActionPerformed(null));        
    }

    @Test
    void telefoneCadastroMenosDe11Digitos() {
        String telefoneTeste = "11987654";
        String esperado = "Telefone inválido! Inclua seu DDD e número de telefone, e digite apenas números.";

        String nomeValido = "Jose da Silva";
        String cpfValido = "11111111111";
        String anoValido = "1999";
        String senhaValida = "senha123";

        MenuCadastro menu = new MenuCadastro();
        menu.getUsuarioCadastro().setText(nomeValido);
        menu.getTelefoneCadastro().setText(telefoneTeste);
        menu.getCpfCadastro().setText(cpfValido);
        menu.getNascimentoCadastro().setText(anoValido);
        menu.getSenhaCadastro().setText(senhaValida);
        assertEquals(esperado, menu.botaoConfirmarActionPerformed(null));
    }

    @Test
    void telefoneCadastroMaisDe11Digitos() {
        String telefoneTeste = "119876543210";
        String esperado = "Telefone inválido! Inclua seu DDD e número de telefone, e digite apenas números.";

        String nomeValido = "Jose da Silva";
        String cpfValido = "11111111111";
        String anoValido = "1999";
        String senhaValida = "senha123";

        MenuCadastro menu = new MenuCadastro();
        menu.getUsuarioCadastro().setText(nomeValido);
        menu.getTelefoneCadastro().setText(telefoneTeste);
        menu.getCpfCadastro().setText(cpfValido);
        menu.getNascimentoCadastro().setText(anoValido);
        menu.getSenhaCadastro().setText(senhaValida);
        assertEquals(esperado, menu.botaoConfirmarActionPerformed(null));
    }



    @Test
    void cpfCadastroValido() {
        String cpfTeste = "23640102843";
        String esperado = "Ok";

        String nomeValido = "Jose da Silva";
        String telefoneValido = "11987654321";
        String anoValido = "1999";
        String senhaValida = "senha123";

        MenuCadastro menu = new MenuCadastro();
        menu.getUsuarioCadastro().setText(nomeValido);
        menu.getTelefoneCadastro().setText(telefoneValido);
        menu.getCpfCadastro().setText(cpfTeste);
        menu.getNascimentoCadastro().setText(anoValido);
        menu.getSenhaCadastro().setText(senhaValida);
        assertEquals(esperado, menu.botaoConfirmarActionPerformed(null));
    }

    @Test
    void cpfCadastroComSimbolos() {
        String cpfTeste = "236.401.028-43";
        String esperado = "CPF inválido! Digite apenas os 11 números do seu CPF.";

        String nomeValido = "Jose da Silva";
        String telefoneValido = "11987654321";
        String anoValido = "1999";
        String senhaValida = "senha123";

        MenuCadastro menu = new MenuCadastro();
        menu.getUsuarioCadastro().setText(nomeValido);
        menu.getTelefoneCadastro().setText(telefoneValido);
        menu.getCpfCadastro().setText(cpfTeste);
        menu.getNascimentoCadastro().setText(anoValido);
        menu.getSenhaCadastro().setText(senhaValida);
        assertEquals(esperado, menu.botaoConfirmarActionPerformed(null));        
    }

    @Test
    void cpfCadastroMenosDe11Digitos() {
        String cpfTeste = "236401028";
        String esperado = "CPF inválido! Digite apenas os 11 números do seu CPF.";

        String nomeValido = "Jose da Silva";
        String telefoneValido = "11987654321";
        String anoValido = "1999";
        String senhaValida = "senha123";

        MenuCadastro menu = new MenuCadastro();
        menu.getUsuarioCadastro().setText(nomeValido);
        menu.getTelefoneCadastro().setText(telefoneValido);
        menu.getCpfCadastro().setText(cpfTeste);
        menu.getNascimentoCadastro().setText(anoValido);
        menu.getSenhaCadastro().setText(senhaValida);
        assertEquals(esperado, menu.botaoConfirmarActionPerformed(null));         
    }
    
    @Test
    void cpfCadastroMaisDe11Digitos() {
        String cpfTeste = "236401028430"; 
        String esperado = "CPF inválido! Digite apenas os 11 números do seu CPF.";

        String nomeValido = "Jose da Silva";
        String telefoneValido = "11987654321";
        String anoValido = "1999";
        String senhaValida = "senha123";

        MenuCadastro menu = new MenuCadastro();
        menu.getUsuarioCadastro().setText(nomeValido);
        menu.getTelefoneCadastro().setText(telefoneValido);
        menu.getCpfCadastro().setText(cpfTeste);
        menu.getNascimentoCadastro().setText(anoValido);
        menu.getSenhaCadastro().setText(senhaValida);
        assertEquals(esperado, menu.botaoConfirmarActionPerformed(null));         
    }



    @Test
    void anoDeNascimentoCadastroValido() {
        String anoTeste = "1984"; 
        String esperado = "Ok";

        String nomeValido = "Jose da Silva";
        String telefoneValido = "11987654321";
        String cpfValido = "11111111111";
        String senhaValida = "senha123";

        MenuCadastro menu = new MenuCadastro();
        menu.getUsuarioCadastro().setText(nomeValido);
        menu.getTelefoneCadastro().setText(telefoneValido);
        menu.getCpfCadastro().setText(cpfValido);
        menu.getNascimentoCadastro().setText(anoTeste);
        menu.getSenhaCadastro().setText(senhaValida);
        assertEquals(esperado, menu.botaoConfirmarActionPerformed(null));
    }

    @Test
    void anoDeNascimentoCadastroNaoInteiro() {
        String anoTeste = "-500";
        String esperado = "Ano inválido! Digite apenas seu ano de nascimento.";

        String nomeValido = "Jose da Silva";
        String telefoneValido = "11987654321";
        String cpfValido = "11111111111";
        String senhaValida = "senha123";

        MenuCadastro menu = new MenuCadastro();
        menu.getUsuarioCadastro().setText(nomeValido);
        menu.getTelefoneCadastro().setText(telefoneValido);
        menu.getCpfCadastro().setText(cpfValido);
        menu.getNascimentoCadastro().setText(anoTeste);
        menu.getSenhaCadastro().setText(senhaValida);
        assertEquals(esperado, menu.botaoConfirmarActionPerformed(null));
    }

    @Test
    void anoDeNascimentoCadastroLetras() {
        String anoTeste = "1500ac";
        String esperado = "Ano inválido! Digite apenas seu ano de nascimento.";

        String nomeValido = "Jose da Silva";
        String telefoneValido = "11987654321";
        String cpfValido = "11111111111";
        String senhaValida = "senha123";

        MenuCadastro menu = new MenuCadastro();
        menu.getUsuarioCadastro().setText(nomeValido);
        menu.getTelefoneCadastro().setText(telefoneValido);
        menu.getCpfCadastro().setText(cpfValido);
        menu.getNascimentoCadastro().setText(anoTeste);
        menu.getSenhaCadastro().setText(senhaValida);
        assertEquals(esperado, menu.botaoConfirmarActionPerformed(null));
    }

    @Test
    void senhaCadastroValido() {
        String senhaTeste = "abcd1234";
        String esperado = "Ok";

        String nomeValido = "Jose da Silva";
        String telefoneValido = "11987654321";
        String cpfValido = "11111111111";
        String anoValido = "1999";

        MenuCadastro menu = new MenuCadastro();
        menu.getUsuarioCadastro().setText(nomeValido);
        menu.getTelefoneCadastro().setText(telefoneValido);
        menu.getCpfCadastro().setText(cpfValido);
        menu.getNascimentoCadastro().setText(anoValido);
        menu.getSenhaCadastro().setText(senhaTeste);
        assertEquals(esperado, menu.botaoConfirmarActionPerformed(null));
    }

    @Test
    void senhaCadastroComEspacos() {
        String senhaTeste = "1 2 3 a b c";
        String esperado = "Senha inválida! Escolha uma senha com pelo menos 8 caracteres e até no máximo 30, podendo usar letras ou números.";

        String nomeValido = "Jose da Silva";
        String telefoneValido = "11987654321";
        String cpfValido = "11111111111";
        String anoValido = "1999";

        MenuCadastro menu = new MenuCadastro();
        menu.getUsuarioCadastro().setText(nomeValido);
        menu.getTelefoneCadastro().setText(telefoneValido);
        menu.getCpfCadastro().setText(cpfValido);
        menu.getNascimentoCadastro().setText(anoValido);
        menu.getSenhaCadastro().setText(senhaTeste);
        assertEquals(esperado, menu.botaoConfirmarActionPerformed(null));
    }

    @Test
    void senhaCadastroCaracteresEspeciais() {
        String senhaTeste = "abc123 @+Ձ֍ᾘꝏ";
        String esperado = "Senha inválida! Escolha uma senha com pelo menos 8 caracteres e até no máximo 30, podendo usar letras ou números.";

        String nomeValido = "Jose da Silva";
        String telefoneValido = "11987654321";
        String cpfValido = "11111111111";
        String anoValido = "1999";

        MenuCadastro menu = new MenuCadastro();
        menu.getUsuarioCadastro().setText(nomeValido);
        menu.getTelefoneCadastro().setText(telefoneValido);
        menu.getCpfCadastro().setText(cpfValido);
        menu.getNascimentoCadastro().setText(anoValido);
        menu.getSenhaCadastro().setText(senhaTeste);
        assertEquals(esperado, menu.botaoConfirmarActionPerformed(null));
    }
    
    @Test
    void senhaCadastroMenorQue8Digitos() {
        String senhaTeste = "abc1";
        String esperado = "Senha inválida! Escolha uma senha com pelo menos 8 caracteres e até no máximo 30, podendo usar letras ou números.";

        String nomeValido = "Jose da Silva";
        String telefoneValido = "11987654321";
        String cpfValido = "11111111111";
        String anoValido = "1999";

        MenuCadastro menu = new MenuCadastro();
        menu.getUsuarioCadastro().setText(nomeValido);
        menu.getTelefoneCadastro().setText(telefoneValido);
        menu.getCpfCadastro().setText(cpfValido);
        menu.getNascimentoCadastro().setText(anoValido);
        menu.getSenhaCadastro().setText(senhaTeste);
        assertEquals(esperado, menu.botaoConfirmarActionPerformed(null));
    }

    @Test
    void senhaCadastroMaiorQue30Digitos() {
        String senhaTeste = "abcd123456789012345678901234567";
        String esperado = "Senha inválida! Escolha uma senha com pelo menos 8 caracteres e até no máximo 30, podendo usar letras ou números.";

        String nomeValido = "Jose da Silva";
        String telefoneValido = "11987654321";
        String cpfValido = "11111111111";
        String anoValido = "1999";

        MenuCadastro menu = new MenuCadastro();
        menu.getUsuarioCadastro().setText(nomeValido);
        menu.getTelefoneCadastro().setText(telefoneValido);
        menu.getCpfCadastro().setText(cpfValido);
        menu.getNascimentoCadastro().setText(anoValido);
        menu.getSenhaCadastro().setText(senhaTeste);
        assertEquals(esperado, menu.botaoConfirmarActionPerformed(null));
    }
}