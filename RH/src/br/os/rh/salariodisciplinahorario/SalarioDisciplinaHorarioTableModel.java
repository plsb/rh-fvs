/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.os.rh.salariodisciplinahorario;

import br.os.rh.salariodiscplinas.*;
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
public class SalarioDisciplinaHorarioTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Horario", "Dia Semana"};
    private List<SalarioDisciplinaHorario> sdh;

    /**
     * Construtor sobrecarregado.
     *
     * @param lista List(Editora).
     */
    public SalarioDisciplinaHorarioTableModel(List<SalarioDisciplinaHorario> lista) {
        sdh = new ArrayList(new HashSet(lista));
        this.sdh.clear();
        this.sdh.addAll(lista);
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
        return sdh.size();
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
        SalarioDisciplinaHorario s = sdh.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Util.decimalFormat().format(s.getId());
            case 1:
                return s.getHorario().getDescricao();
            case 2:
                return s.getDiaSemana();

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
