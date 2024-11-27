package epa;

public class Produto {
    private int codigo;
    private String descricao;
    private double preco;
    private String unidade;
    
    public Produto(int codigo, String descricao, double preco, String unidade) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.unidade = unidade;
    }
    
    public int getCodigo() {
        return codigo;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public double getPreco() {
        return preco;
    }
    
    public String getUnidade() {
        return unidade;
    }
}