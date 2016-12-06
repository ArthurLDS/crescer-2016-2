/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.exercicios.controller;

import br.com.cwi.crescer.aula8.exercicios.entity.Pessoa;
import br.com.cwi.crescer.aula8.exercicios.servico.PessoaServico;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Arthur
 */
@RestController
public class PessoaController {
    
    @Autowired
    private PessoaServico pessoaServico;
    
    @RequestMapping(value = "/pessoa.json", method= GET)
    public Iterable<Pessoa> list(){
        return pessoaServico.listAll();
    }
    
    @RequestMapping(value="/pessoa.json", method= POST)
    public Iterable<Pessoa> add(@RequestBody Pessoa pessoa){
        pessoaServico.add(pessoa);
        return pessoaServico.listAll();
    }
}
