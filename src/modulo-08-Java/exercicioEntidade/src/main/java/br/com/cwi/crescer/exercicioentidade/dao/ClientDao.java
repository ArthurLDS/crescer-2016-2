/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.exercicioentidade.dao;

import br.com.cwi.crescer.exercicioentidade.entity.Client;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Arthur
 */
public class ClientDao implements IDao<Client, Long>{
    final EntityManager entityManager;

    public ClientDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public void insert(Client cliente){
         try {
            entityManager.getTransaction().begin();
            if (cliente.getIdClient() == null) {
                entityManager.persist(cliente);
            } else {
                entityManager.merge(cliente);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }
    @Override
    public void delete(Client cliente){
        try{
            entityManager.getTransaction().begin();
            entityManager.remove(cliente);
            entityManager.getTransaction().commit();
        }
        catch(Exception e){
            entityManager.getTransaction().rollback();
        }
    }
    @Override
    public void update(Client cliente){
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(cliente);
            entityManager.getTransaction().commit();
        }
        catch(Exception e){
            entityManager.getTransaction().rollback();
        }
    }
    
    @Override
    public List<Client> list(){
        List<Client> lista =  entityManager.createQuery("select c from Client c").getResultList();
        return lista;
    }
    
    
}
