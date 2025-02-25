package leilao;

import java.util.ArrayList;

public class Lote {
    ArrayList<Produto> produtos;

    public Lote() {
        this.produtos = new ArrayList<>();
    }


    public void inserirProduto(String descricao, Lance lance) throws ProdutoNaoEncontradoException {
        produtos.add(new Produto(descricao, lance));
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public Produto buscarProduto(String descricao) throws ProdutoNaoEncontradoException {
        for (Produto produto : produtos) {
            if (descricao.equals(produto.getDescricao())) {
                return produto;
            }
        }
        throw new ProdutoNaoEncontradoException();
    }
}
