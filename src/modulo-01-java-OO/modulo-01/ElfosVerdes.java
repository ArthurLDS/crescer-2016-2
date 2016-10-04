public class ElfosVerdes extends Elfo{
    private Item flechaDeVidro;
    
    public ElfosVerdes(String nome){
        super(nome);
        inventario.adicionaItem(new Item("Espada de aço valiriano", 1));
        inventario.adicionaItem(new Item("Flecha de Vidro", 42));
    }
    
    public Item getEspadaDeAcoValiriano(){
         return inventario.getItens().get(2);
    }
    
    public Item getFlechaDeVidro(){
         return inventario.getItens().get(3);
    }
    
    public void atirarFlechaDeVidro(Dwarf dwarf) {
        boolean temFlecha = getFlechaDeVidro().getQuantidade() > 0;
        if (temFlecha) {
            getFlechaDeVidro().setQuantidade(getFlechaDeVidro().getQuantidade() - 1);
            experiencia += 2;
            dwarf.perderVida();
        }
    }
    
}
