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
    public void elfoAtiraFlechaEmUmDwarf() {
        Elfo elfo = new Elfo("Batman");
        Dwarf balin = new Dwarf();
        elfo.atirarFlecha(balin);
        assertEquals(100, balin.getVida());
    }

    @Test
    public void elfoAtiraDuasFlechaEmUmDwarf() {
        Elfo elfo = new Elfo("Batman");
        Dwarf balin = new Dwarf();
        elfo.atirarFlecha(balin);
        elfo.atirarFlecha(balin);
        assertEquals(90, balin.getVida());
    }
    
    @Test //Teste Classe Cesto de Lembas
    public void cestoDeLembasSemGluten(){
        CestoDeLembas doisSemGluten = new CestoDeLembas(2);
        assertEquals(false, doisSemGluten.podeDividirEmPares());
        CestoDeLembas seisSemGluten = new CestoDeLembas(6);
        assertEquals(true, seisSemGluten.podeDividirEmPares());
    }
    
   
     @Test
    public void elfoToStringComInformacoesIniciais() {
        Elfo legolas = new Elfo("Legolas");
        assertEquals("Legolas possui 42 flechas e 0 nível de experiência.",
            legolas.toString());

    }

    @Test
    public void elfoAtiraFlechaEToString() {
        Elfo legolas = new Elfo("Legolas");
        legolas.atirarFlecha(new Dwarf());
        assertEquals("Legolas possui 41 flechas e 1 nível de experiência.",
            legolas.toString());

    }
    @Test
    public void criarElfoInformandoFlechas() {
        Elfo elrond = new Elfo("Elrond", 56);
        assertEquals(56, elrond.getFlecha().getQuantidade());
    }
    
    @Test
    public void criarElfoInformandoZeroFlechas() {
        Elfo elrond = new Elfo("Elrond", 0);
        assertEquals(0, elrond.getFlecha().getQuantidade());
    }
    
    @Test
    public void criarElfoInformandoFlechasNegativas() {
        Elfo elrond = new Elfo("Elrond", -56);
        assertEquals(42, elrond.getFlecha().getQuantidade());
    }
    @Test 
    public void fraseElfo(){
        Elfo elfoDoTeste = new Elfo("Legolas");
        String frase = "Legolas possui 42 flechas e 0 nível de experiência."; 
        assertEquals(frase, elfoDoTeste.toString());
    }
    @Test 
    public void construtorElfoCom1flecha(){
        Elfo elfoDoTeste = new Elfo("Elfo do Bem", 1);
        assertEquals(1, elfoDoTeste.getFlecha().getQuantidade());
    }
    
    @Test
    public void construtorElfocom100flechas(){
        Elfo elfoDoTeste = new Elfo("Elfo do Bem", 100);
        assertEquals(100, elfoDoTeste.getFlecha().getQuantidade());
    }
    
}
