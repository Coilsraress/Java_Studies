package contabilidade;

public class SistemaPagamentoTeste {
    public static void main(String[] args) {
        int dia = 10;
        int mes = 3;
        ControlePagamento contabilidade = new ControlePagamento();
        contabilidade.pagamentos.add(new Titulo(9, 2, 1750.53));
        contabilidade.pagamentos.add(new AssalariadoComissionado("Jorgin","do posto", 123, 67542, 1.05));
        contabilidade.pagamentos.add(new Concessionaria(dia, mes, 1200.36));
        contabilidade.pagamentos.add(new Comissionado("Renatin","do farol", 321, 65473));
        contabilidade.pagamentos.add(new Concessionaria(dia, mes, 1700.33));
        contabilidade.pagamentos.add(new AssalariadoComissionado("Flavin","do pneu", 193, 143148, 1.63));
        contabilidade.pagamentos.add(new Terceirizado("Shaolin matador", "de porco", 122, 88.3));
        contabilidade.pagamentos.add(new Terceirizado("Shaolin dos", "comercios", 172, 193.6));
        contabilidade.pagamentos.add(new Assalariado("Roberval", "da orta", 132, 19.33));
        contabilidade.pagamentos.add(new Titulo(9, 2, 1350.7));

        contabilidade.exibirValoresIndividuaisEmpregados(dia, mes);
        contabilidade.exibirValoresIndividuaisConta(dia, mes);

        System.out.printf("Total do pagamento dos empregados: %.2f\n", contabilidade.getValorTotalEmpregado(dia, mes));
        System.out.printf("Total do pagamento das contas : %.2f\n", contabilidade.getValorTotalConta(dia, mes));
        System.out.printf("Total de todos os pagamentos : %.2f\n", contabilidade.getValorTotalAPagar(dia, mes));
    }
}