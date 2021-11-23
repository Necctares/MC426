package com.grupomc426;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.grupomc426.GUI.MenuLogin;

import org.junit.jupiter.api.Test;

public class MenuLoginTest {

    @Test
    void loginValido() {
        String esperado = "Ok";
        String usuarioValido = "11111111111";
        String senhaValida = "12345678";

        MenuLogin menuLogin = new MenuLogin();
        menuLogin.getUsuarioLogin().setText(usuarioValido);
        menuLogin.getSenhaLogin().setText(senhaValida);

        assertEquals(esperado, menuLogin.botaoConfirmarActionPerformed(null));
    }

    @Test
    void usuarioInexistente() {
        String esperado = "Usuário não cadastrado!";
        String usuarioInvalido = "22222222222";
        String senhaTeste = "senha123";
        
        MenuLogin menuLogin = new MenuLogin();
        menuLogin.getUsuarioLogin().setText(usuarioInvalido);
        menuLogin.getSenhaLogin().setText(senhaTeste);

        assertEquals(esperado, menuLogin.botaoConfirmarActionPerformed(null));
    }

    @Test
    void senhaErrada() {
        String esperado = "Senha incorreta!";
        String usuarioValido = "11111111111";
        String senhaErrada = "123abcdef";
        
        MenuLogin menuLogin = new MenuLogin();
        menuLogin.getUsuarioLogin().setText(usuarioValido);
        menuLogin.getSenhaLogin().setText(senhaErrada);

        assertEquals(esperado, menuLogin.botaoConfirmarActionPerformed(null));
    }    
}