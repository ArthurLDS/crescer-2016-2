import java.util.*;
public interface Estrategias{
    
    List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes, TipoOrdenacao ordem) throws ContingenteDesproporcionalException;
    
    List<Elfo> getOrdemDeAtaqueItercalado(List<Elfo> atacantes) throws ContingenteDesproporcionalException;
    
}
