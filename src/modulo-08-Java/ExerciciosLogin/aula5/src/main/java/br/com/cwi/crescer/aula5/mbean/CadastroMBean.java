/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula5.mbean;

import br.com.cwi.crescer.aula5.bean.UserBean;
import br.com.cwi.crescer.aula5.dao.UserDao;
import br.com.cwi.crescer.aula5.filters.User;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Arthur
 */
@ManagedBean
@ViewScoped
public class CadastroMBean extends AbstractMBean<User, Long, UserDao, UserBean>{
    
    private UserBean userBean;
    private User user;
    

    @PostConstruct
    public void init() {
        this.user = new User();
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public UserBean getBean() {
        return userBean;
    }

    @Override
    public void limpar() {
        this.setEntity(new User());
        this.setList(this.getBean().findAll());
    }
    
}
