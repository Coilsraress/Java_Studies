package visao;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import servicos.ManipulaArquivoTexto;
import negocio.Agenda;
import negocio.Contato;
import negocio.ContatoInexistenteException;

public class AppAgenda {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();
        ManipulaArquivoTexto manipulador = new ManipulaArquivoTexto("contatos.txt");
        int opcao;

        try {
            ArrayList<Contato> contatosLidos = agenda.lerAgenda(manipulador);
            System.out.println("Contatos carregados do arquivo com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao carregar contatos do arquivo: " + e.getMessage());
        }

        do {
            System.out.println("\n=== Menu Agenda ===");
            System.out.println("1. Incluir contato");
            System.out.println("2. Consultar contato");
            System.out.println("3. Remover contato");
            System.out.println("4. Listar todos os contatos");
            System.out.println("5. Salvar contatos no arquivo");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Endereço: ");
                    String endereco = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    Contato novoContato = new Contato(nome, telefone, endereco, email);
                    if (agenda.incluirContato(novoContato)) {
                        System.out.println("Contato incluído com sucesso!");
                    } else {
                        System.out.println("Erro: Contato com este nome já existe.");
                    }
                    break;

                case 2:
                    System.out.print("Digite o nome do contato: ");
                    String nomeConsulta = scanner.nextLine();
                    try {
                        Contato contato = agenda.consultarContato(nomeConsulta);
                        System.out.println("Contato encontrado:");
                        System.out.println("Nome: " + contato.getNome());
                        System.out.println("Telefone: " + contato.getTelefone());
                        System.out.println("Endereço: " + contato.getEndereco());
                        System.out.println("Email: " + contato.getEmail());
                    } catch (ContatoInexistenteException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Digite o nome do contato: ");
                    String nomeRemover = scanner.nextLine();
                    try {
                        agenda.removerContato(nomeRemover);
                        System.out.println("Contato removido com sucesso!");
                    } catch (ContatoInexistenteException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    HashMap<String, Contato> contatos = agenda.getContatos();
                    if (contatos.isEmpty()) {
                        System.out.println("Nenhum contato cadastrado.");
                    } else {
                        System.out.println("Lista de contatos:");
                        for (Contato contato : contatos.values()) {
                            System.out.println("Nome: " + contato.getNome());
                            System.out.println("Telefone: " + contato.getTelefone());
                            System.out.println("Endereço: " + contato.getEndereco());
                            System.out.println("Email: " + contato.getEmail());
                            System.out.println("-------------------");
                        }
                    }
                    break;

                case 5:
                    try {
                        agenda.persistirAgenda(manipulador);
                        System.out.println("Contatos salvos com sucesso no arquivo!");
                        ArrayList<Contato>  contatosLidos = agenda.lerAgenda(manipulador);
                    } catch (Exception e) {
                        System.out.println("Erro ao salvar contatos: " + e.getMessage());
                    }

                    break;

                case 0:
                    try {
                        agenda.persistirAgenda(manipulador);
                        System.out.println("Contatos salvos com sucesso no arquivo!");
                    } catch (Exception e) {
                        System.out.println("Erro ao salvar contatos: " + e.getMessage());
                    }
                    System.out.println("Salvando e encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
