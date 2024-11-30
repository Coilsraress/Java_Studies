package olimp;

public class Atleta extends MembroComite {
private String funcao;

    public Atleta(String nome, String genero, int idade, String funcao) {
        super(nome, genero, idade);
        this.funcao = funcao;
    }



    @Override
    public String exibirDados() {
        String retorno = ("Atleta:\n" + "Nome: " + nome + "\n" +
                "Genero: " + genero + "\n" +
                "Idade: " + idade + "\n" +
                "Função: " + funcao + "\n");
        return retorno;
    }
}
