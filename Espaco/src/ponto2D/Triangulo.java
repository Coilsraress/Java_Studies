package ponto2D;

public class Triangulo extends Forma {
    public Triangulo(Ponto2D[] pontos) {
        super(pontos);
    }

    @Override
    public double calculaArea() {
        double lado1 = pontos[0].distanciaPonto(pontos[1]);
        double lado2 = pontos[1].distanciaPonto(pontos[2]);
        double lado3 = pontos[2].distanciaPonto(pontos[0]);

        double sp = (lado1+lado2+lado3)/2;
        return Math.sqrt(sp*(sp-lado1)*(sp-lado2)*(sp-lado3));
    }

    @Override
    public double calculaPerimetro() {
        double lado1 = pontos[0].distanciaPonto(pontos[1]);
        double lado2 = pontos[1].distanciaPonto(pontos[2]);
        double lado3 = pontos[2].distanciaPonto(pontos[0]);
        return lado1+lado2+lado3;
    }

    public String tipoTriangulo(){
            double lado1 = pontos[0].distanciaPonto(pontos[1]);
            double lado2 = pontos[1].distanciaPonto(pontos[2]);
            double lado3 = pontos[2].distanciaPonto(pontos[0]);
            if((Math.abs(lado1-lado2) < 0.0001) && (Math.abs(lado2-lado3) < 0.0001) && (Math.abs(lado3-lado1) < 0.0001)){
                return "Triângulo Equilátero";
            }
            else if((Math.abs(lado1 - lado2) < 0.0001) ||
                    (Math.abs(lado2 - lado3) < 0.0001) ||
                    (Math.abs(lado1 - lado3) < 0.0001)){
                return "Triângulo Isóceles";
            }
            else{
                return "Triângulo Escaleno";
            }
    }

}