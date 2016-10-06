import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaoEspecialTest{
    @Test
    public void alistaUmElfoEPesquisa(){
        BatalhaoEspecial batalhao = new BatalhaoEspecial();
        Elfo elfo = new Elfo("Elfão",80);
        batalhao.alistar(elfo);
        assertEquals(elfo, batalhao.buscar(elfo.getNome()));
    }
    @Test
    public void alistaDoisElfosEPesquisaOPrimeiro(){
        BatalhaoEspecial batalhao = new BatalhaoEspecial();
        Elfo elfo = new Elfo("Elfão",80);
        Elfo elfo2 = new Elfo("Elfão2",80);
        batalhao.alistar(elfo);
        batalhao.alistar(elfo2);
        assertEquals(elfo, batalhao.buscar(elfo.getNome()));
    }
    @Test
    public void alistaVariosElfosEPesquisa(){
        BatalhaoEspecial batalhao = new BatalhaoEspecial();
        Elfo elfo1 = new Elfo("Elfão7",80);
        Elfo elfo2 = new Elfo("Elfão78",80);
        Elfo elfo = new Elfo("Elfão da Massa",80);
        Elfo elfo3 = new Elfo("Elfão5",80);
        Elfo elfo4 = new Elfo("Elfão4",80);
        batalhao.alistar(elfo);
        batalhao.alistar(elfo1);
        batalhao.alistar(elfo2);
        batalhao.alistar(elfo3);
        batalhao.alistar(elfo4);
        assertEquals(elfo, batalhao.buscar("Elfão da Massa"));
    }
    @Test
    public void alistaZeroElfosEPesquisaVoltaNull(){
        BatalhaoEspecial batalhao = new BatalhaoEspecial();
        assertNull(batalhao.buscar("Paulão"));
    }
    
    //@Test
    public void alista1ElfoEPesquisaVivo(){
        BatalhaoEspecial batalhao = new BatalhaoEspecial();
        Elfo elfo = new Elfo("Elfão",80);
        batalhao.alistar(elfo);
        assertEquals(1, batalhao.buscarPorStatus(Status.VIVO).size());
    }
    @Test
    public void alista1ElfoEPesquisaMorto(){
        
    }
    @Test
    public void alista5ElfosEPesquisaMortos(){
        
    }
    @Test
    public void alista5ElfosEPesquisaVivos(){
        
    }
    @Test
    public void alistaZeroElfosEPesquisaVivos(){
        
    }
}
