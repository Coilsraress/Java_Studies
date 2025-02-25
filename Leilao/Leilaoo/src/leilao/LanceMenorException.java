package leilao;

public class LanceMenorException extends Exception {
    public LanceMenorException() {
        super("O valor do lance é menor ou igual ao maior lance atual!");
    }
}
