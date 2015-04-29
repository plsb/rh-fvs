/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.os.rh.pontoprofessores;

import br.os.rh.funcionario.Funcionario;
import br.os.rh.lotacaodisciplinahorario.LotacaoDisciplinaHorario;
import br.os.rh.periodo.Periodo;
import br.os.rh.turno.Turno;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
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
public class PontoProfessores {
    
    @Id
    @GeneratedValue
    private int id;
    
    @ManyToOne
    private Funcionario professor;
      
    @Temporal(TemporalType.DATE)
    private Date data;
    
    @Temporal(TemporalType.TIME)
    private Date horaEntrada;
    
    @Temporal(TemporalType.TIME)
    private Date horaSaida;
    
    @ManyToOne
    private Periodo periodo;
    
    @Column(length = 2000)
    private String justEntrada;
    
    @Column(length = 2000)
    private String justSaida;
    
    @ManyToOne
    private Turno turno;
    
    private boolean email;

    public String getOpcaoJustEntrada(){
        if(justEntrada.equals("") | justEntrada.equals(" ")){
            return " ";
        } 
        return "Sim";
    }
    
    public String getOpcaoJustSaida(){
        if(justSaida.equals("") | justSaida.equals(" ")){
            return " ";
        } 
        return "Sim";
    }
    
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Date getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(Date horaSaida) {
        this.horaSaida = horaSaida;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public String getJustEntrada() {
        return justEntrada;
    }

    public void setJustEntrada(String justEntrada) {
        this.justEntrada = justEntrada;
    }

    public String getJustSaida() {
        return justSaida;
    }

    public void setJustSaida(String justSaida) {
        this.justSaida = justSaida;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.id;
        hash = 41 * hash + Objects.hashCode(this.professor);
        hash = 41 * hash + Objects.hashCode(this.data);
        hash = 41 * hash + Objects.hashCode(this.horaEntrada);
        hash = 41 * hash + Objects.hashCode(this.horaSaida);
        hash = 41 * hash + Objects.hashCode(this.periodo);
        hash = 41 * hash + Objects.hashCode(this.justEntrada);
        hash = 41 * hash + Objects.hashCode(this.justSaida);
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
        final PontoProfessores other = (PontoProfessores) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.professor, other.professor)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.horaEntrada, other.horaEntrada)) {
            return false;
        }
        if (!Objects.equals(this.horaSaida, other.horaSaida)) {
            return false;
        }
        if (!Objects.equals(this.periodo, other.periodo)) {
            return false;
        }
        if (!Objects.equals(this.justEntrada, other.justEntrada)) {
            return false;
        }
        if (!Objects.equals(this.justSaida, other.justSaida)) {
            return false;
        }
        return true;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public boolean isEmail() {
        return email;
    }

    public void setEmail(boolean email) {
        this.email = email;
    }
    
    

}
