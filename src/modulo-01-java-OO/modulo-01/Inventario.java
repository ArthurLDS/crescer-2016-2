import java.util.ArrayList;

public class Inventario
{
    ArrayList<Item> itens = new ArrayList<>();
    ArrayList<Item> itensOrdem = new ArrayList<>();

    public ArrayList<Item> getItens(){
        return itens;
    } 

    public void adicionaItem(Item item){
        itens.add(item);
    }

    public void removeItem(Item item){
        itens.remove(item);    
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
        if(itens.size()>0){

            for(int i=0; i<itens.size(); i++){
                Item itemAtual = itens.get(i);
                if(itemAtual.getQuantidade()>maior){
                    maior = itemAtual.getQuantidade();
                    maiorItem = itemAtual; 
                }
            }
        }
        boolean temItem = !itens.isEmpty();   
        return temItem ? maiorItem : null;
    }

    public void aumentar1000unidadesDosItens(){
        for(int i=0; i<itens.size(); i++){
            int quantAtual = itens.get(i).getQuantidade();
            itens.get(i).setQuantidade(1000+quantAtual);
        }
    }

    public void ordenaItens(TipoOrdenacao tipo){
        Item aux = null;
        if(tipo == TipoOrdenacao.ASCENDENTE){
            for(int i=itens.size()-1; i>= 1; i--){  
                for(int j=0; j<i ; j++){
                    if(itens.get(j).getQuantidade()>itens.get(j+1).getQuantidade()){
                        aux = itens.get(j);
                        itens.set(j, itens.get(j+1));
                        itens.set(j+1, aux);
                    }
                }
            }
        }
        else{
            for(int i=itens.size()-1; i>= 1; i--){  
                for(int j=0; j<i ; j++){
                    if(itens.get(j).getQuantidade()<itens.get(j+1).getQuantidade()){
                        aux = itens.get(j);
                        itens.set(j, itens.get(j+1));
                        itens.set(j+1, aux);
                    }
                }
            }
        }
    }
}
