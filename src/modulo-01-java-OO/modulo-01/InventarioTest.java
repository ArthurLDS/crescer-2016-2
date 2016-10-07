
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
    public void itensOrdenadosAscendenteSimplesCom4Nodos(){
        Inventario inventario = new Inventario();
        inventario.adicionaItem(new Item("Espada de diamante", 5));
        inventario.adicionaItem(new Item("Poção polissuco", 2));
        inventario.adicionaItem(new Item("Lucky egg", 3));
        inventario.adicionaItem(new Item("Espada de aço", 4));
        inventario.ordenaItens(TipoOrdenacao.ASCENDENTE);
        assertEquals("Poção polissuco, Lucky egg, Espada de aço, Espada de diamante", inventario.getDescricaoItens());
    }

    @Test
    public void itensOrdenadosAscendenteCom4NodosIguais(){
        Inventario inventario = new Inventario();
        inventario.adicionaItem(new Item("Espada de diamante", 5));
        inventario.adicionaItem(new Item("Poção polissuco", 5));
        inventario.adicionaItem(new Item("Lucky egg", 5));
        inventario.adicionaItem(new Item("Espada de aço", 5));
        inventario.ordenaItens(TipoOrdenacao.ASCENDENTE);
        assertEquals("Espada de diamante, Poção polissuco, Lucky egg, Espada de aço", inventario.getDescricaoItens());
    }

    @Test
    public void itensOrdenadosAscendenteCom5Nodos(){
        Inventario inventario = new Inventario();
        inventario.adicionaItem(new Item("UltraBall", 1));
        inventario.adicionaItem(new Item("Espada de diamante", 5));
        inventario.adicionaItem(new Item("Poção polissuco", 2));
        inventario.adicionaItem(new Item("Lucky egg", 3));
        inventario.adicionaItem(new Item("Espada de aço", 4));

        inventario.ordenaItens(TipoOrdenacao.ASCENDENTE);
        assertEquals("UltraBall, Poção polissuco, Lucky egg, Espada de aço, Espada de diamante", inventario.getDescricaoItens());
    }

    @Test
    public void itensOrdenadosDescendenteSimplesCom4Nodos(){
        Inventario inventario = new Inventario();
        inventario.adicionaItem(new Item("Espada de diamante", 5));
        inventario.adicionaItem(new Item("Poção polissuco", 2));
        inventario.adicionaItem(new Item("Lucky egg", 3));
        inventario.adicionaItem(new Item("Espada de aço", 4));
        inventario.ordenaItens(TipoOrdenacao.DESCENDENTE);
        assertEquals("Espada de diamante, Espada de aço, Lucky egg, Poção polissuco", inventario.getDescricaoItens());
    }

    @Test
    public void itensOrdenadosDescendenteCom5Nodos(){
        Inventario inventario = new Inventario();
        inventario.adicionaItem(new Item("Ultra Ball", 1));
        inventario.adicionaItem(new Item("Espada de diamante", 5));
        inventario.adicionaItem(new Item("Poção polissuco", 2));
        inventario.adicionaItem(new Item("Lucky egg", 3));
        inventario.adicionaItem(new Item("Espada de aço", 4));
        inventario.ordenaItens(TipoOrdenacao.DESCENDENTE);
        assertEquals("Espada de diamante, Espada de aço, Lucky egg, Poção polissuco, Ultra Ball", inventario.getDescricaoItens());
    }

    @Test
    public void itensOrdenadosDescendenteCom4NodosIguais(){
        Inventario inventario = new Inventario();
        inventario.adicionaItem(new Item("Espada de diamante", 5));
        inventario.adicionaItem(new Item("Poção polissuco", 5));
        inventario.adicionaItem(new Item("Lucky egg", 5));
        inventario.adicionaItem(new Item("Espada de aço", 5));
        inventario.ordenaItens(TipoOrdenacao.DESCENDENTE);
        assertEquals("Espada de diamante, Poção polissuco, Lucky egg, Espada de aço", inventario.getDescricaoItens());
    }

    @Test
    public void adc1ItemEbuscarOMesmoItemPorDescricao(){
        Inventario inventario = new Inventario();
        Item item = new Item("Espada de diamante", 5);
        inventario.adicionaItem(item);
        assertEquals(item, inventario.buscar("Espada de diamante"));
    }

    @Test
    public void adc5ItensEPesquisaUmPorDescricao(){
        Inventario inventario = new Inventario();
        Item item = new Item("Espada de diamante", 5);
        Item item1 = new Item("Espada de dia", 5);
        Item item2 = new Item("Espada de diam", 5);
        Item item3 = new Item("Espada de diaman", 5);
        Item item4 = new Item("Espada de diamant", 5);
        inventario.adicionaItem(item1);
        inventario.adicionaItem(item2);
        inventario.adicionaItem(item);
        inventario.adicionaItem(item3);
        inventario.adicionaItem(item4);
        assertEquals(item, inventario.buscar("Espada de diamante"));
    }

    @Test
    public void adc5ItensEIguaisPesquisaOPrimeiroPorDescricao(){
        Inventario inventario = new Inventario();
        Item item  = new Item("Espada de diamante", 5);
        Item item1 = new Item("Espada de diamante", 5);
        Item item2 = new Item("Espada de diamante", 5);
        Item item3 = new Item("Espada de diamante", 5);
        Item item4 = new Item("Espada de diamante", 5);
        inventario.adicionaItem(item);
        inventario.adicionaItem(item1);
        inventario.adicionaItem(item2);
        inventario.adicionaItem(item3);
        inventario.adicionaItem(item4);
        assertEquals(item, inventario.buscar("Espada de diamante"));
    }

    @Test
    public void adcZeroItensEPesquisarRetornaNull(){
        Inventario inventario = new Inventario();
        assertNull(inventario.buscar("Espada de diamante"));
    }

    @Test
    public void getMediaQuantidades3itens(){
        Inventario inventario = new Inventario();
        inventario.adicionaItem(new Item("Espada", 3));
        inventario.adicionaItem(new Item("Poção HP", 4));
        inventario.adicionaItem(new Item("Lança", 2));
        assertEquals(3, inventario.getMediaQuantidades(), 0.);
    }

    @Test
    public void getMediaQuantidades1item(){
        Inventario inventario = new Inventario();
        inventario.adicionaItem(new Item("Espada", 3));
        assertEquals(3, inventario.getMediaQuantidades(), 0.);
    }

    @Test
    public void getMediaQuantidadesQuebradaCom3itens(){
        Inventario inventario = new Inventario();
        inventario.adicionaItem(new Item("Espada", 5));
        inventario.adicionaItem(new Item("Poção HP", 6));
        inventario.adicionaItem(new Item("Lança", 6));
        assertEquals(5.6, inventario.getMediaQuantidades(), 1.);
    }

    @Test
    public void getSomatorioQuantidades4itens(){
        Inventario inventario = new Inventario();
        inventario.adicionaItem(new Item("Espada", 5));
        inventario.adicionaItem(new Item("Poção HP", 6));
        inventario.adicionaItem(new Item("Lança", 6));
        inventario.adicionaItem(new Item("GreatBall", 6));
        assertEquals(23, inventario.getSomatorioQuantidades());
    }

    @Test
    public void getSomatorioQuantidades1item(){
        Inventario inventario = new Inventario();
        inventario.adicionaItem(new Item("Espada", 5));
        assertEquals(5, inventario.getSomatorioQuantidades());
    }
    @Test
    public void unir2Inventarios(){
        Inventario inventario = new Inventario();
        inventario.adicionaItem(new Item("GreatBall", 5));
        Inventario inventario2 = new Inventario();
        inventario2.adicionaItem(new Item("UltraBall", 6));
        Inventario resultado = inventario.unir(inventario2);
        assertEquals("GreatBall", resultado.getItens().get(0).getDescricao());
        assertEquals("UltraBall", resultado.getItens().get(1).getDescricao());
    }
    @Test
    public void unir2InventariosE1semItem(){
        Inventario inventario = new Inventario();
        inventario.adicionaItem(new Item("GreatBall", 5));
        Inventario inventario2 = new Inventario();
        Inventario resultado = inventario.unir(inventario2);
        assertEquals(1, resultado.getItens().size());
    }
    @Test
    public void unir2InventariosE2semItem(){
        Inventario inventario = new Inventario();
        Inventario inventario2 = new Inventario();
        Inventario resultado = inventario.unir(inventario2);
        assertEquals(0, resultado.getItens().size());
    }
     
    // Isto NÃO É UM TESTE, é apenas um metodo auxiliar.
    private Inventario criarInventarioCom3Itens(){
        Inventario inventario = new Inventario();
        inventario.adicionaItem(new Item("Espada de aço", 2));
        inventario.adicionaItem(new Item("Poção polissuco", 45));
        inventario.adicionaItem(new Item("Lucky egg", 3));
        return inventario;
    }

}
