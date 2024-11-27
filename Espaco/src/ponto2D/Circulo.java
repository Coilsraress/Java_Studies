package ponto2D;

public class Circulo extends Forma {

    private static final double PI = 3.14;
    public Circulo(Ponto2D[] pontos) {
        super(pontos);
    }

    @Override
    public double calculaArea() {
        double raio = pontos[0].distanciaPonto(pontos[1]);
        return PI*(raio*raio);
    }

    @Override
    public double calculaPerimetro() {
        double raio = pontos[0].distanciaPonto(pontos[1]);
        return 2*PI*raio;
    }
}