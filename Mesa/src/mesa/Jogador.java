package mesa;

public class Jogador {
    private Carta[] mao;

    public Jogador(int num){
        mao = new Carta[num];
    }

    public Carta[] getMao() {
        return mao;
    }

    public void setMao(Carta[] mao) {
        this.mao = mao;
    }
    public Carta escolheMelhor() {
        Carta maior = mao[0];

        for (Carta aux : mao) {

            int comparacao = maior.ehMaior(aux);
                //aux>atual            Empate, verifica ouro
            if (comparacao != 1 || (comparacao == 0 && aux.getNaipe().equals("Ouros"))) {
                maior = aux;
            }
        }

        return maior;
    }


}
