package olimp;

public class Atleta extends MembroComite {


    public Atleta(String nome, String genero, int idade) {
        super(nome, genero, idade);
    }



    @Override
    public String exibirDados() {
        String retorno = ("Nome: " + nome + "\n" +
                "Genero: " + genero + "\n" +
                "Idade: " + idade + "\n");
        return retorno;
    }
}
