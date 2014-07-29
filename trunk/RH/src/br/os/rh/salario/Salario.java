/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.os.rh.salario;

import br.os.rh.funcionario.Funcionario;
import br.os.rh.periodo.Periodo;
import br.os.rh.salariodiscplinas.SalarioDisciplina;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author JOABB
 */
@Entity
public class Salario {

    @Id
    @GeneratedValue
    private int id;

    @Column(length = 45)
    private double salario;

    @Column(length = 45)
    private double porcentGratifica;

    @Column(length = 45)
    private double valAjudaCusto;

    @Column(length = 45)
    private double salarioBase;

    @Column(length = 45)
    private String tipoRegime;

    @Column(length = 45)
    private double valHoraAula;

    @ManyToOne
    private Periodo periodo;

    @ManyToOne
    private Funcionario funcionario;

    private boolean professor;

    @OneToMany(mappedBy = "salario")
    private List<SalarioDisciplina> disciplinas;
    
    private int horasMensalista;

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
    public double getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    /**
     * @return the porcentGratifica
     */
    public double getPorcentGratifica() {
        return porcentGratifica;
    }

    /**
     * @param porcentGratifica the porcentGratifica to set
     */
    public void setPorcentGratifica(double porcentGratifica) {
        this.porcentGratifica = porcentGratifica;
    }

    /**
     * @return the valAjudaCusto
     */
    public double getValAjudaCusto() {
        return valAjudaCusto;
    }

    /**
     * @param valAjudaCusto the valAjudaCusto to set
     */
    public void setValAjudaCusto(double valAjudaCusto) {
        this.valAjudaCusto = valAjudaCusto;
    }

    /**
     * @return the salarioBase
     */
    public double getSalarioBase() {
        return salarioBase;
    }

    /**
     * @param salarioBase the salarioBase to set
     */
    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    /**
     * @return the tipoRegime
     */
    public String getTipoRegime() {
        return tipoRegime;
    }

    /**
     * @param tipoRegime the tipoRegime to set
     */
    public void setTipoRegime(String tipoRegime) {
        this.tipoRegime = tipoRegime;
    }

    /**
     * @return the valHoraAula
     */
    public double getValHoraAula() {
        return valHoraAula;
    }

    /**
     * @param valHoraAula the valHoraAula to set
     */
    public void setValHoraAula(double valHoraAula) {
        this.valHoraAula = valHoraAula;
    }

    /**
     * @return the periodo
     */
    public Periodo getPeriodo() {
        return periodo;
    }
    
    public String getPeriodoTexto() {
        if(periodo==null){
            return " -- ";
        } else {
            return periodo.getDescricao();
        }
        
    }

    /**
     * @param periodo the periodo to set
     */
    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    /**
     * @return the funcionario
     */
    public Funcionario getFuncionario() {
        return funcionario;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    /**
     * @return the professor
     */
    public boolean isProfessor() {
        return professor;
    }

    /**
     * @param professor the professor to set
     */
    public void setProfessor(boolean professor) {
        this.professor = professor;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + this.id;
        hash = 31 * hash + (int) (Double.doubleToLongBits(this.salario) ^ (Double.doubleToLongBits(this.salario) >>> 32));
        hash = 31 * hash + (int) (Double.doubleToLongBits(this.porcentGratifica) ^ (Double.doubleToLongBits(this.porcentGratifica) >>> 32));
        hash = 31 * hash + (int) (Double.doubleToLongBits(this.valAjudaCusto) ^ (Double.doubleToLongBits(this.valAjudaCusto) >>> 32));
        hash = 31 * hash + (int) (Double.doubleToLongBits(this.salarioBase) ^ (Double.doubleToLongBits(this.salarioBase) >>> 32));
        hash = 31 * hash + Objects.hashCode(this.tipoRegime);
        hash = 31 * hash + (int) (Double.doubleToLongBits(this.valHoraAula) ^ (Double.doubleToLongBits(this.valHoraAula) >>> 32));
        hash = 31 * hash + Objects.hashCode(this.periodo);
        hash = 31 * hash + Objects.hashCode(this.funcionario);
        hash = 31 * hash + (this.professor ? 1 : 0);
        hash = 31 * hash + Objects.hashCode(this.disciplinas);
        hash = 31 * hash + this.horasMensalista;
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
        final Salario other = (Salario) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.salario) != Double.doubleToLongBits(other.salario)) {
            return false;
        }
        if (Double.doubleToLongBits(this.porcentGratifica) != Double.doubleToLongBits(other.porcentGratifica)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valAjudaCusto) != Double.doubleToLongBits(other.valAjudaCusto)) {
            return false;
        }
        if (Double.doubleToLongBits(this.salarioBase) != Double.doubleToLongBits(other.salarioBase)) {
            return false;
        }
        if (!Objects.equals(this.tipoRegime, other.tipoRegime)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valHoraAula) != Double.doubleToLongBits(other.valHoraAula)) {
            return false;
        }
        if (!Objects.equals(this.periodo, other.periodo)) {
            return false;
        }
        if (!Objects.equals(this.funcionario, other.funcionario)) {
            return false;
        }
        if (this.professor != other.professor) {
            return false;
        }
        if (!Objects.equals(this.disciplinas, other.disciplinas)) {
            return false;
        }
        if (this.horasMensalista != other.horasMensalista) {
            return false;
        }
        return true;
    }

    

    
    

    @Override
    public String toString() {
        return funcionario.getNome()+ ", " +periodo.getDescricao();
    }

    /**
     * @return the disciplinas
     */
    public List<SalarioDisciplina> getDisciplinas() {
        return disciplinas;
    }

    /**
     * @param disciplinas the disciplinas to set
     */
    public void setDisciplinas(List<SalarioDisciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    /**
     * @return the horasMensalista
     */
    public int getHorasMensalista() {
        return horasMensalista;
    }

    /**
     * @param horasMensalista the horasMensalista to set
     */
    public void setHorasMensalista(int horasMensalista) {
        this.horasMensalista = horasMensalista;
    }

}
