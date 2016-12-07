/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.controller;

import br.com.cwi.crescer.aula8.entity.Classificacao;
import br.com.cwi.crescer.aula8.service.ClassificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Arthur
 */
@Controller
public class ClassificacaoController {
    
    @Autowired
    ClassificacaoService service;
    
    @RequestMapping(value = "/classificacao")
    public String filmes(Model model, @RequestParam(required = false) Long id, Pageable p){
        
        Pageable pageable = new PageRequest(p.getPageNumber(), 5, p.getSort());
        Classificacao classificacao = new Classificacao();
        
        if (id != null) {
            classificacao = service.findOne(id);
            pageable = null;
        }
        if (pageable == null) {
            pageable = new PageRequest(0, 10);
        }
        
        model.addAttribute("classificacao", classificacao);
        Iterable<Classificacao> classificacoes = service.findAll(pageable);
        model.addAttribute("classificacoes", classificacoes);
        
        return "classificacao"; 
    }
    
    @RequestMapping(value = "/classificacao", method= RequestMethod.POST)
    public String save(@ModelAttribute Classificacao classificacao, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (!bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("msg", "Registro salvo com sucesso!");
            service.save(classificacao);
            return "redirect:classificacao";
        }
        return "classificacao";
    }
    
}
