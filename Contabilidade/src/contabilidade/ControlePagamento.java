package contabilidade;
import javax.print.attribute.standard.OutputDeviceAssigned;
import java.sql.SQLOutput;
import java.util.ArrayList;
public class ControlePagamento {
    ArrayList<Passivo> pagamentos;

    public ControlePagamento() {
        pagamentos = new ArrayList<>();
    }

    public double getValorTotalAPagar(int diaPagto, int mesPagto){
        double retorno = 0;
        for (Passivo pagamento : pagamentos) {
            retorno += pagamento.getValorAPagar(diaPagto, mesPagto);
        }
        return retorno;
    }

    public double getValorTotalEmpregado(int diaPagto, int mesPagto){
        double retorno = 0;
        for (Passivo pagamento : pagamentos){
            if(pagamento instanceof Empregado){
                retorno+=pagamento.getValorAPagar(diaPagto, mesPagto);
            }
        }
        return retorno;
    }

    public double getValorTotalConta(int diaPagto, int mesPagto){
        double retorno = 0;
        for (Passivo pagamento : pagamentos){
            if(pagamento instanceof Conta){
                retorno+=pagamento.getValorAPagar(diaPagto, mesPagto);
            }
        }
        return retorno;
    }

    public void exibirValoresIndividuaisConta(int diaPagto, int mesPagto){
        System.out.println("Contas da Empresa:");
        for (Passivo pagamento : pagamentos){
            if(pagamento instanceof Conta){
                if(pagamento instanceof Titulo) {
                    System.out.printf("Titulo: ");
                } else if (pagamento instanceof Concessionaria) {
                    System.out.printf("Concessionaria: ");
                }
                System.out.printf("%.2f\n",pagamento.getValorAPagar(diaPagto, mesPagto));
            }
        }
        System.out.printf("\n");
    }

    public void exibirValoresIndividuaisEmpregados(int diaPagto, int mesPagto) {
        System.out.println("Salario dos empregados:");
        for (Passivo pagamento : pagamentos) {
            if (pagamento instanceof Empregado) {
                System.out.printf(((Empregado) pagamento).getNome() + " ");
                System.out.printf(((Empregado) pagamento).getSobrenome() + ": ");
                System.out.printf("%.2f\n",pagamento.getValorAPagar(diaPagto, mesPagto));

            }
        }
        System.out.printf("\n");
    }


}
