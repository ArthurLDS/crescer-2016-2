/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula03;

import Dao.dao;
import br.com.cwi.crescer.aula03.entity.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author arthur.souza
 */
public class Run {

    public static void main(String[] args) {
        
          
        dao daoP = new dao();
        
        
        // Criando um EntityManager
        /*final EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em;
        em = emf.createEntityManager();

        if (em.isOpen()) {
            em.getTransaction().begin();
            try {
                final Pessoa pessoa = new Pessoa();
                pessoa.setIdPessoa(1l);
                pessoa.setNmPessoa("Arthur Lima");

                em.merge(pessoa);
                em.getTransaction().commit();

                System.out.println("Ok!!");
            }
            catch(Exception e){
                
            }
        }
        final Pessoa pessoa = em.find(Pessoa.class, 1l);
        
        em.close();
        emf.close();*/
      
    }
}
