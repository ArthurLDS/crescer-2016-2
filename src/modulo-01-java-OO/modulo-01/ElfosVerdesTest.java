import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfosVerdesTest
{
    @Test
    public void ElfoVerdeAtiraFlechaERecebe2deXP(){
        ElfosVerdes teste = new ElfosVerdes("", 40);
        teste.atirarFlecha(new Dwarf());
        assertEquals(2, teste.getExperiencia());
    }
    @Test
    public void ElfoVerdeNaoAtiraFlechaENRecebeXP(){
        ElfosVerdes teste = new ElfosVerdes("", 40);
        assertEquals(0, teste.getExperiencia());
    }
    @Test
    public void ElfoVerdeAtiraFlechaEPerdeUmaFlecha(){
        ElfosVerdes teste = new ElfosVerdes("", 42);
        teste.atirarFlecha(new Dwarf());
        int quantFlechas = teste.getFlecha().getQuantidade();
        assertEquals(41, quantFlechas);
    }
    @Test
    public void ElfoVerdeNAtiraFlechaENPerdeFlecha(){
        ElfosVerdes teste = new ElfosVerdes("", 42);
        int quantFlechas = teste.getFlecha().getQuantidade();
        assertEquals(42, quantFlechas);
    }
    @Test
    public void ElfoVerdeAtira42FlechasEPerdeTodasFlechas(){
        ElfosVerdes teste = new ElfosVerdes("", 40);
        for(int i=0; i<42; i++)
            teste.atirarFlecha(new Dwarf());
        int quantFlechas = teste.getFlecha().getQuantidade();
        assertEquals(0, quantFlechas);
    }
    @Test
    public void ElfoVerdeAtira42FlechasEXpFica84(){
        ElfosVerdes teste = new ElfosVerdes("", 42);
        for(int i=0; i<42; i++)
            teste.atirarFlecha(new Dwarf());
        assertEquals(84, teste.getExperiencia());
    }
}
