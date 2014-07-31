/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.os.rh.periodo;


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
public class PeriodoDAO extends GenericDAO<Periodo>{
     public PeriodoDAO() {
        super(Periodo.class);
    }
    public List <Periodo> pesquisaDescricao(String Descricao){
        setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());
        
        List <Periodo> periodos = (List<Periodo>) getSessao().createCriteria(Periodo.class).
                add(Restrictions.ilike("descricao", Descricao, MatchMode.ANYWHERE)).
                addOrder(Order.asc("descricao")).list();
        
        getSessao().close();
        return periodos;
    }
    
    public Periodo pesquisaId(int id){
        setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());
        
        Periodo periodo = (Periodo) getSessao().createCriteria(Periodo.class).
                add(Restrictions.eq("id", id)).uniqueResult();
        
        getSessao().close();
        return periodo;
    }
    
    public void salvar(Periodo p){
        if(p.getId()==0){
            adicionar(p);
        } else {
            atualizar(p);
        }
    }
}
