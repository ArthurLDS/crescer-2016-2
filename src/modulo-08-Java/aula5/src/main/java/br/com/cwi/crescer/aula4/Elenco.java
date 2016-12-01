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
@Table(name = "ELENCO")
public class Elenco implements Serializable{
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_ELENCO")
    @SequenceGenerator(name = "SEQ_ELENCO", sequenceName = "SEQ_ELENCO", allocationSize = 1) 
    @Basic(optional = false)
    @Column(name = "ID_ELENCO")
    private Long idElenco;
    
    @Basic(optional = false)
    @Column(name = "NM_ELENCO")
    private String nmElenco;
    
    @OneToMany(cascade = ALL)
    private List<Ator> atores;
    
    @OneToMany(cascade = ALL)
    private List<Filme> filme;

    public Long getIdElenco() {
        return idElenco;
    }

    public String getNmElenco() {
        return nmElenco;
    }

    public List<Ator> getAtores() {
        return atores;
    }

    public List<Filme> getFilme() {
        return filme;
    }

    public void setIdElenco(Long idElenco) {
        this.idElenco = idElenco;
    }

    public void setNmElenco(String nmElenco) {
        this.nmElenco = nmElenco;
    }

    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }

    public void setFilme(List<Filme> filme) {
        this.filme = filme;
    }
    
    
}
