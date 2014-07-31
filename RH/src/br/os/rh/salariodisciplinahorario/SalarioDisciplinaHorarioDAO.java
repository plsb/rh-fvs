/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.os.rh.salariodisciplinahorario;

import br.os.rh.util.GenericDAO;

/**
 *
 * @author 'Pedro
 */
public class SalarioDisciplinaHorarioDAO extends GenericDAO<SalarioDisciplinaHorario>{

    public SalarioDisciplinaHorarioDAO() {
        super(SalarioDisciplinaHorario.class);
    }

    public void salvar(SalarioDisciplinaHorario get) {
        if(get.getId()==0){
            adicionar(get);
        } else {
            atualizar(get);
        }
    }
    
    
}
