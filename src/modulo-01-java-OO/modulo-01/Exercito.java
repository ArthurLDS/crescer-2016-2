import java.util.*;
public interface Exercito{
    
    Elfo[] getContingente();

    void alistar(Elfo elfo);

    Elfo buscar(String nome);

    ArrayList<Elfo> buscar(Status status);
    

}
