/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.os.rh.disciplina;

import br.os.rh.curso.Curso;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author JOABB
 */
@Entity
public class Disciplina {
    @Id
    @GeneratedValue
    private int id;
    
    @Column (length = 45, nullable = false)
    private String descricao;
    
    private int horas;
    
    @ManyToOne
    private Curso curso;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.descricao);
        hash = 59 * hash + this.horas;
        hash = 59 * hash + Objects.hashCode(this.curso);
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
        final Disciplina other = (Disciplina) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (this.horas != other.horas) {
            return false;
        }
        if (!Objects.equals(this.curso, other.curso)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Disciplina{" + "id=" + id + ", descricao=" + descricao + ", horas=" + horas + ", curso=" + curso + '}';
    }

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
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the horas
     */
    public int getHoras() {
        return horas;
    }

    /**
     * @param horas the horas to set
     */
    public void setHoras(int horas) {
        this.horas = horas;
    }

    /**
     * @return the curso
     */
    public Curso getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
}
