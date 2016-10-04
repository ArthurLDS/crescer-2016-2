import java.text.DecimalFormat;

public class ElfosNoturnos extends Elfo{
   public ElfosNoturnos(String nome){
       super(nome);
   }
   
   public void atirarFlecha(Dwarf dwarf) {
        status = vida<1 ? Status.MORTO : Status.VIVO;
        boolean temFlecha = getFlecha().getQuantidade() > 0;
        if (temFlecha) {
            getFlecha().setQuantidade(getFlecha().getQuantidade() - 1);
            perderVida();
            experiencia += 3;
            dwarf.perderVida();
        }
    }
    public void perderVida(){
        vida -= (vida*5)/100;
    }
}
