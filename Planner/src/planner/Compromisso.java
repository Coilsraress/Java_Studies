package planner;

public class Compromisso {
    private int duracao;
    private String descricao;

    public Compromisso() {
        this.duracao = 0;
        this.descricao = "";
    }

    public Compromisso(int duracao, String descricao) {
        this.duracao = duracao;
        this.descricao = descricao;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
