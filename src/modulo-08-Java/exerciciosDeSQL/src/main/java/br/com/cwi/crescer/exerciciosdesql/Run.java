package br.com.cwi.crescer.exerciciosdesql;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        
        System.out.print("Digite um comando SQL: ");
        String comandoSQL = ler.nextLine();
        MeuSQLUtils.executarSQL(comandoSQL);
        
        System.out.print("Digite um arquivo SQL: ");
        String arquivoSQL = ler.nextLine();
        MeuSQLUtils.executaSQLDeArquivo(arquivoSQL);
    }
}
