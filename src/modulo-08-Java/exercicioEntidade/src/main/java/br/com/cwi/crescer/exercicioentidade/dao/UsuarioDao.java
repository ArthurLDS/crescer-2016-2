/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.exercicioentidade.dao;

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
public class UsuarioDao implements IDao<Usuario, Long>{
    final EntityManager entityManager;

    public UsuarioDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void insert(Usuario usuario) {
        try {
            entityManager.getTransaction().begin();
            if (usuario.getIdUsuario() == null) {
                entityManager.persist(usuario);
            } else {
                entityManager.merge(usuario);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Usuario usuario) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(usuario);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void update(Usuario usuario) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(usuario);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public List<Usuario> list() {
        
        List<Usuario> lista = entityManager.createQuery("select c from Usuario c").getResultList();
        return lista;
    }

    public void exportarCSV(Usuario usuario) {
        try {
            final Writer writer = new FileWriter("Usuario.csv", true);
            final BufferedWriter bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.newLine();
            bufferedWriter.append(usuario.getDsEmail() + ";");
            bufferedWriter.append(usuario.getDsSenha() + ";");
            bufferedWriter.append(usuario.getDsSituacao() + ";");
            bufferedWriter.append(usuario.getDsUserName() + ";");
            bufferedWriter.append(usuario.getNmUsuario() + ";");
            bufferedWriter.append(usuario.getTpPermission() + ";");
            
             bufferedWriter.flush();
            
        } catch (Exception e) {
        }
    }
}
