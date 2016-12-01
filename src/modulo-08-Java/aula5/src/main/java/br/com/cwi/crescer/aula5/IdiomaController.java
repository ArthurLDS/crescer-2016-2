/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula5;

import br.com.cwi.crescer.aula4.Idioma;
import br.com.cwi.crescer.aula4.IdiomaBean;
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
public class IdiomaController {
    @EJB
    private IdiomaBean idiomaBean;
    
    private Idioma idioma;
    private List<Idioma> idiomas;

    @PostConstruct
    public void init() {
        this.idioma = new Idioma();
        this.idiomas = idiomaBean.findAll();
    }
    
    public void adicionar() {
        idiomaBean.insert(idioma);
        this.init();
    }

    public IdiomaBean getIdiomaBean() {
        return idiomaBean;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public List<Idioma> getIdiomas() {
        return idiomas;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public void setIdiomas(List<Idioma> idiomas) {
        this.idiomas = idiomas;
    }
    
}
