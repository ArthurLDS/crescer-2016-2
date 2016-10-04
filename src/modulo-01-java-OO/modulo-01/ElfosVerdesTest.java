import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfosVerdesTest
{
    @Test
    public void ElfoVerdeAtiraFlechaERecebe2deXP(){
        ElfosVerdes teste = new ElfosVerdes();
        teste.atirarFlechaDeVidro(new Dwarf());
        assertEquals(2, teste.getExperiencia());
    }
    @Test
    public void ElfoVerdeNaoAtiraFlechaENRecebeXP(){
        ElfosVerdes teste = new ElfosVerdes();
        assertEquals(0, teste.getExperiencia());
    }
    @Test
    public void ElfoVerdeAtiraFlechaEPerdeUmaFlecha(){
        ElfosVerdes teste = new ElfosVerdes();
        teste.atirarFlechaDeVidro(new Dwarf());
        int quantFlechas = teste.getFlechaDeVidro().getQuantidade();
        assertEquals(41, quantFlechas);
    }
    @Test
    public void ElfoVerdeNAtiraFlechaENPerdeFlecha(){
        ElfosVerdes teste = new ElfosVerdes();
        int quantFlechas = teste.getFlechaDeVidro().getQuantidade();
        assertEquals(42, quantFlechas);
    }
    @Test
    public void ElfoVerdeAtira42FlechasEPerdeTodasFlechas(){
        ElfosVerdes teste = new ElfosVerdes();
        for(int i=0; i<42; i++)
            teste.atirarFlechaDeVidro(new Dwarf());
        int quantFlechas = teste.getFlechaDeVidro().getQuantidade();
        assertEquals(0, quantFlechas);
    }
    @Test
    public void ElfoVerdeAtira42FlechasEXpFica84(){
        ElfosVerdes teste = new ElfosVerdes();
        for(int i=0; i<42; i++)
            teste.atirarFlechaDeVidro(new Dwarf());
        assertEquals(84, teste.getExperiencia());
    }
}
