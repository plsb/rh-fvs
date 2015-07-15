/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.eventoitem;

import br.edu.evento.Evento;
import br.os.rh.util.GenericDAO;
import br.os.rh.util.HibernateUtil;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author 'Pedro
 */
public class EventoItemDAO extends GenericDAO<EventoItem>{

    public EventoItemDAO() {
        super(EventoItem.class);
    }
    
    public List<EventoItem> listarItensEvento(Evento evento){
         List<EventoItem> lista = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            setTransacao(getSessao().beginTransaction());
            lista = this.getSessao().createCriteria(EventoItem.class).
                    add(Restrictions.eq("evento", evento)).list();
            //sessao.close();
        } catch (Throwable e) {
            if (getTransacao().isActive()) {
                getTransacao().rollback();
            }
            JOptionPane.showMessageDialog(null, "Não foi possível listar: " + e.getMessage());
        }
        return lista;
    }
    
}
