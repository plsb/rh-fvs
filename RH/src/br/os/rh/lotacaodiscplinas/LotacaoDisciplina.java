/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.os.rh.lotacaodiscplinas;

import br.os.rh.lotacao.Lotacao;
import br.os.rh.disciplina.Disciplina;
import br.os.rh.horario.Horario;
import br.os.rh.salario.Salario;
import br.os.rh.lotacaodisciplinahorario.LotacaoDisciplinaHorario;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author 'Pedro
 */
@Entity
public class LotacaoDisciplina {

    @Id
    @GeneratedValue
    private int id;
 
    @ManyToOne
    private Lotacao lotacao;

    @ManyToOne
    private Disciplina disciplina;
    
    @Temporal(TemporalType.DATE)
    private Date dataFinalDisciplina;

    public Date getDataFinalDisciplina() {
        return dataFinalDisciplina;
    }

    public void setDataFinalDisciplina(Date dataFinalDisciplina) {
        this.dataFinalDisciplina = dataFinalDisciplina;
    }    

    @OneToMany(mappedBy = "salarioDisciplina", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<LotacaoDisciplinaHorario> sdh;
    /**
             * @return the id
             */

    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the disciplina
     */
    public Disciplina getDisciplina() {
        return disciplina;
    }

    /**
     * @param disciplina the disciplina to set
     */
    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    /**
     * @return the sdh
     */
    public List<LotacaoDisciplinaHorario> getSdh() {
        return sdh;
    }

    /**
     * @param sdh the sdh to set
     */
    public void setSdh(List<LotacaoDisciplinaHorario> sdh) {
        this.sdh = sdh;
    }

    public Lotacao getLotacao() {
        return lotacao;
    }

    public void setLotacao(Lotacao lotacao) {
        this.lotacao = lotacao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.lotacao);
        hash = 97 * hash + Objects.hashCode(this.disciplina);
        hash = 97 * hash + Objects.hashCode(this.sdh);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LotacaoDisciplina other = (LotacaoDisciplina) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.lotacao, other.lotacao)) {
            return false;
        }
        if (!Objects.equals(this.disciplina, other.disciplina)) {
            return false;
        }
        if (!Objects.equals(this.sdh, other.sdh)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SalarioDisciplina{" + "id=" + id + ", lotacao=" + lotacao + ", disciplina=" + disciplina + ", sdh=" + sdh + '}';
    }

}
