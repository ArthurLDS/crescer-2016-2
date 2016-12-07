/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.service;

import br.com.cwi.crescer.aula8.entity.Ator;
import br.com.cwi.crescer.aula8.repository.AtorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author Arthur
 */
@Service
public class AtorService {
    
    @Autowired 
    AtorRepository repository;
    
    public Page<Ator> findAll(Pageable pgbl) {
        return repository.findAll(pgbl);
    }

    public Iterable<Ator> findAll() {
        return repository.findAll();
    }

    public Ator save(Ator ator) {
        return repository.save(ator);
    }

    public void delete(Long id) {
        repository.delete(id);
    }
    
    
}
