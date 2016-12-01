/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula4;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Arthur
 */
@Entity
@Table(name = "ATOR")
public class Ator implements Serializable{
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_ATOR")
    @SequenceGenerator(name = "SEQ_ATOR", sequenceName = "SEQ_ATOR", allocationSize = 1) 
    @Basic(optional = false)
    @Column(name = "ID_ATOR")
    private Long idAtor;
    
    @Basic(optional = false)
    @Column(name = "NM_ATOR")
    private String nmAtor;
    
    @ManyToOne
    private Filme filme;

    public Long getIdAtor() {
        return idAtor;
    }

    public String getNmAtor() {
        return nmAtor;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setIdAtor(Long idAtor) {
        this.idAtor = idAtor;
    }

    public void setNmAtor(String nmAtor) {
        this.nmAtor = nmAtor;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }
    
    
}
