// src/main/java/com/mycompany/trabalhofinal/sevices/ManipulaClientes.java
package com.mycompany.trabalhofinal.sevices;

import com.mycompany.trabalhofinal.modelo.Cliente;

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
                String[] partes = linha.split(", ");
                String nome = partes[0].split(": ")[1];
                String id = partes[1].split(": ")[1];
                Cliente cliente = new Cliente(nome, id);
                clientes.add(cliente); // Adiciona o cliente à lista
            }
        } catch (IOException e) {
            e.printStackTrace(); // Exibe erro se ocorrer
        }
    }

    public void salvarClientes() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("clientes.txt"))) {
            for (Cliente cliente : clientes) {
                String linha = "Nome: " + cliente.getNome() + ", ID: " + cliente.getId();
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