package ponto2D;

public class Quadrado extends Forma {
    public Quadrado(Ponto2D[] pontos) {
        super(pontos);
    }

    @Override
    public double calculaArea() {
        double lado = pontos[0].distanciaPonto(pontos[1]);
        return lado*lado;
    }

    @Override
    public double calculaPerimetro() {
        double lado = pontos[0].distanciaPonto(pontos[1]);
        return 4*lado;
    }
}

