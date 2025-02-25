package com.mycompany.trabalhofinal.modelo;

public class Cliente {
    private String nome;
    private String id;
    private Filme filmeAlugado; // Referência ao filme alugado
    private String dataDevolucao; // Data de devolução do filme

    public Cliente(String nome, String id) {
        this.nome = nome;
        this.id = id;
        this.filmeAlugado = null; // Inicializa como null se não houver filme alugado
        this.dataDevolucao = "";
    }

    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }

    public Filme getFilmeAlugado() {
        return filmeAlugado;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFilmeAlugado(Filme filmeAlugado) {
        this.filmeAlugado = filmeAlugado;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public void alugarFilme(Filme filme, String dataDevolucao) {
        this.filmeAlugado = filme;
        this.dataDevolucao = dataDevolucao;
    }

    public void devolverFilme() {
        this.filmeAlugado = null; // Limpa o filme alugado
        this.dataDevolucao = ""; // Limpa a data de devolução
    }

    public String getFilmeAlugadoNome() {
        return filmeAlugado != null ? filmeAlugado.getNome() : "Nenhum filme alugado";
    }
}