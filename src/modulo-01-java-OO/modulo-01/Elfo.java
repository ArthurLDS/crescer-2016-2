public class Elfo{
    private String nome;
    private Item arco;
    private Item flecha;
    private Adversario dwarves;
    private int xp;
    
    public Elfo(String n){
        nome = n;
        xp = 0;
        arco = new Item("Arco", 1);   
        flecha = new Item("Flechas", 42);
        dwarves = new Adversario("Dwarves", 110);
    }
    public void setNome(String n){
        nome = n;
    }

    public String getNome(){
        return nome;
    }
    
    public void atirarFlechaRefactory(){
        if(flecha.getQuantidade()>0){
           flecha.setQuantidade(flecha.getQuantidade()-1);
           xp++;
           dwarves.setHp(dwarves.getHp()-10);
        }
    }
    public Item getFlechaDpsAtirar(){
        atirarFlechaRefactory();
        return flecha;
    }
    public Item getArco(){
        return arco;
    }
    public Item getFlecha(){
        return flecha;
    }
    public Adversario getAdversario(){
        return dwarves;
    } 
    public Adversario getDpsAdversarioLevar(){
        atirarFlechaRefactory();
        return dwarves;
    }
}