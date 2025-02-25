package cesar;

public class Chave {
    private int deslocamento;
    private String[] nomes = {
            "Ana", "Bruno", "Carlos", "Daniela", "Eduardo",
            "Fernanda", "Gabriel", "Helena", "Igor", "Juliana",
            "Lucas", "Mariana", "Nicolas", "Olivia", "Paulo",
            "Quiteria", "Rafael", "Sofia", "Tiago", "Ursula",
            "Vinicius", "Wanda", "Xavier", "Yasmin", "Ze"
    };

    public Chave(int deslocamento) {
        this.deslocamento = deslocamento;
    }

    public int getDeslocamento() {
        return deslocamento;
    }

    public void setDeslocamento(int deslocamento) {
        this.deslocamento = deslocamento;
    }

    public String getNome(int index) {
        return nomes[index];
    }


}
