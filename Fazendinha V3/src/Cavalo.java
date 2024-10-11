public class Cavalo implements Animal {   //Classe
    private String nome;
    private String corPelo;     //Campos da classe
    private double consumo;


    //Metodos da Classe
    public Cavalo() {   //construtor
        nome = "";
        corPelo = "";
        consumo = 0.0;
    }

    public Cavalo(String nome, String corPelo, double consumo) { //construtor com parametros
        this.nome = nome;
        this.corPelo = corPelo;
        this.consumo = consumo;
    }

    @Override
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    @Override
    public String getCorPelo() {
        return corPelo;
    }
    public void setCorPelo(String corPelo) {
        this.corPelo = corPelo;
    }
    @Override
    public double getConsumo() {
        return consumo;
    }
    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

}
