package leilao;

public class Produto {
    private String descricao;
    private Lance maiorLance;

    public Produto(String descricao, Lance maiorLance) {
        this.descricao = descricao;
        this.maiorLance = maiorLance;
    }

    public void verificarMaiorLance(Lance lance) throws LanceMenorException{
        if(this.maiorLance.getValor() < lance.getValor()){
            this.maiorLance.setValor(lance.getValor());
        }
        else {
            throw new LanceMenorException();
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Lance getMaiorLance() {
        return maiorLance;
    }

    public void setMaiorLance(Lance maiorLance) {
        this.maiorLance = maiorLance;
    }
}
