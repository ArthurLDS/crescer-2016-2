/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula5.mbean;

import br.com.cwi.crescer.aula5.bean.UserBean;
import br.com.cwi.crescer.aula5.dao.UserDao;
import br.com.cwi.crescer.aula5.entity.Usuario;
import br.com.cwi.crescer.aula5.filters.User;
import java.io.Serializable;
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
public class CadastroMBean{
    
    @EJB
    private UserBean userBean;
    private Usuario usuario;
    
    @PostConstruct
    public void init() {
        this.usuario = new Usuario();
    }

    public UserBean getBean() {
        return userBean;
    }
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void inserir(){
        userBean.insert(usuario);
    }

    
    
}
