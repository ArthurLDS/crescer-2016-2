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
        
        if (caminho.contains("."))
            return new File(caminho).getAbsolutePath();
        else
            Arrays.asList(new File(caminho).listFiles());
        return "";    
    }

}
