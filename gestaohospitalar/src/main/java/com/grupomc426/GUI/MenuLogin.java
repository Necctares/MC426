/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupomc426.GUI;

import com.grupomc426.API.controladorProntuario;
import com.grupomc426.Targets.Usuarios.Medico;
import com.grupomc426.Targets.Usuarios.Pessoa;
import com.grupomc426.Targets.Usuarios.Usuario;

/**
 *
 * @author cauan-newton
 */
public class MenuLogin extends javax.swing.JFrame {

    /**
     * Creates new form MenuLogin
     */
    public MenuLogin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        usuarioLogin = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        botaoConfirmar = new javax.swing.JButton();
        botaoVoltar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        senhaLogin = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Menu de Login");

        usuarioLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioLoginActionPerformed(evt);
            }
        });

        jLabel2.setText("Usuário");

        botaoConfirmar.setText("Entrar");
        botaoConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConfirmarActionPerformed(evt);
            }
        });

        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        jLabel3.setText("Senha");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(96, 96, 96)
                                                .addComponent(botaoConfirmar)
                                                .addGap(61, 61, 61)
                                                .addComponent(botaoVoltar)
                                                .addGap(0, 12, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel2))
                                                .addGap(49, 49, 49)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(jLabel1)
                                                        .addComponent(usuarioLogin,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, 169,
                                                                Short.MAX_VALUE)
                                                        .addComponent(senhaLogin))))
                                .addGap(76, 76, 76)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel1)
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(usuarioLogin, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(senhaLogin, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75,
                                        Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(botaoConfirmar)
                                        .addComponent(botaoVoltar))
                                .addGap(31, 31, 31)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usuarioLoginActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_usuarioLoginActionPerformed
    }// GEN-LAST:event_usuarioLoginActionPerformed

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botaoVoltarActionPerformed
        dispose();
    }// GEN-LAST:event_botaoVoltarActionPerformed

    // TODO : Consertar Tela de Login
    public void botaoConfirmarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botaoConfirmarActionPerformed
        String cpf = usuarioLogin.getText();
        String senha = senhaLogin.getText();

        controladorProntuario prontuario = new controladorProntuario();

        Pessoa pessoa = prontuario.obterPessoa(cpf);
        Usuario usuario = null;
        if (pessoa != null) {
            usuario = new Usuario(pessoa, senha, false);
        }

        boolean logou = false;
        try {
            logou = prontuario.tentarLogin(usuario);
        } catch (IllegalArgumentException erro) {
            String mensagem = erro.getMessage();
            TelaErroGenerica telaErro = new TelaErroGenerica(mensagem);
            telaErro.setVisible(true);
        } catch (Exception e) {
            // TODO Implementar Throws Banco de Dados
            TelaErroGenerica telaErro = new TelaErroGenerica("Falha ao conectar ao Banco de Dados!");
            telaErro.setVisible(true);
        }
        if (logou) {
            Medico medico = prontuario.obterMedico(usuario.getCPF());
            if (medico != null) {
                TelaMedico telaMedico = new TelaMedico(medico);
                telaMedico.setVisible(true);
            } else {
                TelaPaciente telapaciente = new TelaPaciente(usuario);
                telapaciente.setVisible(true);
            }
        } else {
            TelaErroGenerica telaErro = new TelaErroGenerica("Falha no login.");
            telaErro.setVisible(true);
        }
        dispose();
    }// GEN-LAST:event_botaoConfirmarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoConfirmar;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField senhaLogin;
    private javax.swing.JTextField usuarioLogin;

    // End of variables declaration//GEN-END:variables
    public javax.swing.JPasswordField getSenhaLogin() {
        return senhaLogin;
    }

    public void setSenhaLogin(javax.swing.JPasswordField senhaLogin) {
        this.senhaLogin = senhaLogin;
    }

    public javax.swing.JTextField getUsuarioLogin() {
        return usuarioLogin;
    }

    public void setUsuarioLogin(javax.swing.JTextField usuarioLogin) {
        this.usuarioLogin = usuarioLogin;
    }
}