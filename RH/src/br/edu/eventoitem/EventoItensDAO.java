/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.eventoitem;

import br.os.rh.util.GenericDAO;

/**
 *
 * @author 'Pedro
 */
public class EventoItensDAO extends GenericDAO<EventoItem>{

    public EventoItensDAO() {
        super(EventoItem.class);
    }
    
}
