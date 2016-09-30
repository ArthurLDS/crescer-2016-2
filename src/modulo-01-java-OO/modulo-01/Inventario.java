import java.util.ArrayList;

public class Inventario
{
    ArrayList<Item> itens = new ArrayList<>();
    public ArrayList<Item> getItens(){
        return itens;
    } 
    public void adicionaItem(Item item){
        itens.add(item);
    }
    public void removeItem(Item item){
        for(int i=0; i< itens.size(); i++){
            Item itemAtual = itens.get(i);
            if(itemAtual.getDescricao().equals(item.getDescricao())){
                itens.remove(itemAtual);
            }
        }
    }
    public String getDescricaoItens(){
        String allItens="";
        for(int i=0; i<itens.size(); i++){
            Item itemAtual = itens.get(i);
            allItens += itemAtual.getDescricao() + ", ";
        }
        return allItens;
    }
}
