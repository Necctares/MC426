package com.grupomc426.API;

public class controladorGeral {
    private controladorHorarios controladorHorarios;
    private controladorProntuario controladorProntuario;
    private controladorConfirmacao controladorConfirmacao;
    private static controladorGeral instance = null;

    public controladorGeral() {
        controladorHorarios = new controladorHorarios();
        controladorProntuario = new controladorProntuario();
        controladorConfirmacao = new controladorConfirmacao();

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
    
    public controladorConfirmacao getControladorConfirmacao(){
        return controladorConfirmacao;
    }
}
