import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class HobbitContadorTest
{
    @Test
    public void calculaProdDasSomaArray(){
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(15,18)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(4, 5)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(12, 60)));
        
        HobbitContador contador = new HobbitContador();
        int soma = contador.calcularDiferenca(arrayDePares);
        assertEquals(840 ,soma);
    }
    @Test
    public void calculaProdDasSomaArrayComTudoEm1(){
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(1,1)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(1, 1)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(1, 1)));
        
        HobbitContador contador = new HobbitContador();
        int soma = contador.calcularDiferenca(arrayDePares);
        assertEquals(0 ,soma);
    }
    @Test
    public void calculaProdDasSomaArrayCom6linhas(){
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(15,18)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(4, 5)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(12, 60)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(1,1)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(1, 1)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(1, 1)));
        
        HobbitContador contador = new HobbitContador();
        int soma = contador.calcularDiferenca(arrayDePares);
        assertEquals(840 ,soma);
    }
    @Test
    public void calculaMMC4e5(){
        HobbitContador hobbit = new HobbitContador();
        int mmc = hobbit.calculaMmc(4,5);
        assertEquals(20, mmc);
    }
    @Test
    public void calculaMMC1e1(){
        HobbitContador hobbit = new HobbitContador();
        int mmc = hobbit.calculaMmc(1,1);
        assertEquals(1, mmc);
    }
}
