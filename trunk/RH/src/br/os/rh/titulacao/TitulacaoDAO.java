/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.os.rh.titulacao;


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
public class TitulacaoDAO extends GenericDAO<Titulacao>{
    public TitulacaoDAO(){
        super(Titulacao.class);
    }
    
    public List <Titulacao> pesquisaDescricao(String Descricao){
        setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());
        
        List <Titulacao> titulacoes = (List<Titulacao>) getSessao().createCriteria(Titulacao.class).
                add(Restrictions.ilike("titulacao", Descricao, MatchMode.ANYWHERE)).
                addOrder(Order.asc("titulacao")).list();
        
        getSessao().close();
        return titulacoes;
    }
    
    public Titulacao pesquisaId(int id){
        setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());
        
        Titulacao titulacao = (Titulacao) getSessao().createCriteria(Titulacao.class).
                add(Restrictions.eq("id", id)).uniqueResult();
        
        getSessao().close();
        return titulacao;
    }
    
    public void salvar(Titulacao t){
        if(t.getId()==0){
            adicionar(t);
        } else {
            atualizar(t);
        }
    }
}
