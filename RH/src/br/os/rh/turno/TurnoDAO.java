/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.os.rh.turno;

import br.os.rh.estado.Estado;
import br.os.rh.util.GenericDAO;
import br.os.rh.util.HibernateUtil;
import java.util.List;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author 'Pedro
 */
public class TurnoDAO extends GenericDAO<Turno>{

    public TurnoDAO() {
        super(Turno.class);
    }
    
    public List <Turno> pesquisaDescricao(String Descricao){
        setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());
        
        List <Turno> turnos = (List<Turno>) getSessao().createCriteria(Turno.class).
                add(Restrictions.ilike("descricao", Descricao, MatchMode.ANYWHERE)).
                addOrder(Order.asc("descricao")).list();
        
        getSessao().close();
        return turnos;
    }
    
    public Turno pesquisaId(int id){
        setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());
        
        Turno turno = (Turno) getSessao().createCriteria(Turno.class).
                add(Restrictions.eq("id", id)).uniqueResult();
        
        getSessao().close();
        return turno;
    }
    
    public void salvar(Turno t){
        if(t.getId()==0){
            adicionar(t);
        } else {
            atualizar(t);
        }
    }
    
    
}
