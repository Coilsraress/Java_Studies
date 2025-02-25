package visao;

import modelo.Calculadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppCalc extends JFrame implements ActionListener {
    private JTextField visor;
    private JPanel teclado;

    private JButton bC, b7, b8, b9, bdiv, bCE, b4, b5, b6, bmul, bsqr, b1, b2, b3, bminus, bpercet, bdot, b0, bequals, bplus;
    Calculadora calculadora;
    public AppCalc(){
        instanciarComponentes();
        adicionarComponentes();
        registrarHandlerEventos();
        calculadora = new Calculadora();
    }

    private JButton criarBotao(String texto, Color corFundo) {
        JButton botao = new JButton(texto);
        botao.setFont(new Font("Arial", Font.PLAIN, 20)); // Fonte padrão
        botao.setBackground(corFundo); // Cor de fundo
        botao.setForeground(Color.WHITE); // Cor do texto
        botao.setFocusPainted(false); // Remove o foco visual
        botao.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); // Borda simples

        // Adiciona efeito de hover
        botao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botao.setBackground(corFundo.darker()); // Escurece a cor no hover
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                botao.setBackground(corFundo); // Volta para a cor original
            }
        });

        return botao;
    }

    private void instanciarComponentes(){
        visor = new JTextField();
        teclado = new JPanel();
        visor.setHorizontalAlignment(JTextField.RIGHT);
        visor.setFont(new Font("Arial", Font.BOLD, 24));

        visor.setBackground(Color.WHITE);
        visor.setForeground(Color.black);

        teclado = new JPanel();


        bC = criarBotao("C", Color.RED);
        bCE = criarBotao("CE", Color.RED);
        bequals = criarBotao("=", Color.ORANGE);


        bdiv = criarBotao("/", Color.BLUE);
        bmul = criarBotao("*", Color.BLUE);
        bsqr = criarBotao("x^", Color.BLUE);
        bminus = criarBotao("-", Color.BLUE);
        bpercet = criarBotao("%", Color.BLUE);
        bplus = criarBotao("+", Color.BLUE);


        b7 = criarBotao("7", Color.DARK_GRAY);
        b8 = criarBotao("8", Color.DARK_GRAY);
        b9 = criarBotao("9", Color.DARK_GRAY);
        b4 = criarBotao("4", Color.DARK_GRAY);
        b5 = criarBotao("5", Color.DARK_GRAY);
        b6 = criarBotao("6", Color.DARK_GRAY);
        b1 = criarBotao("1", Color.DARK_GRAY);
        b2 = criarBotao("2", Color.DARK_GRAY);
        b3 = criarBotao("3", Color.DARK_GRAY);
        b0 = criarBotao("0", Color.DARK_GRAY);
        bdot = criarBotao(".", Color.DARK_GRAY);


    }

    private void adicionarComponentes(){
        setLayout(new BorderLayout());
        add(visor, BorderLayout.NORTH);
        add(teclado, BorderLayout.SOUTH);

        teclado.setLayout(new GridLayout(4,5));
        teclado.add(bCE);
        teclado.add(b7);
        teclado.add(b8);
        teclado.add(b9);
        teclado.add(bdiv);
        teclado.add(bC);
        teclado.add(b4);
        teclado.add(b5);
        teclado.add(b6);
        teclado.add(bmul);
        teclado.add(bsqr);
        teclado.add(b1);
        teclado.add(b2);
        teclado.add(b3);
        teclado.add(bminus);
        teclado.add(bpercet);
        teclado.add(bdot);
        teclado.add(b0);
        teclado.add(bequals);
        teclado.add(bplus);

    }

    private void registrarHandlerEventos(){
        bC.addActionListener(this);
        bCE.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        bdiv.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        bmul.addActionListener(this);
        bsqr.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        bminus.addActionListener(this);
        bpercet.addActionListener(this);
        bdot.addActionListener(this);
        b0.addActionListener(this);
        bequals.addActionListener(this);
        bplus.addActionListener(this);
    }

    public static void main(String[] args) {
        AppCalc janela = new AppCalc();
        janela.setSize(400,500);
        janela.setVisible(true);
        janela.setTitle("Calculadora");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);



    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String face = ((JButton) ae.getSource()).getText();


        if (face.equals("=")) {
        calculadora.exibirResultado();
        visor.setText(calculadora.getVisor());
            String resultado = calculadora.getVisor();
            calculadora.setOperando1(resultado);
            calculadora.setOperando2("");
            calculadora.setOperacao("");
            visor.setText(resultado);
        } else if (face.equals("CE")) {
            visor.setText("");
            calculadora.setOperando1("");
            calculadora.setOperacao("");
            calculadora.setOperando2("");
        } else if (face.equals("C")) {
            String nova = visor.getText().substring(0, visor.getText().length() - 1);
            if (calculadora.getOperacao().isEmpty()) {
                calculadora.setOperando1(nova);
            } else {
                if (calculadora.getOperando2().isEmpty()){
                    calculadora.setOperacao("");
                }
                else {
                    calculadora.setOperando2(nova.substring(nova.indexOf(calculadora.getOperacao()) + 1));
                }
            }
            calculadora.setVisor(nova);
            visor.setText(nova);
        }else {
            if (face.equals("/") || face.equals("x^") || face.equals("*") || face.equals("-") || face.equals("%") || face.equals("+")) {
                if(face.equals("x^")){
                    face = "^";
                }
                calculadora.definirOperacao(face);
            } else if (face.equals(".")) {
                if (calculadora.getOperacao().isEmpty() && !calculadora.getOperando1().contains(".")) {
                    calculadora.concatenarOperando1(face);
                } else if (!calculadora.getOperacao().isEmpty() && !calculadora.getOperando2().contains(".")) {
                    calculadora.concatenarOperando2(face);
                }
            } else {
                if (calculadora.getOperacao().equals("")) {
                    calculadora.concatenarOperando1(face);
                } else {
                    calculadora.concatenarOperando2(face);
                }
            }
            visor.setText(calculadora.getVisor());
        }
    }
}