/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.os.rh.funcionario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import sun.security.util.Length;

/**
 *
 * @author JOABB
 */
@Entity
public class Funcionario {
    @Id
    @GeneratedValue
    private int id;
    
    @Column(length = 100,nullable = false)
    private String nome;
    
    @Column(length = 100,nullable=false)
    private String endereco;
    
    @Column(length = 45,nullable = false)
    private String bairro;
    
    @Column(length = 15)
    private String telefone;
    
    @Column(length = 100)
    private String email;
    
}
