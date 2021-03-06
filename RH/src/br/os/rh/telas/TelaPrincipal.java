/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.os.rh.telas;

import br.os.rh.funcionario.Funcionario;
import br.os.rh.lotacaodisciplinahorario.LotacaoDisciplinaHorario;
import br.os.rh.lotacaodisciplinahorario.LotacaoDisciplinaHorarioDAO;
import br.os.rh.pontoprofessores.PontoProfessores;
import br.os.rh.pontoprofessores.PontoProfessoresDAO;
import br.os.rh.util.Ativo;
import br.os.rh.util.Util;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author 'Pedro
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();

        setLocationRelativeTo(null);
        permissaoFalse();
        permissaoAdm();
        permissaoRH();
        permissaoCoordenador();
        permissaoSecretaria();
        setTitle("OSRH");
        preencheLabel();
        tfEmail.setVisible(false);

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                //mandar email
                tfEmail.setVisible(true);
                PontoProfessoresDAO ppDAO = new PontoProfessoresDAO();
                mandarEmail(ppDAO.pesquisaPontoEmail());
                tfEmail.setVisible(false);
                //fim mandar email
            }
        });
        thread.start();
        
        
    }

    private void permissaoCoordenador() {
        if (!Ativo.getUsuario().isAdministrador()) {
            if (Ativo.getUsuario().getTipo().equals("Coordenador de Curso")) {
                mmDisciplina.setVisible(true);
                mmLotacao.setVisible(true);
                mRelatorios.setVisible(true);
                mmRelPontosPrrofessoresCompleto.setVisible(true);

            }
        }
    }
    

    private void permissaoSecretaria() {
        if (!Ativo.getUsuario().isAdministrador()) {
            if (Ativo.getUsuario().getTipo().equals("Secretária Professores")) {
                mCadastro.setVisible(false);
                mRelatorios.setVisible(true);
                mmPontoProfessores.setVisible(true);
                mmRelPontosPrrofessoresCompleto.setVisible(true);
                menuPontoProfessores.setVisible(true);
                jMenuItem1.setVisible(false);
                mmPontoProfessores.setVisible(true);

            }
        }

    }

    private void preencheLabel() {
        String str = "Usuário: " + Ativo.getUsuario().getNome()
                + " | Tipo: " + Ativo.getUsuario().getTipo();
        if (!Ativo.getUsuario().isAdministrador()) {
            str += " | Período: " + Ativo.getPeriodo().getDescricao();
        }
        str += " | Versão 3.8";
        lblInformativo.setText(str);
    }

    private void permissaoFalse() {
        mmPontoEvento.setVisible(false);
        mmMarcaPontoEvento.setVisible(false);
        mmUsuario.setVisible(false);
        mmPeriodo.setVisible(false);
        mmDisciplina.setVisible(false);
        mmFuncionario.setVisible(false);
        mmHorarios.setVisible(false);
        mmSalario.setVisible(false);
        mmRelProfLotacao.setVisible(false);
        mmRelPlanilhaProfessores.setVisible(false);
        mmCurso.setVisible(false);
        mmLotacao.setVisible(false);
        mmSemestre.setVisible(false);
        mmPontoProfessores.setVisible(false);
        mmGerarPontos.setVisible(false);
        mmFeriado.setVisible(false);
        menuPontoProfessores.setVisible(true);
    }

    private void permissaoAdm() {
        if (Ativo.getUsuario().isAdministrador()) {
            mmSemestre.setVisible(true);
            mmCurso.setVisible(true);
            mmUsuario.setVisible(true);
            mmPeriodo.setVisible(true);
            mMovimentacao.setVisible(false);
            mRelatorios.setVisible(false);
        }
    }

    private void permissaoRH() {
        if (!Ativo.getUsuario().isAdministrador()) {
            if (Ativo.getUsuario().getTipo().equals("RH")) {
                mmPontoEvento.setVisible(true);
//                mmLotacao.setVisible(true);
                mmMarcaPontoEvento.setVisible(true);
                mmFuncionario.setVisible(true);
                mmHorarios.setVisible(true);
                mmSalario.setVisible(true);
                mmRelProfLotacao.setVisible(true);
                mmRelPlanilhaProfessores.setVisible(false);
                mmCurso.setVisible(true);
                mmSemestre.setVisible(true);
                mmRelPontosPrrofessoresCompleto.setVisible(true);
                mmFeriado.setVisible(true);
                mmGerarPontos.setVisible(true);
                menuPontoProfessores.setVisible(true);
            }
        }

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
        jLabel1 = new javax.swing.JLabel();
        lblInformativo = new javax.swing.JLabel();
        tfEmail = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mCadastro = new javax.swing.JMenu();
        mmCurso = new javax.swing.JMenuItem();
        mmDisciplina = new javax.swing.JMenuItem();
        mmFeriado = new javax.swing.JMenuItem();
        mmFuncionario = new javax.swing.JMenuItem();
        mmHorarios = new javax.swing.JMenuItem();
        mmPeriodo = new javax.swing.JMenuItem();
        mmSemestre = new javax.swing.JMenuItem();
        mmUsuario = new javax.swing.JMenuItem();
        mMovimentacao = new javax.swing.JMenu();
        mmLotacao = new javax.swing.JMenuItem();
        mmSalario = new javax.swing.JMenuItem();
        menuPontoProfessores = new javax.swing.JMenu();
        mmGerarPontos = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        mmPontoProfessores = new javax.swing.JMenuItem();
        mmMarcaPontoEvento = new javax.swing.JMenuItem();
        mRelatorios = new javax.swing.JMenu();
        mmRelProfLotacao = new javax.swing.JMenuItem();
        mmRelPlanilhaProfessores = new javax.swing.JMenuItem();
        mmRelPontosPrrofessoresCompleto = new javax.swing.JMenuItem();
        mmPontoEvento = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/os/rh/imagens/nexaspng maior.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 380, 350));

        lblInformativo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblInformativo.setText("jLabel2");
        jPanel1.add(lblInformativo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, -1, -1));

        tfEmail.setForeground(new java.awt.Color(255, 0, 0));
        tfEmail.setText("Enviando E-mail's...");
        jPanel1.add(tfEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, -1, -1));

        mCadastro.setText("Cadastros");

        mmCurso.setText("Curso");
        mmCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmCursoActionPerformed(evt);
            }
        });
        mCadastro.add(mmCurso);

        mmDisciplina.setText("Disciplina");
        mmDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmDisciplinaActionPerformed(evt);
            }
        });
        mCadastro.add(mmDisciplina);

        mmFeriado.setText("Feriado");
        mmFeriado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmFeriadoActionPerformed(evt);
            }
        });
        mCadastro.add(mmFeriado);

        mmFuncionario.setText("Funcionário");
        mmFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmFuncionarioActionPerformed(evt);
            }
        });
        mCadastro.add(mmFuncionario);

        mmHorarios.setText("Horários");
        mmHorarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmHorariosActionPerformed(evt);
            }
        });
        mCadastro.add(mmHorarios);

        mmPeriodo.setText("Período");
        mmPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmPeriodoActionPerformed(evt);
            }
        });
        mCadastro.add(mmPeriodo);

        mmSemestre.setText("Semestre");
        mmSemestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmSemestreActionPerformed(evt);
            }
        });
        mCadastro.add(mmSemestre);

        mmUsuario.setText("Usuário");
        mmUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmUsuarioActionPerformed(evt);
            }
        });
        mCadastro.add(mmUsuario);

        jMenuBar1.add(mCadastro);

        mMovimentacao.setText("Movimentação");

        mmLotacao.setText("Lotação");
        mmLotacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmLotacaoActionPerformed(evt);
            }
        });
        mMovimentacao.add(mmLotacao);

        mmSalario.setText("Salário");
        mmSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmSalarioActionPerformed(evt);
            }
        });
        mMovimentacao.add(mmSalario);

        menuPontoProfessores.setText("Ponto Professores");

        mmGerarPontos.setText("Gerar Pontos");
        mmGerarPontos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmGerarPontosActionPerformed(evt);
            }
        });
        menuPontoProfessores.add(mmGerarPontos);

        jMenuItem1.setText("Listar Pontos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuPontoProfessores.add(jMenuItem1);

        mmPontoProfessores.setText("Marcar Ponto");
        mmPontoProfessores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmPontoProfessoresActionPerformed(evt);
            }
        });
        menuPontoProfessores.add(mmPontoProfessores);

        mmMarcaPontoEvento.setText("Marcar Ponto Evento");
        mmMarcaPontoEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmMarcaPontoEventoActionPerformed(evt);
            }
        });
        menuPontoProfessores.add(mmMarcaPontoEvento);

        mMovimentacao.add(menuPontoProfessores);

        jMenuBar1.add(mMovimentacao);

        mRelatorios.setText("Relatórios");

        mmRelProfLotacao.setText("Professores/Lotação");
        mmRelProfLotacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmRelProfLotacaoActionPerformed(evt);
            }
        });
        mRelatorios.add(mmRelProfLotacao);

        mmRelPlanilhaProfessores.setText("Planilha Professores");
        mmRelPlanilhaProfessores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmRelPlanilhaProfessoresActionPerformed(evt);
            }
        });
        mRelatorios.add(mmRelPlanilhaProfessores);

        mmRelPontosPrrofessoresCompleto.setText("Ponto Professores Completo");
        mmRelPontosPrrofessoresCompleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmRelPontosPrrofessoresCompletoActionPerformed(evt);
            }
        });
        mRelatorios.add(mmRelPontosPrrofessoresCompleto);

        mmPontoEvento.setText("Ponto Evento");
        mmPontoEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmPontoEventoActionPerformed(evt);
            }
        });
        mRelatorios.add(mmPontoEvento);

        jMenuBar1.add(mRelatorios);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mmUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmUsuarioActionPerformed
        // TODO add your handling code here:
        TelaUsuario tu = new TelaUsuario();
        tu.setVisible(true);
    }//GEN-LAST:event_mmUsuarioActionPerformed

    private void mmPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmPeriodoActionPerformed
        // TODO add your handling code here:
        TelaPeriodo tp = new TelaPeriodo();
        tp.setVisible(true);
    }//GEN-LAST:event_mmPeriodoActionPerformed

    private void mmDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmDisciplinaActionPerformed
        // TODO add your handling code here:
        TelaDisciplina td = new TelaDisciplina();
        td.setVisible(true);
    }//GEN-LAST:event_mmDisciplinaActionPerformed

    private void mmFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmFuncionarioActionPerformed
        // TODO add your handling code here:
        TelaFuncionario tf = new TelaFuncionario();
        tf.setVisible(true);
    }//GEN-LAST:event_mmFuncionarioActionPerformed

    private void mmHorariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmHorariosActionPerformed
        // TODO add your handling code here:
        TelaHorario th = new TelaHorario();
        th.setVisible(true);
    }//GEN-LAST:event_mmHorariosActionPerformed

    private void mmRelProfLotacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmRelProfLotacaoActionPerformed
        // TODO add your handling code here:
        TelaRelatorioProfessoresLotacao trpl = new TelaRelatorioProfessoresLotacao();
        trpl.setVisible(true);
    }//GEN-LAST:event_mmRelProfLotacaoActionPerformed

    private void mmRelPlanilhaProfessoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmRelPlanilhaProfessoresActionPerformed
        // TODO add your handling code here:
        TelaGeraPlanilhaFolhaProfessores tgpfp = new TelaGeraPlanilhaFolhaProfessores();
        tgpfp.setVisible(true);
    }//GEN-LAST:event_mmRelPlanilhaProfessoresActionPerformed

    private void mmCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmCursoActionPerformed
        // TODO add your handling code here:
        TelaCurso tc = new TelaCurso();
        tc.setVisible(true);
    }//GEN-LAST:event_mmCursoActionPerformed

    private void mmSemestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmSemestreActionPerformed
        // TODO add your handling code here:
        TelaSemestre ts = new TelaSemestre();
        ts.setVisible(true);
    }//GEN-LAST:event_mmSemestreActionPerformed

    private void mmRelPontosPrrofessoresCompletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmRelPontosPrrofessoresCompletoActionPerformed
        // TODO add your handling code here:
        TelaRelatorioPontoCompleto trc = new TelaRelatorioPontoCompleto();
        trc.setVisible(true);
    }//GEN-LAST:event_mmRelPontosPrrofessoresCompletoActionPerformed

    private void mmFeriadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmFeriadoActionPerformed
        // TODO add your handling code here:
        TelaFeriado tf = new TelaFeriado();
        tf.setVisible(true);
    }//GEN-LAST:event_mmFeriadoActionPerformed

    private void mmPontoProfessoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmPontoProfessoresActionPerformed
        // TODO add your handling code here:
        TelaMarcarPonto tmp = new TelaMarcarPonto();
        tmp.setVisible(true);
    }//GEN-LAST:event_mmPontoProfessoresActionPerformed

    private void mmSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmSalarioActionPerformed
        // TODO add your handling code here:
        TelaSalario ts = new TelaSalario();
        ts.setVisible(true);
    }//GEN-LAST:event_mmSalarioActionPerformed

    private void mmLotacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmLotacaoActionPerformed
        // TODO add your handling code here:
        TelaLotacao tl = new TelaLotacao();
        tl.setVisible(true);
    }//GEN-LAST:event_mmLotacaoActionPerformed

    private void mmGerarPontosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmGerarPontosActionPerformed
        // TODO add your handling code here:
        TelaGerarPontosAutomatico tgp = new TelaGerarPontosAutomatico();
        tgp.setVisible(true);
    }//GEN-LAST:event_mmGerarPontosActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        TelaListarPontos tlp = new TelaListarPontos();
        tlp.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void mmMarcaPontoEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmMarcaPontoEventoActionPerformed
        // TODO add your handling code here:
        TelaMarcarPontoEvento tmp = new TelaMarcarPontoEvento();
        tmp.setVisible(true);
    }//GEN-LAST:event_mmMarcaPontoEventoActionPerformed

    private void mmPontoEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmPontoEventoActionPerformed
        // TODO add your handling code here:
        TelaRelatorioPontoEvento trpe = new TelaRelatorioPontoEvento();
        trpe.setVisible(true);
    }//GEN-LAST:event_mmPontoEventoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblInformativo;
    private javax.swing.JMenu mCadastro;
    private javax.swing.JMenu mMovimentacao;
    private javax.swing.JMenu mRelatorios;
    private javax.swing.JMenu menuPontoProfessores;
    private javax.swing.JMenuItem mmCurso;
    private javax.swing.JMenuItem mmDisciplina;
    private javax.swing.JMenuItem mmFeriado;
    private javax.swing.JMenuItem mmFuncionario;
    private javax.swing.JMenuItem mmGerarPontos;
    private javax.swing.JMenuItem mmHorarios;
    private javax.swing.JMenuItem mmLotacao;
    private javax.swing.JMenuItem mmMarcaPontoEvento;
    private javax.swing.JMenuItem mmPeriodo;
    private javax.swing.JMenuItem mmPontoEvento;
    private javax.swing.JMenuItem mmPontoProfessores;
    private javax.swing.JMenuItem mmRelPlanilhaProfessores;
    private javax.swing.JMenuItem mmRelPontosPrrofessoresCompleto;
    private javax.swing.JMenuItem mmRelProfLotacao;
    private javax.swing.JMenuItem mmSalario;
    private javax.swing.JMenuItem mmSemestre;
    private javax.swing.JMenuItem mmUsuario;
    private javax.swing.JLabel tfEmail;
    // End of variables declaration//GEN-END:variables

    private void mandarEmail(List<PontoProfessores> pesquisaPontoEmail) {
        List<PontoProfessores> lista = pesquisaPontoEmail;
        PontoProfessoresDAO ppDAO = new PontoProfessoresDAO();
        for (PontoProfessores pontoProfessores : lista) {
            if ((pontoProfessores.getProfessor().getEmail() != null)
                    && !pontoProfessores.getProfessor().getEmail().equals("")
                    && pontoProfessores.getProfessor().isAtivo()) {
                Calendar cdtInicial = Util.DateToCalendar(pontoProfessores.getData());
                Funcionario f = pontoProfessores.getProfessor();
                String mensagem = "Caro Prof.(a) " + f.getNome() + ";";
                mensagem += "\n\nNosso sistema informatizado de marcação de frequência não registrou seu ponto nas aulas"
                        + " do dia " + pontoProfessores.getData() + "(" + Util.retornarDiaSemana(cdtInicial) + "), Período " + pontoProfessores.getPeriodo().getDescricao() + ".";

                mensagem += "\n\nHora Entrada: " + pontoProfessores.getHoraEntrada() + ", Hora Saída: "
                        + pontoProfessores.getHoraSaida() + ".\n";

                LotacaoDisciplinaHorarioDAO ldDAO = new LotacaoDisciplinaHorarioDAO();

                List<LotacaoDisciplinaHorario> listaLotacao = ldDAO.pesquisaDisciplinasFuncionario(f,
                        Util.retornarDiaSemana(cdtInicial), Ativo.getPeriodo());
                if (listaLotacao != null) {
                    for (LotacaoDisciplinaHorario ldh : listaLotacao) {
                        mensagem += "\nDisciplina: " + ldh.getSalarioDisciplina().getDisciplina().getDescricao()
                                + " | Semestre: " + ldh.getSalarioDisciplina().getDisciplina().getSemestre()
                                + " | Coordenador: " + ldh.getSalarioDisciplina().getDisciplina().getSemestre().getCurso().getCoordenador().getNome();
                    }
                }

                mensagem += "\n\nPor favor dirija-se ao coordenador do seu curso a fim de verificar esta ocorrência;"
                        + "\n\nEste é um e-mail automático, por favor, não responder!";
                mensagem += "\n\nSistema de Ponto de Professores";
                try {
                    Util.mandarEmail("frequenciadocente@fvs.edu.br", "fvs040908", pontoProfessores.getProfessor().getEmail(),
                            "Sistema Ponto Eletrônico - FVS", mensagem);
                    pontoProfessores.setEmail(true);
                    ppDAO.salvar(pontoProfessores);
                } catch (Exception e) {
                 //   JOptionPane.showMessageDialog(rootPane, "Não foi possível enviar e-mail para: "
                   //         + f.getEmail() + "\nMotivo: " + e.getMessage());
                }

            }
        }
    }

}
