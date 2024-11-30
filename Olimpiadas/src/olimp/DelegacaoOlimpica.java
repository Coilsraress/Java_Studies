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

    public int contaAtletasDelegacao(){
        int contador=0;
        for (Modalidade modalidade : modalidades){
            contador += modalidade.contaAtletas();
        }
        return contador;
    }
    public int contaTecnicosDelegacao(){
        int contador=0;
        for (Modalidade modalidade : modalidades){
            contador += modalidade.contaTecnicos();
        }
        return contador;
    }
    public int contaProfSaudeDelegacao(){
        int contador=0;
        for (Modalidade modalidade : modalidades){
            contador += modalidade.contaProfSaude();
        }
        return contador;
    }


    public String exibirDelegacao(){
        String concatenar = "\nDelegação:\n\n";
        for (Modalidade mods: modalidades){
            concatenar += mods.exibirMembros();
        }
        return concatenar;
    }

}
