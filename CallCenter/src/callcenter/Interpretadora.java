package callcenter;

import java.util.HashSet;

public class Interpretadora {
    private HashSet<String> palavraChave;

    public Interpretadora() {
    this.palavraChave = new HashSet<>();
    }

    private void adicionarPalavra(String palavra){
        this.palavraChave.add(palavra);
    }

    public HashSet<String> getPalavraChave() {
        return palavraChave;
    }
    

    public void separadorPalavras(String frase){
        String[] palavras = frase.split(" ");
        for(String token : palavras){
            adicionarPalavra(token);
        }
    }
}
