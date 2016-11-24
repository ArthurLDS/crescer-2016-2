package br.com.cwi.crescer.aula1;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class StringRun {

    public static void main(String[] args) {
        exibirDiaDoNascimento();
    }

    //Exercicios Datas
    // 01
    public static void exibirDadaAtual() {
        Date agora = new Date();
        System.out.println(agora);
    }

    //02
    public static void exibirDiaDoNascimento() {
        try {
            String[] semana = {"Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "Sábado", "Domingo"};

            String agora = new String("1997/07/02");
            SimpleDateFormat formatar = new SimpleDateFormat("EEEE");
            Date result = formatar.parse(agora);
            System.out.println(result);

        } catch (Exception e) {
            
        }

    }

    public static int verificaVogais(String frase) {
        String vogais = "aeiou";
        int cont = 0;

        for (int i = 0; i < frase.length(); i++) {
            for (int j = 0; j < vogais.length(); j++) {
                if (frase.charAt(i) == vogais.charAt(j)) {
                    cont++;
                }
            }
        }
        return cont;
    }

    public static void imprimeEstados() {
        StringBuilder estadosString = new StringBuilder();
        for (Estados estado : Estados.values()) {
            estadosString.append(estado.getNome() + " ").toString();
        }
        String[] estados = estadosString.toString().split(" ");
        Arrays.sort(estados);

        for (int i = 0; i < Estados.values().length; i++) {
            boolean ehOUltimo = i == Estados.values().length - 1;
            if (!ehOUltimo) {
                System.out.println(estados[i] + ", ");
            } else {
                System.out.println(estados[i]);
            }
        }
    }

    public static String inverterText(String palavra) {
        String retorno = "";

        for (int i = palavra.length(); i >= 0; i++) {
            retorno += palavra.charAt(i);
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
