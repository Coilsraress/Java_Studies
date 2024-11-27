package enquete;

import java.security.SecureRandom;

public class Teste {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        Enquete bandeco;
        bandeco = new Enquete();
        for (int i = 0; i < 50; i++) {
            bandeco.resgistraNota(random.nextInt(10)+1);
        }
        System.out.println("A frequencia de ocorrencia da nota 5 é "+bandeco.frequenciaNota(5));
        System.out.println("A media das notas é "+bandeco.calcularMedia());
        System.out.println("O numero de entrevistados é "+bandeco.numeroEntrevistados());
    }


}