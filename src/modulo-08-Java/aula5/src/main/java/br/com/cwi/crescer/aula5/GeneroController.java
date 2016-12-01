/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula5;

import br.com.cwi.crescer.aula4.Genero;
import br.com.cwi.crescer.aula4.GeneroBean;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Arthur
 */
@ManagedBean
@ViewScoped
public class GeneroController {
    @EJB
    private GeneroBean generoBean;
    private Genero genero;
    private List<Genero> generos;
    
    @PostConstruct
    public void init(){
        this.genero = new Genero();
        this.generos = generoBean.findAll();
    }
    
    public void adicionar() {
        generoBean.insert(genero);
        this.init();
    }
    
    public GeneroBean getGeneroBean() {
        return generoBean;
    }

    public Genero getGenero() {
        return genero;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneroBean(GeneroBean generoBean) {
        this.generoBean = generoBean;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }
    
    
}
