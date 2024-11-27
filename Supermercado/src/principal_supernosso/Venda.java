package principal_supernosso;

public class Venda {
    private ItemDeProduto[] itensDoCliente;
    private Estoque estoque;

    public Venda(ItemDeProduto[] itensDoCliente, Estoque estoque) {
        this.estoque = estoque;
        this.itensDoCliente = itensDoCliente;
    }

    public void registrarVenda(int codigo, double quantidade) {
        for(int i = 0; i < itensDoCliente.length; i++) {
            if(itensDoCliente[i] == null) {
                ItemDeProduto itemEstoque = estoque.consultarProduto(codigo);
                if(itemEstoque != null) {
                    if(quantidade <= itemEstoque.getQuantidade()) {
                        ItemDeProduto novoItem = new ItemDeProduto(itemEstoque.getProduto(), quantidade);
                        itensDoCliente[i] = novoItem;
                        estoque.removerQuantidadeProduto(codigo, quantidade);
                        return;
                    }
                    else{
                        System.out.println("Quantidade indisponivel no estoque!\n");
                    }
                }
                return;
            }
        }
    }

    public void removerItemVenda(int codigo, double quantidade) {
        for(int i = 0; i < itensDoCliente.length; i++) {
            if(itensDoCliente[i] != null && itensDoCliente[i].getProduto().getCodigo() == codigo) {
                double quantidadeAtual = itensDoCliente[i].getQuantidade();
                
                if(quantidade >= quantidadeAtual) {
                    itensDoCliente[i] = null;
                    estoque.adicionarQuantidadeProduto(codigo, quantidadeAtual);
                } else {
                    itensDoCliente[i].setQuantidade(quantidadeAtual - quantidade);
                    estoque.adicionarQuantidadeProduto(codigo, quantidade);
                }
                return;
            }
        }
    }

    public void exibirItensVenda() {  
        for(int i = 0; i < itensDoCliente.length; i++) {
            if(itensDoCliente[i] != null) {
                System.out.print(itensDoCliente[i].getProduto().getDescricao() + " - R$");      
                System.out.print(itensDoCliente[i].getProduto().getPreco() + " - ");
                System.out.print(itensDoCliente[i].getQuantidade() + " - ");
                System.out.println(itensDoCliente[i].getProduto().getUnidade());
            }
        }
    }

    public void exibirResumoCompra() {
        System.out.println("\n=== RESUMO DA COMPRA ===");
        System.out.printf("%-20s %12s %15s %15s\n", "Produto", "Quantidade", "Preço Unit.", "Total");
        System.out.println("-----------------------------------------------------------------------------------");
        double totalGeral = 0;
        for(ItemDeProduto item : itensDoCliente) {
            if(item != null) {
                double totalItem = item.getQuantidade() * item.getProduto().getPreco();
                System.out.printf("Produto: %s  ", item.getProduto().getDescricao());
                System.out.printf("Quantidade: %.2f %s  ", item.getQuantidade(), item.getProduto().getUnidade());
                System.out.printf("Preço: R$ %.2f  ", item.getProduto().getPreco());
                System.out.printf("Total: R$ %.2f  \n", totalItem);
                System.out.println("-----------------------------------------------------------------------------------");
                totalGeral += totalItem;
            }
        }
        System.out.printf("-------------------------------------------------------------TOTAL DA COMPRA: R$ %.2f\n", totalGeral);
    }

    public ItemDeProduto[] getItensDoCliente() {
        return itensDoCliente;
    }
}
