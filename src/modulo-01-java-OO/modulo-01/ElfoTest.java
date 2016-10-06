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
        elfo.atirarFlechas(balin,12);
        assertEquals(100, balin.getVida());
    }

    @Test
    public void elfoAtiraDuasFlechaEmUmDwarf() {
        Elfo elfo = new Elfo("Batman");
        Dwarf balin = new Dwarf();
        elfo.atirarFlechas(balin,12);
        elfo.atirarFlechas(balin,12);
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
        legolas.atirarFlechas(new Dwarf(), 1);
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
    @Test
    public void elfoNasceVivo(){
        Elfo elfo = new Elfo("Alfredo");
        assertEquals(Status.VIVO, elfo.getStatus());
    }
    @Test
    public void elfoDescricaoDosItens(){
        Elfo elfo = new Elfo("Neymidia", 60);
        String allItens = elfo.getInventario().getDescricaoItens();
        assertEquals("Arco, Flechas", allItens);
    }
    @Test
    public void elfoMaiorItemPossuidoFlecha(){
        Elfo elfo = new Elfo("Neymidia", 60);
        elfo.getInventario().adicionaItem(new Item("Armadura", 5));
        Item maiorItem = elfo.getInventario().itemMaisPossuido();
        assertEquals(60, maiorItem.getQuantidade());
    }
    @Test
    public void adicionarItemNoInventario() {
        Elfo elfo = new Elfo("Legolas", 30);
        Item espadaZ = new Item("Espada Z", 1);
        elfo.adicionarItem(espadaZ);
        assertTrue(elfo.getInventario().getItens().contains(espadaZ));
    }
    @Test 
    public void nasceUmElfoEIncrementaCont(){
        int atual = Elfo.contElfos;
        Elfo elfo = new Elfo("Legolas", 30);
        int depois = Elfo.contElfos;
        assertEquals(1, depois-atual);
    }
    @Test 
    public void nasce3ElfoEIncrementaCont(){
        int atual = Elfo.contElfos;
        Elfo elfo = new Elfo("Legolas", 30);
        Elfo elf = new Elfo("Legoas", 30);
        Elfo el = new Elfo("Lelas", 30);
        int depois = Elfo.contElfos;
        assertEquals(3, depois-atual);
    }
    @Test 
    public void nasceZeroElfoeNIncrementaCont(){
        int atual = Elfo.contElfos;
        int depois = Elfo.contElfos;
        assertEquals(0, depois-atual);
    }
}
