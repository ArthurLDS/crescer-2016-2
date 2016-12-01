/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula4;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Arthur
 */
@Entity
@Table(name = "CLASSIFICACAO")
public class Classificacao implements Serializable{
     @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CLASSIFICACAO")
    @SequenceGenerator(name = "SEQ_CLASSIFICACAO", sequenceName = "SEQ_CLASSIFICACAO", allocationSize = 1) 
    @Basic(optional = false)
    @Column(name = "ID_CLASSIFICACAO")
    private Long idClassificacao;
    
    @Basic(optional = false)
    @Column(name = "DESCRICAO")
    private String descricao;
    
    @Basic(optional = true)
    @Column(name = "IDADE")
    private String idade;
    
    @OneToMany(cascade = ALL)
    private List<Filme> filmes;

    public Long getIdClassificacao() {
        return idClassificacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getIdade() {
        return idade;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setIdClassificacao(Long idClassificacao) {
        this.idClassificacao = idClassificacao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }
    
    
}
