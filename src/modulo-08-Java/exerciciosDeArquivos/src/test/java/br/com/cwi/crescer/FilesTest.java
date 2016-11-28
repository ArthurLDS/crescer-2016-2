/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Arthur
 */
public class FilesTest {
    
   @Test
   public void retornarCaminhoDoArquivoTesteTXT(){
       Assert.assertEquals(MeuFileUtils.mostrarCaminhoAbsoluto("teste.txt"), "C:\\Users\\Arthur\\Documents\\Projeto Crescer\\GitHub\\crescer-2016-2\\src\\modulo-08-Java\\exerciciosDeArquivos\\teste.txt");
   }
   
   @Test
   public void retornarCaminhoDeInstrucaoValida(){
       String caminho = "mk teste.txt";
       Assert.assertEquals("teste.txt", MeuFileUtils.getCaminho(caminho));
   }
   
   @Test
   public void retornarComandoDeInstrucaoValida(){
       String caminho = "mk teste.txt";
       Assert.assertEquals("mk", MeuFileUtils.getComando(caminho));
   }
}
