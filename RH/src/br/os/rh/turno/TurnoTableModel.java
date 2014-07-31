/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.os.rh.turno;

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

public class TurnoTableModel extends AbstractTableModel{
     private String[] nomeColunas = {"Código", "Descrição"};
    private List<Turno> turnos;

    /**
     * Construtor sobrecarregado.
     *
     * @param lista List(Editora).
     */
    public TurnoTableModel(List<Turno> lista) {
        turnos = new ArrayList(new HashSet(lista));
        this.turnos.clear();
        this.turnos.addAll(lista);
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
        return turnos.size();
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
        Turno turno = turnos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Util.decimalFormat().format(turno.getId());
            case 1:
                return turno.getDescricao();

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
