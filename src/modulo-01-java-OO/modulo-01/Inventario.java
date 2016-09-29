import

public class Inventario
{
    Arraylist<Item> itens = new ArrayList<>();
   
    //public Item getItens(){
    //    
    //} 
    public void adicionaItem(Item item){
        itens.add(item);
    }
    public void removeItem(item){
        itens.remove(item);
        
    }
}
