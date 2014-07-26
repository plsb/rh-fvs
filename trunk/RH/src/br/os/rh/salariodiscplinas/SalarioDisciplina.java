/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.os.rh.salariodiscplinas;

import br.os.rh.disciplina.Disciplina;
import br.os.rh.salario.Salario;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author 'Pedro
 */
@Entity
public class SalarioDisciplina {
    
    @Id
    @GeneratedValue
    private int id;
    
    @ManyToOne
    private Salario salario;
    
    @ManyToOne
    private Disciplina disciplina;

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
     * @return the salario
     */
    public Salario getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(Salario salario) {
        this.salario = salario;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.id;
        hash = 71 * hash + Objects.hashCode(this.salario);
        hash = 71 * hash + Objects.hashCode(this.disciplina);
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
        final SalarioDisciplina other = (SalarioDisciplina) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.salario, other.salario)) {
            return false;
        }
        if (!Objects.equals(this.disciplina, other.disciplina)) {
            return false;
        }
        return true;
    }
    
    
    
}
