import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

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
}
