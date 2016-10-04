public class Dwarf extends Personagem{

    protected int vida;
    protected DataTerceiraEra dataNascimento;

    public Dwarf(){
        this(null, new DataTerceiraEra(1,1,1));
    }

    public Dwarf(String nome, DataTerceiraEra data){
        super(nome);
        this.dataNascimento = data;
        vida = 110;
    }

    public void perderVida() {
        if(vida<=0){
            status = Status.MORTO;
            vida = 0;
            return;
        }   
        vida -= 10;
    }

    public void receberFlecha(){
        double sorte = getNumeroSorte();
        if(sorte<0)
            experiencia += 2;
        if (sorte<=100)
            perderVida();
    }

    public int getVida() {
        return vida;
    }

    public double getNumeroSorte(){
        double result = 101.0;
        if(dataNascimento.ehBissexto() && (vida>=80 || vida<=90))
            return result* -33;
        else if (!(dataNascimento.ehBissexto()) && (nome != null && nome.equals("Seixas")||nome.equals("Meireles")))
            return result*33 % 100;
        return result;    

    }

    public void tentarSorte(){
        boolean temSorte = getNumeroSorte() == -3333;
        if(temSorte)
            inventario.aumentar1000unidadesDosItens();
    }
}
