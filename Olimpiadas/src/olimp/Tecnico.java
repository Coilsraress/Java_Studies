package olimp;

public class Tecnico extends MembroComite {
    private String atividade;

    public Tecnico(String nome, String genero, int idade, String atividade) {
        super(nome, genero, idade);
        this.atividade = atividade;
    }

    @Override
    public String exibirDados() {
        String retorno = ("Nome: " + nome + "\n" +
                          "Genero: " + genero + "\n" +
                          "Idade: " + idade + "\n" +
                          "Atividade: " + atividade + "\n");
        return retorno;
    }
}
