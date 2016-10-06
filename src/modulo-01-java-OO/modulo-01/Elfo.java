public class Elfo extends Personagem{
    protected double vida;
    protected static int contElfos = 0;
    
    {
        vida = 100;
        contElfos++;
    }
    public static int getContElfos(){
        return contElfos;
    }
    
    protected void finalize() throws Throwable {
        super.finalize();
        Elfo.contElfos--;
    }
    
    public Elfo(String n) {
        // Chamando construtor debaixo
        this(n, 42);
    }
    
    public Elfo(String nome, int quantidadeFlechas) {
        super(nome);
        inventario.adicionaItem(new Item("Arco", 1));
        inventario.adicionaItem(new Item("Flechas", quantidadeFlechas >= 0 ? quantidadeFlechas : 42));
    }
    public Elfo(){
        super(null);
    }

    public Item getArco() {
        return inventario.getItens().get(0);
    }

    public Item getFlecha() {
        return inventario.getItens().get(1);
    }

    protected void atirarFlechas(Dwarf dwarf, int fatorExperiencia) {
        int quantidadeFlechas = getFlecha().getQuantidade();
        boolean temFlecha = quantidadeFlechas > 0;
        if (temFlecha) {
            getFlecha().setQuantidade(quantidadeFlechas - 1);
            experiencia += 1 * fatorExperiencia;
            dwarf.perderVida();
        }
    }

    public String toString() {
        //return "<nome> possui <flechas> flechas e <exp> níveis de experiência.";
        boolean flechaNoSingular = this.getFlecha().getQuantidade() == 1;
        boolean experienciaNoSingular = this.experiencia == 0 || this.experiencia == 1;

        return String.format("%s possui %d %s e %d %s de experiência.",
            this.nome,
            getFlecha().getQuantidade(),
            // ?:
            flechaNoSingular ? "flecha" : "flechas",
            this.experiencia,
            experienciaNoSingular ? "nível" : "níveis"
        );
    }
    
    public double getVida(){
        return vida;
    }
}