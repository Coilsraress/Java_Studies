package epa;

public class Estoque {
    private ItemDeProduto[] estante;
    
    public Estoque() {
        this.estante = new ItemDeProduto[7];
        inserirItemDeProduto(new ItemDeProduto(
                new Produto(11111,"Detergente ABC",1,"unidade"),10));
        inserirItemDeProduto(new ItemDeProduto(
                new Produto(22222,"Sabão em pó OMO",6.50,"unidade"),10));
        inserirItemDeProduto(new ItemDeProduto(
                new Produto(33333,"Shampoo Beleza Fácil",12,"unidade"),10));
        inserirItemDeProduto(new ItemDeProduto(
                new Produto(44444,"Creme dental Colgate",3.50,"unidade"),10));
        inserirItemDeProduto(new ItemDeProduto(
                new Produto(55555,"Sabonete Nívea",1.80,"unidade"),10));
        inserirItemDeProduto(new ItemDeProduto(
                new Produto(66666,"Biscoito Maizena",2,"unidade"),10));
        inserirItemDeProduto(new ItemDeProduto(
                new Produto(77777,"Leite desnatado Parmalat",3,"unidade"),10));
    }
    
    public boolean inserirItemDeProduto(ItemDeProduto item) {
        for(int i = 0; i < estante.length; i++) {
            if(estante[i] == null) {
                estante[i] = item;
                return true;
            }
        }
        return false;
    }
    
    
    public void adicionarItem(ItemDeProduto item) {
        for(int i = 0; i < estante.length; i++) {
            if(estante[i] == null) {
                estante[i] = item;
                return;
            }
        }
        System.out.println("Estoque cheio.");
    }
    
    public void removerItem(int codigo) {
        for(int i = 0; i < estante.length; i++) {
            if(estante[i] != null && estante[i].getProduto().getCodigo() == codigo) {
                estante[i] = null;
                return;
            }
        }
    }
    
    public ItemDeProduto buscarItem(int codigo) {
        for(int i = 0; i < estante.length; i++) {
            if(estante[i] != null && estante[i].getProduto().getCodigo() == codigo) {
                return estante[i];
            }
        }
        return null;
    }
}
/*
package epa;
public class Estoque {
    private ItemDeProduto[] estante;

    public Estoque() {
        this.estante = new ItemDeProduto[7];
        inserirItemDeProduto(new ItemDeProduto(
                new Produto(11111,"Detergente ABC",1,"unidade"),10));
        inserirItemDeProduto(new ItemDeProduto(
                new Produto(22222,"Sabão em pó OMO",6.50,"unidade"),10));
        inserirItemDeProduto(new ItemDeProduto(
                new Produto(33333,"Shampoo Beleza Fácil",12,"unidade"),10));
        inserirItemDeProduto(new ItemDeProduto(
                new Produto(44444,"Creme dental Colgate",3.50,"unidade"),10));
        inserirItemDeProduto(new ItemDeProduto(
                new Produto(55555,"Sabonete Nívea",1.80,"unidade"),10));
        inserirItemDeProduto(new ItemDeProduto(
                new Produto(66666,"Biscoito Maizena",2,"unidade"),10));
        inserirItemDeProduto(new ItemDeProduto(
                new Produto(77777,"Leite desnatado Parmalat",3,"unidade"),10));
    }

    public Estoque(ItemDeProduto[] estante) {
        this.estante = estante;
    }
    
    public ItemDeProduto buscarItem(int codigo) {
    for(int i = 0; i < estante.length; i++) {
        if(estante[i] != null && estante[i].getProduto().getCodigo() == codigo) {
            return estante[i];
        }
    }
    return null;
}

    public boolean inserirItemDeProduto(ItemDeProduto item){
        for(int i=0;i<estante.length;i++){
            if(estante[i] == null){
                estante[i] = item;
                return true;
            }
        }
        return false;
    }

    public ItemDeProduto[] getEstante() {
        return estante;
    }

    public void setEstante(ItemDeProduto[] estante) {
        this.estante = estante;
    }
    
    
    
}
*/
