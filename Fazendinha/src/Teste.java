public class Teste {
    
    public static void main(String[] args) {
        Animal[] animais = new Animal[10];
        animais[0] = new Cavalo("Fantasma", "Branco", 10.5);
        animais[1] = new Cavalo("Penumbra", "Cinza", 11);
        animais[2] = new Vaca("Mimosa", "Branco", 22);
        animais[3] = new Vaca("Miramel", "Marrom", 18);
        animais[4] = new Vaca("Angs", "Prto", 23);
        animais[5] = new Galinha("Ginger", "laranja", 5);
        animais[6] = new Galinha("Babs", "Laranja", 6);
        animais[7] = new Galinha("Rocky", "vermelho", 8);
        animais[8] = new Galinha("Bunty", "vermelho", 13);
        animais[9] = new Galinha("Mac", "Branco", 3);
        
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
    }
}


