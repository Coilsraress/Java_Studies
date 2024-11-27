package ponto2D;

import java.util.ArrayList;

public class Espaco2D {
    private ArrayList<Forma> formas = new ArrayList<>();

    public Forma criarForma(Ponto2D[] pontos){
        return Forma.gerarForma(pontos);
    }

    public double calculaAreaTotal() {
        double area = 0.0;
        for(Forma forma : formas){
        area += forma.calculaArea();
        }
        return area;
    }

    public double calculaPerimetroTotal() {
        double perimetro = 0.0;
        for(Forma forma : formas){
        perimetro += forma.calculaPerimetro();
        }
        return perimetro;
    }

    public boolean adicionaForma(Forma forma) {
        return formas.add(forma);
    }

    public String mostrarTipoTriangulo(Ponto2D p1, Ponto2D p2, Ponto2D p3) {
        for(Forma forma : formas){
            if ((forma instanceof Triangulo)) {
                if ((forma.pontos[0]).equals(p1) && (forma.pontos[1].equals(p2)) && (forma.pontos[2].equals(p3))) {
                    Triangulo triangulo = (Triangulo) forma;
                    return triangulo.tipoTriangulo();
                }
            }
        }
        return "Tipo invalido";
    }
}