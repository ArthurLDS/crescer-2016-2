/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.exercicios.servico;

import br.com.cwi.crescer.aula8.exercicios.entity.Pessoa;
import br.com.cwi.crescer.aula8.exercicios.repositorio.PessoaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Arthur
 */
@Service
public class PessoaServico {
    
    @Autowired
    private PessoaRepositorio pessoaRepositorio;
    
    public Iterable<Pessoa> listAll(){
        return pessoaRepositorio.findAll();
    }
    
    public void add(Pessoa pessoa){
        pessoaRepositorio.save(pessoa);
    }
}
