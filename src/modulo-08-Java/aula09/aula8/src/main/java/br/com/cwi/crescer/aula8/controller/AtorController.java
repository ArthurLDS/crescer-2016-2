/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.controller;

import br.com.cwi.crescer.aula8.entity.Ator;
import br.com.cwi.crescer.aula8.service.AtorService;
import java.util.Date;
import javax.validation.Valid;
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
public class FilmeController {
    
    @Autowired
    AtorService atorService;
    
    @RequestMapping(value = "/filmes")
    public String filmes(Model model, @RequestParam(required = false) Long id, Pageable p){
        
        Pageable pageable = new PageRequest(p.getPageNumber(), 5, p.getSort());
        Ator ator = new Ator();
        
        if (id != null) {
            ator = atorService.findOne(id);
            pageable = null;
        }
        if (pageable == null) {
            pageable = new PageRequest(0, 10);
        }
        
        model.addAttribute("ator", ator);
        Iterable<Ator> atores =  atorService.findAll(pageable);
        model.addAttribute("atores", atores);
        
        return "filmes"; 
    }
    
    @RequestMapping(value = "/ator", method= RequestMethod.POST)
    public String save(@ModelAttribute Ator ator, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (!bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("msg", "Registro salvo com sucesso!");
            atorService.save(ator);
            return "redirect:filmes";
        }
        return "filmes";
    }
}
