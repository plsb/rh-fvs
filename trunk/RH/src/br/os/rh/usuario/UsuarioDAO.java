/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.os.rh.usuario;

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
public class UsuarioDAO extends GenericDAO<Usuario>{
     public UsuarioDAO(){
        super(Usuario.class);
    }
     
     public boolean  autentica(Usuario usu){
         setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());
        
        Usuario usuario = (Usuario) getSessao().createCriteria(Usuario.class).
                add(Restrictions.eq("login", usu.getLogin())).
                add(Restrictions.eq("senha", usu.getSenha())).uniqueResult();
        
        getSessao().close();
        return usuario!=null;
     }
    
    public List <Usuario> pesquisaDescricao(String Login){
        setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());
        
        List <Usuario> usuarios = (List<Usuario>) getSessao().createCriteria(Usuario.class).
                add(Restrictions.ilike("login", Login, MatchMode.ANYWHERE)).
                addOrder(Order.asc("login")).list();
        
        getSessao().close();
        return usuarios;
        
    }
    
    public List <Usuario> pesquisaDescricaoEq(String Login){
        setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());
        
        List <Usuario> usuarios = (List<Usuario>) getSessao().createCriteria(Usuario.class).
                add(Restrictions.eq("login", Login)).
                addOrder(Order.asc("login")).list();
        
        getSessao().close();
        return usuarios;
        
    }
    
    public Usuario pesquisaId(int id){
        setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());
        
        Usuario usuario = (Usuario) getSessao().createCriteria(Usuario.class).
                add(Restrictions.eq("id", id)).uniqueResult();
        
        getSessao().close();
        return usuario;
    }
    
    public void salvar(Usuario u){
        if(u.getId()==0){
            adicionar(u);
        } else {
            atualizar(u);
        }
    }
    
    public List<Usuario> listarCoordenador() {
        List<Usuario> lista = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            setTransacao(getSessao().beginTransaction());
            lista = this.getSessao().createCriteria(Usuario.class).add(Restrictions.eq("tipo", "Coordenador de Curso")).list();
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
