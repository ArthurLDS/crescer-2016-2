/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.repository;

import br.com.cwi.crescer.aula8.entity.Idioma;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author arthur.souza
 */
public interface IdiomaRepository extends PagingAndSortingRepository<Idioma, Long>{
    
}
