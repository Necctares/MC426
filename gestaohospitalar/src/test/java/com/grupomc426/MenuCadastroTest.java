package com.grupomc426;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Executable;

import com.grupomc426.GUI.MenuCadastro;

class MenuCadastroTest {

    @Test
    void usuarioCadastroValido() {
        String nomeTeste = "Jose da Silva";

        MenuCadastro menu = new MenuCadastro();
        JTextField usuarioCadastro = menu.getComponent(0);
        usuarioCadastro.setText(nomeTeste);
        assertDoesNotThrow(executable);
    }

    @Test
    void usuarioCadastroComNumeros() {
        String nomeTeste = "a1b2c3d4";
    }

    @Test
    void usuarioCadastroMaisDe100Caracteres() {
        String nomeTeste = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }



    @Test
    void telefoneCadastroValido() {
        String telefoneTeste = "11987654321";

    }

    @Test
    void telefoneCadastroComSimbolos() {
        String telefoneTeste = "(11) 98765-4321";
        
    }

    @Test
    void telefoneCadastroMenosDe11Digitos() {
        String telefoneTeste = "11987654";
    }

    @Test
    void telefoneCadastroMaisDe11Digitos() {
        String telefoneTeste = "119876543210";
    }



    @Test
    void cpfCadastroValido() {
        String cpfTeste = "23640102843";

    }

    @Test
    void cpfCadastroComSimbolos() {
        String cpfTeste = "236.401.028-43";
        
    }

    @Test
    void cpfCadastroMenosDe11Digitos() {
        String cpfTeste = "236401028";
        
    }
    
    @Test
    void cpfCadastroMaisDe11Digitos() {
        String cpfTeste = "236401028430";
        
    }

    @Test
    void cpfCadastroCPFImpossivel() {
        String cpfTeste = "11111111111";
        
    }



    @Test
    void anoDeNascimentoCadastroValido() {
        String anoTeste = "1984";
    }

    @Test
    void anoDeNascimentoCadastroNaoInteiro() {
        String anoTeste = "-500";
    }

    @Test
    void anoDeNascimentoCadastroLetras() {
        String anoTeste = "1500ac";
    }

    
    
    @Test
    void senhaCadastroValido() {
        String senha = "abcd1234";

        MenuCadastro menu = new MenuCadastro();
        JTextField senhaCadastro = menu.getComponent(0);
        senhaCadastro.setText(senha);
        assertDoesNotThrow();
    }

    @Test
    void senhaCadastroComEspacos() {
        String senha = "1 2 3 a b c";
    }

    @Test
    void senhaCadastroCaracteresEspeciais() {
        String senha = "abc123 @+Ձ֍ᾘꝏ";
    }
    
    @Test
    void senhaCadastroMenorQue8Digitos() {
        String senha = "abc1";
    }

    @Test
    void senhaCadastroMaiorQue30Digitos() {
        String senha = "abcd123456789012345678901234567";
    }
}