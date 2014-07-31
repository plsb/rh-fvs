/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.os.rh.horario;

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

public class HorarioTableModel extends AbstractTableModel{
     private String[] nomeColunas = {"Código", "Descrição", "Turno"};
    private List<Horario> horarios;

    /**
     * Construtor sobrecarregado.
     *
     * @param lista List(Editora).
     */
    public HorarioTableModel(List<Horario> lista) {
        horarios = new ArrayList(new HashSet(lista));
        this.horarios.clear();
        this.horarios.addAll(lista);
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
        return horarios.size();
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
        Horario horario = horarios.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Util.decimalFormat().format(horario.getId());
            case 1:
                return horario.getDescricao();
            case 2:
                return horario.getTurno().getDescricao();

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
        }
        return null;
    }
}
