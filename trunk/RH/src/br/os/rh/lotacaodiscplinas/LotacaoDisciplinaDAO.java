/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.os.rh.lotacaodiscplinas;

import br.os.rh.disciplina.Disciplina;
import br.os.rh.disciplina.DisciplinaDAO;
import br.os.rh.lotacao.Lotacao;
import br.os.rh.salario.Salario;
import br.os.rh.util.GenericDAO;
import br.os.rh.util.HibernateUtil;
import java.util.List;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author 'Pedro
 */
public class LotacaoDisciplinaDAO extends GenericDAO<LotacaoDisciplina>{

    public LotacaoDisciplinaDAO() {
        super(LotacaoDisciplina.class);
    }

    public void salvar(LotacaoDisciplina salDisc) {
        if(salDisc.getId()==0){
            adicionar(salDisc);
        } else {
            atualizar(salDisc);
        }
    }

    public LotacaoDisciplina pesquisaId(Integer id) {
        setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());
        
        LotacaoDisciplina disciplina = (LotacaoDisciplina) getSessao().createCriteria(LotacaoDisciplina.class).
                add(Restrictions.eq("id", id)).uniqueResult();
        
        getSessao().close();
        return disciplina;
    }
    
    public List<LotacaoDisciplina> pesquisaSalario(Salario salario) {
        setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());
        
        List<LotacaoDisciplina> disciplinas = (List<LotacaoDisciplina>) getSessao().createCriteria(LotacaoDisciplina.class).
                add(Restrictions.eq("salario", salario)).list();
        
        getSessao().close();
        return disciplinas;
    }
    
    public List<LotacaoDisciplina> pesquisaLotacao(Lotacao lotacao) {
        setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());
        
        List<LotacaoDisciplina> disciplinas = (List<LotacaoDisciplina>) getSessao().createCriteria(LotacaoDisciplina.class).
                add(Restrictions.eq("lotacao", lotacao)).list();
        
        getSessao().close();
        return disciplinas;
    }
    
    public List<LotacaoDisciplina> pesquisaPorCurso() {
        setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());
        
        DisciplinaDAO dDAO = new DisciplinaDAO();
        List<Disciplina> disciplinas  = dDAO.listarPorCurso();
        
        List<LotacaoDisciplina> sDisciplinas = (List<LotacaoDisciplina>) getSessao().createCriteria(LotacaoDisciplina.class).
                add(Restrictions.in("disciplina", disciplinas)).list();
        
        getSessao().close();
        return sDisciplinas;
    }
    
    
}
