/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.os.rh.telas;

import br.os.rh.disciplina.Disciplina;
import br.os.rh.disciplina.DisciplinaDAO;
import br.os.rh.disciplina.DisciplinaTableModel;
import br.os.rh.funcionario.Funcionario;
import br.os.rh.funcionario.FuncionarioDAO;
import br.os.rh.funcionario.FuncionarioTableModel;
import br.os.rh.periodo.Periodo;
import br.os.rh.periodo.PeriodoDAO;
import br.os.rh.periodo.PeriodoTableModel;
import br.os.rh.salario.Salario;
import br.os.rh.salario.SalarioDAO;
import br.os.rh.salario.SalarioTableModel;
import br.os.rh.lotacaodisciplinahorario.LotacaoDisciplinaHorarioDAO;
import br.os.rh.lotacaodiscplinas.LotacaoDisciplina;
import br.os.rh.lotacaodiscplinas.LotacaoDisciplinaDAO;
import br.os.rh.lotacaodiscplinas.LotacaoDisciplinaTableModel;
import br.os.rh.util.Ativo;
import br.os.rh.util.Calculo;
import br.os.rh.util.FormataTamanhoColunasJTable;
import br.os.rh.util.OnlyNumberField;
import br.os.rh.util.Util;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author JOABB
 */
public class TelaSalario extends javax.swing.JDialog {

    private Salario salario;
    private List<LotacaoDisciplina> disciplinas;
    private List<LotacaoDisciplina> disciplinasSerExcluidas;
    private Funcionario f;

    private double calculo() {
        int horasMensalista = 0;
        if (!tfHorasMenslista.getText().equals("")) {
            horasMensalista = Integer.parseInt(tfHorasMenslista.getText());
        }
        double vHoraAula = 0;
        if (!tfValorHoraAula.getText().equals("")) {
            vHoraAula = Double.parseDouble(tfValorHoraAula.getText());
        }
        double ajudaCusto = 0;
        if (!tfValorAjudaCusto.getText().equals("")) {
            ajudaCusto = Double.parseDouble(tfValorAjudaCusto.getText());
        }
        double porcentagem = 0;
        if (!tfPorcentagem.getText().equals("")) {
            porcentagem = Double.parseDouble(tfPorcentagem.getText());

        }
        double comissao = 0;
        if (!tfComissao.getText().equals("")) {
            comissao = Double.parseDouble(tfComissao.getText());
        }
//        if(disciplinas.size()==0){
//            return Double.parseDouble(tfSalario.getText());
//        }
        return Calculo.calculoHorista(disciplinas, vHoraAula, ajudaCusto, porcentagem,
                horasMensalista, Double.parseDouble(tfSalarioBase.getText()), comissao);
//        if (jcbRegime.getSelectedIndex() == 1) {
//
//            return Calculo.calculoHorista(disciplinas, vHoraAula, ajudaCusto, porcentagem);
//        } else if (jcbRegime.getSelectedIndex() == 2) {
//            return Calculo.calculoMensalistaHorista(disciplinas, horasMensalista, vHoraAula, ajudaCusto, porcentagem);
//        }
        //return 0;
    }

//    private double calculoMensalistaHorista() {
//        int ch = 0;
//        for (int i = 0; i < disciplinas.size(); i++) {
//            ch += disciplinas.get(i).getDisciplina().getHoras();
//        }
//        int horasMensalista = 0;
//        System.out.println(tfHorasMenslista.getText());
//        if (!tfHorasMenslista.getText().equals("")) {
//            horasMensalista = Integer.parseInt(tfHorasMenslista.getText());
//        }
//        if (ch < horasMensalista) {
//            ch = 0;
//        } else {
//            ch = ch - horasMensalista;
//        }
//
//        double vHoraAula = 0;
//        if (!tfValorHoraAula.getText().equals("")) {
//            vHoraAula = Double.parseDouble(tfValorHoraAula.getText());
//        }
//        double horasMensais = (ch / 20) * 4.5;
//        double remuneracaoMensal = horasMensais * vHoraAula;
//        double umSexto = remuneracaoMensal / 6;
//
//        double ajudaCusto = 0;
//        if (!tfValorAjudaCusto.getText().equals("")) {
//            ajudaCusto = Double.parseDouble(tfValorAjudaCusto.getText());
//        }
//        double salarioBruto = remuneracaoMensal + umSexto + ajudaCusto;
//
//        double horasMensaisMensalista = horasMensalista / 20;
//        double totalMesMensalista = horasMensaisMensalista * 4;
//        double horaAulaMesMensalista = totalMesMensalista / 0.75;
//        double valorMensalista = horaAulaMesMensalista * vHoraAula;
//        double gratificacao = 0;
//        if (!tfPorcentagem.getText().equals("")) {
//            double porcentagem = Double.parseDouble(tfPorcentagem.getText());
//            gratificacao = (porcentagem * (remuneracaoMensal + valorMensalista)) / 100;
//        }
//
//        return salarioBruto + valorMensalista + gratificacao;
//
//    }
//
//    private double calculoHorista() {
//        int ch = 0;
//        for (int i = 0; i < disciplinas.size(); i++) {
//            ch += disciplinas.get(i).getDisciplina().getHoras();
//        }
//        double vHoraAula = 0;
//        if (!tfValorHoraAula.getText().equals("")) {
//            vHoraAula = Double.parseDouble(tfValorHoraAula.getText());
//        }
//        double horasMensais = (ch / 20) * 4.5;
//        double remuneracaoMensal = horasMensais * vHoraAula;
//        double umSexto = remuneracaoMensal / 6;
//        double gratificacao = 0;
//        if (!tfPorcentagem.getText().equals("")) {
//            double porcentagem = Double.parseDouble(tfPorcentagem.getText());
//            gratificacao = (porcentagem * remuneracaoMensal) / 100;
//        }
//        double ajudaCusto = 0;
//        if (!tfValorAjudaCusto.getText().equals("")) {
//            ajudaCusto = Double.parseDouble(tfValorAjudaCusto.getText());
//        }
//        double salarioBruto = remuneracaoMensal + umSexto + gratificacao + ajudaCusto;
//        return salarioBruto;
//    }
    /**
     * Creates new form TelaSalario
     */
    public TelaSalario() {
        initComponents();
        setModal(true);
        limpaCampos();
        pnTelaSalario.setVisible(false);
//        setSize(500, 1500);
        setLocationRelativeTo(null);
        limpaCampos();
        tfHorasMenslista.setDocument(new OnlyNumberField(20));

    }

