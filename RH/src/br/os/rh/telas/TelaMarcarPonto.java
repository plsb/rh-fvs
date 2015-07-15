/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.os.rh.telas;

import br.os.rh.funcionario.Funcionario;
import br.os.rh.funcionario.FuncionarioDAO;
import br.os.rh.pontoprofessores.HistoricoPontoProfessoresTableModel;
import br.os.rh.pontoprofessores.PontoProfessores;
import br.os.rh.pontoprofessores.PontoProfessoresDAO;
import br.os.rh.turno.Turno;
import br.os.rh.turno.TurnoDAO;
import br.os.rh.util.Ativo;
import br.os.rh.util.Biometria;
import br.os.rh.util.Util;
import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPSample;
import com.digitalpersona.onetouch.capture.DPFPCapture;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusEvent;
import groovy.lang.Closure;
import groovy.swing.SwingBuilder;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 'Pedro
 */
public class TelaMarcarPonto extends javax.swing.JDialog {

    private Funcionario f;
    private String justificativa = "";
    List<String> listaHistorico = new ArrayList<String>();

    public TelaMarcarPonto() {
        initComponents();

        setModal(true);
        setLocationRelativeTo(null);

        lblNome.setText("");
        lblCidade.setText("");
        lblTitulacao.setText("");

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
        limpaCampos();
    }

