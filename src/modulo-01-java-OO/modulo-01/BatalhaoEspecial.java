import java.util.AbstractMap;
import java.util.HashMap;
import java.util.ArrayList;

public class BatalhaoEspecial{
    protected HashMap<String, Elfo> batalhao;
    
    public BatalhaoEspecial(){
        batalhao = new HashMap<>();
    }

    public HashMap<String, Elfo> getContingente(){
        return batalhao;
    }

    public void alistar(Elfo elfo){
       batalhao.put(elfo.getNome(), elfo);
    }
    
    public Elfo buscar(String nome){
        return batalhao.get(nome);
    }
    
    public ArrayList<Elfo> buscarPorStatus(Status status){
       ArrayList<Elfo> escolhidosByStatus = null;
       for(int i=0; i< batalhao.size(); i++){
           escolhidosByStatus.add(batalhao.get(status));
       }
       return escolhidosByStatus;     
    }
}
