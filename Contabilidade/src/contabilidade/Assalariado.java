package contabilidade;

public class Assalariado extends Empregado{
    double horasExtra;
    public Assalariado(String nome, String sobrenome, int numIdent, double horasExtra) {
        super(nome, sobrenome, numIdent);
        this.horasExtra=horasExtra;
    }

    @Override
    public double getValorAPagar(int diaPagto, int mesPagto) {
        double retorno;
        retorno = SALARIO + horasExtra*HORA;
        return retorno;
    }
}
