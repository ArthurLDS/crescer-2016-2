public class IrishDwarf extends Dwarf{   
    
    public IrishDwarf(){
        this(null, new DataTerceiraEra(1,1,1));
    }
    
    public IrishDwarf(String nome, DataTerceiraEra data){
        super(nome, data);
    }
   
    public void tentarSorte(){
        boolean temSorte = getNumeroSorte() == -3333;
        if(temSorte){
            for(int i=0; i<getInventario().getItens().size(); i++){
                Item  itemAtual = getInventario().getItens().get(i);
                calculaSorte(itemAtual);
            } 
        }   
    }
    
    private void calculaSorte(Item item){
        int novaQuant = 0, quantItem = item.getQuantidade()<0 ? item.getQuantidade()*(-1):item.getQuantidade();   
        //Refazer usando PA
        for(int i=0; i<=quantItem; i++){
            novaQuant+=i;
        }
        item.setQuantidade(novaQuant*1000+quantItem);
    }
}
