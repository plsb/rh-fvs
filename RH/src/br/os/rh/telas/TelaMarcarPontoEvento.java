/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.os.rh.telas;

import br.edu.evento.Evento;
import br.edu.evento.EventoDAO;
import br.edu.eventoitem.EventoItem;
import br.edu.eventoitem.EventoItemDAO;
import br.edu.eventoponto.EventoPonto;
import br.edu.eventoponto.EventoPontoDAO;
import br.os.rh.funcionario.Funcionario;
import br.os.rh.funcionario.FuncionarioDAO;
import br.os.rh.pontoprofessores.HistoricoPontoProfessoresTableModel;
import br.os.rh.pontoprofessores.PontoProfessores;
import br.os.rh.pontoprofessores.PontoProfessoresDAO;
import br.os.rh.turno.Turno;
import br.os.rh.turno.TurnoDAO;
import br.os.rh.util.Ativo;
import br.os.rh.util.Biometria;
import com.digitalpersona.onetouch.DPFPSample;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 'Pedro
 */
public class TelaMarcarPontoEvento extends javax.swing.JDialog {

    private Funcionario f=null;
    List<String> listaHistorico = new ArrayList<String>();
    Thread t1;

    /**
     * Creates new form TelaPontoEvento
     */
    public TelaMarcarPontoEvento() {
        initComponents();
        setLocationRelativeTo(null);
        setModal(true);

        limparCampos();

        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    String fHora = "HH:mm:ss";
                    SimpleDateFormat sdf = new SimpleDateFormat(fHora);
                    Date hour = new Date();

                    String fData = "dd/MM/yy";
                    SimpleDateFormat sdf2 = new SimpleDateFormat(fData);
                    Date day = new Date();

                    lblHora.setText(getDiaSemana() + ", " + sdf2.format(day) + " | " + sdf.format(hour));
                }
            }
        });
        t.start();
        preencheEvento();
        limparCampos();
    }

    public void limparCampos() {
//        f=new Funcionario();
        lblFuncNaoEncontrado.setVisible(false);
        lblNome.setText("");
        lblCidade.setText("");
        lblTitulacao.setText("");
        if (cbItens.getSelectedIndex() > 0) {
            t1 = new Thread(new Runnable() {

                @Override
                public void run() {
                    try {

                        f = localizarPorDigital();
                    } catch (Exception e) {

                    }
                    if (f == null) {
                        lblFuncNaoEncontrado.setVisible(true);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(TelaMarcarPonto.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        limparCampos();
                    } else {
                        mostraProfessor(f);

                    }
                }

            });
            t1.start();

        }
    }

    public static Funcionario localizarPorDigital() throws InterruptedException {
        //pega a digital...
        DPFPSample digitalAtual = Biometria.getDigital();

        FuncionarioDAO fDAO = new FuncionarioDAO();

        List<Funcionario> funcionarios = fDAO.listarDigital();

        //loop em busca da digital pega anteriormente nos alunos da base
        Funcionario funcEncontrado = null;
        for (int i = 0; i < funcionarios.size(); i++) {
            Funcionario func = funcionarios.get(i);
            if (func.getDigital() != null) {
                if (Biometria.compararDigitais(func.getDigital(), digitalAtual)) {
                    funcEncontrado = func;
                    return func;
                }
            }
        }
        return null;
    }

    private void mostraProfessor(Funcionario f) {
        if (f != null) {
            if (f.isAtivo()) {
                //carregarFoto(f.getCaminhoFoto());
                lblNome.setText(f.getNome());
                lblCidade.setText(f.getCidade().getDescricao() + " - " + f.getCidade().getEstado().getDescricao());
                lblTitulacao.setText(f.getTitulacao().getDescricao());
                try {
                    Thread.sleep(1500); //espera um tempo
                } catch (InterruptedException ex) {
                    Logger.getLogger(TelaMarcarPonto.class.getName()).log(Level.SEVERE, null, ex);
                }

                marcaPonto();
            } else {
                lblFuncNaoEncontrado.setText("Funcionário não está ativo!");
                lblFuncNaoEncontrado.setVisible(true);
                try {
                    Thread.sleep(1000); //espera um tempo
                } catch (InterruptedException ex) {
                    Logger.getLogger(TelaMarcarPonto.class.getName()).log(Level.SEVERE, null, ex);
                }
                t1.stop();
                limparCampos();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Funcionário não encontrado!");

        }

    }

    public void marcaPonto() {
        EventoPonto ep = new EventoPonto();
        EventoPontoDAO epDAO = new EventoPontoDAO();
        ep.setData(new Date());
        ep.setFuncionario(f);
        ep.setHora(new Date());
        ep.setItem((EventoItem) cbItens.getSelectedItem());
        String texto = "";
        texto += "Entrada de " + f.getNome() + ", marcada com sucesso!";
        listaHistorico.add(0, texto + " | Data: " + new Date());
        historico.setModel(new HistoricoPontoProfessoresTableModel(listaHistorico));
        try {
            epDAO.adicionar(ep);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
        f = new Funcionario();

        limparCampos();
    }

    public void preencheEvento() {
        cbEvento.removeAllItems();
        EventoDAO edao = new EventoDAO();
        cbEvento.addItem("- Selecione -");
        for (Evento evt : edao.listar()) {
            cbEvento.addItem(evt);
        }
    }

    public void preencheItensEvento() {
        if (cbEvento.getSelectedIndex() > 0) {
            cbItens.removeAllItems();
            EventoItemDAO edao = new EventoItemDAO();
            cbItens.addItem("- Selecione -");
            for (EventoItem evt : edao.listarItensEvento((Evento) cbEvento.getSelectedItem())) {
                cbItens.addItem(evt);
            }
        }
    }

    private String getDiaSemana() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int day = cal.get(Calendar.DAY_OF_WEEK);
        switch (day) {

            case 1:
                return "Domingo";
            case 2:
                return "Segunda";
            case 3:
                return "Terça";
            case 4:
                return "Quarta";
            case 5:
                return "Quinta";
            case 6:
                return "Sexta";
            case 7:
                return "Sábado";

        }
        return "";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblFoto = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblCidade = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblTitulacao = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        historico = new javax.swing.JTable();
        lblFuncNaoEncontrado = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbItens = new javax.swing.JComboBox();
        cbEvento = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFoto.setBackground(new java.awt.Color(51, 51, 51));
        lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFoto.setText("* Foto");
        lblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblFoto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFotoMouseClicked(evt);
            }
        });
        jPanel2.add(lblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 90, 100));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nome.:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Titulação.:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Cidade.:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        lblCidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCidade.setText("jLabel6");
        jPanel2.add(lblCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, -1));

        lblNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNome.setText("jLabel6");
        jPanel2.add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        lblTitulacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTitulacao.setText("jLabel6");
        jPanel2.add(lblTitulacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, -1));

        jPanel5.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 529, 120));

        jLabel6.setText("Histórico");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        historico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(historico);

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 530, 70));

        lblFuncNaoEncontrado.setBackground(new java.awt.Color(255, 0, 51));
        lblFuncNaoEncontrado.setForeground(new java.awt.Color(255, 0, 51));
        lblFuncNaoEncontrado.setText("Funcionário Não Encontrado!");
        jPanel5.add(lblFuncNaoEncontrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Ítem:");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Evento:");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        cbItens.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbItens.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- Selecione -" }));
        cbItens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbItensMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbItensMousePressed(evt);
            }
        });
        cbItens.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbItensItemStateChanged(evt);
            }
        });
        cbItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbItensActionPerformed(evt);
            }
        });
        jPanel5.add(cbItens, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 390, -1));

        cbEvento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbEvento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- Selecione -" }));
        cbEvento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbEventoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbEventoMousePressed(evt);
            }
        });
        cbEvento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbEventoItemStateChanged(evt);
            }
        });
        cbEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEventoActionPerformed(evt);
            }
        });
        jPanel5.add(cbEvento, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 470, -1));

        jButton1.setText("Iniciar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, -1, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 39, 550, 310));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("MARCAR PONTO EVENTO");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, -1, -1));

        lblHora.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblHora.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblHora.setText("jLabel1");
        lblHora.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 11, 280, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFotoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblFotoMouseClicked

    private void cbEventoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbEventoMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_cbEventoMouseClicked

    private void cbEventoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbEventoMousePressed
        // TODO add your handling code here:


    }//GEN-LAST:event_cbEventoMousePressed

    private void cbEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEventoActionPerformed
        // TODO add your handling code here:
        preencheItensEvento();
    }//GEN-LAST:event_cbEventoActionPerformed

    private void cbEventoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbEventoItemStateChanged
        // TODO add your handling code here:


    }//GEN-LAST:event_cbEventoItemStateChanged

    private void cbItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbItensActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cbItensActionPerformed

    private void cbItensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbItensMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cbItensMouseClicked

    private void cbItensMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbItensMousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cbItensMousePressed

    private void cbItensItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbItensItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cbItensItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(cbItens.getSelectedIndex()>0){
            jButton1.setEnabled(false);
            limparCampos();            
        }else {
            JOptionPane.showMessageDialog(rootPane, "Informe o Item do Evento");            
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaMarcarPontoEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMarcarPontoEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMarcarPontoEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMarcarPontoEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMarcarPontoEvento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbEvento;
    private javax.swing.JComboBox cbItens;
    private javax.swing.JTable historico;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblFuncNaoEncontrado;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTitulacao;
    // End of variables declaration//GEN-END:variables
}
