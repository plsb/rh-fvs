/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.os.rh.lotacao;

import br.os.rh.funcionario.Funcionario;
import br.os.rh.periodo.Periodo;
import br.os.rh.lotacaodiscplinas.LotacaoDisciplina;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author 'Pedro
 */
@Entity
public class Lotacao {
    
    @Id
    @GeneratedValue
    private int id;
    
    @ManyToOne
    private Funcionario professor;
    
    @ManyToOne
    private Periodo periodo;
    
    @OneToMany(mappedBy = "lotacao")    
    private List<LotacaoDisciplina> disciplinas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Funcionario getProfessor() {
        return professor;
    }

    public void setProfessor(Funcionario professor) {
        this.professor = professor;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.id;
        hash = 79 * hash + Objects.hashCode(this.professor);
        hash = 79 * hash + Objects.hashCode(this.periodo);
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
        final Lotacao other = (Lotacao) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.professor, other.professor)) {
            return false;
        }
        if (!Objects.equals(this.periodo, other.periodo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return professor.getNome();
    }
    
    
    
    
    
}
