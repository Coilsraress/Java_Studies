package olimp;

import java.util.ArrayList;

public class DelegacaoOlimpica {
    private ArrayList<Modalidade> modalidades;


    public DelegacaoOlimpica() {
        modalidades = new ArrayList<>();
    }



    public boolean adicionarModalidade(Modalidade modalidade){
        modalidades.add(modalidade);
        return true;
    }

    public String exibirDelegacao(){
        String concatenar = "Delegação:\n\n";
        for (Modalidade mods: modalidades){
            concatenar += mods.exibirMembros();
        }
        return concatenar;
    }

}
