/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula5;

import br.com.cwi.crescer.aula4.Filme;
import br.com.cwi.crescer.aula4.FilmeBean;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Arthur
 */
@ManagedBean
@ViewScoped
public class FilmeController {
    @EJB
    private FilmeBean filmeBean;
    
    private Filme filme;
    private List<Filme> filmes;
    
    
    @PostConstruct
    public void init() {
        this.filme = new Filme();
        this.filmes = filmeBean.findAll();
    }
    
    public void adicionar() {
        filmeBean.insert(filme);
        this.init();
    }

    public Filme getFilme() {
        return filme;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }
    
}
