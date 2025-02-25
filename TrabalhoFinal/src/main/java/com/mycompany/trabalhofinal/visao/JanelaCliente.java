package com.mycompany.trabalhofinal.visao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaCliente extends JDialog {
    private JTextField txtNome;
    private JTextField txtId;
    private boolean confirmado = false;
    private String nomeCliente;
    private String idCliente;

    public JanelaCliente(JFrame parent) {
        super(parent, "Dodos de Cliente", true);
        setSize(300, 200);
        setLayout(new GridLayout(3, 2, 5, 5));

        JLabel lblNome = new JLabel("Nome:");
        txtNome = new JTextField();
        JLabel lblId = new JLabel("ID:");
        txtId = new JTextField();

        JButton btnSalvar = new JButton("Salvar");
        JButton btnCancelar = new JButton("Cancelar");

        add(lblNome);
        add(txtNome);
        add(lblId);
        add(txtId);
        add(btnSalvar);
        add(btnCancelar);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nomeCliente = txtNome.getText();
                idCliente = txtId.getText();
                confirmado = true;
                dispose();
            }
        });

        btnCancelar.addActionListener(e -> dispose());

        setLocationRelativeTo(parent);
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getIdCliente() {
        return idCliente;
    }
}
