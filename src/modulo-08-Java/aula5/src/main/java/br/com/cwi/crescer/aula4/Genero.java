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
@Table(name = "GENERO")
public class Genero implements Serializable{
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_GENERO")
    @SequenceGenerator(name = "SEQ_GENERO", sequenceName = "SEQ_GENERO", allocationSize = 1) 
    @Basic(optional = false)
    @Column(name = "ID_GENERO")
    private Long iGenero;
    
    @Basic(optional = false)
    @Column(name = "DESCRICAO")
    private String descricao;
    
    @OneToMany(cascade = ALL)
    private List<Filme> filmes;

    public Long getiGenero() {
        return iGenero;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setiGenero(Long iGenero) {
        this.iGenero = iGenero;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }
    
    
}
