/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.os.rh.telas;

import br.os.rh.cidade.Cidade;
import br.os.rh.cidade.CidadeDAO;
import br.os.rh.cidade.CidadeTableModel;
import br.os.rh.curso.Curso;
import br.os.rh.curso.CursoDAO;
import br.os.rh.curso.CursoTableModel;
import br.os.rh.disciplina.Disciplina;
import br.os.rh.disciplina.DisciplinaDAO;
import br.os.rh.disciplina.DisciplinaTableModel;
import br.os.rh.estado.Estado;
import br.os.rh.estado.EstadoDAO;
import br.os.rh.estado.EstadoTableModel;
import br.os.rh.funcionario.Funcionario;
import br.os.rh.funcionario.FuncionarioDAO;
import br.os.rh.funcionario.FuncionarioTableModel;
import br.os.rh.semestre.Semestre;
import br.os.rh.semestre.SemestreDAO;
import br.os.rh.semestre.SemestreTableModel;
import br.os.rh.titulacao.Titulacao;
import br.os.rh.titulacao.TitulacaoDAO;
import br.os.rh.titulacao.TitulacaoTableModel;
import br.os.rh.util.OnlyNumberField;
import br.os.rh.util.Util;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author JOABB
 */
public class TelaFuncionario extends javax.swing.JDialog {
    private Funcionario funcionario;
    /**
     * Creates new form TelaDisciplina
     */
    public TelaFuncionario() {
        initComponents();
        setModal(true);
        setLocationRelativeTo(null);
        limpaCampos();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btRemover = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        tfTitulacao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        tfEndereco = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        tfCidade = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tfTelefone = new javax.swing.JFormattedTextField();
        tfBairro = new javax.swing.JTextField();
        tfEmail = new javax.swing.JTextField();
        chbAtivo = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Nome:*");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 23, -1, -1));

        tfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomeActionPerformed(evt);
            }
        });
        jPanel5.add(tfNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 44, 463, -1));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/os/rh/imagens/novo_1.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 48, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/os/rh/imagens/save_1.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 329, 48, 40));

        btRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/os/rh/imagens/remove_1.png"))); // NOI18N
        btRemover.setEnabled(false);
        btRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverActionPerformed(evt);
            }
        });
        jPanel5.add(btRemover, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 48, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/os/rh/imagens/procurar_1.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 48, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/os/rh/imagens/SA.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, 48, 39));

        tfTitulacao.setEnabled(false);
        tfTitulacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTitulacaoActionPerformed(evt);
            }
        });
        jPanel5.add(tfTitulacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 190, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Titulação:*");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jButton2.setText("...");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 35, -1));

        jButton6.setText("+");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, -1, -1));

        tfEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEnderecoActionPerformed(evt);
            }
        });
        jPanel5.add(tfEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 91, 463, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Endereço:*");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Bairro:*");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 117, -1, -1));

        jButton7.setText("...");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 35, -1));

        jButton8.setText("+");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, -1, -1));

        tfCidade.setEnabled(false);
        tfCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCidadeActionPerformed(evt);
            }
        });
        jPanel5.add(tfCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 169, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Cidade:*");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Telefone:");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("E-mail:");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        try {
            tfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel5.add(tfTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 190, -1));
        jPanel5.add(tfBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 190, -1));
        jPanel5.add(tfEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 460, -1));

        chbAtivo.setBackground(new java.awt.Color(255, 255, 255));
        chbAtivo.setText("Ativo");
        chbAtivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbAtivoActionPerformed(evt);
            }
        });
        jPanel5.add(chbAtivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("CADASTRO DE FUNCIONÁRIO");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNomeActionPerformed
    private void limpaCampos(){
        tfNome.setText("");
        funcionario= new Funcionario();
        btRemover.setEnabled(false);
        tfEndereco.setText("");
        tfBairro.setText("");
        tfCidade.setText("");
        tfTelefone.setText("");
        tfEmail.setText("");
        tfTitulacao.setText("");
        chbAtivo.setSelected(true);
             
    }
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        limpaCampos();
    }//GEN-LAST:event_jButton5ActionPerformed
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (Util.chkVazio(tfBairro.getText(),tfTitulacao.getText(),tfNome.getText(),
                tfCidade.getText(),tfEndereco.getText())){
            
            funcionario.setNome(tfNome.getText());
            funcionario.setBairro(tfBairro.getText());
            funcionario.setEndereco(tfEndereco.getText());
            funcionario.setEmail(tfEmail.getText());
            funcionario.setTelefone(tfTelefone.getText().replaceAll("\\D*", ""));
            FuncionarioDAO dao = new FuncionarioDAO();
            funcionario.setAtivo(chbAtivo.isSelected());
            dao.salvar(funcionario);
            limpaCampos();

            JOptionPane.showMessageDialog(rootPane, "Cadastro Efetuado");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverActionPerformed
        FuncionarioDAO dao = new FuncionarioDAO();
        dao.remover(funcionario);
        limpaCampos();
        
        JOptionPane.showMessageDialog(rootPane, "Funcionário Excluída");
    }//GEN-LAST:event_btRemoverActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        FuncionarioDAO dao = new FuncionarioDAO();
        List <Funcionario> funcionarios = (!tfNome.getText().isEmpty() ? dao.pesquisaDescricao(tfNome.getText())
            : dao.listar());

        FuncionarioTableModel ctm = new FuncionarioTableModel(funcionarios);

        Object o = TelaPesquisa.exibeTela(ctm, "Funcionário");

        if (o != null){
            funcionario = new Funcionario();
            funcionario = dao.pesquisaId(Integer.valueOf(String.valueOf(o)));

            tfNome.setText(funcionario.getNome());
            tfEndereco.setText(funcionario.getEndereco());
            tfBairro.setText(funcionario.getBairro());
            tfCidade.setText(funcionario.getCidade().toString());
            tfTitulacao.setText(funcionario.getTitulacao().getDescricao());
            tfTelefone.setText(funcionario.getTelefone());
            tfEmail.setText(funcionario.getEmail());
            chbAtivo.setSelected(funcionario.isAtivo());

            btRemover.setEnabled(true);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tfTitulacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTitulacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTitulacaoActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        TelaTitulacao tt = new TelaTitulacao();
        tt.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        TitulacaoDAO dao = new TitulacaoDAO();
        List<Titulacao> lista = dao.listar();
        TitulacaoTableModel stm = new TitulacaoTableModel(lista);
        Object o = TelaPesquisa.exibeTela(stm, "Titulação");
        Titulacao t;
        if (o != null) {
            t = dao.pesquisaId(Integer.valueOf(String.valueOf(o)));
            funcionario.setTitulacao(t);
            tfTitulacao.setText(t.getDescricao());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tfEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEnderecoActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        CidadeDAO dao = new CidadeDAO();
        List<Cidade> lista = dao.listar();
        CidadeTableModel stm = new CidadeTableModel(lista);
        Object o = TelaPesquisa.exibeTela(stm, "Cidade");
        Cidade c;
        if (o != null) {
            c = dao.pesquisaId(Integer.valueOf(String.valueOf(o)));
            funcionario.setCidade(c);
            tfCidade.setText(c.toString());
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        TelaCidade tc = new TelaCidade();
        tc.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void tfCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCidadeActionPerformed

    private void chbAtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbAtivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chbAtivoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btRemover;
    private javax.swing.JCheckBox chbAtivo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField tfBairro;
    private javax.swing.JTextField tfCidade;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfEndereco;
    private javax.swing.JTextField tfNome;
    private javax.swing.JFormattedTextField tfTelefone;
    private javax.swing.JTextField tfTitulacao;
    // End of variables declaration//GEN-END:variables
}
