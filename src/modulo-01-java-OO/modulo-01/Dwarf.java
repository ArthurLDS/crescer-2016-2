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
            experiencia += 2;
        if (sorte<=100)
            perderVida();
    }

    public int getVida() {
        return vida;
    }
    public int getXp() {
        return experiencia;
    }
    public double getNumeroSorte(){
        double result = 101.0;
        if(dataNascimento.ehBissexto() && (vida>=80 || vida<=90))
            return result* -33;
        else if (!(dataNascimento.ehBissexto()) && (nome != null && nome.equals("Seixas")||nome.equals("Meireles")))
            return result*33 % 100;
        return result;    
        
    }
}
