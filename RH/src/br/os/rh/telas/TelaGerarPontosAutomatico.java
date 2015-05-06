/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.os.rh.telas;

import br.edu.feriado.Feriado;
import br.edu.feriado.FeriadoDAO;
import br.os.rh.curso.Curso;
import br.os.rh.curso.CursoDAO;
import br.os.rh.funcionario.Funcionario;
import br.os.rh.funcionario.FuncionarioDAO;
import br.os.rh.funcionario.FuncionarioTableModel;
import br.os.rh.lotacao.Lotacao;
import br.os.rh.lotacao.LotacaoDAO;
import br.os.rh.lotacaodisciplinahorario.LotacaoDisciplinaHorario;
import br.os.rh.lotacaodiscplinas.LotacaoDisciplina;
import br.os.rh.lotacaodiscplinas.LotacaoDisciplinaDAO;
import br.os.rh.periodo.Periodo;
import br.os.rh.periodo.PeriodoDAO;
import br.os.rh.pontoprofessores.PontoProfessores;
import br.os.rh.pontoprofessores.PontoProfessoresDAO;
import br.os.rh.turno.Turno;
import br.os.rh.turno.TurnoDAO;
import br.os.rh.util.Ativo;
import br.os.rh.util.ConnectionFactory;
import br.os.rh.util.Util;
import java.net.URL;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Pedro Saraiva
 */
public class TelaGerarPontosAutomatico extends javax.swing.JDialog {

    private Funcionario f;

    /**
     * Creates new form TelaRelatorioAcervo
     */
    public TelaGerarPontosAutomatico() {
        initComponents();
        setModal(true);
        setLocationRelativeTo(null);
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
        btSair = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btImprimir = new javax.swing.JButton();
        tfDataInicial = new javax.swing.JFormattedTextField();
        Descricao_Biblioteca3 = new javax.swing.JLabel();
        tfDataFinal = new javax.swing.JFormattedTextField();
        Descricao_Biblioteca4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerar Pontos de Professores");
        setModal(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(432, 177));

        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/os/rh/imagens/SA.png"))); // NOI18N
        btSair.setToolTipText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));
        jPanel3.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("GERAR PONTOS AUTOMÁTICOS");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(0, 10, 360, 17);

        btImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/os/rh/imagens/confi.gif"))); // NOI18N
        btImprimir.setToolTipText("Sair");
        btImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImprimirActionPerformed(evt);
            }
        });

        try {
            tfDataInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfDataInicial.setToolTipText("Informe a Data Inicial ");
        tfDataInicial.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        tfDataInicial.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        Descricao_Biblioteca3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        Descricao_Biblioteca3.setText("Data Inicial.: *");

        try {
            tfDataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfDataFinal.setToolTipText("Informe a Data Inicial ");
        tfDataFinal.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        tfDataFinal.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        Descricao_Biblioteca4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        Descricao_Biblioteca4.setText("Data Final.: *");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Descricao_Biblioteca3)
                    .addComponent(tfDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btImprimir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btSair))
                    .addComponent(Descricao_Biblioteca4)
                    .addComponent(tfDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Descricao_Biblioteca3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(tfDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Descricao_Biblioteca4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(tfDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btSair)
                    .addComponent(btImprimir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void btImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImprimirActionPerformed
        // TODO add your handling code here:
        if (!tfDataInicial.equals("  /  /    ") && !tfDataFinal.equals("  /  /    ")) {
            java.util.Date dataInicial = null, dataFinal = null;
            Calendar cdtInicial = null, cdtFinal = null;
            try {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                dataInicial = new java.sql.Date(format.parse(tfDataInicial.getText()).getTime());
                dataFinal = new java.sql.Date(format.parse(tfDataFinal.getText()).getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            cdtInicial = Util.DateToCalendar(dataInicial);
            cdtFinal = Util.DateToCalendar(dataFinal);

            LotacaoDisciplinaDAO lDAO = new LotacaoDisciplinaDAO();
            List<LotacaoDisciplina> listaLotacao = lDAO.pesquisaPeriodo();
            FeriadoDAO fDAO = new FeriadoDAO();

            //System.out.println(Util.retornarDiaSemana());
            while (true) {
                if (fDAO.checkExists("data", dataInicial).size() == 0) {
                    PontoProfessoresDAO ppDAO = new PontoProfessoresDAO();
                    for (LotacaoDisciplina lotacao : listaLotacao) {

                        for (LotacaoDisciplinaHorario lotacaoDisciplinaH : lotacao.getSdh()) {
                            if (Util.retornarDiaSemana(cdtInicial).equals(lotacaoDisciplinaH.getDiaSemana())
                                    && lotacao.getLotacao().getProfessor().isAtivo()) {
                                TurnoDAO tDAO = new TurnoDAO();
                                Turno t = tDAO.verificaTurno(lotacaoDisciplinaH.getHorario().getHoraInicial());
                                PontoProfessores pp = ppDAO.pesquisaPonto(dataInicial, lotacao.getLotacao().getProfessor(),
                                        Ativo.getPeriodo(), t);
                                //verifica se o ponto é nulo, e se não é feriado
                                if (pp == null) {

                                    pp = new PontoProfessores();
                                    pp.setData(cdtInicial.getTime());
                                    pp.setJustEntrada(" ");
                                    pp.setJustSaida(" ");
                                    pp.setPeriodo(Ativo.getPeriodo());
                                    pp.setProfessor(lotacao.getLotacao().getProfessor());
                                    pp.setTurno(t);

                                    ppDAO.salvar(pp);

                                }

                            }
                        }

                    }
                }
                cdtInicial.add(Calendar.DAY_OF_MONTH, 1);
                dataInicial.setDate(dataInicial.getDate() + 1);
                if (dataInicial.after(dataFinal)) {
                    break;
                }

            }
            JOptionPane.showMessageDialog(rootPane, "Pontos Gerados com Sucesso!");
            tfDataFinal.setText("");
            tfDataInicial.setText("");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Informe a Data!");
        }

    }//GEN-LAST:event_btImprimirActionPerformed

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
            java.util.logging.Logger.getLogger(TelaGerarPontosAutomatico.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaGerarPontosAutomatico.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaGerarPontosAutomatico.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaGerarPontosAutomatico.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaGerarPontosAutomatico().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Descricao_Biblioteca3;
    private javax.swing.JLabel Descricao_Biblioteca4;
    private javax.swing.JButton btImprimir;
    private javax.swing.JButton btSair;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JFormattedTextField tfDataFinal;
    private javax.swing.JFormattedTextField tfDataInicial;
    // End of variables declaration//GEN-END:variables

//    private void preencheCurso() {
//        CursoDAO cDAO = new CursoDAO();
//        for (int i = 0; i < cDAO.listar().size(); i++) {
//            cbCurso.addItem(cDAO.listar().get(i).getDescricao());
//        }
//    }
}
