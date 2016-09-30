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
        /*for(int i=0; i< itens.size(); i++){
            Item itemAtual = itens.get(i);
            if(itemAtual.getDescricao().equals(item.getDescricao())){*/
          itens.remove(item);
        //    }
        //}
    }

    public String getDescricaoItens(){
        String allItens="";
        for(int i=0; i<itens.size(); i++){
            Item itemAtual = itens.get(i);
            if(i==itens.size()-1)
                allItens += itemAtual.getDescricao();
            else
                allItens += itemAtual.getDescricao() + ", ";
        }
        return allItens;
    }

    public Item itemMaisPossuido(){
        int maior = 0;
        Item maiorItem = itens.get(0);
        for(int i=0; i<itens.size(); i++){
            Item itemAtual = itens.get(i);
            if(itemAtual.getQuantidade()>maior){
                maior = itemAtual.getQuantidade();
                maiorItem = itemAtual; 
            }
        }
        return maiorItem;
    }
    public void aumentar1000unidadesDosItens(){
        for(int i=0; i<itens.size(); i++){
                int quantAtual = itens.get(i).getQuantidade();
                itens.get(i).setQuantidade(1000+quantAtual);
           }
    }
}
