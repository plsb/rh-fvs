/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.os.rh.lotacaodisciplinahorario;

import br.os.rh.horario.Horario;
import br.os.rh.lotacaodiscplinas.LotacaoDisciplina;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author 'Pedro
 */
@Entity
public class LotacaoDisciplinaHorario {
    
    @Id
    @GeneratedValue
    private int id;
    
    @ManyToOne
    private LotacaoDisciplina salarioDisciplina;
    
    @ManyToOne
    private Horario horario;
    
    private String diaSemana;
    
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
     * @return the salarioDisciplina
     */
    public LotacaoDisciplina getSalarioDisciplina() {
        return salarioDisciplina;
    }

    /**
     * @param salarioDisciplina the salarioDisciplina to set
     */
    public void setSalarioDisciplina(LotacaoDisciplina salarioDisciplina) {
        this.salarioDisciplina = salarioDisciplina;
    }

    /**
     * @return the horario
     */
    public Horario getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    /**
     * @return the diaSemana
     */
    public String getDiaSemana() {
        return diaSemana;
    }

    /**
     * @param diaSemana the diaSemana to set
     */
    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.salarioDisciplina);
        hash = 59 * hash + Objects.hashCode(this.horario);
        hash = 59 * hash + Objects.hashCode(this.diaSemana);
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
        final LotacaoDisciplinaHorario other = (LotacaoDisciplinaHorario) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.salarioDisciplina, other.salarioDisciplina)) {
            return false;
        }
        if (!Objects.equals(this.horario, other.horario)) {
            return false;
        }
        if (!Objects.equals(this.diaSemana, other.diaSemana)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "{" + horario.getDescricao() + ", "+ horario.getTurno().getDescricao()+"," + diaSemana + "}";
    }

}
