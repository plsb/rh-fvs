/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.os.rh.horario;

import br.os.rh.turno.Turno;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author 'Pedro
 */
@Entity
public class Horario {
    
    @Id
    @GeneratedValue
    private int id;
    
    private String descricao;
    
    @ManyToOne
    private Turno turno;
    
    private int qtdHora;
    
    @Temporal(TemporalType.TIME)
    private Date horaInicial;
    
    @Temporal(TemporalType.TIME)
    private Date horaFinal;

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
     * @return the turno
     */
    public Turno getTurno() {
        return turno;
    }

    /**
     * @param turno the turno to set
     */
    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "{"+descricao+", "+turno.getDescricao()+"}";
    }    

    public int getQtdHora() {
        return qtdHora;
    }

    public void setQtdHora(int qtdHora) {
        this.qtdHora = qtdHora;
    }

    public Date getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(Date horaInicial) {
        this.horaInicial = horaInicial;
    }

    public Date getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Date horaFinal) {
        this.horaFinal = horaFinal;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + this.id;
        hash = 13 * hash + Objects.hashCode(this.descricao);
        hash = 13 * hash + Objects.hashCode(this.turno);
        hash = 13 * hash + this.qtdHora;
        hash = 13 * hash + Objects.hashCode(this.horaInicial);
        hash = 13 * hash + Objects.hashCode(this.horaFinal);
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
        final Horario other = (Horario) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.turno, other.turno)) {
            return false;
        }
        if (this.qtdHora != other.qtdHora) {
            return false;
        }
        if (!Objects.equals(this.horaInicial, other.horaInicial)) {
            return false;
        }
        if (!Objects.equals(this.horaFinal, other.horaFinal)) {
            return false;
        }
        return true;
    }
    
    
}
