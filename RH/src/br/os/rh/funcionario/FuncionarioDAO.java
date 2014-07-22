/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.os.rh.funcionario;

import br.os.rh.cidade.Cidade;
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
public class FuncionarioDAO extends GenericDAO<Funcionario>{

    public FuncionarioDAO() {
        super(Funcionario.class);
    }
    
    public boolean salvar(Funcionario funcionario){
        if(funcionario.getId()==0){
            funcionario.setAtivo(true);
            adicionar(funcionario);
        } else {
            atualizar(funcionario);
        }
        return true;
    }

    public List<Funcionario> pesquisaDescricao(String text) {
        setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());
        
        List <Funcionario> funcionarios = (List<Funcionario>) getSessao().createCriteria(Funcionario.class).
                add(Restrictions.ilike("nome", text, MatchMode.ANYWHERE)).
                addOrder(Order.asc("nome")).list();
        
        getSessao().close();
        return funcionarios;
    }

    public Funcionario pesquisaId(Integer id) {
        setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());
        
        Funcionario funcionario = (Funcionario) getSessao().createCriteria(Funcionario.class).
                add(Restrictions.eq("id", id)).uniqueResult();
        
        getSessao().close();
        return funcionario;
    }
    
    
}
