// src/main/java/com/mycompany/trabalhofinal/modelo/Locadora.java
package com.mycompany.trabalhofinal.modelo;

import com.mycompany.trabalhofinal.sevices.ManipulaClientes;
import com.mycompany.trabalhofinal.sevices.ManipulaFilmes;


/**
 *
 * @author luis
 */
public class Locadora {
    private ManipulaFilmes manipulaFilmes; // Manipulador de filmes
    private ManipulaClientes manipulaClientes; // Manipulador de clientes

    public Locadora() {
        manipulaFilmes = new ManipulaFilmes();
        manipulaClientes = new ManipulaClientes();
    }

    public void adicionaFilme(Filme filme) {
        manipulaFilmes.adicionarFilme(filme); // Adiciona filme usando o manipulador
    }

    public void removerFilme(Filme filme) {
        manipulaFilmes.removerFilme(filme); // Remove filme usando o manipulador
    }

    public void adicionaCliente(Cliente cliente) {
        manipulaClientes.adicionarCliente(cliente); // Adiciona cliente usando o manipulador
    }

    public void removerCliente(Cliente cliente) {
        manipulaClientes.removerCliente(cliente); // Remove cliente usando o manipulador
    }

    public void alugarFilme(Cliente cliente, Filme filme, String dataDevolucao) {
        if (manipulaClientes.getClientes().contains(cliente)) {
            for (Filme f : manipulaFilmes.getFilmes()) {
                if (f.getNome().equals(filme.getNome()) && f.getUnidades() > 0) {
                    cliente.alugarFilme(f, dataDevolucao);
                    f.setUnidades(f.getUnidades() - 1); // Reduz a quantidade disponível
                    manipulaFilmes.salvarFilmes(); // Salva as alterações
                    return;
                }
            }
        }
    }

    public void devolverFilme(Cliente cliente) {
        if (manipulaClientes.getClientes().contains(cliente)) {
            Filme filmeAlugado = cliente.getFilmeAlugado();
            if (filmeAlugado != null) {
                for (Filme f : manipulaFilmes.getFilmes()) {
                    if (f.getNome().equals(filmeAlugado.getNome())) {
                        f.setUnidades(f.getUnidades() + 1); // Aumenta a quantidade disponível
                        cliente.devolverFilme(); // Limpa o filme alugado e a data de devolução
                        manipulaFilmes.salvarFilmes(); // Salva as alterações
                        manipulaClientes.salvarClientes(); // Salva as alterações do cliente
                        return;
                    }
                }
            }
        }
    }

    public ManipulaFilmes getManipulaFilmes() {
        return manipulaFilmes;
    }

    public ManipulaClientes getManipulaClientes() {
        return manipulaClientes;
    }
    
    
    
}