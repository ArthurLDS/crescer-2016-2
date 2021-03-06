package br.com.cwi.crescer.exercicioentidade.dao;

import br.com.cwi.crescer.exercicioentidade.entity.Client;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;
import java.util.List;
import javax.persistence.EntityManager;

public class ClientDao implements IDao<Client, Long> {

    final EntityManager entityManager;

    public ClientDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void insert(Client cliente) {
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
    public void delete(Client cliente) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(cliente);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void update(Client cliente) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(cliente);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public List<Client> list() {
        List<Client> lista = entityManager.createQuery("select c from Client c").getResultList();
        return lista;
    }

    public void exportarCSV(Client cliente) {
        try {
            final Writer writer = new FileWriter("Client.csv", true);
            final BufferedWriter bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.newLine();
            bufferedWriter.append(cliente.getDsEmail() + ";");
            bufferedWriter.append(cliente.getDsPassword() + ";");
            bufferedWriter.append(cliente.getDsPreferredCoin() + ";");
            bufferedWriter.append(cliente.getDsState() + ";");
            bufferedWriter.append(cliente.getDsUserName() + ";");
            bufferedWriter.append(cliente.getNmClient() + ";");
            bufferedWriter.append(cliente.getTpPermission() + ";");
            
             bufferedWriter.flush();
            
        } catch (Exception e) {
        }
    }

}
