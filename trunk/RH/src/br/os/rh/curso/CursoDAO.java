/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.os.rh.curso;

import br.os.rh.util.Ativo;
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
public class CursoDAO extends GenericDAO<Curso>{

    public CursoDAO() {
        super(Curso.class);
    }
    public List <Curso> pesquisaDescricao(String Descricao){
        setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());
        
        List <Curso> cursos = (List<Curso>) getSessao().createCriteria(Curso.class).
                add(Restrictions.ilike("descricao", Descricao, MatchMode.ANYWHERE)).
                addOrder(Order.asc("descricao")).list();
        
        getSessao().close();
        return cursos;
    }
    
    public List <Curso> pesquisaCursosCoordenadores(){
        setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());
        
        List <Curso> cursos = (List<Curso>) getSessao().createCriteria(Curso.class).
                add(Restrictions.eq("coordenador", Ativo.getUsuario())).
                addOrder(Order.asc("descricao")).list();
        
        getSessao().close();
        return cursos;
    }
    
    public Curso pesquisaId(int id){
        setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());
        
        Curso curso = (Curso) getSessao().createCriteria(Curso.class).
                add(Restrictions.eq("id", id)).uniqueResult();
        
        getSessao().close();
        return curso;
    }
    
    public void salvar(Curso c){
        if(c.getId()==0){
            adicionar(c);
        } else {
            atualizar(c);
        }
    }
}
