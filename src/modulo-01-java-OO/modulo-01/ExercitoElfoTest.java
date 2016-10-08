import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class ExercitoElfoTest{
    @Test
    public void alistaElfoVerde(){
        ExercitoElfo teste = new ExercitoElfo();
        Elfo verdao = new ElfosVerdes("Verdão da Massa", 50);
        teste.alistar(verdao);
        assertEquals("Verdão da Massa", teste.getExercito().get(0).getNome());
    }

    @Test
    public void alistaElfoNoturbo(){
        ExercitoElfo teste = new ExercitoElfo();
        Elfo verdao = new ElfosNoturnos("Verdão da Massa");
        teste.alistar(verdao);
        assertEquals("Verdão da Massa", teste.getExercito().get(0).getNome());
    }

    @Test
    public void buscaUmElfoVerde(){
        ExercitoElfo teste = new ExercitoElfo();
        Elfo verdao = new ElfosVerdes("Verdão da Massa", 50);
        teste.alistar(verdao);
        assertEquals(verdao, teste.buscarElfo("Verdão da Massa"));
    }

    @Test
    public void buscaUmElfoVerdeEntreMuitos(){
        ExercitoElfo teste = new ExercitoElfo();
        Elfo verdao = new ElfosVerdes("Verdão da Massa", 50);
        teste.alistar(new ElfosVerdes("Verdão", 50));
        teste.alistar(verdao);
        teste.alistar(new ElfosVerdes("Verdão Ruim", 50));
        teste.alistar(new ElfosVerdes("Recruta", 50));
        assertEquals(verdao, teste.buscarElfo("Verdão da Massa"));
    }

    @Test
    public void buscaUmElfoVerdeEntreMuitosComMesmoNome(){
        ExercitoElfo teste = new ExercitoElfo();
        Elfo verdao = new ElfosVerdes("Verdão da Massa", 50);
        teste.alistar(verdao);
        teste.alistar(new ElfosVerdes("Verdão da Massa", 50));
        teste.alistar(new ElfosVerdes("Verdão da Massa", 50));
        teste.alistar(new ElfosVerdes("Verdão da Massa", 50));
        assertEquals(verdao, teste.buscarElfo("Verdão da Massa"));
    }

    @Test
    public void buscaTresElfoPorStatusVivo(){
        ExercitoElfo teste = new ExercitoElfo();
        Elfo verdao = new ElfosVerdes("Verdão da Massa", 50);
        Elfo verdim = new ElfosVerdes("Verdão do Povo", 50);
        Elfo verde = new ElfosVerdes("Verdão do Povo", 50);
        teste.alistar(verdao);
        teste.alistar(verdim);
        teste.alistar(verde);

        ArrayList<Elfo> resultado = teste.buscarPorStatus(Status.VIVO);
        assertEquals(3, resultado.size());
    }

    @Test
    public void buscaTresElfoPorStatusMortoENenhumEstaMorto(){
        ExercitoElfo teste = new ExercitoElfo();
        Elfo verdao = new ElfosVerdes("Verdão da Massa", 50);
        Elfo verdim = new ElfosVerdes("Verdão do Povo", 50);
        Elfo verde = new ElfosVerdes("Verdão do Povo", 50);
        teste.alistar(verdao);
        teste.alistar(verdim);
        teste.alistar(verde);
        ArrayList<Elfo> resultado = teste.buscarPorStatus(Status.MORTO);
        assertEquals(0, resultado.size());
    }

    @Test
    public void getOrdemDeAtaque4Elfos(){
        ExercitoElfo exercito = new ExercitoElfo();
        List<Elfo> elfos = new ArrayList<>();
        elfos.add(new ElfosNoturnos("2"));
        elfos.add(new ElfosVerdes("1", 50));
        elfos.add(new ElfosNoturnos("2"));
        elfos.add(new ElfosVerdes("1", 50));
        elfos.add(new ElfosVerdes("1", 50));
        exercito.getOrdemDeAtaque(elfos, new ArrayList<>());
        assertEquals(elfos.get(0).getNome(), "1");
        assertEquals(elfos.get(1).getNome(), "1");
        assertEquals(elfos.get(2).getNome(), "1");
        assertEquals(elfos.get(3).getNome(), "2");
        assertEquals(elfos.get(4).getNome(), "2");
    }
    @Test
    public void getOrdemDeAtaque4ElfosE2Mortos(){
        ExercitoElfo exercito = new ExercitoElfo();
        List<Elfo> elfos = new ArrayList<>();
        elfos.add(new ElfosNoturnos("2"));
        elfos.add(new ElfosVerdes("1", 50));
        elfos.add(new ElfosNoturnos("2"));
        
        ElfosNoturnos enMorto = new ElfosNoturnos("2");
        for(int i=0; i<=90; i++)
            enMorto.perderVida();
        elfos.add(enMorto);
        
        ElfosNoturnos enMorto2 = new ElfosNoturnos("2");
        for(int i=0; i<=90; i++)
            enMorto2.perderVida();
        elfos.add(enMorto2);
        
        exercito.getOrdemDeAtaque(elfos, new ArrayList<>());
        assertEquals(elfos.get(0).getNome(), "1");
        assertEquals(elfos.get(1).getNome(), "2");
        assertEquals(elfos.get(2).getNome(), "2");
    }
    @Test
    public void getOrdemDeAtaque2Elfos(){
        ExercitoElfo exercito = new ExercitoElfo();
        List<Elfo> elfos = new ArrayList<>();
        elfos.add(new ElfosNoturnos("2"));
        elfos.add(new ElfosVerdes("1", 50));
        
        exercito.getOrdemDeAtaque(elfos, new ArrayList<>());
        
        assertEquals(2, elfos.size());
        assertEquals(elfos.get(0).getNome(), "1");
        assertEquals(elfos.get(1).getNome(), "2"); 
    }
    @Test
    public void getOrdemDeAtaque2ElfosMortos(){
        ExercitoElfo exercito = new ExercitoElfo();
        List<Elfo> elfos = new ArrayList<>();
        
        ElfosNoturnos enMorto = new ElfosNoturnos("2");
        for(int i=0; i<=90; i++)
            enMorto.perderVida();
        elfos.add(enMorto);
        
        ElfosNoturnos enMorto2 = new ElfosNoturnos("2");
        for(int i=0; i<=100; i++)
            enMorto2.perderVida();
        elfos.add(enMorto2);
        
        exercito.getOrdemDeAtaque(elfos, new ArrayList<>());
        assertEquals(0, elfos.size());
    }
}
