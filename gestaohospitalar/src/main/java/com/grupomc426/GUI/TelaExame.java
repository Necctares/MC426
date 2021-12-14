/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupomc426.GUI;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.grupomc426.Targets.Atendimento.Exame;
import com.grupomc426.Targets.Usuarios.Medico;
import com.grupomc426.Targets.Usuarios.Pessoa;
import com.grupomc426.Targets.Usuarios.Usuario;

/**
 *
 * @author Melanie
 */
public class TelaExame extends javax.swing.JFrame {

    /**
     * Creates new form TelaExame
     */
    public TelaExame(Exame exame) {
        initComponents(exame);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents(Exame exame) {

        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToggleButton1.setText("Voltar");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        if (exame.getAssinatura() != null) {
            jLabel6.setText("Assinado por: " + exame.getAssinatura());
        } else {
            jLabel6.setText("Nao assinado");
        }

        String medico = "Medico: " + exame.getMedico().getNome() + " || CRM: " + exame.getMedico().getCrm();
        String paciente = "Paciente: " + exame.getPaciente().getNome() + " || CPF: " + exame.getPaciente().getCPF();
        String anotacoes = "Anotacoes: " + exame.getAnotacoes();
        String horario = "Horario do Exame: "
                + exame.getHorario().format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss"));

        Object[][] status = new Object[][] { { medico }, { paciente }, { anotacoes }, { horario } };

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                status,
                new String[] {
                        "Status"
                }));
        jScrollPane1.setViewportView(jTable1);

        jLabel7.setText("Titulo: " + exame.getTitulo());
        jLabel8.setText("Resultado: " + exame.getResultado());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(391, 391, 391)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jToggleButton1)
                                                        .addComponent(jLabel6)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 432,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                                .addGap(197, 197, 197)
                                                .addComponent(jLabel7).addComponent(jLabel8)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                                .addContainerGap(46, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(10, 10, 10).addComponent(jLabel8).addGap(38, 38, 38)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel6)
                                .addGap(32, 32, 32)
                                .addComponent(jToggleButton1)
                                .addContainerGap()));
        pack();
    }// </editor-fold>

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        dispose();
    }

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
        Pessoa pessoaMed = new Pessoa("Carlos Daniel da Silva Costa", "31923453421", "20210130310", "1989");
        Medico medico = new Medico(new Usuario(pessoaMed, null, true), "293010", "xavaskAA2340T");
        Pessoa paciente = new Pessoa("Luan Caetano Souza", "31920203010", "40322235610", "1999");
        Exame mock = new Exame("Exame de Sangue", "2", medico, new Usuario(paciente, null, false),
                "Coagulacao reagiu ao antigeno", "Detectado Hepatite A",
                true, "293010", LocalDateTime.parse("2020-03-01T15:30:00", DateTimeFormatter.ISO_DATE_TIME));

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaExame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaExame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaExame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaExame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaExame(mock).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration
}
