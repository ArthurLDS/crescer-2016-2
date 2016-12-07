/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.service;

import br.com.cwi.crescer.aula8.entity.Elenco;
import br.com.cwi.crescer.aula8.repository.ElencoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author Arthur
 */
@Service
public class ElencoService {
    
    @Autowired
    ElencoRepository repository;
    
    public Page<Elenco> findAll(Pageable pgbl) {
        return repository.findAll(pgbl);
    }

    public Iterable<Elenco> findAll() {
        return repository.findAll();
    }

    public Elenco save(Elenco elenco) {
        return repository.save(elenco);
    }

    public void delete(Long id) {
        repository.delete(id);
    }
    
    public Elenco findOne(Long id){
        return repository.findOne(id);
    }
}
