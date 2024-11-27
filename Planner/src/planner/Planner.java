package planner;

import java.util.Scanner;

public class Planner {
    public static void main(String[] args) {
        Semana semana = new Semana();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar compromisso");
            System.out.println("2. Listar compromissos da semana");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.print("Informe o dia (0-Segunda, 1-Terça, 2-Quarta, 3-Quinta, 4-Sexta): ");
                int dia = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Informe a hora de início (9-18): ");
                int hora = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Informe a duração do compromisso (em horas): ");
                int duracao = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Informe a descrição do compromisso: ");
                String descricao = scanner.nextLine();

                Compromisso compromisso = new Compromisso(duracao, descricao);

                if (semana.adicionarCompromisso(dia, compromisso, hora)) {
                    System.out.println("Compromisso adicionado com sucesso!");
                } else {
                    System.out.println("Verifique os horários.");
                }
            } else if (opcao == 2) {
                semana.listarCompromissosSemana();
            } else if (opcao == 3) {
                System.out.println("Encerrando o programa.");
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
