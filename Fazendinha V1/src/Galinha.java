public class Galinha {   //Classe
    private String nome;
    private String corPelo;     //Campos da classe
    private double consumo;


    //Metodos da Classe
    public Galinha() {   //construtor
        nome = "";
        corPelo = "";
        consumo = 0.0;
    }

    public Galinha(String nome, String corPelo, double consumo) { //construtor com parametros
        this.nome = nome;
        this.corPelo = corPelo;
        this.consumo = consumo;
    }


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCorPelo() {
        return corPelo;
    }
    public void setCorPelo(String corPelo) {
        this.corPelo = corPelo;
    }
    public double getConsumo() {
        return consumo;
    }
    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

}
