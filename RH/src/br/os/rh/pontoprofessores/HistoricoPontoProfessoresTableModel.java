/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.os.rh.pontoprofessores;

import br.os.rh.periodo.*;
import br.os.rh.util.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author JOABB
 */
public class HistoricoPontoProfessoresTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Histórico"};
    private List<String> lPP;

    /**
     * Construtor sobrecarregado.
     *
     * @param lista List(Editora).
     */
    public HistoricoPontoProfessoresTableModel(List<String> lista) {
        lPP = new ArrayList(new HashSet(lista));
        this.lPP.clear();
        this.lPP.addAll(lista);
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
        return lPP.size();
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
        String pp = lPP.get(rowIndex);
        switch (columnIndex) {
            case 0:
               return pp;
                
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
            
        }
        return null;
    }
}
