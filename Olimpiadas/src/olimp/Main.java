package olimp;


public class Main {
    public static void main(String[] args) {
        DelegacaoOlimpica olimpiada = new DelegacaoOlimpica();
        Modalidade futebol = new Modalidade(20, "Futebol");
        Tecnico joao = new Tecnico("João", "M", 45, "Treinador");
        futebol.adicionarMembro(joao);
        ProfSaude maria = new ProfSaude("Maria", "F", 34, "Fisioterapeuta");
        futebol.adicionarMembro(maria);
        Atleta pedro = new Atleta("Pedro Silva", "M", 28, "Atacante");
        futebol.adicionarMembro(pedro);
        Tecnico carlos = new Tecnico("Carlos", "M", 50, "Treinador Assistente");
        futebol.adicionarMembro(carlos);
        ProfSaude julia = new ProfSaude("Julia", "F", 29, "Nutricionista");
        futebol.adicionarMembro(julia);
        Atleta lucas = new Atleta("Lucas Souza", "M", 25, "Zagueiro");
        futebol.adicionarMembro(lucas);
        Tecnico fernando = new Tecnico("Fernando", "M", 42, "Preparador Físico");
        futebol.adicionarMembro(fernando);
        ProfSaude paulo = new ProfSaude("Paulo", "M", 37, "Médico");
        futebol.adicionarMembro(paulo);
        Atleta ricardo = new Atleta("Ricardo Lima", "M", 31, "Meia");
        futebol.adicionarMembro(ricardo);
        Tecnico ana = new Tecnico("Ana", "F", 39, "Auxiliar Técnica");
        futebol.adicionarMembro(ana);
        ProfSaude sofia = new ProfSaude("Sofia", "F", 40, "Psicóloga Esportiva");
        futebol.adicionarMembro(sofia);
        Atleta renata = new Atleta("Renata Alves", "F", 27, "Atacante");
        futebol.adicionarMembro(renata);
        Tecnico rodrigo = new Tecnico("Rodrigo", "M", 48, "Treinador de Goleiros");
        futebol.adicionarMembro(rodrigo);
        ProfSaude leticia = new ProfSaude("Letícia", "F", 33, "Fisioterapeuta");
        futebol.adicionarMembro(leticia);
        Atleta fernanda = new Atleta("Fernanda Costa", "F", 26, "Volante");
        futebol.adicionarMembro(fernanda);
        Tecnico luciana = new Tecnico("Luciana", "F", 46, "Preparadora Mental");
        futebol.adicionarMembro(luciana);
        ProfSaude gabriel = new ProfSaude("Gabriel", "M", 41, "Médico do Esporte");
        futebol.adicionarMembro(gabriel);
        Atleta bruno = new Atleta("Bruno Oliveira", "M", 29, "Atacante");
        futebol.adicionarMembro(bruno);


        olimpiada.adicionarModalidade(futebol);

        System.out.printf("\nO numero de atletas da modalidade %s é: %d\n", futebol.getDescricao(), futebol.contaAtletas());
        System.out.printf("O numero de tecnicos da modalidade %s é: %d\n", futebol.getDescricao(), futebol.contaTecnicos());
        System.out.printf("O numero de profissionais da saude da modalidade %s é: %d\n", futebol.getDescricao(), futebol.contaProfSaude());

        System.out.printf("\nO numero de atletas da delegação é: %d\n", olimpiada.contaAtletasDelegacao());
        System.out.printf("O numero de tecnicos da delegação é: %d\n", olimpiada.contaTecnicosDelegacao());
        System.out.printf("O numero de profissionais da saude da delegação é: %d\n",  olimpiada.contaProfSaudeDelegacao());

        System.out.println((olimpiada.exibirDelegacao()));

    }
}