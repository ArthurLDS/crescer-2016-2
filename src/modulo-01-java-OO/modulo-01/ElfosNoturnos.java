import java.text.DecimalFormat;


public class ElfosNoturnos extends Elfo{
   public ElfosNoturnos(String nome){
       super(nome);
   }
   
   public void atirarFlecha(Dwarf dwarf) {
        boolean temFlecha = getFlecha().getQuantidade() > 0;
        if (temFlecha) {
            getFlecha().setQuantidade(getFlecha().getQuantidade() - 1);
            perderVida();
            experiencia += 3;
            dwarf.perderVida();
        }
    }
    public void perderVida(){
        status = vida<=0 ? Status.MORTO : Status.VIVO;
        DecimalFormat formato = new DecimalFormat("#.##");
        vida -= (vida*5)/100;
        formato.format(vida);
    }
}
