package mesa;

public class Mesa {
    public static void main(String[] args) {
        boolean endgame = true;
        while (endgame) {
            Baralho copag = new Baralho();
            Jogador a = new Jogador(5);
            Jogador b = new Jogador(5);

            copag.embaralhar();
            System.out.println("Mesa embaralhando......");
            a.setMao(copag.distribuirCartas(5));
            b.setMao(copag.distribuirCartas(5));
            System.out.println("Mesa distribui as 5 cartas a cada jogador");

            Carta carta_a = a.escolheMelhor();
            Carta carta_b = b.escolheMelhor();

            System.out.println("O jogador A joga a carta de naipe " + carta_a.getNaipe() + " de valor " + carta_a.getNumero());
            System.out.println("O jogador B joga a carta de naipe " + carta_b.getNaipe() + " de valor " + carta_b.getNumero());

            if (carta_a.ehMaior(carta_b) == 1) {
                System.out.println("O jogador A é o vencedor");
                endgame = false;
            } else if (carta_a.ehMaior(carta_b) == -1) {
                System.out.println("O jogador B é o vencedor");
                endgame = false;
            } else if (carta_a.ehMaior(carta_b) == 0) {
                if (carta_a.getNaipe().equals("Ouros")) {
                    System.out.println("O jogador A é o vencedor");
                    endgame = false;
                } else {
                    System.out.println("O jogador B é o vencedor");
                    endgame = false;
                }
            } else {
                System.out.println("Empate");
                System.out.println("Resetando jogo.....");
            }


        }
    }
}