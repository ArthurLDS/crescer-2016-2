public class Dwarf {
    private int vida;
    private DataTerceiraEra dataNascimento;
    
    // java type initializer
    // vai ser replicado para cada construtor
    {
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