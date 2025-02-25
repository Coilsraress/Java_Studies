package leilao;

import java.util.ArrayList;

public class Leilao {
    ArrayList<Lote> lotes;

    public Leilao() {
        this.lotes = new ArrayList<>();
    }

    public void inserirLote(int numLote) {
        while (lotes.size() <= numLote) {
            lotes.add(null);
        }
        lotes.set(numLote, new Lote());
    }

    public void receberLance(int numLote, String descricaoProduto, Lance lance){
        Lote auxiliar = lotes.get(numLote);
        Produto aux = null;



        try {
            aux = auxiliar.buscarProduto(descricaoProduto);
        } catch (ProdutoNaoEncontradoException e) {
            System.err.println("Erro: " + e.getMessage());
        }
        if(aux!=null) {
            try {
                aux.verificarMaiorLance(lance);
            } catch (LanceMenorException e) {
                System.err.println("Erro: " + e.getMessage());
            }
        }
    }

    public void encerraLeilao(){
        System.exit(1);
    }

    public String listarProdutos(){
        String retorno = "\n";
        for (Lote lote : lotes){
            if(lote==null){
                continue;
            }
            int i = 1;
            retorno += "Lote:" + i + "\n";
            for (Produto produto : lote.getProdutos()){
                retorno += "- " + produto.getDescricao() + "\n";
            }
            i++;
        }
    return retorno;
    }

}
