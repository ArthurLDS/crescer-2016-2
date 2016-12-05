/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula5.bean;

import br.com.cwi.crescer.aula5.dao.AbstractDao;
import br.com.cwi.crescer.aula5.dao.UserDao;
import br.com.cwi.crescer.aula5.entity.Usuario;
import br.com.cwi.crescer.aula5.filters.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Arthur
 */
@Stateless
public class UserBean extends AbstractDao<Usuario, Long>{
    
    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;

    public UserBean() {
        super(Usuario.class);
    }

    @Override
    public EntityManager getEntityManager() {
       return this.entityManager;
    }
    
   
}
