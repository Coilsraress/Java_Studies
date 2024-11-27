package principal_supernosso;

public class Estoque {
    private ItemDeProduto[] estoque;

    public Estoque() {
        this.estoque = new ItemDeProduto[10];
        inserirProduto(new ItemDeProduto(
                new Produto(11111,"Detergente ABC",1,"unidade(s)"),10));
        inserirProduto(new ItemDeProduto(
                new Produto(22222,"Sabão em pó OMO",6.50,"unidade(s)"),10));
        inserirProduto(new ItemDeProduto(
                new Produto(33333,"Shampoo Beleza Fácil",12,"unidade(s)"),10));
        inserirProduto(new ItemDeProduto(
                new Produto(44444,"Creme dental Colgate",3.50,"unidade(s)"),10));
        inserirProduto(new ItemDeProduto(
                new Produto(55555,"Sabonete Nívea",1.80,"unidade(s)"),10));
        inserirProduto(new ItemDeProduto(
                new Produto(66666,"Biscoito Maizena",2,"unidade(s)"),10));
        inserirProduto(new ItemDeProduto(
                new Produto(77777,"Leite desnatado Parmalat",3,"unidade(s)"),10));
    }
    public Estoque(int capacidade) {
        this.estoque = new ItemDeProduto[capacidade];
        inserirProduto(new ItemDeProduto(
                new Produto(11111,"Detergente ABC",1,"unidade(s)"),10));
        inserirProduto(new ItemDeProduto(
                new Produto(22222,"Sabão em pó OMO",6.50,"unidade(s)"),10));
        inserirProduto(new ItemDeProduto(
                new Produto(33333,"Shampoo Beleza Fácil",12,"unidade(s)"),10));
        inserirProduto(new ItemDeProduto(
                new Produto(44444,"Creme dental Colgate",3.50,"unidade(s)"),10));
        inserirProduto(new ItemDeProduto(
                new Produto(55555,"Sabonete Nívea",1.80,"unidade(s)"),10));
        inserirProduto(new ItemDeProduto(
                new Produto(66666,"Biscoito Maizena",2,"unidade(s)"),10));
        inserirProduto(new ItemDeProduto(
                new Produto(77777,"Leite desnatado Parmalat",3,"unidade(s)"),10));
    }


    public ItemDeProduto consultarProduto(int codigo){
        for(int i=0; i<estoque.length; i++){
            if(estoque[i]!=null && estoque[i].getProduto().getCodigo()==codigo){
                return estoque[i];
            }
        }
        return null;
    }

    public void inserirProduto(ItemDeProduto item){
        for (int i = 0; i< estoque.length; i++){
            if (estoque[i]==null){
                estoque[i]=item;
                break;
            }
        }
    }

    public void removerProduto(int codigo){
        for(int i=0; i<estoque.length; i++){
            if(estoque[i]!=null && estoque[i].getProduto().getCodigo()==codigo){
                estoque[i]=null;
                break;
            }
        }
    }

    public void atualizarQuantidadeProduto(int codigo, double quantidade){
        for(int i=0; i<estoque.length; i++){
            if(estoque[i]!=null && estoque[i].getProduto().getCodigo()==codigo){
                estoque[i].setQuantidade(quantidade);
                break;
            }
        }
    }

    public void removerQuantidadeProduto(int codigo, double quantidade){
        for(int i=0; i<estoque.length; i++){
            if(estoque[i]!=null && estoque[i].getProduto().getCodigo()==codigo){
                estoque[i].setQuantidade(estoque[i].getQuantidade()-quantidade);
                break;
            }
        }
    }

    public void adicionarQuantidadeProduto(int codigo, double quantidade){
        for(int i=0; i<estoque.length; i++){
            if(estoque[i]!=null && estoque[i].getProduto().getCodigo()==codigo){
                estoque[i].setQuantidade(estoque[i].getQuantidade()+quantidade);
                break;
            }
        }
    }

    public void exibirEstoque(){
        System.out.println("\nEstoque:");
        for(ItemDeProduto item : estoque){
            if(item != null) {
                System.out.println(item.getProduto().getCodigo() + " - " + item.getProduto().getDescricao() + " - " + item.getQuantidade() + " " + item.getProduto().getUnidade());
            }
        }
        System.out.printf("\n");
    }

    public void mudarValorProduto(int codigo, double valor){
        for(int i=0; i<estoque.length; i++){
            if(estoque[i]!=null && estoque[i].getProduto().getCodigo()==codigo){
                estoque[i].getProduto().setPreco(valor);
                break;
            }
        }
    }

    public ItemDeProduto[] getEstoque() {
        return estoque;
    }

    public void setEstoque(ItemDeProduto[] estoque) {
        this.estoque = estoque;
    }
}
