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
import br.os.rh.salariodisciplinahorario.SalarioDisciplinaHorarioDAO;
import br.os.rh.salariodiscplinas.SalarioDisciplina;
import br.os.rh.salariodiscplinas.SalarioDisciplinaDAO;
import br.os.rh.salariodiscplinas.SalarioDisciplinaTableModel;
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
    private List<SalarioDisciplina> disciplinas;

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

        return Calculo.calculoHorista(disciplinas, vHoraAula, ajudaCusto, porcentagem,
                horasMensalista, Double.parseDouble(tfSalario.getText()));
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
        tbDisciplinas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        FormataTamanhoColunasJTable.packColumns(tbDisciplinas, 1);

    }

    private void calculaHorasMostraJLabel() {
        double horas = 0;
        for (int i = 0; i < disciplinas.size(); i++) {
            horas += disciplinas.get(i).getDisciplina().getHoras();
        }
        lblHoras.setText(String.valueOf(horas) + " horas");
    }

    private void preencheTabelaDisciplinas() {
        SalarioDisciplinaTableModel dtm = new SalarioDisciplinaTableModel(disciplinas);
        tbDisciplinas.setModel(dtm);
        calculaHorasMostraJLabel();
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
        chbProfessor = new javax.swing.JCheckBox();
        pnTelaSalario = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jcbRegime = new javax.swing.JComboBox();
        tfValorHoraAula = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfPeriodo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        tfPorcentagem = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDisciplinas = new javax.swing.JTable();
        jButton9 = new javax.swing.JButton();
        tfValorAjudaCusto = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        lblHoras = new javax.swing.JLabel();
        lblSalarioBruto = new javax.swing.JLabel();
        tfHorasMenslista = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btRemover = new javax.swing.JButton();
        tfSalario = new javax.swing.JTextField();
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

        chbProfessor.setBackground(new java.awt.Color(255, 255, 255));
        chbProfessor.setText("Professor");
        chbProfessor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        chbProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbProfessorActionPerformed(evt);
            }
        });
        jPanel5.add(chbProfessor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

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

        jButton2.setText("...");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        pnTelaSalario.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 35, -1));

        jButton6.setText("+");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        pnTelaSalario.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, -1, -1));

        tfPorcentagem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfPorcentagemFocusLost(evt);
            }
        });
        pnTelaSalario.add(tfPorcentagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 93, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Gratificação (%):");
        pnTelaSalario.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Disciplinas:*");
        pnTelaSalario.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 110, -1, -1));

        tbDisciplinas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbDisciplinas);

        pnTelaSalario.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 131, 550, 111));

        jButton9.setText("...");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        pnTelaSalario.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, 35, -1));

        tfValorAjudaCusto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfValorAjudaCustoFocusLost(evt);
            }
        });
        pnTelaSalario.add(tfValorAjudaCusto, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 32, 140, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Valor Ajuda de Custo:");
        pnTelaSalario.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 16, -1, 10));

        lblHoras.setText("000 horas");
        pnTelaSalario.add(lblHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 200, 70, -1));

        lblSalarioBruto.setText("R$ 0,00");
        pnTelaSalario.add(lblSalarioBruto, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 220, 80, -1));

        tfHorasMenslista.setEnabled(false);
        tfHorasMenslista.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfHorasMenslistaFocusLost(evt);
            }
        });
        pnTelaSalario.add(tfHorasMenslista, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 32, 93, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Horas Mensalista:");
        pnTelaSalario.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 16, -1, 10));

        jPanel5.add(pnTelaSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 660, 260));

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

        tfSalario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfSalarioFocusLost(evt);
            }
        });
        jPanel5.add(tfSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 220, -1));

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
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void limpaCampos() {
        tfHorasMenslista.setText("");
        tfHorasMenslista.setEnabled(false);
        tfSalario.setEnabled(true);
        tfFuncionario.setText("");
        tfSalario.setText("");
        tfValorAjudaCusto.setText("");
        tfValorHoraAula.setText("");
        tfPeriodo.setText("");
        tfPorcentagem.setText("");
        chbProfessor.setSelected(false);
        pnTelaSalario.setEnabled(false);
        salario = new Salario();
        disciplinas = new ArrayList<SalarioDisciplina>();
        pnTelaSalario.setVisible(false);
        setSize(670, 230);
        preencheTabelaDisciplinas();

        jcbRegime.setSelectedIndex(0);
        setLocationRelativeTo(null);
        btRemover.setEnabled(false);

    }
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        limpaCampos();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void salvar() {
        SalarioDAO dao = new SalarioDAO();
        if (!tfSalario.getText().equals("")) {
            salario.setSalario(Double.parseDouble(tfSalario.getText()));
        }
        salario.setPorcentGratifica(Double.parseDouble(tfPorcentagem.getText()));
        salario.setValAjudaCusto(Double.parseDouble(tfValorAjudaCusto.getText()));
        salario.setValHoraAula(Double.parseDouble(tfValorHoraAula.getText()));
        salario.setTipoRegime(jcbRegime.getSelectedItem().toString());
        salario.setProfessor(chbProfessor.isSelected());
        if (!tfHorasMenslista.getText().equals("")) {
            salario.setHorasMensalista(Integer.parseInt(tfHorasMenslista.getText()));
        }
        dao.salvar(salario);
        for (int i = 0; i < disciplinas.size(); i++) {
            SalarioDisciplinaDAO sDAO = new SalarioDisciplinaDAO();
            disciplinas.get(i).setSalario(salario);
            sDAO.salvar(disciplinas.get(i));

        }
        for (int i = 0; i < disciplinas.size(); i++) {
            for (int j = 0; j < disciplinas.get(i).getSdh().size(); j++) {
                SalarioDisciplinaHorarioDAO sdhDAO = new SalarioDisciplinaHorarioDAO();
                disciplinas.get(i).getSdh().get(j).setSalarioDisciplina(disciplinas.get(i));
                sdhDAO.salvar(disciplinas.get(i).getSdh().get(j));
            }

        }
        JOptionPane.showMessageDialog(rootPane, "Salario cadastro com sucesso!");
        limpaCampos();

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        SalarioDAO dao = new SalarioDAO();
        Salario salarioCadastrado = dao.pesquisaFuncionarioPeriodoCadastrado(salario.getFuncionario(),
                (chbProfessor.isSelected() ? salario.getPeriodo() : null));
        if (salarioCadastrado != null && salario.getId() == 0) {
            if (JOptionPane.showConfirmDialog(rootPane, "Já existe um salário cadastrado nessas condições, \n"
                    + "deseja alterar?", "OSRH", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE)
                    == JOptionPane.YES_OPTION) {
                carregaSalario(salarioCadastrado.getId());
            }
        } else if (chbProfessor.isSelected()) {
            if (Util.chkVazio(tfFuncionario.getText(),
                    tfValorHoraAula.getText(),
                    tfPeriodo.getText())) {
                if (jcbRegime.getSelectedIndex() == 2 && tfHorasMenslista.getText().equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Informe a Qtd. Horas Mensalista!");
                } else if (jcbRegime.getSelectedIndex() != 0) {
                    if (disciplinas.size() != 0) {
                        salvar();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Informe as disciplinas do Professor!");
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Informe o Tipo de Regime!");
                }

            }
        } else {
            if (Util.chkVazio(tfFuncionario.getText(), tfSalario.getText())) {

                salario.setSalario(Double.parseDouble(tfSalario.getText()));
                dao.salvar(salario);
                JOptionPane.showMessageDialog(rootPane, "Salario cadastro com sucesso!");
                limpaCampos();

            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverActionPerformed
        SalarioDAO dao = new SalarioDAO();
        SalarioDisciplinaDAO sdDAO = new SalarioDisciplinaDAO();
        SalarioDisciplinaHorarioDAO sdhDAO = new SalarioDisciplinaHorarioDAO();
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
        List<Salario> salarios = (!tfFuncionario.getText().isEmpty() ? dao.pesquisaFuncionario(salario.getFuncionario())
                : dao.listar());

        SalarioTableModel stm = new SalarioTableModel(salarios);

        Object o = TelaPesquisa.exibeTela(stm, "Salario");
        carregaSalario(o);

        lblSalarioBruto.setText("R$ " + calculoString());

    }//GEN-LAST:event_jButton3ActionPerformed

    private void carregaSalario(Object o) {
        if (o != null) {
            SalarioDAO dao = new SalarioDAO();
            salario = new Salario();
            salario = dao.pesquisaId(Integer.valueOf(String.valueOf(o)));

            tfFuncionario.setText(salario.getFuncionario().getNome());
            tfSalario.setText(String.valueOf(salario.getSalario()));
            if (salario.isProfessor()) {
                tfPorcentagem.setText(String.valueOf(salario.getPorcentGratifica()));
                tfValorAjudaCusto.setText(String.valueOf(salario.getValAjudaCusto()));
                tfValorHoraAula.setText(String.valueOf(salario.getValHoraAula()));
                tfPeriodo.setText(salario.getPeriodo().getDescricao());
                jcbRegime.setSelectedItem(salario.getTipoRegime());
                if(salario.getTipoRegime().equals("Horista")){
                    tfSalario.setEnabled(false);
                }
                SalarioDisciplinaDAO sdDAO = new SalarioDisciplinaDAO();
                disciplinas = new ArrayList<>(new HashSet(sdDAO.pesquisaSalario(salario)));//salario.getDisciplinas();
                chbProfessor.setSelected(salario.isProfessor());
                chbProfessorActionPerformed(null);
                preencheTabelaDisciplinas();
                tfHorasMenslista.setText(String.valueOf(salario.getHorasMensalista()));

            }

            btRemover.setEnabled(true);
        }
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tfPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPeriodoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPeriodoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        PeriodoDAO dao = new PeriodoDAO();
        List<Periodo> lista = dao.listar();
        PeriodoTableModel ptm = new PeriodoTableModel(lista);
        Object o = TelaPesquisa.exibeTela(ptm, "Periodo");
        Periodo p;
        if (o != null) {
            p = dao.pesquisaId(Integer.valueOf(String.valueOf(o)));
            salario.setPeriodo(p);
            tfPeriodo.setText(p.getDescricao());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        TelaPeriodo tp = new TelaPeriodo();
        tp.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        FuncionarioDAO dao = new FuncionarioDAO();
        List<Funcionario> lista = dao.listar();
        FuncionarioTableModel stm = new FuncionarioTableModel(lista);
        Object o = TelaPesquisa.exibeTela(stm, "Funcionário");
        Funcionario f;
        if (o != null) {
            f = dao.pesquisaId(Integer.valueOf(String.valueOf(o)));
            if (f.isAtivo()) {
                salario.setFuncionario(f);
                tfFuncionario.setText(f.getNome());
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

    private void chbProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbProfessorActionPerformed
        // TODO add your handling code here:
        if (chbProfessor.isSelected()) {
            pnTelaSalario.setVisible(true);
            setSize(670, 470);
//            tfSalario.setEnabled(false);
        } else {
            pnTelaSalario.setVisible(false);
            setSize(670, 230);
//            tfSalario.setEnabled(true);
        }
        setLocationRelativeTo(null);

    }//GEN-LAST:event_chbProfessorActionPerformed

    private void jcbRegimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbRegimeActionPerformed
        // TODO add your handling code here:
        if (jcbRegime.getSelectedIndex() == 2) {
            tfHorasMenslista.setText("240");
//            tfSalario.setEnabled(true);
        } else {
            tfHorasMenslista.setText("0");
            tfHorasMenslista.setEnabled(false);
//            tfSalario.setEnabled(false);
            tfSalario.setText("0");
        }
        lblSalarioBruto.setText("R$ " + calculoString());
    }//GEN-LAST:event_jcbRegimeActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        if (tfPeriodo.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o Período!");
        } else if (tfFuncionario.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o Funcionário!");
        } else {
            DisciplinaDAO dao = new DisciplinaDAO();
//            List<Disciplina> lista = dao.listar();
//            DisciplinaTableModel ptm = new DisciplinaTableModel(lista);
//            Object o = TelaPesquisa.exibeTela(ptm, "Disciplina");
            Disciplina d = new Disciplina();
            SalarioDisciplina sd = new SalarioDisciplina();
            sd = TelaSalarioDisciplina.chamaTela(disciplinas);

            if (sd != null) {
//                d = sd.getDisciplina();
                d = dao.pesquisaId(Integer.valueOf(String.valueOf(sd.getDisciplina().getId())));
                if (!containsDisciplina(d)) {
                    SalarioDAO sDAO = new SalarioDAO();
                    List<Salario> retorno = sDAO.pesquisaDisciplinaPeriodo(d, salario.getPeriodo());
                    if (retorno.size() > 0) {
                        if (JOptionPane.showConfirmDialog(rootPane, "Disciplina cadastrada para outros professores \n"
                                + " no período indicado, deseja continuar?"
                                + retorno.toString(), "OSRH", JOptionPane.YES_NO_OPTION,
                                JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION) {
                            //SalarioDisciplina sd = new SalarioDisciplina();
//                            sd.setDisciplina(d);
                            disciplinas.add(sd);
                            preencheTabelaDisciplinas();
                        }
                    } else {
//                        SalarioDisciplina sd = new SalarioDisciplina();
//                        sd.setDisciplina(d);
                        disciplinas.add(sd);
                        preencheTabelaDisciplinas();
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Esta disciplina já está na lista!");
                }
            }
        }
        lblSalarioBruto.setText("R$ " + String.valueOf(calculo()));
    }//GEN-LAST:event_jButton9ActionPerformed

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
        lblSalarioBruto.setText("R$ " + calculoString());
    }//GEN-LAST:event_tfHorasMenslistaFocusLost

    private void tfValorHoraAulaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfValorHoraAulaFocusLost
        // TODO add your handling code here:
        lblSalarioBruto.setText("R$ " + calculoString());
    }//GEN-LAST:event_tfValorHoraAulaFocusLost

    private void tfValorAjudaCustoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfValorAjudaCustoFocusLost
        // TODO add your handling code here:
        lblSalarioBruto.setText("R$ " + calculoString());
    }//GEN-LAST:event_tfValorAjudaCustoFocusLost

    private void tfPorcentagemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfPorcentagemFocusLost
        // TODO add your handling code here:
        lblSalarioBruto.setText("R$ " + calculoString());
    }//GEN-LAST:event_tfPorcentagemFocusLost

    private void tfSalarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfSalarioFocusLost
        // TODO add your handling code here:
        lblSalarioBruto.setText("R$ " + calculoString());
    }//GEN-LAST:event_tfSalarioFocusLost

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
    private javax.swing.JCheckBox chbProfessor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jcbRegime;
    private javax.swing.JLabel lblHoras;
    private javax.swing.JLabel lblSalarioBruto;
    private javax.swing.JPanel pnTelaSalario;
    private javax.swing.JTable tbDisciplinas;
    private javax.swing.JTextField tfFuncionario;
    private javax.swing.JTextField tfHorasMenslista;
    private javax.swing.JTextField tfPeriodo;
    private javax.swing.JTextField tfPorcentagem;
    private javax.swing.JTextField tfSalario;
    private javax.swing.JTextField tfValorAjudaCusto;
    private javax.swing.JTextField tfValorHoraAula;
    // End of variables declaration//GEN-END:variables
}