    private void preencheTabelaDisciplinas() {
        LotacaoDisciplinaTableModel dtm = new LotacaoDisciplinaTableModel(disciplinas);

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
        jLabel4 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        tfFuncionario = new javax.swing.JTextField();
        pnTelaSalario = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jcbRegime = new javax.swing.JComboBox();
        tfValorHoraAula = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfPeriodo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfPorcentagem = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tfValorAjudaCusto = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tfHorasMenslista = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tfComissao = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btRemover = new javax.swing.JButton();
        tfSalarioBase = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Nome:*");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Salário Base:*");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, -1, -1));

        jButton7.setText("...");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 35, -1));

        jButton8.setText("+");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, -1, -1));

        tfFuncionario.setEnabled(false);
        tfFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfFuncionarioActionPerformed(evt);
            }
        });
        jPanel5.add(tfFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 320, -1));

        pnTelaSalario.setBackground(new java.awt.Color(255, 255, 255));
        pnTelaSalario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnTelaSalario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Regime:*");
        pnTelaSalario.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 12, -1, -1));

        jcbRegime.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione ", "Horista", "Mensalista/Horista" }));
        jcbRegime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbRegimeActionPerformed(evt);
            }
        });
        pnTelaSalario.add(jcbRegime, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 32, 144, -1));

        tfValorHoraAula.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfValorHoraAulaFocusLost(evt);
            }
        });
        pnTelaSalario.add(tfValorHoraAula, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 32, 130, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Valor da Hora/Aula:*");
        pnTelaSalario.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 16, -1, 10));

        tfPeriodo.setEnabled(false);
        tfPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPeriodoActionPerformed(evt);
            }
        });
        pnTelaSalario.add(tfPeriodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 140, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Período:*");
        pnTelaSalario.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, -1, -1));

        tfPorcentagem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfPorcentagemFocusLost(evt);
            }
        });
        pnTelaSalario.add(tfPorcentagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 93, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Gratificação (%):");
        pnTelaSalario.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        tfValorAjudaCusto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfValorAjudaCustoFocusLost(evt);
            }
        });
        pnTelaSalario.add(tfValorAjudaCusto, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 32, 140, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Valor Ajuda de Custo:");
        pnTelaSalario.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 16, -1, 10));

        tfHorasMenslista.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfHorasMenslistaFocusLost(evt);
            }
        });
        pnTelaSalario.add(tfHorasMenslista, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 32, 93, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Horas Mensalista:");
        pnTelaSalario.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 16, -1, 10));

        tfComissao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfComissaoFocusLost(evt);
            }
        });
        pnTelaSalario.add(tfComissao, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 140, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Comissão:");
        pnTelaSalario.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, -1, 10));

        jPanel5.add(pnTelaSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 660, 130));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/os/rh/imagens/novo_1.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, -1, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/os/rh/imagens/SA.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, -1, 40));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/os/rh/imagens/procurar_1.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/os/rh/imagens/save_1.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, -1, -1));

        btRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/os/rh/imagens/remove_1.png"))); // NOI18N
        btRemover.setEnabled(false);
        btRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverActionPerformed(evt);
            }
        });
        jPanel5.add(btRemover, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, -1, -1));

        tfSalarioBase.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfSalarioBaseFocusLost(evt);
            }
        });
        jPanel5.add(tfSalarioBase, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 220, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("SALÁRIO");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void limpaCampos() {
        tfHorasMenslista.setText("");
//        tfHorasMenslista.setEnabled(false);
        tfSalarioBase.setEnabled(true);
        tfFuncionario.setText("");
        tfSalarioBase.setText("");
        tfValorAjudaCusto.setText("");
        tfValorHoraAula.setText("");
        tfPeriodo.setText(Ativo.getPeriodo().getDescricao());
        tfPorcentagem.setText("");

        pnTelaSalario.setEnabled(false);
        salario = new Salario();
        disciplinas = new ArrayList<LotacaoDisciplina>();
        disciplinasSerExcluidas = new ArrayList<LotacaoDisciplina>();
        pnTelaSalario.setVisible(false);
        setSize(670, 230);
        preencheTabelaDisciplinas();

        jcbRegime.setSelectedIndex(0);
        setLocationRelativeTo(null);
        btRemover.setEnabled(false);
        f = null;

    }
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        limpaCampos();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        SalarioDAO dao = new SalarioDAO();
        if (f != null) {
            boolean professor = f.isProfessor();
            if (professor) {
                if (jcbRegime.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(rootPane, "Informe o Tipo de Regime!", "", JOptionPane.ERROR_MESSAGE);
                } else if (jcbRegime.getSelectedIndex() == 2 && tfSalarioBase.getText().equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Informe o Salário Base!", "", JOptionPane.ERROR_MESSAGE);
                } else if (tfValorHoraAula.getText().equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Informe o Valor da Hora Aula!", "", JOptionPane.ERROR_MESSAGE);
                } else {
//                    Salario s = new Salario();
                    salario.setFuncionario(f);
                    salario.setPeriodo(Ativo.getPeriodo());
                    if (!tfComissao.getText().equals("")) {
                        salario.setComissao(Double.parseDouble(tfComissao.getText()));
                    } else {
                        salario.setComissao(0);
                    }

                    if (!tfHorasMenslista.getText().equals("")) {
                        int hm = Integer.parseInt(tfHorasMenslista.getText());
                        salario.setHorasMensalista(hm);
                    } else {
                        salario.setHorasMensalista(0);
                    }

                    if (!tfPorcentagem.getText().equals("")) {
                        salario.setPorcentGratifica(Double.parseDouble(tfPorcentagem.getText()));
                    } else {
                        salario.setPorcentGratifica(0);
                    }

                    if (!tfSalarioBase.getText().equals("")) {
                        salario.setSalarioBase(Double.parseDouble(tfSalarioBase.getText()));
                    } else {
                        salario.setSalarioBase(0);
                    }

                    if (!tfValorAjudaCusto.getText().equals("")) {
                        salario.setValAjudaCusto(Double.parseDouble(tfValorAjudaCusto.getText()));
                    } else {
                        salario.setValAjudaCusto(0);
                    }

                    if (!tfValorHoraAula.getText().equals("")) {
                        salario.setValHoraAula(Double.parseDouble(tfValorHoraAula.getText()));
                    } else {
                        salario.setValHoraAula(0);
                    }

                    salario.setTipoRegime(jcbRegime.getSelectedItem().toString());

                    dao.salvar(salario);

                    JOptionPane.showMessageDialog(rootPane, "Salário salvo com sucesso!", "", JOptionPane.INFORMATION_MESSAGE);
                    limpaCampos();
                }
            } else {
                if (tfSalarioBase.getText().equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Informe o Salário!", "", JOptionPane.ERROR_MESSAGE);
                } else if (Double.parseDouble(tfSalarioBase.getText()) <= 0) {
                    JOptionPane.showMessageDialog(rootPane, "Salário deve ser maior que 0!", "", JOptionPane.ERROR_MESSAGE);
                } else {
//                    Salario s = new Salario();
                    salario.setComissao(0);
                    salario.setHorasMensalista(0);
                    salario.setFuncionario(f);
                    salario.setTipoRegime(" ");
                    salario.setPeriodo(Ativo.getPeriodo());
                    salario.setSalarioBase(Double.parseDouble(tfSalarioBase.getText()));
                    SalarioDAO sDAO = new SalarioDAO();
                    sDAO.salvar(salario);
                    JOptionPane.showMessageDialog(rootPane, "Salário salvo com sucesso!", "", JOptionPane.INFORMATION_MESSAGE);
                    limpaCampos();

                }
            }
        } else {

            JOptionPane.showMessageDialog(rootPane, "Informe o Funcionário", "", JOptionPane.INFORMATION_MESSAGE);
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void btRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverActionPerformed
        SalarioDAO dao = new SalarioDAO();
        LotacaoDisciplinaDAO sdDAO = new LotacaoDisciplinaDAO();
        LotacaoDisciplinaHorarioDAO sdhDAO = new LotacaoDisciplinaHorarioDAO();
        for (int i = 0; i < disciplinas.size(); i++) {
            for (int j = 0; j < disciplinas.get(i).getSdh().size(); j++) {
                sdhDAO.remover(disciplinas.get(i).getSdh().get(j));
            }

        }
        for (int i = 0; i < disciplinas.size(); i++) {
            sdDAO.remover(disciplinas.get(i));
        }
        dao.remover(salario);
        limpaCampos();

        JOptionPane.showMessageDialog(rootPane, "Salário Excluído");
    }//GEN-LAST:event_btRemoverActionPerformed

    private String calculoString() {
        DecimalFormat df = new DecimalFormat("#,###.00");
        return df.format(calculo());
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        SalarioDAO dao = new SalarioDAO();
        List<Salario> salarios = (dao.listar());

        SalarioTableModel stm = new SalarioTableModel(salarios);

        Object o = TelaPesquisa.exibeTela(stm, "Salario");
        carregaSalario(o);
        btRemover.setEnabled(true);


    }//GEN-LAST:event_jButton3ActionPerformed

    private void carregaSalario(Object o) {
        if (o != null) {
            SalarioDAO dao = new SalarioDAO();
            salario = new Salario();
            salario = dao.pesquisaId(Integer.valueOf(String.valueOf(o)));
            f = salario.getFuncionario();

            tfFuncionario.setText(salario.getFuncionario().getNome());
            tfSalarioBase.setText(String.valueOf(salario.getSalarioBase()));
//            if (salario.isProfessor()) {
            tfPorcentagem.setText(String.valueOf(salario.getPorcentGratifica()));
            tfValorAjudaCusto.setText(String.valueOf(salario.getValAjudaCusto()));
            tfValorHoraAula.setText(String.valueOf(salario.getValHoraAula()));
            tfComissao.setText(String.valueOf(salario.getComissao()));
            tfPeriodo.setText(salario.getPeriodo().getDescricao());
            jcbRegime.setSelectedItem(salario.getTipoRegime());
            if (salario.getFuncionario().isProfessor()) {
                tfSalarioBase.setEnabled(false);
                pnTelaSalario.setVisible(true);
                setSize(662, 340);
            } else {
                setSize(670, 230);
                tfSalarioBase.setEnabled(true);
            }
            if (salario.getTipoRegime().equals("Mensalista/Horista")) {
                tfSalarioBase.setEnabled(true);
            }

            tfHorasMenslista.setText(String.valueOf(salario.getHorasMensalista()));

//            }
        }
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tfPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPeriodoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPeriodoActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        FuncionarioDAO dao = new FuncionarioDAO();
        List<Funcionario> lista = dao.listar();
        FuncionarioTableModel stm = new FuncionarioTableModel(lista);
        Object o = TelaPesquisa.exibeTela(stm, "Funcionário");

        if (o != null) {
            f = dao.pesquisaId(Integer.valueOf(String.valueOf(o)));
            if (f.isAtivo()) {
                SalarioDAO sDAO = new SalarioDAO();
                Salario s = sDAO.pesquisaFuncionarioPeriodoCadastrado(f, Ativo.getPeriodo());

                if (s != null) {
                    carregaSalario(s.getId());
                } else {
                    salario.setFuncionario(f);
                    tfFuncionario.setText(f.getNome());

                    if (f.isProfessor()) {
                        setSize(662, 340);
                        pnTelaSalario.setVisible(true);
                    } else {
                        tfSalarioBase.setEnabled(true);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Funcionário Não está Ativo!");
            }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        TelaFuncionario tf = new TelaFuncionario();
        tf.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void tfFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfFuncionarioActionPerformed

    private void jcbRegimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbRegimeActionPerformed
        // TODO add your handling code here:
        if (jcbRegime.getSelectedIndex() == 2) {
            tfHorasMenslista.setText("240");
            tfSalarioBase.setEnabled(true);
        } else {
            tfHorasMenslista.setText("0");
            tfHorasMenslista.setEnabled(false);
            tfSalarioBase.setEnabled(false);
            tfSalarioBase.setText("0");
        }

    }//GEN-LAST:event_jcbRegimeActionPerformed

    private boolean containsDisciplina(Disciplina d) {
        for (int i = 0; i < disciplinas.size(); i++) {
            if (disciplinas.get(i).getDisciplina().equals(d)) {
                return true;
            }
        }
        return false;
    }

    private void tfHorasMenslistaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfHorasMenslistaFocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_tfHorasMenslistaFocusLost

    private void tfValorHoraAulaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfValorHoraAulaFocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_tfValorHoraAulaFocusLost

    private void tfValorAjudaCustoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfValorAjudaCustoFocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_tfValorAjudaCustoFocusLost

    private void tfPorcentagemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfPorcentagemFocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_tfPorcentagemFocusLost

    private void tfSalarioBaseFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfSalarioBaseFocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_tfSalarioBaseFocusLost

    private void tfComissaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfComissaoFocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_tfComissaoFocusLost

    public void removeDisciplinas(LotacaoDisciplina salario) {
        int i = -1;
        for (int j = 0; j < disciplinas.size(); j++) {
            if (disciplinas.get(j).getId() == salario.getId()) {
                i = j;
                disciplinasSerExcluidas.add(disciplinas.get(j));
            }
        }
        if (i > -1) {
            disciplinas.remove(i);
        }
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaSalario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaSalario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaSalario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaSalario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaSalario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btRemover;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JComboBox jcbRegime;
    private javax.swing.JPanel pnTelaSalario;
    private javax.swing.JTextField tfComissao;
    private javax.swing.JTextField tfFuncionario;
    private javax.swing.JTextField tfHorasMenslista;
    private javax.swing.JTextField tfPeriodo;
    private javax.swing.JTextField tfPorcentagem;
    private javax.swing.JTextField tfSalarioBase;
    private javax.swing.JTextField tfValorAjudaCusto;
    private javax.swing.JTextField tfValorHoraAula;
    // End of variables declaration//GEN-END:variables
}
