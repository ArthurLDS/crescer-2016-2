package br.com.cwi.crescer;

import br.com.cwi.crescer.MeuFileUtils;

public class Run {
    public static void main(String[] args) {
        String caminho = "teste.txt";
        
        boolean ok = MeuFileUtils.criarArquivo(caminho);
        if(ok) System.out.println("Arquivo criado!");
        
        System.out.println("Caminho deste arquivo: " + MeuFileUtils.mostrarCaminhoAbsoluto(caminho));
        /*boolean deleteOk = MeuFileUtils.excluirArquivo(caminho);
        if(deleteOk) System.out.println("Arquivo excluído!!");
        else System.out.println("Opá isso é um diretorio!");*/
    }
}
