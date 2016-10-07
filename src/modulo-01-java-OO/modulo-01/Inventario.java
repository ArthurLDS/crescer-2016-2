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
        Item aux;
        for(int i=itens.size()-1; i>= 1; i--){  
            for(int j=0; j<i ; j++){
                if(tipo == TipoOrdenacao.ASCENDENTE){
                    if(itens.get(j).getQuantidade()>itens.get(j+1).getQuantidade()){
                        aux = itens.get(j);
                        itens.set(j, itens.get(j+1));
                        itens.set(j+1, aux);
                    }
                }
                else if(tipo == TipoOrdenacao.DESCENDENTE){
                    if(itens.get(j).getQuantidade()<itens.get(j+1).getQuantidade()){
                        aux = itens.get(j);
                        itens.set(j, itens.get(j+1));
                        itens.set(j+1, aux);
                    }
                }
            }
        }

    }
    //Exercicio 3.1 EXTRA
    public Item buscar(String descricao){
        Item resultado = null;
        for(int i=0; i<itens.size(); i++){
            Item itemAtual = itens.get(i);
            if(descricao.equals(itemAtual.getDescricao())){
                resultado = itemAtual;
                break;
            }
        }
        return resultado;
    }
    //Exercicio 3.2 EXTRA
    public double getMediaQuantidades(){
        int somador = getSomatorioQuantidades(), sizeItens = itens.size();
        double media = 0;
        return media = somador / sizeItens; 
    }   
    //Exercicio 3.3 EXTRA
    public int getSomatorioQuantidades(){
        int somador  = 0;
        for(int i=0; i<itens.size(); i++){
            int quantItemAtual = itens.get(i).getQuantidade();
            somador += quantItemAtual;
        }
        return somador;
    }
    //Exercicio 3.4 EXTRA
    public Inventario unir(Inventario inventario){
        ArrayList<Item> itensInventario = inventario.getItens();
        Inventario resultado = new Inventario();
        for(int i=0; i<itens.size(); i++){
            Item itemAtual = itens.get(i);
            resultado.adicionaItem(itemAtual);
        }
        for(int i=0; i<itensInventario.size(); i++){
            Item itemAtual = itensInventario.get(i);
            resultado.adicionaItem(itemAtual);
        }
        return resultado;
    }
}
