/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula5;


import br.com.cwi.crescer.aula4.Elenco;
import br.com.cwi.crescer.aula4.ElencoBean;
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
public class ElencoController {
    @EJB
    private ElencoBean elencoBean;
    
    private Elenco elenco;
    private List<Elenco> elencos;

    @PostConstruct
    public void init() {
        this.elenco = new Elenco();
        elencos = elencoBean.findAll();
    }
    
    public void adicionar() {
        elencoBean.insert(elenco);
        this.init();
    }

    public ElencoBean getElencoBean() {
        return elencoBean;
    }

    public Elenco getElenco() {
        return elenco;
    }

    public List<Elenco> getElencos() {
        return elencos;
    }

    public void setElencoBean(ElencoBean elencoBean) {
        this.elencoBean = elencoBean;
    }

    public void setElenco(Elenco elenco) {
        this.elenco = elenco;
    }

    public void setElencos(List<Elenco> elencos) {
        this.elencos = elencos;
    }
    
}
