import java.util.ArrayList;
public class ExercitoElfo
{
    ArrayList<Elfo> exercito;
    ArrayList<Elfo> escolhidosPorStatus;
    
    public ArrayList<Elfo> getExercito(){
        return exercito;
    }
    public ExercitoElfo(){
        exercito = new ArrayList<Elfo>();
    }

    public void alistar(ElfosVerdes elfo){
        exercito.add(elfo);
    }

    public void alistar(ElfosNoturnos elfo){
        exercito.add(elfo);
    }

    public Elfo buscarElfo(String nome){
        Elfo escolhido = null;
        for(int i=0; i<exercito.size(); i++){
            if(exercito.get(i).getNome()==nome){
                escolhido = exercito.get(i);
            }
        }
        return escolhido;
    }
    public Elfo buscarElfo(){
        return exercito.get(0);
    }
    public ArrayList<Elfo> buscarPorStatus(Status status){
        
        for(int i=0; i<exercito.size(); i++){
            if(exercito.get(i).getStatus() == status){
                escolhidosPorStatus.add(exercito.get(i));
                return escolhidosPorStatus;
            }
        }
        return null;
    }
}