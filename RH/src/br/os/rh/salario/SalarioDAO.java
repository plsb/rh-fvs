/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.os.rh.salario;

import br.os.rh.disciplina.Disciplina;
import br.os.rh.funcionario.Funcionario;
import br.os.rh.periodo.Periodo;
import br.os.rh.lotacaodiscplinas.LotacaoDisciplina;
import br.os.rh.util.Ativo;
import br.os.rh.util.GenericDAO;
import br.os.rh.util.HibernateUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author JOABB
 */
public class SalarioDAO extends GenericDAO<Salario> {

    public SalarioDAO() {
        super(Salario.class);
    }

    public List<Salario> pesquisaFuncionario(Funcionario funcionario) {
        setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());

        List<Salario> salarios = (List<Salario>) getSessao().createCriteria(Salario.class).
                add(Restrictions.eq("funcionario", funcionario)).list();

        getSessao().close();
        return salarios;
    }

    public Salario pesquisaId(int id) {
        setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());

        Salario salario = (Salario) getSessao().createCriteria(Salario.class).
                add(Restrictions.eq("id", id)).uniqueResult();

        getSessao().close();
        return salario;
    }
    
    public List<Salario> pesquisaPeriodo(Periodo p) {
        setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());

        List<Salario> salario = (List<Salario>) getSessao().createCriteria(Salario.class).
                add(Restrictions.eq("periodo", p)).list();
        
        //        getSessao().close();
        return salario;
    }

    public List<Salario> pesquisaDisciplinaPeriodo(Disciplina d, Periodo p) {
        setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());

        List<Salario> salarios = (List<Salario>) getSessao().createCriteria(Salario.class).
                add(Restrictions.eq("periodo", p)).list();

        List<LotacaoDisciplina> listaSalaDis = new ArrayList<>();
        if (salarios.size() > 0) {
             listaSalaDis = (List<LotacaoDisciplina>) getSessao().createCriteria(LotacaoDisciplina.class).
                    add(Restrictions.in("salario", salarios)).
                    add(Restrictions.eq("disciplina", d)).list();
        }

        List<Salario> salarioReturn = new ArrayList<Salario>();
        for (int i = 0; i < listaSalaDis.size(); i++) {
//            salarioReturn.add(listaSalaDis.get(i).getSalario());
        }

        getSessao().close();
        return salarioReturn;
    }

    public Salario pesquisaFuncionarioPeriodoCadastrado(Funcionario func,
            Periodo peri) {
        setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());
        Salario salario;
        if (peri != null) {
            salario = (Salario) getSessao().createCriteria(Salario.class).
                    add(Restrictions.eq("funcionario", func)).
                    add(Restrictions.eq("periodo", peri)).uniqueResult();
        } else {
            salario = (Salario) getSessao().createCriteria(Salario.class).
                    add(Restrictions.eq("funcionario", func)).
                    uniqueResult();
        }

        getSessao().close();
        return salario;
    }

    public void salvar(Salario s) {
        if (s.getId() == 0) {
            adicionar(s);
        } else {
            atualizar(s);
        }
    }
    
    public List<Salario> listar() {
        List<Salario> lista = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            setTransacao(getSessao().beginTransaction());
            lista = this.getSessao().createCriteria(Salario.class).add(Restrictions.eq("periodo", Ativo.getPeriodo())).list();
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
