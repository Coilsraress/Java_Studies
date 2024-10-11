
import java.util.ArrayList;
import java.util.List;

public class Teste {
    
    public static void main(String[] args) {
        List<Animal> animais = new ArrayList<>();
        animais.add(new Cavalo("Fantasma", "Branco", 10.5));
        animais.add(new Cavalo("Penumbra", "Cinza", 11));
        animais.add(new Vaca("Mimosa", "Branco", 22));
        animais.add(new Vaca("Miramel", "Marrom", 18));
        animais.add(new Vaca("Angs", "Preto", 23));
        animais.add(new Galinha("Ginger", "laranja", 5));
        animais.add(new Galinha("Babs", "Laranja", 6));
        animais.add(new Galinha("Rocky", "vermelho", 8));
        animais.add(new Galinha("Bunty", "vermelho", 13));
        animais.add(new Galinha("Mac", "Branco", 3));
        animais.add(new Cavalo("Jhonny", "Preto", 12));

        double racaoTotal = 0;
        double racaoCavalos = 0;
        double racaoVacas = 0;
        double racaoGalinhas = 0;   
        int numeroDeCavalos = 0;
        int numeroDeVacas = 0;
        int numeroDeGalinhas = 0;

        for (Animal animal : animais) {
            racaoTotal += animal.getConsumo();
            if (animal instanceof Cavalo) {
                numeroDeCavalos++;
                racaoCavalos += animal.getConsumo();
            } else if (animal instanceof Vaca) {
                numeroDeVacas++;
                racaoVacas += animal.getConsumo();
            } else if (animal instanceof Galinha) {
                numeroDeGalinhas++;
                racaoGalinhas += animal.getConsumo();
            }
        }
        //Consumo total no mês
        racaoTotal*=30;
        racaoCavalos*=30;
        racaoVacas*=30;
        racaoGalinhas*=30;

        System.out.println("O número de cavalos é: " + numeroDeCavalos);
        System.out.println("A quantidade de ração para cavalos é: " + racaoCavalos);
        //System.out.println("\n");
        System.out.println("O número de vacas é: " + numeroDeVacas);
        System.out.println("A quantidade de ração para vacas é: " + racaoVacas);
        //System.out.println("\n" );
        System.out.println("O número de galinhas é: " + numeroDeGalinhas);
        System.out.println("A quantidade de ração para galinhas é: " + racaoGalinhas);
        //System.out.println("\n");
        System.out.println("A quantidade de ração total necessária é: " + racaoTotal);
        System.out.println("O nome do(a) " + animais.get(4).getClass().getSimpleName() + " mais gordo(a) é: " + animais.get(4).getNome()+" comendo "+animais.get(4).getConsumo()*30+"kg por mês");
    }
}


