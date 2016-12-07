/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.service;

import br.com.cwi.crescer.aula8.entity.Genero;
import br.com.cwi.crescer.aula8.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author arthur.souza
 */
@Service
public class GeneroService {
    
    @Autowired
    GeneroRepository repository;
    
    public Page<Genero> findAll(Pageable pgbl) {
        return repository.findAll(pgbl);
    }

    public Iterable<Genero> findAll() {
        return repository.findAll();
    }

    public Genero save(Genero ator) {
        return repository.save(ator);
    }

    public void delete(Long id) {
        repository.delete(id);
    }
    
    public Genero findOne(Long id){
        return repository.findOne(id);
    }
}
