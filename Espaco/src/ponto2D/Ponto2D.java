package ponto2D;

public class Ponto2D {
    private double x;
    private double y;

    public Ponto2D() {
        this.x = 0.0;
        this.y = 0.0;
    }

    public Ponto2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

        public Ponto2D(Ponto2D outroPonto) {
        this.x = outroPonto.x;
        this.y = outroPonto.y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distanciaPonto(Ponto2D outroPonto){
        return Math.sqrt(Math.pow(this.x - outroPonto.x, 2) + Math.pow(this.y - outroPonto.y, 2));
    }
}
