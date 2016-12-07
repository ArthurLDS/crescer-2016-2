/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.service;

import br.com.cwi.crescer.aula8.entity.Classificacao;
import br.com.cwi.crescer.aula8.repository.ClassificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


/**
 *
 * @author Arthur
 */
@Service
public class ClassificacaoService {
    
    @Autowired
    ClassificacaoRepository repository;
    
    public Page<Classificacao> findAll(Pageable pgbl) {
        return repository.findAll(pgbl);
    }

    public Iterable<Classificacao> findAll() {
        return repository.findAll();
    }

    public Classificacao save(Classificacao ator) {
        return repository.save(ator);
    }

    public void delete(Long id) {
        repository.delete(id);
    }
    
    public Classificacao findOne(Long id){
        return repository.findOne(id);
    }
    
}
