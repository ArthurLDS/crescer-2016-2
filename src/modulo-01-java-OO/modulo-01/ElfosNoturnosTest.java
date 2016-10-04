import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfosNoturnosTest
{
    @Test
    public void elfoNoturnoAtiraFlehcaE3GanhaXp(){
        ElfosNoturnos teste = new ElfosNoturnos("Elfo da night");
        teste.atirarFlecha(new Dwarf());
        assertEquals(3, teste.getExperiencia());
    }
    @Test
    public void elfoNoturnoAtira10FlehcaE3GanhaXp(){
        ElfosNoturnos teste = new ElfosNoturnos("Elfo da night");
        for(int i=0; i<10; i++)
            teste.atirarFlecha(new Dwarf());
        assertEquals(30, teste.getExperiencia());
    }
    @Test
    public void elfoNoturnoNAtiraFlehcaENGanhaXp(){
        ElfosNoturnos teste = new ElfosNoturnos("Elfo da night");
        assertEquals(0, teste.getExperiencia());
    }
    @Test
    public void elfoNoturnoAtira3FlehcaEPedeVida(){
        ElfosNoturnos teste = new ElfosNoturnos("Elfo da night");
        teste.atirarFlecha(new Dwarf());
        teste.atirarFlecha(new Dwarf());
        teste.atirarFlecha(new Dwarf());
        assertEquals(85.732, teste.getVida(), 0.01);
    }
    @Test
    public void elfoNoturnoMorre(){
        ElfosNoturnos teste = new ElfosNoturnos("Elfo da Night");
        for(int i=0; i<=90;i++)
            teste.perderVida();
        assertEquals(Status.MORTO, teste.getStatus());    
    }
    @Test
    public void elfoNoturnoNMorre(){
        ElfosNoturnos teste = new ElfosNoturnos("Elfo da Night");
        for(int i=0; i<=80;i++)
            teste.perderVida();
        assertEquals(Status.VIVO, teste.getStatus());    
    }
}
