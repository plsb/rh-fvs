/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.os.rh.salariodiscplinas;

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
public class SalarioDisciplinaTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Descrição", "Hora/Aula", "Semestre", "Curso"};
    private List<SalarioDisciplina> disciplinas;

    /**
     * Construtor sobrecarregado.
     *
     * @param lista List(Editora).
     */
    public SalarioDisciplinaTableModel(List<SalarioDisciplina> lista) {
        disciplinas = new ArrayList(new HashSet(lista));
        this.disciplinas.clear();
        this.disciplinas.addAll(lista);
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
        return disciplinas.size();
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
        SalarioDisciplina disciplina = disciplinas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Util.decimalFormat().format(disciplina.getId());
            case 1:
                return disciplina.getDisciplina().getDescricao();
            case 2:
                return disciplina.getDisciplina().getHoras();
            case 3:
                return disciplina.getDisciplina().getSemestre().getDescricao();
            case 4:
                return disciplina.getDisciplina().getSemestre().getCurso().getDescricao();

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
