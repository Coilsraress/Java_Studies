package mesa;
import java.util.Random;
public class Baralho {
    private String[] naipes = {"Copas", "Ouros", "Paus", "Espadas"};
    private Carta[] baralho;
    private Random gerador;
    public Baralho(){
        int contador = 0;
        baralho = new Carta[52];
        gerador = new Random();
        for(String naipe : naipes){
            for(int i=1; i<=13; i++){
                baralho[contador] = new Carta(naipe, i);
                contador++;
            }
        }
    }
    public void embaralhar(){
        int num = gerador.nextInt(baralho.length);
        for(int i=0; i<baralho.length; i++){
            Carta aux = baralho[i];
            baralho[i]=baralho[num];
            baralho[num]=aux;
        }
    }

    public Carta[] distribuirCartas(int numero) {
        int cartasDisponiveis = 0;
        Carta [] retorno;
        for (Carta carta : baralho) {
            if (carta != null) {
                cartasDisponiveis++;
            }
        }
        if (cartasDisponiveis>numero) {
            retorno = new Carta[numero];
            int contador = 0;

            for (int i = 0; i < baralho.length && contador < numero; i++) {
                if (baralho[i] != null) {
                    retorno[contador] = baralho[i];
                    baralho[i] = null;
                    contador++;
                }
            }
        }
        else{
            retorno = null;
            System.out.println("O numero de cartas no baralho pequeno demais para mais um jogador.");
        }
        return retorno;
    }

}
