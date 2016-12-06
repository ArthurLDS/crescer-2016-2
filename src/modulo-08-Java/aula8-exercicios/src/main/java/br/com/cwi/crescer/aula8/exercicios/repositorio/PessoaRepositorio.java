/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.exercicios.repositorio;

import br.com.cwi.crescer.aula8.exercicios.entity.Pessoa;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Arthur
 */
public interface PessoaRepositorio extends CrudRepository<Pessoa, Long>{
    
}
