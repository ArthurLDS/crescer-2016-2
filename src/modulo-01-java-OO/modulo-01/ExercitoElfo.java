import java.util.*;

public class ExercitoElfo{
    ArrayList<Elfo> exercito;

    public ArrayList<Elfo> getExercito(){
        return exercito;
    }

    public ExercitoElfo(){
        exercito = new ArrayList<Elfo>();
    }

    public void alistar(Elfo elfo){
        boolean podeAlistar = elfo instanceof ElfosVerdes || elfo instanceof ElfosNoturnos;
        if(podeAlistar)
            exercito.add(elfo);
            
    }

    public Elfo buscarElfo(String nome){
        Elfo escolhido = null;
        for(int i=0; i<exercito.size(); i++){
            if(exercito.get(i).getNome().equals(nome)){
                escolhido = exercito.get(i);
                break;
            }
        }
        return escolhido;
    }

    public Elfo buscarElfo(){
        return exercito.get(0);
    }

    public ArrayList<Elfo> buscarPorStatus(Status status){
        ArrayList<Elfo> escolhidosPorStatus = new ArrayList<>();
        for(int i=0; i<exercito.size(); i++){
            if(exercito.get(i).getStatus().equals(status)){
                escolhidosPorStatus.add(exercito.get(i));
            }
        }
        return escolhidosPorStatus;
    }

    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes, List<Dwarf> alvos){
        Elfo aux = null;
        for(int i=atacantes.size()-1; i>=1; i--){
            for(int j=0; j<i; j++){
                //if(atacantes.get(j).getStatus() == Status.MORTO)
                    
                if(atacantes.get(j) instanceof ElfosNoturnos && atacantes.get(j+1) instanceof ElfosVerdes){
                    aux = atacantes.get(j);
                    atacantes.set(j, atacantes.get(j+1));
                    atacantes.set(j+1, aux);
                }
            }
        }
        return atacantes;
    }
}