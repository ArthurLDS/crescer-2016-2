/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import br.com.cwi.crescer.aula03.entity.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author arthur.souza
 */
public class dao implements IDao<Pessoa, Long> {

    @Override
    public void insert(Pessoa t) {

        final EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em;
        em = emf.createEntityManager();

        if (em.isOpen()) {
            em.getTransaction().begin();
            try {
                final Pessoa pessoa = new Pessoa();
                pessoa.setIdPessoa(1l);
                pessoa.setNmPessoa("Valdivia");

                em.merge(pessoa);
                em.getTransaction().commit();

                System.out.println("Ok!!");
            } catch (Exception e) {

            }
        }
        final Pessoa pessoa = em.find(Pessoa.class, 1l);

        em.close();
        emf.close();
    }

    @Override
    public Pessoa find(Long id) {
        final EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em;
        Pessoa pessoa = new Pessoa(); 
        
        em = emf.createEntityManager();
        if (em.isOpen()) {
            pessoa = em.find(Pessoa.class, id);
        }
        em.close();
        emf.close();
        
        return pessoa;
    }

    @Override
    public void delete(Pessoa t) {
        final EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em;
        em = emf.createEntityManager();
        if (em.isOpen()) {
            em.remove(t);
        }
        em.close();
        emf.close();
    }

}
