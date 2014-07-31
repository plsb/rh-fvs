/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.os.rh.horario;

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
public class HorarioDAO extends GenericDAO<Horario>{

    public HorarioDAO() {
        super(Horario.class);
    }
    
    public List <Horario> pesquisaDescricao(String Descricao){
        setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());
        
        List <Horario> horarios = (List<Horario>) getSessao().createCriteria(Horario.class).
                add(Restrictions.ilike("descricao", Descricao, MatchMode.ANYWHERE)).
                addOrder(Order.asc("descricao")).list();
        
        getSessao().close();
        return horarios;
    }
    
    public Horario pesquisaId(int id){
        setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());
        
        Horario horario = (Horario) getSessao().createCriteria(Horario.class).
                add(Restrictions.eq("id", id)).uniqueResult();
        
        getSessao().close();
        return horario;
    }
    
    public void salvar(Horario h){
        if(h.getId()==0){
            adicionar(h);
        } else {
            atualizar(h);
        }
    }
    
    
}
