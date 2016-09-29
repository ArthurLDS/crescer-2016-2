import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
    public void dwarfPerdeVidaVinteVezes() {
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
        assertEquals(-90, gimli.getVida());
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
        assertEquals(2, teste.getXp()); 
    }
    @Test
    public void recebeFlechaEmSeixasENaoBissexto(){
        Dwarf teste = new Dwarf("Seixas", new DataTerceiraEra(1,1,2013));
        teste.receberFlecha();
        assertEquals(0, teste.getXp());
        assertEquals(100, teste.getVida());
    }
    
    
}
