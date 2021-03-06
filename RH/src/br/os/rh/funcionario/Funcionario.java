/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.os.rh.funcionario;

import br.os.rh.cidade.Cidade;
import br.os.rh.titulacao.Titulacao;
import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPTemplate;
import java.util.Arrays;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.swing.ImageIcon;
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

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(length = 100, nullable = false)
    private String endereco;

    @Column(length = 45, nullable = false)
    private String bairro;

    @Column(length = 15)
    private String telefone;

    @Column(length = 100)
    private String email;

    @ManyToOne
    private Cidade cidade;

    private byte[] digital;

    @ManyToOne
    private Titulacao titulacao;

    private boolean ativo;

    private boolean professor;

    private int codigoPonto;

    private String caminhoFoto;

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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the cidade
     */
    public Cidade getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the titulacao
     */
    public Titulacao getTitulacao() {
        return titulacao;
    }

    /**
     * @param titulacao the titulacao to set
     */
    public void setTitulacao(Titulacao titulacao) {
        this.titulacao = titulacao;
    }

    /**
     * @return the ativo
     */
    public String isAtivoString() {
        if (ativo == true) {
            return "Sim";
        }
        return "Não";
    }

    public boolean isAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public boolean isProfessor() {
        return professor;
    }

    public void setProfessor(boolean professor) {
        this.professor = professor;
    }

    public String isProfessoString() {
        if (professor == true) {
            return "Sim";
        }
        return "Não";
    }

    public int getCodigoPonto() {
        return codigoPonto;
    }

    public void setCodigoPonto(int codigoPonto) {
        this.codigoPonto = codigoPonto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.nome);
        hash = 59 * hash + Objects.hashCode(this.endereco);
        hash = 59 * hash + Objects.hashCode(this.bairro);
        hash = 59 * hash + Objects.hashCode(this.telefone);
        hash = 59 * hash + Objects.hashCode(this.email);
        hash = 59 * hash + Objects.hashCode(this.cidade);
        hash = 59 * hash + Arrays.hashCode(this.digital);
        hash = 59 * hash + Objects.hashCode(this.titulacao);
        hash = 59 * hash + (this.ativo ? 1 : 0);
        hash = 59 * hash + (this.professor ? 1 : 0);
        hash = 59 * hash + this.codigoPonto;
        hash = 59 * hash + Objects.hashCode(this.caminhoFoto);
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
        final Funcionario other = (Funcionario) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Arrays.equals(this.digital, other.digital)) {
            return false;
        }
        if (!Objects.equals(this.titulacao, other.titulacao)) {
            return false;
        }
        if (this.ativo != other.ativo) {
            return false;
        }
        if (this.professor != other.professor) {
            return false;
        }
        if (this.codigoPonto != other.codigoPonto) {
            return false;
        }
        if (!Objects.equals(this.caminhoFoto, other.caminhoFoto)) {
            return false;
        }
        return true;
    }

    public String getCaminhoFoto() {
        return caminhoFoto;
    }

    public void setCaminhoFoto(String caminhoFoto) {
        this.caminhoFoto = caminhoFoto;
    }

    public ImageIcon getFotoAsImageIcon() {

        ImageIcon fotoEspecie = new ImageIcon();

        if (this.getCaminhoFoto() != null) {
            fotoEspecie = new ImageIcon(this.getCaminhoFoto());
        }

        return fotoEspecie;
    }

    public DPFPTemplate getDigital() {
        return DPFPGlobal.getTemplateFactory().createTemplate(this.digital);
    }

    public void setDigital(DPFPTemplate digital) {
        this.digital = digital.serialize();
    }
}
