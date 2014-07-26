/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.os.rh.salariodiscplinas;

import br.os.rh.disciplina.Disciplina;
import br.os.rh.salario.Salario;
import br.os.rh.util.GenericDAO;
import br.os.rh.util.HibernateUtil;
import java.util.List;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author 'Pedro
 */
public class SalarioDisciplinaDAO extends GenericDAO<SalarioDisciplina>{

    public SalarioDisciplinaDAO() {
        super(SalarioDisciplina.class);
    }

    public void salvar(SalarioDisciplina salDisc) {
        if(salDisc.getId()==0){
            adicionar(salDisc);
        } else {
            atualizar(salDisc);
        }
    }

    public SalarioDisciplina pesquisaId(Integer id) {
        setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());
        
        SalarioDisciplina disciplina = (SalarioDisciplina) getSessao().createCriteria(SalarioDisciplina.class).
                add(Restrictions.eq("id", id)).uniqueResult();
        
        getSessao().close();
        return disciplina;
    }
    
    public List<SalarioDisciplina> pesquisaSalario(Salario salario) {
        setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());
        
        List<SalarioDisciplina> disciplinas = (List<SalarioDisciplina>) getSessao().createCriteria(SalarioDisciplina.class).
                add(Restrictions.eq("salario", salario)).list();
        
        getSessao().close();
        return disciplinas;
    }
    
    
}
