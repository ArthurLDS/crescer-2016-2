/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.exercicioentidade.dao;

import br.com.cwi.crescer.exercicioentidade.entity.Contract;
import br.com.cwi.crescer.exercicioentidade.entity.Usuario;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Arthur
 */
public class ContractDao implements IDao<Contract, Long>{
     final EntityManager entityManager;
     
     public ContractDao(EntityManager entityManager){
         this.entityManager = entityManager;
     }
     
    @Override
    public void insert(Contract contrato) {
        try {
            entityManager.getTransaction().begin();
            if (contrato.getIdContract() == null) {
                entityManager.persist(contrato);
            } else {
                entityManager.merge(contrato);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Contract contrato) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(contrato);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void update(Contract contrato) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(contrato);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public List<Contract> list() {
        
        List<Contract> lista = entityManager.createQuery("select c from Contract c").getResultList();
        return lista;
    }

    public void exportarCSV(Contract contrato) {
        try {
            final Writer writer = new FileWriter("Contract.csv", true);
            final BufferedWriter bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.newLine();
            bufferedWriter.append(contrato.getIdContract() + ";");
            bufferedWriter.append(contrato.getDsDescription() + ";");
            bufferedWriter.append(contrato.getDsState() + ";");
            bufferedWriter.append(contrato.getDsWebSite() + ";");
            bufferedWriter.append(contrato.getNmContract() + ";");
            bufferedWriter.append(contrato.getClientIdClient() + ";");
            
             bufferedWriter.flush();
            
        } catch (Exception e) {
        }
    }
}
