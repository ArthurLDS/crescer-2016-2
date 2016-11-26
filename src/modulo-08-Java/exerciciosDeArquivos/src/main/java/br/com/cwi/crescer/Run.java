package br.com.cwi.crescer;

import br.com.cwi.crescer.MeuFileUtils;
import java.util.Scanner;

public class Run {

    public static void main(String[] args) {
        //C:\\Users\\Arthur\\Documents\\Projeto Crescer\\GitHub\\crescer-2016-2\\src\\modulo-08-Java\\exerciciosDeArquivos\\
         
        Scanner ler = new Scanner(System.in);
        do {
            System.out.print("Digite um comando: ");
            String instrucao = ler.nextLine();
            
            if(!validaComando(instrucao)){ 
                System.out.println("Comando inválido!");
                continue;
            }
            
            String comando = getComando(instrucao);
            String caminho = getCaminho(instrucao);

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
                default:
                    System.out.println("Comando inválido!");
            }
        } while (true);

    }

    public static String getComando(String instrucao) {
        return instrucao.split(" ")[0];
    }

    public static String getCaminho(String instrucao) {
        return instrucao.split(" ")[1];
    }
    public static boolean validaComando(String instrucao){
        return instrucao.contains(" ");
    }
}
