/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula5;

import br.com.cwi.crescer.aula4.Classificacao;
import br.com.cwi.crescer.aula4.ClassificacaoBean;
import br.com.cwi.crescer.aula4.Pessoa;
import br.com.cwi.crescer.aula4.PessoaBean;
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
public class ClassificacaoController {
    @EJB
    private ClassificacaoBean classificacaoBean;
    
    private Classificacao classificacao;
    private List<Classificacao> classificacoes;

    @PostConstruct
    public void init() {
        this.classificacao = new Classificacao();
        this.classificacoes = classificacaoBean.findAll();
    }
     public void adicionar() {
        classificacaoBean.insert(classificacao);
        this.init();
    }

    public ClassificacaoBean getClassificacaoBean() {
        return classificacaoBean;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public List<Classificacao> getClassificacoes() {
        return classificacoes;
    }

    public void setClassificacaoBean(ClassificacaoBean classificacaoBean) {
        this.classificacaoBean = classificacaoBean;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }

    public void setClassificacoes(List<Classificacao> classificacoes) {
        this.classificacoes = classificacoes;
    }
     
}
