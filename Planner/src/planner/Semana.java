package planner;

public class Semana {
    private Dia[] dias;

    public Semana() {
        dias = new Dia[5];
        dias[0] = new Dia("Segunda-feira");
        dias[1] = new Dia("Terça-feira");
        dias[2] = new Dia("Quarta-feira");
        dias[3] = new Dia("Quinta-feira");
        dias[4] = new Dia("Sexta-feira");
    }

    public boolean adicionarCompromisso(int dia, Compromisso compromisso, int hora) {
        if (dia < 0 || dia >= dias.length) {
            System.out.println("Dia inválido.");
            return false;
        }
        return dias[dia].inserirCompromisso(compromisso, hora);
    }

    public void listarCompromissosSemana() {
        for (int i = 0; i < dias.length; i++) {
            System.out.println("\n" + dias[i].getDescricaoDia() + ":");
            dias[i].listarCompromisso();
        }
    }

}
