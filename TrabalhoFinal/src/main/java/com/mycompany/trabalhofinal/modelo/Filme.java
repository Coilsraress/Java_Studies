// src/main/java/com/mycompany/trabalhofinal/modelo/Filme.java
package com.mycompany.trabalhofinal.modelo;

public class Filme {
    private String nome;
    private String genero;
    private int anoLancamento;
    private int unidades;
    private String sinopse;

    public Filme(String nome, String genero, int anoLancamento, int unidades, String sinopse) {
        this.nome = nome;
        this.genero = genero;
        this.anoLancamento = anoLancamento;
        this.unidades = unidades;
        this.sinopse = sinopse;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }
}