    private static Funcionario localizarPorDigital() throws InterruptedException {
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
        lblJust = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        historico = new javax.swing.JTable();
        lblFuncNaoEncontrado = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        tfCodigo = new javax.swing.JTextField();
        btSair = new javax.swing.JButton();
        btMarcarPonto = new javax.swing.JButton();
        btJustificativa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

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

        jPanel5.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 25, 529, 120));

        lblJust.setForeground(new java.awt.Color(255, 0, 0));
        lblJust.setText("Justificativa Adicioada!");
        jPanel5.add(lblJust, new org.netbeans.lib.awtextra.AbsoluteConstraints(429, 0, -1, -1));

        jLabel6.setText("Histórico");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 151, -1, -1));

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

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 530, 120));

        lblFuncNaoEncontrado.setBackground(new java.awt.Color(255, 0, 51));
        lblFuncNaoEncontrado.setForeground(new java.awt.Color(255, 0, 51));
        lblFuncNaoEncontrado.setText("Funcionário Não Encontrado!");
        jPanel5.add(lblFuncNaoEncontrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 39, 550, 310));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("MARCAR PONTO");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, -1, -1));

        lblHora.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblHora.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblHora.setText("jLabel1");
        lblHora.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 11, 280, -1));

        tfCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfCodigoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfCodigoKeyReleased(evt);
            }
        });
        jPanel1.add(tfCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 179, -1));

        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/os/rh/imagens/erase-icon.png"))); // NOI18N
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });
        jPanel1.add(btSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, -1, -1));

        btMarcarPonto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/os/rh/imagens/confi.gif"))); // NOI18N
        btMarcarPonto.setText("Marcar");
        btMarcarPonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMarcarPontoActionPerformed(evt);
            }
        });
        btMarcarPonto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btMarcarPontoKeyPressed(evt);
            }
        });
        jPanel1.add(btMarcarPonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, -1, -1));

        btJustificativa.setText("F2 -Justificativa");
        btJustificativa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btJustificativaActionPerformed(evt);
            }
        });
        jPanel1.add(btJustificativa, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, -1, 33));

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

    private void tfCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCodigoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            FuncionarioDAO fDAO = new FuncionarioDAO();

            try {
                f = fDAO.checkExists("codigoPonto", Integer.parseInt(tfCodigo.getText())).get(0);
            } catch (Exception e) {
            }
            if (f != null) {
                mostraProfessor(f);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Funcionario Não Encontrado!");
            }
        } else if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_F2) {
            btJustificativaActionPerformed(null);
        }
    }//GEN-LAST:event_tfCodigoKeyPressed

    public void mostraProfessor(Funcionario f) {
        if (f != null) {
            if (f.isAtivo()) {
                //carregarFoto(f.getCaminhoFoto());
                lblNome.setText(f.getNome());
                lblCidade.setText(f.getCidade().getDescricao() + " - " + f.getCidade().getEstado().getDescricao());
                lblTitulacao.setText(f.getTitulacao().getDescricao());
                btMarcarPonto.setEnabled(true);
                btMarcarPonto.requestFocus();

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
                tfCodigo.setText("");
                tfCodigo.setFocusable(true);
                limpaCampos();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Funcionário não encontrado!");
            tfCodigo.setText("");
            tfCodigo.setFocusable(true);
        }

    }


    private void btMarcarPontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMarcarPontoActionPerformed
        // TODO add your handling code here:
        String senha = TelaPedeSenha.chamaTela();
        senha = Util.md5(senha);
        if (senha.equals(Ativo.getUsuario().getSenha())) {
            marcaPonto();
        } else {
            JOptionPane.showMessageDialog(null, "Senha Incorreta, Impossível Marcar ponto!");
            limpaCampos();
        }


    }//GEN-LAST:event_btMarcarPontoActionPerformed

    public void marcaPonto() {
        TurnoDAO tDAO = new TurnoDAO();
        PontoProfessoresDAO pDAo = new PontoProfessoresDAO();
        PontoProfessores p = pDAo.pesquisaPonto(new Date(), f, Ativo.getPeriodo(), tDAO.verificaTurno());
        if (p == null) {
            p = new PontoProfessores();
        } else if (p.getHoraEntrada() != null && p.getHoraSaida() != null) {
            p = new PontoProfessores();
        }
        String texto = "";
        p.setProfessor(f);
        p.setData(new Date());
        if (p.getHoraEntrada() == null) {
            p.setHoraEntrada(new Date());
            p.setJustEntrada(justificativa);
            p.setJustSaida(" ");
            texto += "Entrada de " + f.getNome() + ", marcada com sucesso!";
            Turno t = tDAO.verificaTurno();
            if (t != null) {
                p.setTurno(t);
            }
        } else {
            p.setHoraSaida(new Date());
            p.setJustSaida(justificativa);
            texto += "Saída de " + f.getNome() + ", marcada com sucesso!";
        }
        listaHistorico.add(0, texto + " | Data: " + new Date());
        historico.setModel(new HistoricoPontoProfessoresTableModel(listaHistorico));
        p.setPeriodo(Ativo.getPeriodo());
        pDAo.salvar(p);

        limpaCampos();
    }

    private void btJustificativaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btJustificativaActionPerformed
        // TODO add your handling code here:
        justificativa = TelaJustificativaPonto.chamaTela();
        if (!justificativa.equals("")) {
            lblJust.setText("Justificativa Adicioada!");
        }
    }//GEN-LAST:event_btJustificativaActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_F2) {
            btJustificativaActionPerformed(null);
        }
    }//GEN-LAST:event_formKeyPressed

    private void btMarcarPontoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btMarcarPontoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_F2) {
            btJustificativaActionPerformed(null);
        }
    }//GEN-LAST:event_btMarcarPontoKeyPressed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        try {
            // TODO add your handling code here:
            limpaCampos();
        } catch (Exception e) {

        }
    }//GEN-LAST:event_btSairActionPerformed

    private void tfCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCodigoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCodigoKeyReleased

    private void limpaCampos() {
        f = null;
        tfCodigo.setVisible(false);
        btMarcarPonto.setEnabled(false);
        lblCidade.setText("");
        lblFoto.setIcon(null);
        lblNome.setText("");
        lblTitulacao.setText("");
        tfCodigo.setText("");
        tfCodigo.requestFocus();
        justificativa = "";
        lblJust.setText("");
        lblFuncNaoEncontrado.setText("Funcionário Não Encontrado!");
        lblFuncNaoEncontrado.setVisible(false);
        btJustificativa.setVisible(false);
        btMarcarPonto.setVisible(false);
        btSair.setVisible(false);
        Thread t1 = new Thread(new Runnable() {

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
                    limpaCampos();
                } else {
                    mostraProfessor(f);

                }
            }
        });
        t1.start();

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

    private void carregarFoto(String path) {
        String caminhoFoto = path;

        ImageIcon imagem = new ImageIcon(caminhoFoto);

        Image img = imagem.getImage().getScaledInstance(lblFoto.getWidth() + 2, lblFoto.getHeight() + 2, Image.SCALE_DEFAULT);
        lblFoto.setIcon(new ImageIcon(img));
    }

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
            java.util.logging.Logger.getLogger(TelaMarcarPonto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMarcarPonto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMarcarPonto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMarcarPonto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMarcarPonto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btJustificativa;
    private javax.swing.JButton btMarcarPonto;
    private javax.swing.JButton btSair;
    private javax.swing.JTable historico;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblFuncNaoEncontrado;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblJust;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTitulacao;
    private javax.swing.JTextField tfCodigo;
    // End of variables declaration//GEN-END:variables
}
