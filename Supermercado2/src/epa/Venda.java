package epa;

public class Venda {
    private Estoque estoque;
    private ItemDeProduto[] itemDeVenda;
    
    public Venda(Estoque estoque, int capacidade) {
        this.estoque = estoque;
        this.itemDeVenda = new ItemDeProduto[capacidade];
    }
    
    public void adicionarItem(int codigo, int quantidade) {
        for(int i = 0; i < itemDeVenda.length; i++) {
            if(itemDeVenda[i] == null) {
                ItemDeProduto itemEstoque = estoque.buscarItem(codigo);
                if(itemEstoque != null) {
                    if(quantidade <= itemEstoque.getQuantidade()) {
                        ItemDeProduto novoItem = new ItemDeProduto(itemEstoque.getProduto(), quantidade);
                        itemDeVenda[i] = novoItem;
                        return;
                    }
                }
                return;
            }
        }
    }
    
    public void removerItem(int codigo) {
        for(int i = 0; i < itemDeVenda.length; i++) {
            if(itemDeVenda[i] != null && itemDeVenda[i].getProduto().getCodigo() == codigo) {
                itemDeVenda[i] = null;
                return;
            }
        }
    }
    
    public double calcularTotal() {
        double total = 0.0;
        for(int i = 0; i < itemDeVenda.length; i++) {
            if(itemDeVenda[i] != null) {
                double precoItem = itemDeVenda[i].getProduto().getPreco();
                int quantidadeItem = itemDeVenda[i].getQuantidade();
                total += precoItem * quantidadeItem;
            }
        }
        return total;
    }
    
    public int buscarQuantidadeItem(int codigo) {
        for(int i = 0; i < itemDeVenda.length; i++) {
            if(itemDeVenda[i] != null && itemDeVenda[i].getProduto().getCodigo() == codigo) {
                return itemDeVenda[i].getQuantidade();
            }
        }
        return 0;
    }
    
    public boolean estaVazia() {
        for(int i = 0; i < itemDeVenda.length; i++) {
            if(itemDeVenda[i] != null) {
                return false;
            }
        }
        return true;
    }
}