package contabilidade;

public class Terceirizado extends Empregado{
    private double horasTrabalhadas;
    public Terceirizado(String nome, String sobrenome, int numIdent, double horasTrabalhadas) {
        super(nome, sobrenome, numIdent);
        this.horasTrabalhadas=horasTrabalhadas;
    }

    @Override
    public double getValorAPagar(int diaPagto, int mesPagto) {
        double retorno;
        retorno=horasTrabalhadas*HORA;
        return retorno;
    }
}
