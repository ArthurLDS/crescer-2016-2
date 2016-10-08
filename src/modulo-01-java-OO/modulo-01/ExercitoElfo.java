import java.util.*;

public class ExercitoElfo implements Estrategias{
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

    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes){

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

    public List<Elfo> getOrdemDeAtaqueItercalado(List<Elfo> atacantes){
        atacantes = getOrdemDeAtaque(atacantes);
        ArrayList<Elfo> metade1 = new ArrayList<>();
        ArrayList<Elfo> metade2 = new ArrayList<>();
        
        int metade = atacantes.size() / 2, x=0, y=1;
        for(int i=0; i<atacantes.size(); i++){
            if(i<metade)
                metade1.add(atacantes.get(i));
            else
                metade2.add(atacantes.get(i));
        }
        for(int i=0; i<metade1.size(); i++){
            atacantes.set(x, metade1.get(i));
            x+=2;
        }
        y=1;
        for(int i=0; i<metade2.size(); i++){
            atacantes.set(y, metade2.get(i));
            y+=2;
        }
        
        return atacantes;
    }
}