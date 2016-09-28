public class Adversario
{
   private String nome;
   private int hp;
   
   public Adversario(String n, int h){
       nome = n;
       hp = h;
   }
   public int getHp(){
       return hp;
   }
   public void setHp(int dano){
       hp-= dano;
   }
   public String getNome(){
       return nome;
   }
   public void setNome(String n){
       nome = n;
   }
}
