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
        for(int i=0; i<exercito.size(); i++)
            if(exercito.get(i).getStatus().equals(status))
                escolhidosPorStatus.add(exercito.get(i));
        return escolhidosPorStatus;
    }

    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes, List<Dwarf> alvos){
        Elfo aux = null;
        for(int i=atacantes.size()-1; i>=0; i--)
            if(atacantes.get(i).getStatus() == Status.MORTO)
                atacantes.remove(i);
                
        for(int i=atacantes.size()-1; i>=1; i--){
            for(int j=0; j<i; j++){     //Esse elfoPost aí é de "Elfo Posterior"!
                Elfo elfoAtual = atacantes.get(j), elfoPost = atacantes.get(j+1);
                if(elfoAtual instanceof ElfosNoturnos && elfoPost instanceof ElfosVerdes){
                    aux = atacantes.get(j);
                    atacantes.set(j, elfoPost);
                    atacantes.set(j+1, aux);
                }
            }
        }
        return atacantes;
    }
}