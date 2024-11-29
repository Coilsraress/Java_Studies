package contabilidade;

public class Comissionado extends Empregado{
    private double valorVendas;
    public Comissionado(String nome, String sobrenome, int numIdent, double valorVendas) {
        super(nome, sobrenome, numIdent);
        this.valorVendas = valorVendas;
    }

    @Override
    public double getValorAPagar(int diaPagto, int mesPagto) {
        double retorno;
        retorno = valorVendas*Passivo.PERCENTUAL;
        return retorno;
    }
}
