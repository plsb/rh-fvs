/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.os.rh.funcionario;

import br.os.rh.estado.*;
import br.os.rh.util.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author JOABB
 */
public class FuncionarioTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Nome", "Titulação", "Cidade", "Ativo"};
    private List<Funcionario> funcionarios;

    /**
     * Construtor sobrecarregado.
     *
     * @param lista List(Editora).
     */
    public FuncionarioTableModel(List<Funcionario> lista) {
        funcionarios = new ArrayList(new HashSet(lista));
        this.funcionarios.clear();
        this.funcionarios.addAll(lista);
        //Collections.sort(cursos);
        super.fireTableDataChanged();
    }

    /**
     * Método sobrescrito.
     *
     * @return int.
     */
    @Override
    public int getRowCount() {
        return funcionarios.size();
    }

    /**
     * Método sobrescrito.
     *
     * @return int.
     */
    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }

    /**
     * Método sobrescrito.
     *
     * @param rowIndex int
     * @param columnIndex int.
     * @return Object.
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Funcionario func = funcionarios.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Util.decimalFormat().format(func.getId());
            case 1:
                return func.getNome();
            case 2:
                return func.getTitulacao().getDescricao();
            case 3:
                return func.getCidade().getDescricao() + " - " + func.getCidade().getEstado().getDescricao();
            case 4:
                return func.isAtivoString();

        }
        return null;
    }

    /**
     * Método sobrescrito.
     *
     * @param column int.
     * @return String nomeColunas[index].
     */
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return nomeColunas[0];
            case 1:
                return nomeColunas[1];
            case 2:
                return nomeColunas[2];
            case 3:
                return nomeColunas[3];
            case 4:
                return nomeColunas[4];
        }
        return null;
    }
}
