public class Personagem{

    protected String nome;
    protected Inventario inventario;
    protected Status status;
    protected int experiencia;
    
    public Personagem(){
    
    }
    public void setNome(String n) {
        nome = n;
    }

    public String getNome() {
        return nome;
    }

    public Inventario getInventario(){
        return inventario;
    }

    public Status getStatus(){
        return status;
    } 

    public int getExperiencia() {
        return experiencia;
    }
}
