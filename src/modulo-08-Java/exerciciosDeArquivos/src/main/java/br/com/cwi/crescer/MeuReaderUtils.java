package br.com.cwi.crescer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class MeuReaderUtils {
    
    public static void exibirConteudo(String arquivo){
         try{
            final File file = new File(arquivo); 
            
            if(!arquivo.contains(".txt")){
                System.out.println("Arquivo incompatível!");
                return;
            }
            if(!file.exists()){
                System.out.println("Arquivo inexistente!");
                return;
            }
            
            final Reader reader = new FileReader(arquivo);
            final BufferedReader bufferReader = new BufferedReader(reader);
            
            String linha = bufferReader.readLine();
            while(linha!=null){
                System.out.printf("%s\n", linha);
                linha = bufferReader.readLine();
            }
            
        } catch(IOException e){
            e.printStackTrace();
        }
        
        //return lista;
    }
}
