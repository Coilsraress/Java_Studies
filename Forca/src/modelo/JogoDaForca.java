
package modelo;

import java.util.ArrayList;
import java.util.Random;
import servico.ManArqTexto;


public class JogoDaForca {
    private String palavraSorteada;
    private ArrayList<String> todasPalavras;
    private int numTentativas;
    
    public void lerArquivoPalavras(){
        ManArqTexto gerenciador = new ManArqTexto();
        todasPalavras = gerenciador.lerPalavras();
    }
    
    public void sorteiaPalavra() {
        Random random = new Random(); 
        if (!todasPalavras.isEmpty()) { 
            int indiceAleatorio = random.nextInt(todasPalavras.size()); 
            palavraSorteada = todasPalavras.get(indiceAleatorio); 
        } else {
            System.out.println("Nenhuma palavra disponível para sortear.");
        }
    }
    
    public int[] verificaLetra(String letra) {
        int[] posicoes = new int[palavraSorteada.length()];
        for (int i = 0; i < palavraSorteada.length(); i++) {
            if (String.valueOf(palavraSorteada.charAt(i)).equalsIgnoreCase(letra)) {
                posicoes[i] = i; // Armazenando a posição da letra
            } else {
                posicoes[i] = -1; // -1 indica que a letra não está nessa posição
            }
        }
        numTentativas--; // Decrementando o número de tentativas
        return posicoes;
    }

    public boolean palavraDescoberta(String letra) {
        return palavraSorteada.equalsIgnoreCase(letra);
    }

    public int getNumTentativas() {
        return numTentativas;
    }

    public String getPalavraSorteada() {
        return palavraSorteada;
    }
    
}
