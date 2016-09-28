public class Item{
    private String descricao;
    private int quantidade;

    public Item(String desc, int quant){
        this.descricao = desc;
        this.quantidade = quant;
    }

    public void setQuantidade(int novaQuantidade){
        quantidade = novaQuantidade;
    }

    public int getQuantidade(){
        return quantidade;
    }

    public String getDescricao(){
        return descricao;
    }
}