/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.service;

import br.com.cwi.crescer.aula8.dominio.Pessoa;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author arthur.souza
 */
@Service
public class Servico {
    
    private List<Pessoa> pessoas;
    
    public List<Pessoa> listAll(){
        pessoas = new ArrayList<>();
        return pessoas;
    }
    
    public void insert(Pessoa pessoa){
        pessoas.add(pessoa);
    }
}
