/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.os.rh.salariodiscplinas;

import br.os.rh.disciplina.Disciplina;
import br.os.rh.horario.Horario;
import br.os.rh.salario.Salario;
import br.os.rh.salariodisciplinahorario.SalarioDisciplinaHorario;
import java.util.Collection;
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

    @OneToMany(mappedBy = "salarioDisciplina", fetch = FetchType.EAGER)
    private List<SalarioDisciplinaHorario> sdh;
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

    /**
     * @return the sdh
     */
    public List<SalarioDisciplinaHorario> getSdh() {
        return sdh;
    }

    /**
     * @param sdh the sdh to set
     */
    public void setSdh(List<SalarioDisciplinaHorario> sdh) {
        this.sdh = sdh;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.salario);
        hash = 37 * hash + Objects.hashCode(this.disciplina);
        hash = 37 * hash + Objects.hashCode(this.sdh);
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
        if (!Objects.equals(this.sdh, other.sdh)) {
            return false;
        }
        return true;
    }

     
    
   

}
