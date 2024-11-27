package callcenter;
import java.util.HashSet;
import java.util.Scanner;

public class CallCenter {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    SuporteTecnico suporte = new SuporteTecnico();
    Interpretadora interpretadora = new Interpretadora();
    System.out.println("Descreva seu problema de maneira sucinta.");
    String problema = scanner.nextLine();
    interpretadora.separadorPalavras(problema);
    HashSet<String> palavras = interpretadora.getPalavraChave();
    suporte.buscaSolucaoFrase(palavras);

    }
}