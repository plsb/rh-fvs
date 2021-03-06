/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.os.rh.semestre;

import br.os.rh.curso.Curso;
import br.os.rh.curso.CursoDAO;
import br.os.rh.disciplina.Disciplina;
import br.os.rh.util.GenericDAO;
import br.os.rh.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author 'Pedro
 */
public class SemestreDAO extends GenericDAO<Semestre> {

    public SemestreDAO() {
        super(Semestre.class);
    }

    public Semestre pesquisaId(Integer id) {
        setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());

        Semestre semestre = (Semestre) getSessao().createCriteria(Semestre.class).
                add(Restrictions.eq("id", id)).uniqueResult();

        getSessao().close();
        return semestre;
    }

    public List<Semestre> pesquisaDescricao(String text) {
        setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());

        List<Semestre> semestre = (List<Semestre>) getSessao().createCriteria(Semestre.class).
                add(Restrictions.eq("descricao", text)).uniqueResult();

        getSessao().close();
        return semestre;
    }

    public void salvar(Semestre semestre) {
        if (semestre.getId() == 0) {
            adicionar(semestre);
        } else {
            atualizar(semestre);
        }
    }
    
    public List<Semestre> listarPorCurso() {
        List<Semestre> lista = null;
        
        
        CursoDAO cDAO = new CursoDAO();
        
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            setTransacao(getSessao().beginTransaction());
            lista = this.getSessao().createCriteria(Semestre.class).add(Restrictions.in("curso", 
                    cDAO.pesquisaCursosCoordenadores())).list();
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
