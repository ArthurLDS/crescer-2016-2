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
        boolean podeAlistar = elfo instanceof ElfosVerdes || elfo instanceof ElfosNoturnos;
        if(podeAlistar)
            batalhao.put(elfo.getNome(), elfo);
    }

    public Elfo buscar(String nome){
        return batalhao.get(nome);
    }

    public HashMap<String, Elfo> buscarPorStatus(Status status){
        HashMap<String, Elfo> escolhidosByStatus = new HashMap<>();
        
        for(String keyElfo : batalhao.keySet()){
            Elfo elfoStatus = batalhao.get(keyElfo);
            if(elfoStatus.getStatus() == status)
                escolhidosByStatus.put(keyElfo, elfoStatus);

        }
        return escolhidosByStatus;     
    }
}
