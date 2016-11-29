/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.exercicioentidade;

import br.com.cwi.crescer.exercicioentidade.dao.ClientDao;
import br.com.cwi.crescer.exercicioentidade.dao.UsuarioDao;
import br.com.cwi.crescer.exercicioentidade.entity.Client;
import br.com.cwi.crescer.exercicioentidade.entity.Usuario;
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

        /*final ClientDao clienteDao = new ClientDao(em);
        final Client cliente = new Client();
        
        cliente.setDsEmail("fsdf@sfdfsd.com");
        cliente.setDsPassword("12345");
        cliente.setDsPreferredCoin("Real");
        cliente.setDsState("Ativo");
        cliente.setDsUserName("ArthurLDS");
        cliente.setNmClient("Arthur");
        cliente.setTpPermission("Admin");
        
        clienteDao.exportarCSV(cliente);
        
        clienteDao.list();*/
        
        final UsuarioDao usuarioDao = new UsuarioDao(em);
        final Usuario usuario = new Usuario();
        
        usuario.setDsEmail("fsdf@sfdfsd.com");
        usuario.setDsSenha("12345");
        usuario.setDsSituacao("Real");
        usuario.setDsUserName("ArthurLDS");
        usuario.setNmUsuario("Silvio Santos Santos");
        usuario.setTpPermission("Moderador");
        
        usuarioDao.exportarCSV(usuario);
        
        em.close();
        emf.close();
        
    }
}
