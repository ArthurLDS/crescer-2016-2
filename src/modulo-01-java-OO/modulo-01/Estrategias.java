import java.util.*;
public interface Estrategias{
    
    List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes);
    
    List<Elfo> getOrdemDeAtaqueItercalado(List<Elfo> atacantes);
    
}
