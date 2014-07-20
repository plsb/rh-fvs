/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.os.rh.cidade;

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
public class CidadeDAO extends GenericDAO<Cidade>{
   
    public CidadeDAO() {
        super(Cidade.class);
    }
    public List <Cidade> pesquisaDescricao(String Descricao){
        setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());
        
        List <Cidade> cidades = (List<Cidade>) getSessao().createCriteria(Cidade.class).
                add(Restrictions.ilike("descricao", Descricao, MatchMode.ANYWHERE)).
                addOrder(Order.asc("descricao")).list();
        
        getSessao().close();
        return cidades;
    }
    
    public Cidade pesquisaId(int id){
        setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());
        
        Cidade cidade = (Cidade) getSessao().createCriteria(Cidade.class).
                add(Restrictions.eq("id", id)).uniqueResult();
        
        getSessao().close();
        return cidade;
    }
    
    public void salvar(Cidade cid){
        if(cid.getId()==0){
            adicionar(cid);
        } else {
            atualizar(cid);
        }
    }
    
}
