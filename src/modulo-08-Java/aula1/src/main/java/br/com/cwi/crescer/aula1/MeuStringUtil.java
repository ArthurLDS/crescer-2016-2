package br.com.cwi.crescer.aula1;

public class MeuStringUtil {
    
    public boolean validaString(String texto){
        return (texto.isEmpty() || texto.equals(null)) ? true : false;
    }
    public int contaVogais(String texto){
        String vogais = "aeiou";
        int count = 0;
        
        for(int i=0; i<texto.length();i++){
            for (int j = 0; j <vogais.length(); j++) {
                count++;
            }
        }
        return count;
    }
}
