
public class CestoDeLembas
{
   private int quantidade;
   
   public CestoDeLembas(int quant){
       quantidade = quant;
    }
   public boolean podeDividirEmPares(){
       if(quantidade>4 && quantidade<=100)
          return true;
       else
          return false;  
   }
}
