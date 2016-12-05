/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.dominio;

import java.util.Date;

/**
 *
 * @author arthur.souza
 */
public class Pessoa {
    private String nome;
    private Date data;
        
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    public String getNome() {
        return nome;
    }

    public Date getData() {
        return data;
    }
    
    
}
