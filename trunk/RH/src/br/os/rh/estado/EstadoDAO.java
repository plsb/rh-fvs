/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.os.rh.estado;

import br.os.rh.util.GenericDAO;
import br.os.rh.util.HibernateUtil;
import java.util.List;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author JOABB
 */
public class EstadoDAO extends GenericDAO<Estado>{
     public EstadoDAO() {
        super(Estado.class);
    }
    public List <Estado> pesquisaDescricao(String Descricao){
        setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());
        
        List <Estado> estados = (List<Estado>) getSessao().createCriteria(Estado.class).
                add(Restrictions.ilike("estado", Descricao, MatchMode.ANYWHERE)).
                addOrder(Order.asc("estado")).list();
        
        getSessao().close();
        return estados;
    }
    
    public Estado pesquisaId(int id){
        setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());
        
        Estado estado = (Estado) getSessao().createCriteria(Estado.class).
                add(Restrictions.eq("id", id)).uniqueResult();
        
        getSessao().close();
        return estado;
    }
    
    public void salvar(Estado e){
        if(e.getId()==0){
            adicionar(e);
        } else {
            atualizar(e);
        }
    }
}
