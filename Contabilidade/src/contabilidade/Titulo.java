package contabilidade;

public class Titulo extends Conta{

    public Titulo(int diaVencimento, int mesVencimento, double valor) {
        super(diaVencimento, mesVencimento, valor);
    }

    @Override
    public double getValorAPagar(int diaPagto, int mesPagto) {
        double retorno = 0;
        if(((diaPagto > diaVencimento)&&(mesPagto >= mesVencimento))||(mesPagto> mesVencimento)){
            retorno=valor*1.10;
        }
        return retorno;
    }
}
