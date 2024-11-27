package principal_supernosso;

public class Produto {
    private int codigo;
    private String descricao;
    private String unidade;
    private double preco;

    public Produto() {
        this.codigo = 0;
        this.descricao = "";
        this.preco = 0.0;
    }

    public Produto(int codigo, String descricao, double preco, String unidade) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.unidade = unidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
    
   
    
    
    
    
    
}
