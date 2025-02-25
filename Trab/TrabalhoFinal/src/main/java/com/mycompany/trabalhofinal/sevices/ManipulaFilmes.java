// src/main/java/com/mycompany/trabalhofinal/sevices/ManipulaFilmes.java
package com.mycompany.trabalhofinal.sevices;

import com.mycompany.trabalhofinal.modelo.Filme;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManipulaFilmes {
    private List<Filme> filmes;

    public ManipulaFilmes() {
        filmes = new ArrayList<>();
        carregarFilmes();
    }

    private void carregarFilmes() {
        try (BufferedReader br = new BufferedReader(new FileReader("filmes.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(", ");
                String nome = partes[0].split(": ")[1];
                String genero = partes[1].split(": ")[1];
                int anoLancamento = Integer.parseInt(partes[2].split(": ")[1]);
                int unidades = Integer.parseInt(partes[3].split(": ")[1]);
                String sinopse = partes[4].split(": ")[1];

                Filme filme = new Filme(nome, genero, anoLancamento, unidades, sinopse);
                filmes.add(filme);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void salvarFilmes() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("filmes.txt"))) {
            for (Filme filme : filmes) {
                String linha = "Nome: " + filme.getNome() + ", Gênero: " + filme.getGenero() +
                               ", Lançamento: " + filme.getAnoLancamento() +
                               ", Unidades: " + filme.getUnidades() +
                               ", Sinopse: " + filme.getSinopse();
                bw.write(linha);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Filme getFilmePorNome(String nome) {
        for (Filme filme : filmes) {
            if (filme.getNome().equals(nome)) {
                return filme;
            }
        }
        return null;
    }
        
    public void adicionarFilme(Filme filme) {
        filmes.add(filme);
        salvarFilmes();
    }

    public void removerFilme(Filme filme) {
        filmes.remove(filme);
        salvarFilmes();
    }

    public List<Filme> getFilmes() {
        return filmes;
    }
}