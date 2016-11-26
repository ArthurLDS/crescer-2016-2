package br.com.cwi.crescer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.List;

public class MeuWriterUtils {

    public static void escreverConteudo(String arquivo, List<String> conteudos) {
        try {
            final File file = new File(arquivo); 
            
            if(!arquivo.contains(".txt")){
                System.out.println("Arquivo incompatível!");
                return;
            }
            if(!file.exists()){
                System.out.println("Arquivo inexistente!");
                return;
            }
            
            final Writer writer = new FileWriter(arquivo, true);
            final BufferedWriter bufferedWriter = new BufferedWriter(writer);
            
            for (int i = 0; i<conteudos.size(); i++) {
                bufferedWriter.newLine();
                bufferedWriter.append(conteudos.get(i));
            }
            
            bufferedWriter.flush();

        } catch (Exception e) {
        }
    }
}
