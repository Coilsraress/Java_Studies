package visao;

import java.util.ArrayList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// definem o Layout (Separação em Bordas e Grades respectivamente)
import java.awt.BorderLayout;
import java.awt.GridLayout;

// Componentes necessários para a GUI
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import operacional.Calculadora;

public class DisplayCalc extends JFrame implements ActionListener{

    private final Calculadora calculadora;

    private JTextField visor;
    private JPanel teclado;

    private ArrayList<JButton> botoes;


    private void instanciarComponentes(){
        visor = new JTextField();
        teclado = new JPanel();
        botoes = new ArrayList<>();

        // primeira fileira;
        botoes.add(new JButton("C"));
        botoes.add(new JButton("7"));
        botoes.add(new JButton("8"));
        botoes.add(new JButton("9"));
        botoes.add(new JButton("/"));
        // segunda fileira;
        botoes.add(new JButton("CE"));
        botoes.add(new JButton("4"));
        botoes.add(new JButton("5"));
        botoes.add(new JButton("6"));
        botoes.add(new JButton("*"));
        // terceira fileira;
        botoes.add(new JButton("X^2"));
        botoes.add(new JButton("1"));
        botoes.add(new JButton("2"));
        botoes.add(new JButton("3"));
        botoes.add(new JButton("-"));
        // quarta fileira;
        botoes.add(new JButton("%"));
        botoes.add(new JButton("."));
        botoes.add(new JButton("0"));
        botoes.add(new JButton("="));
        botoes.add(new JButton("+"));

    }

    private void adicionarComponentes(){
        setLayout(new BorderLayout());
        add(visor, BorderLayout.NORTH);
        add(teclado, BorderLayout.SOUTH);
        teclado.setLayout(new GridLayout(4, 5));
        for(JButton b : botoes){
            teclado.add(b);
        }
    }

    private void registrarEvento(){
        for(JButton b : botoes)
            b.addActionListener(this);
    }

