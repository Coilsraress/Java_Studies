package ponto2D;

public abstract class Forma {
    protected Ponto2D[] pontos;

    public Forma(Ponto2D[] pontos) {
        this.pontos = pontos;
    }

    public abstract double calculaArea();
    public abstract double calculaPerimetro();

    public static Forma gerarForma(Ponto2D[] pontos) {
        if (pontos.length == 3) {
            double lado1 = pontos[0].distanciaPonto(pontos[1]);
            double lado2 = pontos[1].distanciaPonto(pontos[2]);
            double lado3 = pontos[2].distanciaPonto(pontos[0]);

            if (lado1 + lado2 > lado3 && lado1 + lado3 > lado2 && lado2 + lado3 > lado1) {
                return new Triangulo(pontos);
            } else {
                throw new IllegalArgumentException("Os pontos não formam um triângulo.");
            }

        } else if (pontos.length == 4) {
            double lado1 = pontos[0].distanciaPonto(pontos[1]);
            double lado2 = pontos[1].distanciaPonto(pontos[2]);
            double lado3 = pontos[2].distanciaPonto(pontos[3]);
            double lado4 = pontos[3].distanciaPonto(pontos[0]);

            double diagonal1 = pontos[0].distanciaPonto(pontos[2]);
            double diagonal2 = pontos[1].distanciaPonto(pontos[3]);

            boolean ladosIguais = (Math.abs(lado1-lado2) < 0.0001) &&
                    (Math.abs(lado2-lado1) < 0.0001) &&
                    (Math.abs(lado3-lado4) < 0.0001) && (Math.abs(lado4-lado1) < 0.0001);
            boolean diagonaisIguais = (Math.abs(diagonal1-diagonal2) < 0.0001);

            if (ladosIguais&&diagonaisIguais) {
                return new Quadrado(pontos);
            } else {
                throw new IllegalArgumentException("Os pontos não formam um quadrado.");
            }

        } else if (pontos.length == 2) {
            return new Circulo(pontos);
        } else {
            throw new IllegalArgumentException("Número de pontos inválido para formar uma forma conhecida.");
        }
    }
}