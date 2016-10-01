import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IrishDwarfTest{
   @Test
   public void irishDwarfComSorte(){
       IrishDwarf teste = new IrishDwarf("Chuck Irlandês", new DataTerceiraEra(1,1,2016));
       teste.adicionarItem(new Item("GreatBall", 5));
       teste.perderVida();
       teste.perderVida();
       teste.perderVida();
       teste.tentarSorte();
       assertEquals(15005, teste.getInventario().getItens().get(0).getQuantidade());
   }
   @Test
   public void irishDwarfSemSorte(){
       IrishDwarf teste = new IrishDwarf("Chuck Irlandês", new DataTerceiraEra(1,1,1987));
       teste.adicionarItem(new Item("GreatBall", 5));
       teste.tentarSorte();
       assertEquals(5, teste.getInventario().getItens().get(0).getQuantidade());
   }
   @Test
   public void irishDwarfSemSorteEComItemZerado(){
       IrishDwarf teste = new IrishDwarf("Chuck Irlandês", new DataTerceiraEra(1,1,1987));
       teste.adicionarItem(new Item("GreatBall", 0));
       teste.tentarSorte();
       assertEquals(0, teste.getInventario().getItens().get(0).getQuantidade());
   }
   @Test
   public void irishDwarfComSorteEComItemNegativo(){
       IrishDwarf teste = new IrishDwarf("Chuck Irlandês", new DataTerceiraEra(1,1,2016));
       teste.adicionarItem(new Item("GreatBall", -5));
       teste.perderVida();
       teste.perderVida();
       teste.perderVida();
       teste.tentarSorte();
       assertEquals(15005, teste.getInventario().getItens().get(0).getQuantidade());
    }
}
