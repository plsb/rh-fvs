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
import javax.swing.JOptionPane;
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
            if(checkExists("codigoPonto", funcionario.getCodigoPonto()).size()>0){
                JOptionPane.showMessageDialog(null, "Código de Ponto Já Cadastrado!");
                return false;
            }
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
    
    public List<Funcionario> pesquisaDescricaoEq(String text) {
        setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());
        
        List <Funcionario> funcionarios = (List<Funcionario>) getSessao().createCriteria(Funcionario.class).
                add(Restrictions.eq("nome", text)).
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
    
    public List<Funcionario> listarProfessorAtivo() {
        List<Funcionario> lista = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            setTransacao(getSessao().beginTransaction());
            lista = this.getSessao().createCriteria(Funcionario.class).
                    add(Restrictions.eq("ativo", true)).
                    add(Restrictions.eq("professor", true)).list();
            //sessao.close();
        } catch (Throwable e) {
            if (getTransacao().isActive()) {
                getTransacao().rollback();
            }
            JOptionPane.showMessageDialog(null, "Não foi possível listar: " + e.getMessage());
        }
        return lista;
    }
    
    public List<Funcionario> listarDigital() {
        List<Funcionario> lista = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            setTransacao(getSessao().beginTransaction());
            lista = this.getSessao().createCriteria(Funcionario.class).add(Restrictions.isNotNull("digital")).list();
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
