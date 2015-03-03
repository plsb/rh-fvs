/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.os.rh.lotacao;

import br.os.rh.horario.*;
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
public class LotacaoTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Professor", "Período"};
    private List<Lotacao> lotacoes;

    /**
     * Construtor sobrecarregado.
     *
     * @param lista List(Editora).
     */
    public LotacaoTableModel(List<Lotacao> lista) {
        lotacoes = new ArrayList(new HashSet(lista));
        this.lotacoes.clear();
        this.lotacoes.addAll(lista);
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
        return lotacoes.size();
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
        Lotacao lotacao = lotacoes.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Util.decimalFormat().format(lotacao.getId());
            case 1:
                return lotacao.getProfessor().getNome();
            case 2:
                return lotacao.getPeriodo().getDescricao();
            
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
