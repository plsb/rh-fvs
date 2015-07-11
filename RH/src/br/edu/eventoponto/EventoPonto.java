/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.eventoponto;

import br.edu.eventoitem.EventoItem;
import br.os.rh.funcionario.Funcionario;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class EventoPonto {
    
    @Id
    @GeneratedValue
    private int codigo;
    
    @ManyToOne
    private Funcionario funcionario;
    
    @ManyToOne
    private EventoItem item;
    
    @Temporal(TemporalType.DATE)
    private Date data;
    
    @Temporal(TemporalType.TIME)
    private Date hora;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public EventoItem getItem() {
        return item;
    }

    public void setItem(EventoItem item) {
        this.item = item;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.codigo;
        hash = 97 * hash + Objects.hashCode(this.funcionario);
        hash = 97 * hash + Objects.hashCode(this.item);
        hash = 97 * hash + Objects.hashCode(this.data);
        hash = 97 * hash + Objects.hashCode(this.hora);
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
        final EventoPonto other = (EventoPonto) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.funcionario, other.funcionario)) {
            return false;
        }
        if (!Objects.equals(this.item, other.item)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.hora, other.hora)) {
            return false;
        }
        return true;
    }
            
}
