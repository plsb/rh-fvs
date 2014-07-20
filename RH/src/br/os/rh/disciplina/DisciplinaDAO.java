/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.os.rh.disciplina;

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
public class DisciplinaDAO extends GenericDAO<Disciplina>{

    public DisciplinaDAO() {
        super(Disciplina.class);
    }
    public List <Disciplina> pesquisaDescricao(String Descricao){
        setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());
        
        List <Disciplina> disciplinas = (List<Disciplina>) getSessao().createCriteria(Disciplina.class).
                add(Restrictions.ilike("descricao", Descricao, MatchMode.ANYWHERE)).
                addOrder(Order.asc("descricao")).list();
        
        getSessao().close();
        return disciplinas;
    }
    
    public Disciplina pesquisaId(int id){
        setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());
        
        Disciplina disciplina = (Disciplina) getSessao().createCriteria(Disciplina.class).
                add(Restrictions.eq("id", id)).uniqueResult();
        
        getSessao().close();
        return disciplina;
    }
    
    public void salvar(Disciplina d){
        if(d.getId()==0){
            adicionar(d);
        } else {
            atualizar(d);
        }
    }
}
