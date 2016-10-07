import java.util.ArrayList;

public class HobbitContador
{

    public int calcularDiferenca(ArrayList<ArrayList<Integer>> lista){
        int[] prodDosPares = new int [lista.size()];
        int[] mmcDosPares = new int[lista.size()];    
        int somaDosProd = 0, somaDosMmc = 0, resto = 0, a = 0, b = 0;
        //Calculo das somas
        for(int i=0; i<lista.size(); i++){
            for(int j=0; j<2; j++){
                int nodoAtual = lista.get(i).get(j);
                if(j==0)
                    prodDosPares[i]= nodoAtual;
                else
                    prodDosPares[i]*= nodoAtual;
            }
        }
        // Calculo de imcs  
        for(int i=0; i<lista.size(); i++){
            for(int j=0; j<2; j++){
                if(j==1){
                    int nodoAtual = lista.get(i).get(j-1);
                    int nodoPost  = lista.get(i).get(j);
                    mmcDosPares[i] = calculaMmc(nodoAtual, nodoPost);
                }
            }
        }

        for (int i=0; i<lista.size(); i++){
            somaDosProd += prodDosPares[i];
            somaDosMmc += mmcDosPares[i];
        }    

        return somaDosProd - somaDosMmc;
    }

    public int calculaMmc(int nodoAtual, int nodoPost){
        int a = nodoAtual;
        int b = nodoPost;
        int resto = 0;
        do{
            resto = a % b;
            a = b;
            b = resto;
        }while(resto!=0);
        return (nodoAtual * nodoPost)/a;
    }
    //Exercicio 1 EXTRA 
    public int obterMaiorMultiploDeTresAte(int numero) { 
        int maior = 0; 
        /* Desta maneira a variável limite não esta sendo declarada e o "continue"  
         * não tem motivo para estar presente no codigo. 
         * for (int i = 1; i <= limite; i++) { 
        Na maneira abaixo.. O teste é feito até o numero recebido 
        por parâmetro, assim percorrendo todos os numeros até o valor informado 
        pelo usuário e testando os mesmosaté obter o maior Multiplo de 3.     */ 
        for (int i = 1; i <= numero; i++) { 
            if (i%3 == 0)  
                maior = i; 
        } 
        return maior; 

    } 

     
} 

