package ponto2D;

public class Espaco {
    public static void main(String[] args) {
        Espaco2D espaco = new Espaco2D();

        Ponto2D p1 = new Ponto2D(0, 0);
        Ponto2D p2 = new Ponto2D(3, 0);
        Ponto2D p3 = new Ponto2D(0, 3);
        Ponto2D p4 = new Ponto2D(3, 3);

        Ponto2D[] pontosTriangulo = {p1, p2, p3};
        Forma triangulo = espaco.criarForma(pontosTriangulo);
        espaco.adicionaForma(triangulo);
        System.out.printf("Área do triângulo: %.2f\n", triangulo.calculaArea());
        System.out.printf("Perímetro do triângulo: %.2f\n", triangulo.calculaPerimetro());
        System.out.println("Tipo do triângulo: " + espaco.mostrarTipoTriangulo(p1, p2, p3));

        Ponto2D[] pontosCirculo = {p1, p2};
        Forma circulo = espaco.criarForma(pontosCirculo);
        espaco.adicionaForma(circulo);
        System.out.printf("\nÁrea do círculo: %.2f\n", circulo.calculaArea());
        System.out.printf("Perímetro do círculo: %.2f\n", circulo.calculaPerimetro());

        Ponto2D[] pontosQuadrado = {p1, p2, p4, p3};
        Forma quadrado = espaco.criarForma(pontosQuadrado);
        espaco.adicionaForma(quadrado);
        System.out.printf("\nÁrea do quadrado: %.2f\n", quadrado.calculaArea());
        System.out.printf("Perímetro do quadrado: %.2f\n", quadrado.calculaPerimetro());

        System.out.printf("\nÁrea total: %.2f\n", espaco.calculaAreaTotal());
        System.out.printf("Perímetro total: %.2f\n", espaco.calculaPerimetroTotal());

        Ponto2D ap1 = new Ponto2D(0, 0);
        Ponto2D ap2 = new Ponto2D(2, 0);
        Ponto2D ap3 = new Ponto2D(1, 2);

        Ponto2D[] pontosIsosceles = {ap1, ap2, ap3};
        Forma trianguloIsosceles = espaco.criarForma(pontosIsosceles);
        espaco.adicionaForma(trianguloIsosceles);
        System.out.printf("\nÁrea do triângulo isósceles: %.2f\n", trianguloIsosceles.calculaArea());
        System.out.printf("Perímetro do triângulo isósceles: %.2f\n", trianguloIsosceles.calculaPerimetro());
        System.out.println("Tipo do triângulo: " + espaco.mostrarTipoTriangulo(ap1, ap2, ap3));

        Ponto2D e1 = new Ponto2D(0, 0);
        Ponto2D e2 = new Ponto2D(4, 0);
        Ponto2D e3 = new Ponto2D(2, 4 * Math.sqrt(3)/2);

        Ponto2D[] pontosEquilatero = {e1, e2, e3};
        Forma trianguloEquilatero = espaco.criarForma(pontosEquilatero);
        espaco.adicionaForma(trianguloEquilatero);
        System.out.printf("\nÁrea do triângulo equilátero: %.2f\n", trianguloEquilatero.calculaArea());
        System.out.printf("Perímetro do triângulo equilátero: %.2f\n", trianguloEquilatero.calculaPerimetro());
        System.out.println("Tipo do triângulo: " + espaco.mostrarTipoTriangulo(e1, e2, e3));

        System.out.printf("\nÁrea total: %.2f\n", espaco.calculaAreaTotal());
        System.out.printf("Perímetro total: %.2f\n", espaco.calculaPerimetroTotal());
    }
}
