package com.mycompany.trabalhofinal.sevices;

import com.mycompany.trabalhofinal.modelo.Cliente;
import com.mycompany.trabalhofinal.modelo.Filme;

import java.io.*;
import java.util.ArrayList;

public class ManipulaClientes {
    private ArrayList<Cliente> clientes; // Lista de clientes

    public ManipulaClientes() {
        clientes = new ArrayList<>(); // Inicializa a lista de clientes
        carregarClientes(); // Carrega os clientes do arquivo
    }

private void carregarClientes() {
    try (BufferedReader br = new BufferedReader(new FileReader("clientes.txt"))) {
        String linha;
        while ((linha = br.readLine()) != null) {
            // Ignora linhas vazias
            if (linha.isEmpty()) {
                continue;
            }

            String[] partes = linha.split(", ");
            // Verifica se a linha contém o número esperado de partes
            if (partes.length < 4) {
                System.err.println("Linha inválida: " + linha); // Log de erro para linha inválida
                continue; // Ignora linhas inválidas
            }

            // Acessa as partes da linha sem usar trim()
            String nome = partes[0].split(": ")[1]; // Nome do cliente
            String id = partes[1].split(": ")[1]; // ID do cliente
            String filmeAlugado = partes[2].split(": ")[1]; // Filme alugado
            String dataDevolucao = partes[3].split(": ")[1]; // Data de devolução

            // Cria o cliente
            Cliente cliente = new Cliente(nome, id);
            
            // Se houver um filme alugado, atualiza o cliente
            if (!filmeAlugado.equals("Nenhum") && !filmeAlugado.isEmpty()) {
                cliente.alugarFilme(new Filme(filmeAlugado, "", 0, 0, ""), dataDevolucao);
            } else {
                // Se não houver filme alugado, apenas define a data de devolução
                cliente.setDataDevolucao(dataDevolucao.isEmpty() ? "Nenhuma" : dataDevolucao);
            }

            // Adiciona o cliente à lista
            clientes.add(cliente);
        }
    } catch (IOException e) {
        e.printStackTrace(); // Exibe erro se ocorrer
    }
}

    public void salvarClientes() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("clientes.txt"))) {
            for (Cliente cliente : clientes) {
                String filmeAlugado = cliente.getFilmeAlugado() != null ? cliente.getFilmeAlugado().getNome() : "Nenhum";
                String linha = "Nome: " + cliente.getNome() + ", ID: " + cliente.getId() +
                               ", Filme Alugado: " + filmeAlugado + 
                               ", Data de Devolução: " + cliente.getDataDevolucao();
                bw.write(linha); // Escreve a linha no arquivo
                bw.newLine(); // Nova linha
            }
        } catch (IOException e) {
            e.printStackTrace(); // Exibe erro se ocorrer
        }
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente); // Adiciona cliente à lista
        salvarClientes(); // Salva a lista atualizada no arquivo
    }

    public void removerCliente(Cliente cliente) {
        clientes.remove(cliente); // Remove cliente da lista
        salvarClientes(); // Salva a lista atualizada no arquivo
    }

    public Cliente getClientePorId(String id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null; // Retorna null se o cliente não for encontrado
    }
    
        public Cliente getClientePorNome(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(nome)) {
                return cliente;
            }
        }
        return null; // Retorna null se o cliente não for encontrado
    }

    public ArrayList<Cliente> getClientes() {
        return clientes; // Retorna a lista de clientes
    }
}