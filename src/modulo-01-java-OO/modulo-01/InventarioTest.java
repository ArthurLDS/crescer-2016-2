

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
    //@Test
    /*public void ordenaItemDoElfo(){
        Elfo elfo = new Elfo("Doug",6);
        elfo.getInventario().ordenaItens();
        for(int i=0; i< getItens().size(); i++){
            String itensEmOrdem = getItens().getQuantidade();
        }
             
    }*/
}
