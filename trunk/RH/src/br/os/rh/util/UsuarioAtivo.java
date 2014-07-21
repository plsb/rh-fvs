/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.os.rh.util;

import br.os.rh.usuario.Usuario;

/**
 *
 * @author 'Pedro
 */
public class UsuarioAtivo {
    
    private static Usuario usuario;

    /**
     * @return the usuario
     */
    public static Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param aUsuario the usuario to set
     */
    public static void setUsuario(Usuario aUsuario) {
        usuario = aUsuario;
    }

  
    
    
}
