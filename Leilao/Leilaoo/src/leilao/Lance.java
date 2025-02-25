package leilao;

public class Lance {
    private Pessoa pessoa;
    private float valor;

    public Lance(Pessoa pessoa, float valor) {
        this.pessoa = pessoa;
        this.valor = valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public float getValor() {
        return valor;
    }
}
