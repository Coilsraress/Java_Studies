package app;

import visao.DisplayCalc;
import javax.swing.JFrame;

public class AppCalc {
    public static void main(String[] args) {
        DisplayCalc calculadora = new DisplayCalc();
        calculadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculadora.setSize(400,400);
        calculadora.setVisible(true);
        calculadora.setTitle("Calculadora");
    }
}
