/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.exercicioentidade;

import br.com.cwi.crescer.exercicioentidade.dao.ClientDao;
import br.com.cwi.crescer.exercicioentidade.entity.Client;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Arthur
 */
public class Run {
    public static void main(String[] args) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em = emf.createEntityManager();

        final ClientDao clienteDao = new ClientDao(em);
        final Client cliente = new Client();
        
        cliente.setDsEmail("adfsdf@sfdfsd.com");
        cliente.setDsPassword("12345");
        cliente.setDsPreferredCoin("Real");
        cliente.setDsState("Ativo");
        cliente.setDsUserName("ArthurLDS");
        cliente.setNmClient("Arthur Lima");
        cliente.setTpPermission("Admin");
        
        clienteDao.insert(cliente);
        
        em.close();
        emf.close();
        
    }
}
