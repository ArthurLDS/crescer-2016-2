import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExercitoElfoTest{
    @Test
    public void alistaElfoVerde(){
        ExercitoElfo teste = new ExercitoElfo();
        Elfo verdao = new ElfosVerdes("Verdão da Massa");
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
        Elfo verdao = new ElfosVerdes("Verdão da Massa");
        teste.alistar(verdao);
        assertEquals(verdao, teste.buscarElfo("Verdão da Massa"));
    }
    @Test
    public void buscaUmElfoVerdeEntreMuitos(){
        ExercitoElfo teste = new ExercitoElfo();
        Elfo verdao = new ElfosVerdes("Verdão da Massa");
        teste.alistar(new ElfosVerdes("Verdão"));
        teste.alistar(verdao);
        teste.alistar(new ElfosVerdes("Verdão Ruim"));
        teste.alistar(new ElfosVerdes("Recruta"));
        assertEquals(verdao, teste.buscarElfo("Verdão da Massa"));
    }
    @Test
    public void buscaUmElfoVerdeEntreMuitosComMesmoNome(){
        ExercitoElfo teste = new ExercitoElfo();
        Elfo verdao = new ElfosVerdes("Verdão da Massa");
        teste.alistar(verdao);
        teste.alistar(new ElfosVerdes("Verdão da Massa"));
        teste.alistar(new ElfosVerdes("Verdão da Massa"));
        teste.alistar(new ElfosVerdes("Verdão da Massa"));
        assertEquals(verdao, teste.buscarElfo("Verdão da Massa"));
    }
}
