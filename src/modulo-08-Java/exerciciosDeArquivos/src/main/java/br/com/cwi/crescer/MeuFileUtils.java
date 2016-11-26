package br.com.cwi.crescer;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class MeuFileUtils {

    public static boolean criarArquivo(String caminho) {
        try {
            return new File(caminho).createNewFile();
        } catch (Exception e) {
        }
        return false;
    }

    public static boolean excluirArquivo(String caminho) {
        try {
            if (!caminho.contains(":") && !caminho.contains("/")) {
                return new File(caminho).delete();
            } else {
                return false;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static String mostrarCaminhoAbsoluto(String caminho) {
        String retorno = "";
        File arquivo =  new File(caminho);
        
        if (arquivo.isFile())
            retorno = arquivo.getAbsolutePath();
        else{
            List<File> listaDeArquivos = Arrays.asList(arquivo.listFiles());
            
            for(File arq : listaDeArquivos){
                String nomeArquivoAtual = arq.getName();
                
                if(nomeArquivoAtual.contains("."))
                    retorno += nomeArquivoAtual + " " ;
            }
        }
        return retorno; 
    }
    
}
