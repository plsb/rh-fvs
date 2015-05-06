/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.feriado;

import br.os.rh.util.Ativo;
import br.os.rh.util.GenericDAO;
import br.os.rh.util.HibernateUtil;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author 'Pedro
 */
public class FeriadoDAO extends GenericDAO<Feriado> {

    public FeriadoDAO() {
        super(Feriado.class);
    }

    public void salvar(Feriado feriado) {
        if (feriado.getId() == 0) {
            adicionar(feriado);
        } else {
            atualizar(feriado);
        }
    }

    public List<Feriado> listar() {
        List<Feriado> retorno = null;
        try {
            setSessao(HibernateUtil.getSessionFactory().openSession());
            retorno = getSessao().createCriteria(Feriado.class).
                    add(Restrictions.eq("periodo", Ativo.getPeriodo())).list();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            getSessao().close();
        }

        return retorno;
    }
}
