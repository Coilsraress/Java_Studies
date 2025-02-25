/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhofinal.modelo;

/**
 *
 * @author luis
 */
public class Item {
    
    private Filme filme;
    private int quantidade;

    public Item(Filme filme, int quantidade) {
        this.filme = filme;
        this.quantidade = quantidade;
    }
    
    public Item(Filme filme){
        this.filme = filme;
        quantidade = 1;
    }
    
    public void adicionarN(int n){
        quantidade += n;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
