import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaoEspecialTest{
    @Test
    public void alistaUmElfoEPesquisa(){
        BatalhaoEspecial batalhao = new BatalhaoEspecial();
        Elfo elfo = new ElfosVerdes("Elfão",80);
        batalhao.alistar(elfo);
        assertEquals(elfo, batalhao.buscar(elfo.getNome()));
    }

    @Test
    public void alistaDoisElfosEPesquisaOPrimeiro(){
        BatalhaoEspecial batalhao = new BatalhaoEspecial();
        Elfo elfo = new ElfosVerdes("Elfão",80);
        Elfo elfo2 = new ElfosVerdes("Elfão2",80);
        batalhao.alistar(elfo);
        batalhao.alistar(elfo2);
        assertEquals(elfo, batalhao.buscar(elfo.getNome()));
    }

    @Test
    public void alistaVariosElfosEPesquisa(){
        BatalhaoEspecial batalhao = new BatalhaoEspecial();
        Elfo elfo1 = new ElfosVerdes("Elfão7",80);
        Elfo elfo2 = new ElfosVerdes("Elfão78",80);
        Elfo elfo = new ElfosVerdes("Elfão da Massa",80);
        Elfo elfo3 = new ElfosVerdes("Elfão5",80);
        Elfo elfo4 = new ElfosVerdes("Elfão4",80);
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

    @Test
    public void alista1ElfoEPesquisaVivo(){
        BatalhaoEspecial batalhao = new BatalhaoEspecial();
        batalhao.alistar(new ElfosVerdes("Elfo da Mascada",80));
        assertEquals(1, batalhao.buscarPorStatus(Status.VIVO).size());
    }

    @Test
    public void alista1ElfoEPesquisaMorto(){
        BatalhaoEspecial batalhao = new BatalhaoEspecial();
        ElfosNoturnos elfo =  new ElfosNoturnos("Elfo da Mascada");
        for(int i=0; i<=90; i++)
            elfo.perderVida();
        batalhao.alistar(elfo); 
        assertEquals(1, batalhao.buscarPorStatus(Status.MORTO).size());
    }

    @Test
    public void alista2ElfosEPesquisaMortos(){
        BatalhaoEspecial batalhao = new BatalhaoEspecial();
        ElfosNoturnos elfo =  new ElfosNoturnos("Elfo da Mascada");
        for(int i=0; i<=90; i++)
            elfo.perderVida();
        ElfosNoturnos elfo1 =  new ElfosNoturnos("Elf da Mascada");
        for(int i=0; i<=90; i++)
            elfo1.perderVida();
        batalhao.alistar(elfo);
        batalhao.alistar(elfo1);
        assertEquals(2, batalhao.buscarPorStatus(Status.MORTO).size());
    }

    @Test
    public void alista6ElfosEPesquisa4Vivos(){
        BatalhaoEspecial batalhao = new BatalhaoEspecial();
        ElfosNoturnos elfo =  new ElfosNoturnos("Elfo da Masada");
        for(int i=0; i<=90; i++)
            elfo.perderVida();
        ElfosNoturnos elfo1 =  new ElfosNoturnos("Elf da Mascada");
        for(int i=0; i<=90; i++)
            elfo1.perderVida();
        ElfosNoturnos elfo2 =  new ElfosNoturnos("Elf Mcada");
        ElfosNoturnos elfo3 =  new ElfosNoturnos("Eo dascada");
        ElfosNoturnos elfo4 =  new ElfosNoturnos("Elfo ddda Masca");
        ElfosNoturnos elfo5 =  new ElfosNoturnos("Elfoada");
        batalhao.alistar(elfo);
        batalhao.alistar(elfo1);
        batalhao.alistar(elfo2);
        batalhao.alistar(elfo3);
        batalhao.alistar(elfo4);
        batalhao.alistar(elfo5);
        assertEquals(4, batalhao.buscarPorStatus(Status.VIVO).size());
    }

    @Test
    public void alista6ElfosEPesquisa2Mortos(){
        BatalhaoEspecial batalhao = new BatalhaoEspecial();
        
        ElfosNoturnos elfo2 =  new ElfosNoturnos("Elf Mcada");
        ElfosNoturnos elfo3 =  new ElfosNoturnos("Eo dascada");
        ElfosNoturnos elfo =  new ElfosNoturnos("Elfo da Masada");
        for(int i=0; i<=90; i++)
            elfo.perderVida();
        ElfosNoturnos elfo1 =  new ElfosNoturnos("Elf da Mascada");
        for(int i=0; i<=90; i++)
            elfo1.perderVida();
        ElfosNoturnos elfo4 =  new ElfosNoturnos("Elfo ddda Masca");
        ElfosNoturnos elfo5 =  new ElfosNoturnos("Elfoada");
        batalhao.alistar(elfo);
        batalhao.alistar(elfo1);
        batalhao.alistar(elfo2);
        batalhao.alistar(elfo3);
        batalhao.alistar(elfo4);
        batalhao.alistar(elfo5);
        assertEquals(2, batalhao.buscarPorStatus(Status.MORTO).size());
    }
}
