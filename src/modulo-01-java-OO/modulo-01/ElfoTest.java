import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
    @Test
    public void elfoNasceComNome(){
        //Arrage
        String nomeEsperado = "Paulo Brito";
        //Act
        Elfo brito = new Elfo(nomeEsperado);
        //Assert
        assertEquals(nomeEsperado, brito.getNome());
    }
    @Test 
    public void elfoNasceComArco() {  
        Elfo elfoDoTeste = new Elfo("Doug"); 
        // Assert 
        assertEquals("Arco", elfoDoTeste.getArco().getDescricao()); 
        assertEquals(1, elfoDoTeste.getArco().getQuantidade()); 
    }
    //Teste criação 42 flechas
    @Test
    public void elfoNasceCom42Flechas(){
        //Arrage and Act
        Elfo elfoDeTeste = new Elfo("Doug");
        //Assert
        assertEquals("Flechas", elfoDeTeste.getFlecha().getDescricao()); 
        assertEquals(42, elfoDeTeste.getFlecha().getQuantidade());
    }
    //Teste metodo atirarFlecha()
    @Test
    public void elfoAtiraFlecha(){
        Elfo elfoDeTeste = new Elfo("Doug10");
        assertEquals(41, elfoDeTeste.getFlechaDpsAtirar().getQuantidade());
    }
    
    @Test //Teste Classe Cesto de Lembas
    public void cestoDeLembasSemGluten(){
        CestoDeLembas doisSemGluten = new CestoDeLembas(2);
        assertEquals(false, doisSemGluten.podeDividirEmPares());
        CestoDeLembas seisSemGluten = new CestoDeLembas(6);
        assertEquals(true, seisSemGluten.podeDividirEmPares());
    }
    
    @Test //Teste Classe Adversario
    public void AcertaFlechaNoDwarves(){
        Elfo elfoDoTeste = new Elfo("Elfo do Bem");
        assertEquals(110, elfoDoTeste.getAdversario().getHp());
        assertEquals(10, elfoDoTeste.getDpsAdversarioLevar().getHp());
    }
}
