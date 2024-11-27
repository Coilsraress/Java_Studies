package principal_supernosso;

import java.util.Scanner;

public class Caixa {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Estoque estoque = new Estoque(25);
        Venda venda = new Venda(new ItemDeProduto[10], estoque);

        int opcao = 0;

        while(opcao!=9){
            System.out.println("1 - Adicionar item a venda");
            System.out.println("2 - Remover item da venda");
            System.out.println("3 - Total parcial da venda");
            System.out.println("4 - Adicionar item ao estoque");
            System.out.println("5 - Remover item do estoque");
            System.out.println("6 - Mudar valor de item no estoque");
            System.out.println("7 - Atualizar quantidade de item no estoque");
            System.out.println("8 - Exibir estoque");
            System.out.println("9 - Sair (FINALIZAR COMPRA)");
            opcao = input.nextInt();

            switch(opcao){
                case 1:
                    System.out.println("Digite o codigo do produto: ");
                    int codigo = input.nextInt();
                    System.out.println("Digite a quantidade: ");
                    double quantidade = input.nextDouble();
                    venda.registrarVenda(codigo, quantidade);
                    venda.exibirItensVenda();
                    break;
                case 2:
                    System.out.println("Digite o codigo do produto: ");
                    codigo = input.nextInt();
                    System.out.println("Digite a quantidade: ");
                    quantidade = input.nextDouble();
                    venda.removerItemVenda(codigo, quantidade);
                    break;
                case 3: 
                    venda.exibirResumoCompra();
                    break;
                case 4:
                    System.out.println("Digite o codigo do produto: ");
                    codigo = input.nextInt();
                    input.nextLine();
                    System.out.println("Digite a descricao: ");
                    String descricao = input.nextLine();
                    System.out.println("Digite a unidade: ");
                    String unidade = input.nextLine();
                    System.out.println("Digite o preco: ");
                    double preco = input.nextDouble();
                    System.out.println("Digite a quantidade: ");
                    quantidade = input.nextDouble();
                    estoque.inserirProduto(new ItemDeProduto(new Produto(codigo, descricao, preco, unidade), quantidade));
                    break;
                case 5:
                    System.out.println("Digite o codigo do produto: ");
                    codigo = input.nextInt();
                    estoque.removerProduto(codigo);
                    break;
                case 6:
                    System.out.println("Digite o codigo do produto: ");
                    codigo = input.nextInt();
                    System.out.println("Digite o novo valor: ");
                    double valor = input.nextDouble();
                    estoque.mudarValorProduto(codigo, valor);
                    break;
                case 7:
                    System.out.println("Digite o codigo do produto: ");
                    codigo = input.nextInt();
                    System.out.println("Digite a nova quantidade: ");
                    quantidade = input.nextDouble();
                    estoque.atualizarQuantidadeProduto(codigo, quantidade);
                    break;
                case 8:
                    estoque.exibirEstoque();
                    break;
            }

        }
        if(opcao == 9 && venda.getItensDoCliente().length > 0){
            venda.exibirResumoCompra();
        }

    }
}