    public DisplayCalc(){
        instanciarComponentes();
        adicionarComponentes();
        registrarEvento();
        calculadora = new Calculadora();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String face = ((JButton) e.getSource()).getText();
        // função do C
        switch (face) {
            case "C" -> {
                String auxOp2;
                String auxOp;
                String auxOp1;
                if (!calculadora.getOperando2().isEmpty()) {
                    if (calculadora.getOperando2().length() == 1)
                        auxOp2 = "";
                    else
                        auxOp2 = calculadora.getOperando2().substring(0,
                                calculadora.getOperando2().length() - 1);
                    auxOp = calculadora.getOperacao();
                    auxOp1 = calculadora.getOperando1();
                    calculadora.setOperando1(auxOp1);
                    calculadora.setOperacao(auxOp);
                    calculadora.setOperando2(auxOp2);
                    calculadora.atualizaVisor();
                } else {
                    if (!calculadora.getOperacao().isEmpty()) {
                        auxOp1 = calculadora.getOperando1();
                        calculadora.setOperando1(auxOp1);
                        calculadora.setOperacao("");
                        calculadora.atualizaVisor();
                    } else {
                        if (!calculadora.getOperando1().isEmpty()) {
                            if (calculadora.getOperando1().length() == 1)
                                calculadora.condicaoInicial();
                            else {
                                auxOp1 = calculadora.getOperando1().substring(0,
                                        calculadora.getOperando1().length() - 1);
                                calculadora.setOperando1(auxOp1);
                                calculadora.atualizaVisor();
                            }
                        } else {
                            calculadora.condicaoInicial();
                        }
                    }
                }
            }
            // função da /
            case "/", "*", "+" -> {
                try{
                    if(!calculadora.getOperando1().isEmpty()){
                        if(calculadora.getOperando2().isEmpty()){
                            calculadora.setOperacao(face);
                        } else{
                            calculadora.buscarResultado();
                            calculadora.setOperacao(face);
                        }
                    } else
                        calculadora.condicaoInicial();
                    calculadora.atualizaVisor();
                } catch (ArithmeticException ex){
                    calculadora.operacaoIlegal();
                }
            }
            // função do CE
            case "CE" -> calculadora.condicaoInicial();

            // função do X^2
            case "X^2" -> {
                try{
                    if(!calculadora.getOperando1().isEmpty()){
                        if(calculadora.getOperando2().isEmpty()){
                            if(calculadora.getOperacao().isEmpty())
                                calculadora.calcularPotencia();
                        } else {
                            calculadora.buscarResultado();
                            calculadora.calcularPotencia();
                        }
                    } else
                        calculadora.condicaoInicial();
                    calculadora.atualizaVisor();
                } catch (ArithmeticException ex){
                    calculadora.condicaoInicial();
                    calculadora.operacaoIlegal();
                }
            }
            // função do -
            case "-" -> {
                if(!calculadora.getOperando1().isEmpty()){
                    if(!calculadora.getOperando1().equals("-")){
                        if(!calculadora.getOperacao().isEmpty()) {
                            if (!calculadora.getOperacao().equals("-")) {
                                if (!calculadora.getOperando2().isEmpty()) {
                                    calculadora.buscarResultado();
                                    calculadora.setOperacao("-");
                                } else
                                    calculadora.concatenaOperando2("-");
                            }
                        } else{
                            calculadora.setOperacao("-");
                            calculadora.atualizaVisor();
                        }
                    }
                } else{
                    calculadora.setOperando1("-");
                }
                calculadora.atualizaVisor();
            }
            // função do %
            case "%" -> {
                try{
                    if(!calculadora.getOperando1().isEmpty()){
                        if(calculadora.getOperando2().isEmpty()){
                            if(calculadora.getOperacao().isEmpty())
                                calculadora.calcularPorcentagem();
                        } else {
                            calculadora.buscarResultado();
                            calculadora.calcularPorcentagem();
                        }
                    } else
                        calculadora.condicaoInicial();
                    calculadora.atualizaVisor();
                } catch (ArithmeticException ex){
                    calculadora.condicaoInicial();
                    calculadora.operacaoIlegal();
                }
            }
            // função do ponto
            case "." -> {
                if (calculadora.getOperacao().isEmpty()) {
                    if (!calculadora.jaTemPontoOperando1()) {
                        if (calculadora.getOperando1().isEmpty())
                            calculadora.concatenaOperando1("0");
                        calculadora.concatenaOperando1(face);
                    }
                } else {
                    if (!calculadora.jaTemPontoOperando2()){
                        if(calculadora.getOperando2().isEmpty())
                            calculadora.concatenaOperando2("0");
                        calculadora.concatenaOperando2(face);
                    }
                }
                calculadora.atualizaVisor();
            }
            // função do +
            case "=" -> {
                try {
                    if(!calculadora.getOperando2().isEmpty())
                        calculadora.buscarResultado();
                    else
                        calculadora.setOperacao("");
                    calculadora.atualizaVisor();
                } catch (ArithmeticException ex){
                    calculadora.operacaoIlegal();
                }
            }
            // função dos números
            case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" -> {
                if (calculadora.getOperacao().isEmpty()) {
                    if(isNumeric(calculadora.getOperando1())){
                        if(!calculadora.getOperando1().isEmpty()) {
                            if (Double.parseDouble(calculadora.getOperando1()) == 0 &&
                                    !calculadora.jaTemPontoOperando1())
                                calculadora.setOperando1(face);
                            else
                                calculadora.concatenaOperando1(face);
                        }
                        else
                            calculadora.concatenaOperando1(face);
                    } else{
                        calculadora.concatenaOperando1(face);
                    }
                }
                else {
                    if(!calculadora.getOperando2().isEmpty()) {
                        if(isNumeric(calculadora.getOperando2())){
                            if (Double.parseDouble(calculadora.getOperando2()) == 0 &&
                                    !calculadora.jaTemPontoOperando2())
                                calculadora.setOperando2(face);
                            else
                                calculadora.concatenaOperando2(face);
                        } else
                            calculadora.concatenaOperando2(face);
                    }
                    else
                        calculadora.concatenaOperando2(face);
                }
                calculadora.atualizaVisor();
            }
            default -> calculadora.operacaoIlegal();
        }
        visor.setText(calculadora.getVisor());
    }
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
