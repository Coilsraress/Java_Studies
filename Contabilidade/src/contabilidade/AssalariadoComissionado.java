package contabilidade;

public class AssalariadoComissionado extends Comissionado{

    private double percentualBonus;

    public AssalariadoComissionado(String nome, String sobrenome, int numIdent, double valorVendas, double percentualBonus) {
        super(nome, sobrenome, numIdent, valorVendas);
        this.percentualBonus=percentualBonus;
    }

    @Override
    public double getValorAPagar(int diaPagto, int mesPagto) {
        double retorno;
        retorno = Passivo.SALARIO + SALARIO*percentualBonus + super.getValorAPagar(diaPagto, mesPagto);
        return retorno;
    }
}
