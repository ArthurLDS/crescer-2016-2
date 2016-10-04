import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
public class DwarfTest
{
    @Test
    public void dwarfNasceCom110Vida() {
        Dwarf gimli = new Dwarf();
        assertEquals(110, gimli.getVida());
    }

    @Test
    public void dwarfPerdeVidaUmaVez() {
        Dwarf gimli = new Dwarf();
        gimli.perderVida();
        assertEquals(100, gimli.getVida());
    }

    @Test
    public void dwarfPerdeVidaDuasVezes() {
        Dwarf gimli = new Dwarf();
        gimli.perderVida();
        gimli.perderVida();
        assertEquals(90, gimli.getVida());
    }

    @Test
    public void dwarfPerdeVidaVinteVezesZeraVidaEMorre() {
        Dwarf gimli = new Dwarf();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        assertEquals(0, gimli.getVida());
    }
    @Test
    public void numSorteNBissextoSeixas(){
        Dwarf teste = new Dwarf("Seixas", new DataTerceiraEra(1,1,2014));
        teste.getNumeroSorte();
        assertEquals(33, teste.getNumeroSorte(), .0);
        //Não sei porque, mas funcionou :)
    }
    @Test
    public void numSorteNBissextoMeireles(){
        Dwarf teste = new Dwarf("Meireles", new DataTerceiraEra(1,1,2011));
        teste.getNumeroSorte();
        assertEquals(33, teste.getNumeroSorte(), .0);
    }
    @Test
    public void numSorteBissextoHpNoventa(){
        Dwarf teste = new Dwarf("nada", new DataTerceiraEra(1,1,2016));
        teste.perderVida();
        teste.perderVida();
        teste.getNumeroSorte();
        assertEquals(-3333.0, teste.getNumeroSorte(), .0);
    }
    @Test
    public void numSorteBissextoHpSetenta(){
        Dwarf teste = new Dwarf("nada", new DataTerceiraEra(1,1,2016));
        teste.perderVida();
        teste.perderVida();
        teste.perderVida();
        teste.perderVida();
        teste.perderVida();
        teste.getNumeroSorte();
        assertEquals(-3333.0, teste.getNumeroSorte(), .0);
    }
    @Test
    public void recebeFlechaComVidaCheia(){
        Dwarf teste = new Dwarf("nada", new DataTerceiraEra(1,1,2016));
        teste.receberFlecha();
        assertEquals(2, teste.getExperiencia()); 
    }
    @Test
    public void recebeFlechaEmSeixasENaoBissexto(){
        Dwarf teste = new Dwarf("Seixas", new DataTerceiraEra(1,1,2013));
        teste.receberFlecha();
        assertEquals(0, teste.getExperiencia());
        assertEquals(100, teste.getVida());
    }
    @Test
    public void dwarfMorre(){
        Dwarf teste = new Dwarf();
        for(int i=0; i<=11; i++)
            teste.perderVida();
        assertEquals(Status.MORTO, teste.getStatus());    
    }
    @Test
     public void dwarfNasceVivo(){
        Dwarf teste = new Dwarf();
        assertEquals(Status.VIVO, teste.getStatus());    
    }
    @Test
     public void dwarfMPerde13VidasEMorre(){
        Dwarf teste = new Dwarf();
        for(int i=0; i<=13; i++)
            teste.perderVida();
        assertEquals(Status.MORTO, teste.getStatus());    
    }
    @Test
     public void dwarfPerdeVidaENaoMorre(){
        Dwarf teste = new Dwarf();
        for(int i=0; i<=5; i++)
            teste.perderVida();
        assertEquals(Status.VIVO, teste.getStatus());    
    }
    @Test
     public void dwarfMPerde13Vidas(){
        Dwarf teste = new Dwarf();
        for(int i=0; i<=13; i++)
            teste.perderVida();
        assertEquals(0, teste.getVida());    
    }
    @Test
     public void dwarfMorreEPerdeMuitoMaisVida(){
        Dwarf teste = new Dwarf();
        for(int i=0; i<=20; i++)
            teste.perderVida();
        assertEquals(0, teste.getVida());    
    }
    
    @Test
    public void dwarfTemSorte(){
        Dwarf dwarf = new Dwarf("Anao", new DataTerceiraEra(1,1,2016));
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.adicionarItem(new Item("Armadura de Diamante", 2));
        dwarf.tentarSorte();
        int quantAtual = dwarf.getInventario().getItens().get(0).getQuantidade();
        assertEquals(1002, quantAtual);
    }
    @Test
    public void dwarfTemSorteCom3Itens(){
        Dwarf dwarf = new Dwarf("Anao", new DataTerceiraEra(1,1,2016));
        dwarf.adicionarItem(new Item("Armadura de Diamante", 2));
        dwarf.adicionarItem(new Item("Lury", 5));
        dwarf.tentarSorte();
        int quantAtual = dwarf.getInventario().getItens().get(1).getQuantidade();
        assertEquals(1005, quantAtual);
    }
    @Test
    public void dwarfNaoTemSorte(){
        Dwarf dwarf = new Dwarf("Anao", new DataTerceiraEra(1,1,2013));
        dwarf.adicionarItem(new Item("Armadura de Diamante", 2));
        dwarf.tentarSorte();
        int quantAtual = dwarf.getInventario().getItens().get(0).getQuantidade();
        assertEquals(2, quantAtual);
    }
    @Test
    public void dwarfAdicionaUmItem(){
        Dwarf teste = new Dwarf();
        Item item = new Item("Escudo", 4);
        teste.adicionarItem(item);
        Item fd= teste.getInventario().getItens().get(0);
        for(int i=0; i<teste.getInventario().getItens().size(); i++){
            Item itemAtual = teste.getInventario().getItens().get(i);
            if(itemAtual.getDescricao().equals(item.getDescricao())){
                assertEquals(itemAtual.getDescricao(), item.getDescricao());
            }
        
        }
    }
    
}
