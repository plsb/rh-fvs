/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.os.rh.periodo;


import br.os.rh.util.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author JOABB
 */

public class PeriodoTableModel extends AbstractTableModel{
    private String[] nomeColunas = {"Código", "Descrição"};
    private List<Periodo> periodos;

    /**
     * Construtor sobrecarregado.
     *
     * @param lista List(Editora).
     */
    public PeriodoTableModel(List<Periodo> lista) {
        periodos = new ArrayList(new HashSet(lista));
        this.periodos.clear();
        this.periodos.addAll(lista);
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
        return periodos.size();
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
        Periodo periodo = periodos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Util.decimalFormat().format(periodo.getId());
            case 1:
                return periodo.getDescricao();

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
        }
        return null;
    }
}
