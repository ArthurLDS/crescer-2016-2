public class Dwarf {
    private String nome;
    private int vida;
    private DataTerceiraEra dataNascimento;
    private int experiencia;
    private Status status;
    private Inventario inventario;
    
    public Dwarf(){
        this.nome = nome;
        status = Status.VIVO;
        this.dataNascimento = new DataTerceiraEra(1,1,1);
        vida = 110;
        inventario = new Inventario();
    }
    
    public Dwarf(String nome, DataTerceiraEra data){
        status = Status.VIVO;
        this.nome = nome;
        this.dataNascimento = data;
        vida = 110;
        inventario = new Inventario();
    }

    public void perderVida() {
        if(vida<=0){
            status = Status.MORTO;
            vida = 0;
            return;
        }   
        vida -= 10;
    }
    public void receberFlecha(){
        double sorte = getNumeroSorte();
        if(sorte<0)
            experiencia += 2;
        if (sorte<=100)
            perderVida();
    }
    public Status getStatus(){
        return status;
    }
    public int getVida() {
        return vida;
    }
    public int getXp() {
        return experiencia;
    }
    public double getNumeroSorte(){
        double result = 101.0;
        if(dataNascimento.ehBissexto() && (vida>=80 || vida<=90))
            return result* -33;
        else if (!(dataNascimento.ehBissexto()) && (nome != null && nome.equals("Seixas")||nome.equals("Meireles")))
            return result*33 % 100;
        return result;    
        
    }
    public void adicionarItem(Item item){
        inventario.adicionaItem(item);
    }
    public void perderItem(Item item){
        inventario.removeItem(item);
    }
    public Inventario getInventario(){
        return inventario;
    }
    public void tentarSorte(){
        double numSorte = getNumeroSorte();
        if(numSorte == -3333){
            for(int i=0; i<inventario.getItens().size(); i++){
                int quantAtual = inventario.getItens().get(i).getQuantidade();
                inventario.getItens().get(i).setQuantidade(1000+quantAtual);
            }
        }
    }
}
