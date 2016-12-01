/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula4;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Arthur
 */
@Stateless
public class GeneroBean extends AbstractDao<Genero, Long>{
    
    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;

    public GeneroBean() {
        super(Genero.class);
    }
    
    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public List<Genero> findAll() {
        return this.getEntityManager().createQuery("select g from Genero g").getResultList();
    }
    
}
