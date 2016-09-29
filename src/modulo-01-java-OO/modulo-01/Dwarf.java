public class Dwarf {
    private String nome;
    private int vida;
    private DataTerceiraEra dataNascimento;
    private int experiencia;
    
    public Dwarf(){
        this.nome = nome;
        this.dataNascimento = new DataTerceiraEra(1,1,1);
        vida = 110;
    }
    
    public Dwarf(String nome, DataTerceiraEra data){
        this.nome = nome;
        this.dataNascimento = data;
        vida = 110;
    }

    public void perderVida() {
        vida -= 10;
    }
    public void receberFlecha(){
        double sorte = getNumeroSorte();
        if(sorte<0)
            experiencia+=2;
        else if (sorte<=100)
            perderVida();
    }

    public int getVida() {
        return vida;
    }
    public int getXp() {
        return experiencia;
    }
    public double getNumeroSorte(){
        double n = 101.0;
        if(dataNascimento.ehBissexto() && (vida>=80 || vida<=90))
            return n* -33;
        else if (!(dataNascimento.ehBissexto()) && (nome.equals("Seixas")||nome.equals("Meireles")))
            return (n*33)%100;
        return n;    
        
    }
}
