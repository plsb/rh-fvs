/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.os.rh.usuario;

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
public class UsuarioTableModel extends AbstractTableModel{
    private String[] nomeColunas = {"Código", "Nome", "Login", "Tipo"};
    private List<Usuario> usuarios;

    /**
     * Construtor sobrecarregado.
     *
     * @param lista List(Editora).
     */
    public UsuarioTableModel(List<Usuario> lista) {
        usuarios = new ArrayList(new HashSet(lista));
        this.usuarios.clear();
        this.usuarios.addAll(lista);
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
        return usuarios.size();
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
        Usuario usuario = usuarios.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Util.decimalFormat().format(usuario.getId());
            case 1:
                return usuario.getNome();
            case 2:
                return usuario.getLogin();
            case 3:
                return usuario.getTipo();

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
