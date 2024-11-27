package planner;

public class Dia {
    private Compromisso[] diaria;
    private String descricaoDia;

    public Dia() {
        diaria = new Compromisso[10];
        descricaoDia = "";
    }

    public Dia(String descricaoDia) {
        diaria = new Compromisso[10];
        this.descricaoDia = descricaoDia;
    }


        public boolean inserirCompromisso(Compromisso compromisso, int hora) {
        for (int i = 0; i < compromisso.getDuracao(); i++) {
            if (diaria[hora-9+i] != null) {
                System.out.println("\nHorário ocupado!");
                return false;
            }
        }

        for (int i = 0; i < compromisso.getDuracao(); i++) {
            diaria[hora-9+i] = compromisso;
        }
        return true;
    }

    public Compromisso consultaCompromisso(int hora){
        return diaria[hora-9];
    }


    public void listarCompromisso() {
            for (int i = 0; i < diaria.length; i++) {
                if (diaria[i] != null && (i == 0 || diaria[i] != diaria[i-1])) {
                    System.out.println((i+9) + "h: " + diaria[i].getDescricao() + " | duração: " + diaria[i].getDuracao() +"h");
                } else if (diaria[i] == null) {
                }
            }
        }
    public String getDescricaoDia(){
        return this.descricaoDia;
    }
}
