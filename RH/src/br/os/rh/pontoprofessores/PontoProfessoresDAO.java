/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.os.rh.pontoprofessores;

import br.os.rh.funcionario.Funcionario;
import br.os.rh.periodo.Periodo;
import br.os.rh.util.GenericDAO;
import br.os.rh.util.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author 'Pedro
 */
public class PontoProfessoresDAO extends GenericDAO<PontoProfessores> {

    public PontoProfessoresDAO() {
        super(PontoProfessores.class);
    }

    public PontoProfessores pesquisaPonto(Date data, Funcionario f, Periodo p) {
        setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());
        PontoProfessores ponto = null;
        try {
            ponto = (PontoProfessores) getSessao().createCriteria(PontoProfessores.class).
                    add(Restrictions.eq("data", data)).
                    add(Restrictions.eq("professor", f)).
                    add(Restrictions.eq("periodo", p)).
                    addOrder(Order.asc("horaEntrada"))
                    .uniqueResult();
        } catch (Exception e) {
            ponto = (PontoProfessores) getSessao().createCriteria(PontoProfessores.class).
                    add(Restrictions.eq("data", data)).
                    add(Restrictions.eq("professor", f)).
                    add(Restrictions.eq("periodo", p)).
                    addOrder(Order.asc("horaEntrada"))
                    .list().get(0);
        }

        getSessao().close();
        return ponto;
    }

    public List<PontoProfessores> pesquisaPonto(Date data, Periodo p) {
        setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());
        List<PontoProfessores> ponto = null;

        ponto = (List<PontoProfessores>) getSessao().createCriteria(PontoProfessores.class).
                add(Restrictions.eq("data", data)).
                add(Restrictions.eq("periodo", p)).
                addOrder(Order.asc("horaEntrada"))
                .list();

        getSessao().close();
        return ponto;
    }

    public void salvar(PontoProfessores p) {
        if (p.getId() == 0) {
            adicionar(p);
        } else {
            atualizar(p);
        }
    }

}
