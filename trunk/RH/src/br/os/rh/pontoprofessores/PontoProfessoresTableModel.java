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
public class PontoProfessoresTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Professor", "Data", "Entrada", "Saida", "Just. E", "Just. S"};
    private List<PontoProfessores> lPP;

    /**
     * Construtor sobrecarregado.
     *
     * @param lista List(Editora).
     */
    public PontoProfessoresTableModel(List<PontoProfessores> lista) {
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
        PontoProfessores pp = lPP.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Util.decimalFormat().format(pp.getId());
            case 1:
                return pp.getProfessor().getNome();
            case 2:
                return pp.getData();
            case 3:
                return pp.getHoraEntrada();
            case 4:
                return pp.getHoraSaida();
            case 5:
                return pp.getOpcaoJustEntrada();
            case 6:
                return pp.getOpcaoJustSaida();

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
            case 5:
                return nomeColunas[5];
            case 6:
                return nomeColunas[6];
        }
        return null;
    }
}
