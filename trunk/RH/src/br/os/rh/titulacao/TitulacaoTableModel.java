/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.os.rh.titulacao;

import br.os.rh.util.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author JOABB
 */
@SuppressWarnings("serial")
public class TitulacaoTableModel extends AbstractTableModel{
    private String[] nomeColunas = {"Código", "Descrição"};
    private List<Titulacao> titulacoes;

    /**
     * Construtor sobrecarregado.
     *
     * @param lista List(Editora).
     */
    public TitulacaoTableModel(List<Titulacao> lista) {
        titulacoes = new ArrayList(new HashSet(lista));
        this.titulacoes.clear();
        this.titulacoes.addAll(lista);
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
        return titulacoes.size();
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
        Titulacao titulacao = titulacoes.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Util.decimalFormat().format(titulacao.getId());
            case 1:
                return titulacao.getDescricao();

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
