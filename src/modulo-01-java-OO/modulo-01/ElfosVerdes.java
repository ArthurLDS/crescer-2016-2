public class ElfosVerdes extends Elfo{
    
    public ElfosVerdes(){
        super();
        inventario.adicionaItem(new Item("Espada de aço valiriano", 1));
        inventario.adicionaItem(new Item("Flecha de Vidro", 42));
    }
    
    public Item getEspadaDeAcoValiriano(){
         return inventario.getItens().get(0);
    }
    
    public Item getFlechaDeVidro(){
         return inventario.getItens().get(1);
    }
    
    public void atirarFlechaDeVidro(Dwarf dwarf) {
        boolean temFlecha = getFlechaDeVidro().getQuantidade() > 0;
        if (temFlecha) {
            getFlecha().setQuantidade(getFlechaDeVidro().getQuantidade() - 1);
            experiencia += 2;
            dwarf.perderVida();
        }
    }
    
}
