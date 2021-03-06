package br.com.cwi.crescer;

import br.com.cwi.crescer.MeuFileUtils;
import br.com.cwi.crescer.MeuReaderUtils;
import br.com.cwi.crescer.MeuWriterUtils;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class Run {

    public static void main(String[] args) {
        
        Scanner ler = new Scanner(System.in);
        do {
            System.out.print("Digite um comando: ");
            String instrucao = ler.nextLine();
            
            if(!MeuFileUtils.validaComando(instrucao)){ 
                System.out.println("Comando inválido!");
                continue;
            }
            String comando = MeuFileUtils.getComando(instrucao);
            String caminho = MeuFileUtils.getCaminho(instrucao);
            
            switch (comando) {
                case "mk":
                    MeuFileUtils.criarArquivo(caminho);
                    break;
                case "rm":
                    MeuFileUtils.excluirArquivo(caminho);
                    break;
                case "ls":
                    System.out.println("Caminho: " + MeuFileUtils.mostrarCaminhoAbsoluto(caminho));
                    break;
                //Leitura de Arquivo (Exercicio-02)    
                case "read":
                    MeuReaderUtils.exibirConteudo(caminho);
                    break;
                //Escrita em Arquivo (Exercicio-03)
                case "write":
                    if(!MeuWriterUtils.validarEntrada(caminho)) continue;
                    
                    List<String> conteudos = new ArrayList<>();
                    String resposta = "N";
                    do{
                        System.out.print("Insira um texto: ");
                        conteudos.add(ler.nextLine());
                        
                        System.out.print("Deseja inserir mais textos? [S]im [N]ão: ");
                        resposta = ler.nextLine();
                        
                    }while(resposta.charAt(0) != 'N');
                    
                    MeuWriterUtils.escreverConteudo(caminho, conteudos);
                    break;    
            }
        } while (true);
    }  
}
