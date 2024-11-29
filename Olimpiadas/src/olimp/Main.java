package olimp;


public class Main {
    public static void main(String[] args) {
        DelegacaoOlimpica olimpiada = new DelegacaoOlimpica();
        Modalidade futebol = new Modalidade(27, "Futebol");
        Tecnico jorge = new Tecnico("Jorge", "M", 488, "Treinador");
        futebol.adicionarMembro(jorge);
        ProfSaude luis = new ProfSaude("Luis", "palio 1.4", 985, "Otorrinolaringologista");
        futebol.adicionarMembro(luis);
        Atleta ronaldo = new Atleta("Ronaldin do gol", "atacante", 23);
        futebol.adicionarMembro(ronaldo);
        Tecnico paulo = new Tecnico("Paulo", "M", 342, "Treinador Assistente");
        futebol.adicionarMembro(paulo);

        ProfSaude ana = new ProfSaude("Ana", "fiat uno", 743, "Fisioterapeuta");
        futebol.adicionarMembro(ana);

        Atleta neymar = new Atleta("Neymar Jr", "atacante", 31);
        futebol.adicionarMembro(neymar);

        Tecnico eduardo = new Tecnico("Eduardo", "M", 102, "Preparador Físico");
        futebol.adicionarMembro(eduardo);

        ProfSaude carlos = new ProfSaude("Carlos", "mercedes-benz", 345, "Médico");
        futebol.adicionarMembro(carlos);

        Atleta messi = new Atleta("Lionel Messi", "meia", 36);
        futebol.adicionarMembro(messi);

        Tecnico fernando = new Tecnico("Fernando", "M", 765, "Técnico Assistente");
        futebol.adicionarMembro(fernando);

        ProfSaude juliana = new ProfSaude("Juliana", "honda civic", 566, "Nutricionista");
        futebol.adicionarMembro(juliana);

        Atleta suarez = new Atleta("Luis Suárez", "atacante", 37);
        futebol.adicionarMembro(suarez);

        Tecnico marcelo = new Tecnico("Marcelo", "M", 999, "Analista de Desempenho");
        futebol.adicionarMembro(marcelo);

        ProfSaude roberta = new ProfSaude("Roberta", "toyota corolla", 156, "Psicóloga Esportiva");
        futebol.adicionarMembro(roberta);

        Atleta cristiano = new Atleta("Cristiano Ronaldo", "atacante", 39);
        futebol.adicionarMembro(cristiano);

        Tecnico ricardo = new Tecnico("Ricardo", "M", 411, "Treinador de Goleiros");
        futebol.adicionarMembro(ricardo);

        ProfSaude gabriela = new ProfSaude("Gabriela", "chevrolet tracker", 852, "Fisioterapeuta");
        futebol.adicionarMembro(gabriela);

        Atleta mbappe = new Atleta("Kylian Mbappé", "atacante", 25);
        futebol.adicionarMembro(mbappe);

        Tecnico gustavo = new Tecnico("Gustavo", "M", 256, "Auxiliar Técnico");
        futebol.adicionarMembro(gustavo);

        ProfSaude rodrigo = new ProfSaude("Rodrigo", "nissan sentra", 358, "Médico do Esporte");
        futebol.adicionarMembro(rodrigo);

        Atleta kane = new Atleta("Harry Kane", "atacante", 30);
        futebol.adicionarMembro(kane);

        Tecnico vinicius = new Tecnico("Vinícius", "M", 645, "Preparador Mental");
        futebol.adicionarMembro(vinicius);

        olimpiada.adicionarModalidade(futebol);
/*
        System.out.println(futebol.getDescricao() + ": \n");

        System.out.println(jorge.exibirDados());
        System.out.println(luis.exibirDados());
        System.out.println(ronaldo.exibirDados());
*/
        System.out.println((olimpiada.exibirDelegacao()));

    }
}