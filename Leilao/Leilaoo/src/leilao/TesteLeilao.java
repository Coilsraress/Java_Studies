package leilao;

import java.util.Scanner;

public class TesteLeilao {
    public static void main(String[] args) throws ProdutoNaoEncontradoException {
        Scanner scanner = new Scanner(System.in);
        Leilao leilao = new Leilao();

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Criar Lote");
            System.out.println("2. Inserir Produto em Lote");
            System.out.println("3. Fazer Lance");
            System.out.println("4. Listar Produtos");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha pendente

            switch (opcao) {
                case 1:
                    // Criar Lote
                    System.out.print("Digite o número do lote: ");
                    int numLote = scanner.nextInt();
                    scanner.nextLine();  // Consumir a nova linha pendente
                    leilao.inserirLote(numLote);
                    System.out.println("Lote " + numLote + " criado com sucesso!");
                    break;

                case 2:
                    // Inserir Produto em Lote
                    System.out.print("Digite o número do lote onde deseja adicionar o produto: ");
                    numLote = scanner.nextInt();
                    scanner.nextLine();  // Consumir a nova linha pendente
                    System.out.print("Digite a descrição do produto: ");
                    String descricaoProduto = scanner.nextLine();
                    System.out.print("Digite o valor do lance inicial: ");
                    float valorLance = scanner.nextFloat();
                    scanner.nextLine();  // Consumir a nova linha pendente

                    // Criar pessoa para o lance
                    System.out.print("Digite o nome da pessoa: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o contato da pessoa: ");
                    String contato = scanner.nextLine();
                    Pessoa pessoa = new Pessoa(nome, contato);

                    Lance lanceInicial = new Lance(pessoa, valorLance);
                    Lote lote = leilao.lotes.get(numLote);

                    // Inserir o produto no lote
                    lote.inserirProduto(descricaoProduto, lanceInicial);
                    System.out.println("Produto \"" + descricaoProduto + "\" adicionado ao lote " + numLote);
                    break;

                case 3:
                    // Fazer Lance
                    System.out.print("Digite o número do lote onde deseja fazer o lance: ");
                    numLote = scanner.nextInt();
                    scanner.nextLine();  // Consumir a nova linha pendente
                    System.out.print("Digite a descrição do produto no qual deseja fazer o lance: ");
                    descricaoProduto = scanner.nextLine();
                    System.out.print("Digite o valor do novo lance: ");
                    float novoValorLance = scanner.nextFloat();
                    scanner.nextLine();  // Consumir a nova linha pendente

                    // Criar pessoa para o lance
                    System.out.print("Digite o nome da pessoa para o lance: ");
                    nome = scanner.nextLine();
                    System.out.print("Digite o contato da pessoa para o lance: ");
                    contato = scanner.nextLine();
                    pessoa = new Pessoa(nome, contato);

                    Lance novoLance = new Lance(pessoa, novoValorLance);

                    // Receber o lance
                    leilao.receberLance(numLote, descricaoProduto, novoLance);
                    System.out.println("Lance de R$" + novoValorLance + " registrado para o produto \"" + descricaoProduto + "\" no lote " + numLote);
                    break;

                case 4:
                    // Listar Produtos
                    System.out.println(leilao.listarProdutos());
                    break;

                case 5:
                    // Sair
                    System.out.println("Saindo do programa...");
                    scanner.close();
                    leilao.encerraLeilao();

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}