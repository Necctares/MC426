package com.grupomc426.API;

public class controladorGeral {
    private controladorHorarios controladorHorarios;
    private controladorProntuario controladorProntuario;
    private static controladorGeral instance = null;

    public controladorGeral() {
        controladorHorarios = new controladorHorarios();
        controladorProntuario = new controladorProntuario();

        if(instance == null){
            instance = this;
        }
    }

    public controladorGeral getInstance() {
        return instance;
    }

    public controladorHorarios getControladorHorarios() {
        return controladorHorarios;
    }

    public controladorProntuario getControladorProntuario() {
        return controladorProntuario;
    }
}
