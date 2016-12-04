/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula5.bean;

import br.com.cwi.crescer.aula5.dao.UserDao;
import br.com.cwi.crescer.aula5.filters.User;
import javax.persistence.EntityManager;

/**
 *
 * @author Arthur
 */
public class UserBean extends AbstractBean<User, Long, UserDao>{
    
    private UserDao userDao;
    
    
    @Override
    public UserDao getDao() {
        if (userDao == null) {
            userDao = new UserDao(this.getEntityManager());
        }
        return userDao;
    }
}
