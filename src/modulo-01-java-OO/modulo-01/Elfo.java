public class Elfo {
    private String nome;
    private int experiencia;
    private Status status;
    private Inventario inventario;
    
    public Elfo(String n) {
        // Chamando construtor debaixo
        this(n, 42);
    }
    
    public Elfo(String nome, int quantidadeFlechas) {
        status = Status.VIVO;
        this.nome = nome;
        inventario = new Inventario();
        inventario.adicionaItem(new Item("Arco", 1));
        inventario.adicionaItem(new Item("Flechas", quantidadeFlechas >= 0 ? quantidadeFlechas : 42));
    }

    public void setNome(String n) {
        nome = n;
    }

    public String getNome() {
        return nome;
    }
    public Status getStatus() {
        return status;
    }

    public Item getArco() {
        return inventario.getItens().get(0);
    }

    public int getExperiencia() {
        return experiencia;
    }

    public Item getFlecha() {
        return inventario.getItens().get(1);
    }

    public void atirarFlecha(Dwarf dwarf) {
        boolean temFlecha = getFlecha().getQuantidade() > 0;
        if (temFlecha) {
            getFlecha().setQuantidade(getFlecha().getQuantidade() - 1);
            experiencia++;
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
    public Inventario getInventario(){
        return inventario;
    }
    /*public void atirarFlechaRefactory() {
    experiencia++;
    flecha.setQuantidade(flecha.getQuantidade()-1);
    }*/
}