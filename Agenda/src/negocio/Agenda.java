package negocio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import servicos.ManipulaArquivoTexto;

public class Agenda {
    HashMap<String, Contato> contatos;

    public Agenda() {
        contatos=new HashMap<>();
    }

    public boolean incluirContato(Contato contato){
        if(contatos.containsKey(contato.getNome())){
            return false;
        }
        contatos.put(contato.getNome(), contato);
        return true;
    }

    public boolean exitesContato(String nome){
        if(contatos.containsKey(nome)){
            return true;
        }
        else{
            return false;
        }
    }

    public Contato consultarContato(String nome) throws ContatoInexistenteException{
        if(this.exitesContato(nome)){
            return contatos.get(nome);
        }
        else{
            throw new ContatoInexistenteException("O contato não existe!");
        }
    }

    public void removerContato(String nome) throws ContatoInexistenteException{
        if(this.exitesContato(nome)){
            contatos.remove(nome);
        }
        else{
            throw new ContatoInexistenteException("O contato não existe!");
        }
    }

    public void persistirAgenda(ManipulaArquivoTexto manipulador) throws IOException {
        manipulador.abrirArquivoParaGravacao();
        manipulador.gravarContato(contatos);
        manipulador.fecharArquivoGravacao();
    }

    public ArrayList<Contato> lerAgenda(ManipulaArquivoTexto manipulador) throws IOException {
        manipulador.abrirArquivoParaLeitura();
        ArrayList<Contato> contatosLidos = manipulador.lerArquivo();
        manipulador.fecharArquivoLeitura();

        for (Contato contato : contatosLidos) {
            incluirContato(contato);
        }
        return contatosLidos;
    }

    public HashMap<String, Contato> getContatos() {
        return contatos;
    }

    public void setContatos(HashMap<String, Contato> contatos) {
        this.contatos = contatos;
    }
}
