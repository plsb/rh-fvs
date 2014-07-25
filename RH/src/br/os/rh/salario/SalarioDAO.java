/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.os.rh.salario;

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
public class SalarioDAO extends GenericDAO<Salario>{
     public SalarioDAO() {
        super(Salario.class);
    }
    public List <Salario> pesquisaFuncionario(String Descricao){
        setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());
        
        List <Salario> salarios = (List<Salario>) getSessao().createCriteria(Salario.class).
                add(Restrictions.ilike("Salario", Descricao, MatchMode.ANYWHERE)).
                addOrder(Order.asc("Salario")).list();
        
        getSessao().close();
        return salarios;
    }
    
    public Salario pesquisaId(int id){
        setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());
        
        Salario salario = (Salario) getSessao().createCriteria(Salario.class).
                add(Restrictions.eq("id", id)).uniqueResult();
        
        getSessao().close();
        return salario;
    }
    
    public void salvar(Salario s){
        if(s.getId()==0){
            adicionar(s);
        } else {
            atualizar(s);
        }
    }
}
