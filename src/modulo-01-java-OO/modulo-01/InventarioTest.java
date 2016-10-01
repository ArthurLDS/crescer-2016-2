

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InventarioTest
{
    @Test
    public void elfoDescricaoDosItens(){
        Elfo elfo = new Elfo("ads",4);
        String allItens = elfo.getInventario().getDescricaoItens();
        assertEquals("Arco, Flechas", allItens);
    }
    @Test
    public void adicionarItemNoInventario() {
        Inventario inventario = new Inventario();
        Item espadaZ = new Item("Espada Z", 1);
        inventario.adicionaItem(espadaZ);
        assertTrue(inventario.getItens().contains(espadaZ));
    }

    @Test
    public void inventarioSemAdicionarItem() {
        Inventario inventario = new Inventario();
        Item espadaZ = new Item("Espada Z", 1);
        assertFalse(inventario.getItens().contains(espadaZ));
    }

    @Test
    public void adicionarDoisItensNoInventario() {
        Inventario inventario = new Inventario();
        Item espadaZ = new Item("Espada Z", 1);
        Item botasDeFerro = new Item("Iron Boots", 1);
        inventario.adicionaItem(espadaZ);
        inventario.adicionaItem(botasDeFerro);
        assertTrue(inventario.getItens().contains(espadaZ));
        assertTrue(inventario.getItens().contains(botasDeFerro));
    }

    @Test
    public void adicionarCincoItensNoInventario() {
        Inventario inventario = new Inventario();
        Item espadaZ = new Item("Espada Z", 1);
        Item botasDeFerro = new Item("Iron Boots", 1);
        inventario.adicionaItem(espadaZ);
        inventario.adicionaItem(botasDeFerro);
        inventario.adicionaItem(botasDeFerro);
        inventario.adicionaItem(botasDeFerro);
        inventario.adicionaItem(botasDeFerro);
        assertTrue(inventario.getItens().contains(espadaZ));
        assertTrue(inventario.getItens().contains(botasDeFerro));
        assertEquals(5, inventario.getItens().size());
    }

    @Test
    public void adicionarItemNoInventarioEDepoisRemovelo() {
        Inventario inventario = new Inventario();
        Item espadaZ = new Item("Espada Z", 1);
        inventario.adicionaItem(espadaZ);
        inventario.removeItem(espadaZ);
        assertFalse(inventario.getItens().contains(espadaZ));
    }

    @Test
    public void adicionarDoisItensNoInventarioERemoverApenasUm() {
        Inventario inventario = new Inventario();
        Item espadaZ = new Item("Espada Z", 1);
        Item bastaoMagico = new Item("Bastão Mágico", 1);
        inventario.adicionaItem(espadaZ);
        inventario.adicionaItem(bastaoMagico);
        inventario.removeItem(espadaZ);
        assertFalse(inventario.getItens().contains(espadaZ));
        assertTrue(inventario.getItens().contains(bastaoMagico));
    }

    @Test
    public void removerItemSemAdicionaloAntes() {
        Inventario inventario = new Inventario();
        Item espadaZ = new Item("Espada Z", 1);
        inventario.removeItem(espadaZ);
        assertFalse(inventario.getItens().contains(espadaZ));
    }

    @Test
    public void getDescricoesItensComVariosItens() {
        Inventario inventario = new Inventario();
        inventario.adicionaItem(new Item("Adaga", 14));
        inventario.adicionaItem(new Item("Escudo", 2));
        inventario.adicionaItem(new Item("Bracelete", 56));
        assertEquals("Adaga, Escudo, Bracelete", inventario.getDescricaoItens());
    }

    @Test
    public void getDescricoesItensComApenasUmItem() {
        Inventario inventario = new Inventario();
        inventario.adicionaItem(new Item("Bracelete", 56));
        assertEquals("Bracelete", inventario.getDescricaoItens());
    }

    @Test
    public void getDescricoesItensSemItens() {
        Inventario inventario = new Inventario();
        assertEquals("", inventario.getDescricaoItens());
    }

    @Test
    public void aumentar1000UnidadesDosItens() {
        Inventario inventario = criarInventarioCom3Itens();
        inventario.aumentar1000unidadesDosItens();
        assertEquals(1002, inventario.getItens().get(0).getQuantidade());
        assertEquals(1045, inventario.getItens().get(1).getQuantidade());
        assertEquals(1003, inventario.getItens().get(2).getQuantidade());
    }
    
    @Test
    public void aumentarUnidadeSemItens() {
        Inventario inventario = new Inventario();
        inventario.aumentar1000unidadesDosItens();
        assertEquals(0, inventario.getItens().size());
    }
    
    @Test
    public void itemComMaiorQuantidadeCom3Itens() {
        Inventario inventario = criarInventarioCom3Itens();
        Item item = inventario.itemMaisPossuido();
        assertEquals("Poção polissuco", item.getDescricao());
        assertEquals(45, item.getQuantidade());
    }
    
    @Test
    public void itemComMaiorQuantidadeCom3ItensDeQuantidadesIguais() {
        Inventario inventario = new Inventario();
        inventario.adicionaItem(new Item("Espada de aço", 2));
        inventario.adicionaItem(new Item("Poção polissuco", 2));
        inventario.adicionaItem(new Item("Lucky egg", 2));
        Item item = inventario.itemMaisPossuido();
        assertEquals("Espada de aço", item.getDescricao());
        assertEquals(2, item.getQuantidade());
    }
    @Test
    public void itensOrdenadosSimplesCom4Nodos(){
        Inventario inventario = new Inventario();
        inventario.adicionaItem(new Item("Espada de diamante", 5));
        inventario.adicionaItem(new Item("Poção polissuco", 2));
        inventario.adicionaItem(new Item("Lucky egg", 3));
        inventario.adicionaItem(new Item("Espada de aço", 4));
        inventario.ordenaItens();
        assertEquals("Poção polissuco, Lucky egg, Espada de aço, Espada de diamante", inventario.getDescricaoItens());
    }
    @Test
    public void itensOrdenadosCom4NodosIguais(){
        Inventario inventario = new Inventario();
        inventario.adicionaItem(new Item("Espada de diamante", 5));
        inventario.adicionaItem(new Item("Poção polissuco", 5));
        inventario.adicionaItem(new Item("Lucky egg", 5));
        inventario.adicionaItem(new Item("Espada de aço", 5));
        inventario.ordenaItens();
        assertEquals("Espada de diamante, Poção polissuco, Lucky egg, Espada de aço", inventario.getDescricaoItens());
    }
    @Test
    public void itensOrdenadosCom5Nodos(){
        Inventario inventario = new Inventario();
        inventario.adicionaItem(new Item("Espada de diamante", 5));
        inventario.adicionaItem(new Item("Poção polissuco", 2));
        inventario.adicionaItem(new Item("Lucky egg", 3));
        inventario.adicionaItem(new Item("Espada de aço", 4));
        inventario.adicionaItem(new Item("Ultra Ball", 1));
        inventario.ordenaItens();
        assertEquals("Ultra Ball, Poção polissuco, Lucky egg, Espada de aço, Espada de diamante", inventario.getDescricaoItens());
    }
    
    // Isto NÃO É UM TESTE, é apenas um metodo auxiliar.
    private Inventario criarInventarioCom3Itens() {
        Inventario inventario = new Inventario();
        inventario.adicionaItem(new Item("Espada de aço", 2));
        inventario.adicionaItem(new Item("Poção polissuco", 45));
        inventario.adicionaItem(new Item("Lucky egg", 3));
        return inventario;
    }
    
}
