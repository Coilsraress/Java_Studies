package servicos;

import negocio.Contato;
import java.io.*;
import java.util.*;

public class ManipulaArquivoTexto {
    private String arquivo;
    private Formatter gravador;
    private Scanner leitor;

    public ManipulaArquivoTexto(String arquivo) {
        this.arquivo = arquivo;
    }

    public void abrirArquivoParaGravacao() throws IOException {
        gravador = new Formatter(new FileWriter(arquivo, false));
    }

    public void gravarContato(HashMap<String, Contato> contatos) throws IOException {
        for (Contato contato : contatos.values()) {
            gravador.format("Nome: %s\nTelefone: %s\nEndereço: %s\nEmail: %s\n", contato.getNome(), contato.getTelefone(), contato.getEndereco(), contato.getEmail());
        }
    }

    public void fecharArquivoGravacao() throws IOException {
        if (gravador != null) {
            gravador.close();
        }
    }

    public void abrirArquivoParaLeitura() throws IOException {
        leitor = new Scanner(new FileReader(arquivo));
    }

    public ArrayList<Contato> lerArquivo() throws IOException {
        ArrayList<Contato> listaContatos = new ArrayList<>();
        Contato contato = null;

        while (leitor.hasNextLine()) {
            String linha = leitor.nextLine();

            if (linha.startsWith("Nome:")) {
                String nome = linha.substring(6).trim();
                contato = new Contato(nome, "", "", ""); // Cria o contato com nome inicial
            } else if (linha.startsWith("Telefone:") && contato != null) {
                String telefone = linha.substring(10).trim();
                contato.setTelefone(telefone);
            } else if (linha.startsWith("Endereço:") && contato != null) {
                String endereco = linha.substring(10).trim();
                contato.setEndereco(endereco);
            } else if (linha.startsWith("Email:") && contato != null) {
                String email = linha.substring(7).trim();
                contato.setEmail(email);
                listaContatos.add(contato);
                contato = null;
            }
        }

        return listaContatos;
    }

    public void fecharArquivoLeitura() throws IOException {
        if (leitor != null) {
            leitor.close();
        }
    }
}
