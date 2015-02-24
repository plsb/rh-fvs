/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.os.rh.disciplina;

import br.os.rh.curso.CursoDAO;
import br.os.rh.semestre.Semestre;
import br.os.rh.semestre.SemestreDAO;
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
    
    public List<Disciplina> listarPorCurso() {
        List<Disciplina> lista = null;
        
        
        SemestreDAO sDAO = new SemestreDAO();
        
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            setTransacao(getSessao().beginTransaction());
            lista = this.getSessao().createCriteria(Disciplina.class).add(Restrictions.in("semestre", 
                    sDAO.listarPorCurso())).list();
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
