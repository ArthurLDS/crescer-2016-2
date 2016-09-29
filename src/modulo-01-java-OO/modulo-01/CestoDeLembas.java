
public class CestoDeLembas
{
   private int quantidade;
   
   public CestoDeLembas(int quant){
       quantidade = quant;
    }
   public boolean podeDividirEmPares() {
        return quantidade > 2 && quantidade % 2 == 0 && quantidade <= 100;
    }
}
