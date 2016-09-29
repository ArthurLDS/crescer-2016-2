public class Dwarf {
    private String nome;
    private int vida;
    private DataTerceiraEra dataNascimento;
    
    // java type initializer
    // vai ser replicado para cada construtor
    public Dwarf(String nome, DataTerceiraEra data){
        this.nome = nome;
        this.dataNascimento = data;
        vida = 110;
    }

    public void perderVida() {
        vida -= 10;
    }

    public int getVida() {
        return vida;
    }
}
// Dwarf gimli;