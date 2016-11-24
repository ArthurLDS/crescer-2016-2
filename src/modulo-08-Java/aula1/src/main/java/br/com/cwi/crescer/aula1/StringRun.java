
package br.com.cwi.crescer.aula1;

import java.util.Arrays;
import java.util.Scanner;

public class StringRun {
    public static void main(String[] args) {
        StringBuilder estadosString = new StringBuilder();
        
        
        for(Estados estado: Estados.values()){  
            estadosString.append(estado.getNome() + " ").toString();
        }
        
        String[] estados = estadosString.toString().split(" ");
        Arrays.sort(estados);
                
        for (int i = 0; i<Estados.values().length; i++) {
            boolean ehOUltimo = i== Estados.values().length-1;
            
            if(!ehOUltimo)
                System.out.println(estados[i]+", ");
            else
                System.out.println(estados[i]);
        }
        
        
        /*Scanner leia = new Scanner(System.in);
        System.out.println("Digite uma frase: ");
        String frase = leia.nextLine();
        
        System.out.println("Numero de vogais: " + verificaVogais(frase));*/
        
    }
    public static int verificaVogais(String frase){
        String vogais = "aeiou";
        int cont = 0;
        
        for (int i = 0; i <frase.length(); i++) {
            for (int j = 0; j <vogais.length(); j++) {
                if(frase.charAt(i) == vogais.charAt(j)){
                    cont++;
                }
            }
        }
        return cont;
    }
    
    public static String inverterText(String palavra){
        String retorno = "";
        
        for(int i =palavra.length(); i>=0; i++){
            retorno+= palavra.charAt(i);
        }
        return retorno;
    }
    
    enum Estados {
    AC("Acre"), AL("Alagoas"), ES("EspíritoSanto"), AP("Amapá"),
    BA("Bahia"), CE("Ceará"), DF("DistritoFederal"), GO("Goiás"),
    MA("Maranhão"), SC("SantaCatarina"), MG("MinasGerais"),
    MT("MatoGrosso"), MS("MatoGrossodoSul"), PA("Pará"),
    RS("RioGrandedoSul"), PE("Pernambuco"), PI("Piauí"),
    AM("Amazonas"), PR("Paraná"), RJ("RiodeJaneiro"),
    RN("RioGrandedoNorte"), PB("Paraíba"), RO("Rondônia"),
    RR("Roraima"), SE("Sergipe"), SP("SãoPaulo"), TO("Tocantins");

    private String nome;

    private Estados(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
}

