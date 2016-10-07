import java.util.*;

public class ElfosVerdes extends Elfo{

    public ElfosVerdes(String nome, int quantidadeFlechas) {
        super(nome, quantidadeFlechas);
    }

    
    public void atirarFlecha(Dwarf dwarf) {
        super.atirarFlechas(dwarf, 2);
    }

    
    protected void inicializarInventario(int quantidadeFlechas) {
        this.adicionarItem(new Item("Arco de Vidro", 1));
        this.adicionarItem(new Item("Flecha de Vidro", quantidadeFlechas >= 0 ? quantidadeFlechas : 42));
    }

    public void adicionarItem(Item item) {        
        String[] validas = getNomesValidos();
        boolean podeAdicionar = item != null && new ArrayList<>(Arrays.asList(validas)).contains(item.getDescricao());

        if (podeAdicionar) {
            super.adicionarItem(item);
        }
    }

    private String[] getNomesValidos() {
        return new String[] { 
            "Espada de aço valiriano", 
            "Arco de Vidro",
            "Flecha de Vidro"
        };
    }

    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes, List<Dwarf> alvos){
        return null;
    }
}
