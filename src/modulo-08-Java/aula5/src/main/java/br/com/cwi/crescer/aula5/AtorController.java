/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula5;


import br.com.cwi.crescer.aula4.Ator;
import br.com.cwi.crescer.aula4.AtorBean;
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
public class AtorController {
     @EJB
    private AtorBean atorBean;
    
    private Ator ator;
    private List<Ator> atores;

    @PostConstruct
    public void init() {
        this.ator = new Ator();
        this.atores = atorBean.findAll();
    }

    public AtorBean getAtorBean() {
        return atorBean;
    }

    public Ator getAtor() {
        return ator;
    }

    public List<Ator> getAtores() {
        return atores;
    }

    public void setAtorBean(AtorBean atorBean) {
        this.atorBean = atorBean;
    }

    public void setAtor(Ator ator) {
        this.ator = ator;
    }

    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }
    
    
}
