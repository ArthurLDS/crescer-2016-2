package br.com.cwi.crescer.exerciciosdesql;

import java.util.Scanner;

public class Run {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        String instrucao = "";

        do {
            System.out.print("Digite uma instrução: ");
            instrucao = ler.nextLine();

            switch (instrucao) {
                case "sql":
                    System.out.print("Digite um comando SQL: ");
                    String comandoSQL = ler.nextLine();
                    MeuSQLUtils.executarSQL(comandoSQL);
                    break;
                case "fileSql":
                    System.out.print("Digite um arquivo .SQL: ");
                    String arquivoSQL = ler.nextLine();
                    MeuSQLUtils.executaSQLDeArquivo(arquivoSQL);
                    break;
                case "importFile":
                    System.out.print("Digite um arquivo .CSV");
                    String arquivo = ler.nextLine();
                    MeuSQLUtils.importarArquivo(arquivo);
                    break;
            }
        } while (true);
    }

}
