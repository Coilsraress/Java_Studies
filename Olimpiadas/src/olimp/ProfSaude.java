package olimp;

public class ProfSaude extends MembroComite{
    private String especialidade;
    public ProfSaude(String nome, String genero, int idade, String especialidade) {
        super(nome, genero, idade);
        this.especialidade=especialidade;
    }

    @Override
    public String exibirDados() {
        String retorno = ("Nome: " + nome + "\n" +
                "Genero: " + genero + "\n" +
                "Idade: " + idade + "\n" +
                "Especialidade: " + especialidade + "\n");
        return retorno;
    }
}
