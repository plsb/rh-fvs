/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.os.rh.salario;

import br.os.rh.util.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.swing.table.AbstractTableModel;



/**
 *
 * @author JOABB
 */

public class SalarioTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Funcionario", "Período", "É Professor?"};
    private List<Salario> salarios;

    /**
     * Construtor sobrecarregado.
     *
     * @param lista List(Editora).
     */
    public SalarioTableModel(List<Salario> lista) {
        salarios = new ArrayList(new HashSet(lista));
        this.salarios.clear();
        this.salarios.addAll(lista);
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
        return salarios.size();
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
        Salario func = salarios.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Util.decimalFormat().format(func.getId());
            case 1:
                return func.getFuncionario().getNome();
            case 2:
                return func.getPeriodoTexto();
            case 3:
                return func.getFuncionario().isProfessoString();
           
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
            
        }
        return null;
    }
}
