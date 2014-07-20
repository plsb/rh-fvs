/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.os.rh.salario;

import br.os.rh.funcionario.Funcionario;
import br.os.rh.periodo.Periodo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author JOABB
 */
@Entity
public class Salario {
    @Id
    @GeneratedValue
    private int id;
    
    @Column(length = 45,nullable = false)
    private double salario;
    
    @Column(length = 45,nullable = false)
    private double porcentGratifica;
    
    @Column(length = 45,nullable = false)
    private double valAjudaCusto;
    
    @Column(length = 45,nullable = false)
    private double salarioBase;
    
    @Column(length = 45,nullable = false)
    private String tipoRegime;
    
    @Column(length = 45,nullable = false)
    private double valHoraAula;
    
    @ManyToMany
    private Periodo periodo;
    
    @ManyToOne
    private Funcionario funcionario;
}
