package cesar;

import java.util.Random;
import java.util.Scanner;

public class Enigma {
    public static void main(String[] args) throws DecifragemInvalidaException {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int index = random.nextInt(25);
        Chave chave = new Chave(3);
        String mensagem = chave.getNome(index);
        CifraDeCesar cifra = new CifraDeCesar(chave);

        System.out.println(mensagem);
        System.out.printf("Mensagem cifrada: %s\n", cifra.cifrar(mensagem));

        System.out.println("Digite a decodificação:");
        while (true) {
            String decod = scanner.nextLine();

            try {
                System.out.println(cifra.verificarMensagem(decod));
                if (decod.equals(mensagem)){
                    System.out.println("Decodificação correta.");
                    break;
                }
            } catch (DecifragemInvalidaException e) {
                    System.err.println("Erro na decodificação: " + e.getMessage());
                    System.out.println("Por favor, tente novamente.");
            }
 
        }
    }
}