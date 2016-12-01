/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula4;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;

/**
 *
 * @author Arthur
 */
@Entity
@Table(name = "Filme")
public class Filme implements Serializable{
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_FILME")
    @SequenceGenerator(name = "SEQ_FILME", sequenceName = "SEQ_FILME", allocationSize = 1) 
    @Basic(optional = false)
    @Column(name = "SEQ_FILME")
    private Long idFilme;
    
    @Basic(optional = false)
    @Column(name = "TITULO")
    private String titulo;
    
    @ManyToOne
    private Genero genero;
    
    @Basic(optional = false)
    @Column(name = "DIRETOR")
    private String diretor;
    
    @Column(name = "DT_LANCAMENTO", nullable = true)
    @Temporal(DATE)
    @Basic(optional = true)
    private Date dtLancamento;
    
    @ManyToOne
    private Elenco elenco;
    
    @ManyToOne
    private Classificacao classificacao;
    
    @ManyToOne
    private Idioma idioma;

    public Long getIdFilme() {
        return idFilme;
    }

    public String getTitulo() {
        return titulo;
    }

    public Genero getGenero() {
        return genero;
    }

    public String getDiretor() {
        return diretor;
    }

    public Date getDtLancamento() {
        return dtLancamento;
    }

    public Elenco getElenco() {
        return elenco;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdFilme(Long idFilme) {
        this.idFilme = idFilme;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public void setDtLancamento(Date dtLancamento) {
        this.dtLancamento = dtLancamento;
    }

    public void setElenco(Elenco elenco) {
        this.elenco = elenco;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }
    
    
    
}
