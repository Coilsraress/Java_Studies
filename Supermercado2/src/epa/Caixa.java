package epa;

import java.util.Scanner;

public class Caixa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Criar e popular o estoque (exemplo com alguns produtos)
        Estoque estoque = new Estoque();
        
        
        // Criar uma nova venda
        Venda venda = new Venda(estoque, 7);
        
        while(true) {
            System.out.println("\nDigite o código do produto (0 para finalizar):");
            int codigo = scanner.nextInt();
            
            if(codigo == 0) {
                break;
            }
            
            ItemDeProduto itemEstoque = estoque.buscarItem(codigo);
            if(itemEstoque != null) {
                System.out.println("Produto: " + itemEstoque.getProduto().getDescricao());
                System.out.println("Preço: R$ " + itemEstoque.getProduto().getPreco());
                System.out.println("Quantidade disponível: " + itemEstoque.getQuantidade());
                
                System.out.println("Digite a quantidade desejada:");
                int quantidade = scanner.nextInt();
                
                if(quantidade <= itemEstoque.getQuantidade()) {
                    venda.adicionarItem(codigo, quantidade);
                    System.out.println("Item adicionado com sucesso!");
                } else {
                    System.out.println("Quantidade indisponível no estoque!");
                }
            } else {
                System.out.println("Produto não encontrado!");
            }
        }
        
        double totalVenda = venda.calcularTotal();
        System.out.printf("\nTotal a pagar: R$ %.2f\n", totalVenda);
        
        scanner.close();
    }
    

}