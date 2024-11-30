package olimp;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Modalidade {
    private int limiteMembros;
    private String descricao;

    private ArrayList<MembroComite> membros;

    public Modalidade(int limiteMembros, String descricao) {
        this.limiteMembros = limiteMembros;
        this.descricao = descricao;
        membros = new ArrayList<>();
    }
    public boolean adicionarMembro(MembroComite membro){
        if(membros.size()<limiteMembros) {
            membros.add(membro);
            return true;
        }
        else {
            return false;
        }
    }
    public int contaAtletas(){
        int contador=0;
        for (MembroComite membro : membros){
            if (membro instanceof Atleta){
                contador++;
            }
        }
        return contador;
    }

    public int contaTecnicos(){
        int contador=0;
        for (MembroComite membro : membros){
            if (membro instanceof Tecnico){
                contador++;
            }
        }
        return contador;
    }

    public int contaProfSaude(){
        int contador=0;
        for (MembroComite membro : membros){
            if (membro instanceof ProfSaude){
                contador++;
            }
        }
        return contador;
    }

    public int getLimiteMembros() {
        return limiteMembros;
    }

    public void setLimiteMembros(int limiteMembros) {
        this.limiteMembros = limiteMembros;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String exibirMembros(){
        String concatenar = descricao + ":\n";
        for (MembroComite membro: membros){
            concatenar += "\n" + membro.exibirDados();
        }
        return concatenar;
    }

}
