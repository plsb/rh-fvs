/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.os.rh.salariodisciplinahorario;

import br.os.rh.funcionario.Funcionario;
import br.os.rh.horario.Horario;
import br.os.rh.periodo.Periodo;
import br.os.rh.salario.Salario;
import br.os.rh.salariodiscplinas.SalarioDisciplina;
import br.os.rh.util.GenericDAO;
import br.os.rh.util.HibernateUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author 'Pedro
 */
public class SalarioDisciplinaHorarioDAO extends GenericDAO<SalarioDisciplinaHorario>{

    public SalarioDisciplinaHorarioDAO() {
        super(SalarioDisciplinaHorario.class);
    }

    public void salvar(SalarioDisciplinaHorario get) {
        if(get.getId()==0){
            adicionar(get);
        } else {
            atualizar(get);
        }
    }
    
    public boolean pesquisaChoqueHorario(Funcionario f, Horario h, String ds, Periodo p) {
        setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());
        
        List<Salario> salarios = (List<Salario>) getSessao().createCriteria(Salario.class).
                add(Restrictions.eq("funcionario", f)).
                add(Restrictions.eq("periodo", p)).list();
        
        List<SalarioDisciplina> sdLista = new ArrayList<SalarioDisciplina>( new HashSet(
                getSessao().createCriteria(SalarioDisciplina.class).
                add(Restrictions.in("salario", salarios)).list()));
        
        List<SalarioDisciplinaHorario> sdhLista = (List<SalarioDisciplinaHorario>) getSessao().createCriteria(SalarioDisciplina.class).
                add(Restrictions.in("salarioDisciplina", sdLista)).
                add(Restrictions.eq("horario",h)).
                add(Restrictions.eq("diaSemana", ds)).list();
        
        getSessao().close();
        return sdhLista.size()>0;
    }
    
    
}
