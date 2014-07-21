/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.os.rh.semestre;

import br.os.rh.disciplina.*;
import br.os.rh.curso.Curso;
import br.os.rh.util.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author JOABB
 */
public class SemestreTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Descrição", "Curso"};
    private List<Semestre> semestres;

    /**
     * Construtor sobrecarregado.
     *
     * @param lista List(Editora).
     */
    public SemestreTableModel(List<Semestre> lista) {
        semestres = new ArrayList(new HashSet(lista));
        this.semestres.clear();
        this.semestres.addAll(lista);
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
        return semestres.size();
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
        Semestre semestre = semestres.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Util.decimalFormat().format(semestre.getId());
            case 1:
                return semestre.getDescricao();
            case 2:
                return semestre.getCurso().getDescricao();

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
