package contabilidade;

public interface Passivo {
    public static final double SALARIO = 1412.00;
    public static final double HORA = 65.00;
    public static final double PERCENTUAL = 0.06;
    public abstract double getValorAPagar(int diaPagto, int mesPagto);

}
