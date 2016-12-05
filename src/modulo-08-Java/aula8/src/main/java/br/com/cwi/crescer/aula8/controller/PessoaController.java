/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.controller;

import br.com.cwi.crescer.aula8.dominio.Pessoa;
import br.com.cwi.crescer.aula8.service.Servico;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author arthur.souza
 */
@RestController
public class PessoaController {
    
    @Autowired
    Servico servico = new Servico();
    
    
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public void inserir(@RequestBody Pessoa pessoa) {
        pessoa = new Pessoa();
        servico.insert(pessoa);
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Pessoa> list() {
        return servico.listAll();
    }
    
}
