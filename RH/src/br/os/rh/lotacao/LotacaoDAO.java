/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.os.rh.lotacao;

import br.os.rh.disciplina.Disciplina;
import br.os.rh.disciplina.DisciplinaDAO;
import br.os.rh.funcionario.Funcionario;
import br.os.rh.funcionario.FuncionarioDAO;
import br.os.rh.periodo.Periodo;
import br.os.rh.lotacaodiscplinas.LotacaoDisciplina;
import br.os.rh.lotacaodiscplinas.LotacaoDisciplinaDAO;
import br.os.rh.util.Ativo;
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
public class LotacaoDAO extends GenericDAO<Lotacao> {

    public LotacaoDAO() {
        super(Lotacao.class);
    }

    public void salvar(Lotacao lotacao) {
        if (lotacao.getId() == 0) {
            adicionar(lotacao);
        } else {
            atualizar(lotacao);
        }
    }

    public List<Lotacao> pesquisaFuncionarioPeriodo(Funcionario f, Periodo p) {
        setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());

        List<Lotacao> lotacao = (List<Lotacao>) getSessao().createCriteria(Lotacao.class).
                add(Restrictions.eq("professor", f))
                .add(Restrictions.eq("periodo", p)).list();

        getSessao().close();
        return lotacao;
    }

    public List<Lotacao> pesquisaDisciplinaPeriodo(Disciplina d, Periodo periodo) {
        setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());

        List<Lotacao> lotacoes = (List<Lotacao>) getSessao().createCriteria(Lotacao.class).
                add(Restrictions.eq("periodo", periodo)).list();

        List<LotacaoDisciplina> listaSalaDis = new ArrayList<>();
        if (lotacoes.size() > 0) {
            listaSalaDis = (List<LotacaoDisciplina>) getSessao().createCriteria(LotacaoDisciplina.class).
                    add(Restrictions.in("lotacao", lotacoes)).
                    add(Restrictions.eq("disciplina", d)).list();
        }

        List<Lotacao> lotacaoReturn = new ArrayList<Lotacao>();
        for (int i = 0; i < listaSalaDis.size(); i++) {
            lotacaoReturn.add(listaSalaDis.get(i).getLotacao());
        }

        getSessao().close();
        return lotacaoReturn;
    }

    public List<Lotacao> listarPorCoordenador() {
        
        setSessao(HibernateUtil.getSessionFactory().openSession());
        setTransacao(getSessao().beginTransaction());

        LotacaoDisciplinaDAO sdDAO = new LotacaoDisciplinaDAO();
        List<LotacaoDisciplina> lSalDisc = new ArrayList(new HashSet(sdDAO.pesquisaPorCurso()));

        List<Integer> lIds = new ArrayList<>();
        for (LotacaoDisciplina s : lSalDisc) {
            lIds.add(s.getLotacao().getId());
        }

        List<Lotacao> lotacoes = (List<Lotacao>) getSessao().createCriteria(Lotacao.class).
                add(Restrictions.in("id", lIds))
                .add(Restrictions.eq("periodo", Ativo.getPeriodo())).list();

        getSessao().close();
        return lotacoes;
    }

    

}
