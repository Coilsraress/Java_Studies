/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package principal;

import java.text.DecimalFormat;
import java.util.Random;

public class JogoFatos {

    private String operando1;
    private String operando2;
    private String operacao;
    private double resultado;

    private Random gerador;
    
    
    public JogoFatos() {
        this.operando1 = "";
        this.operando2 = "";
        this.operacao = "";
        this.resultado = 0;
        gerador = new Random();
    }
    
    public String getOperando1(){
        return operando1;
    }
    public String getOperando2(){
        return operando2;
    }
    public String getOperacao(){
        return operacao;
    }
    public String sorteiaOperando1() {
        return null;
    }

    public boolean verificaResultado(String valor) {
        double palpite = Double.valueOf(valor);
        double op1 = Double.valueOf(operando1);
        double op2 = Double.valueOf(operando2);
        double resultado = 0;
            switch (operacao) {
            case "+":
                resultado = op1 + op2;
                break;
            case "-":
                resultado = op1 - op2;
                break;
            case "*":
                resultado = op1 * op2;
                break;
            case "/":
                resultado = op1 / op2;
                break;
        }
        DecimalFormat df = new DecimalFormat("#0.00");
        String resultadoFormatado = df.format(resultado);
        String palpiteFormatado = df.format(palpite);
        
        return resultadoFormatado.equals(palpiteFormatado);
    }

    public void sortearNovaOperacao() {
        double op1 = gerador.nextInt(100);
        double op2 = gerador.nextInt(100) + 1;
        int opera = gerador.nextInt(4);
        operando1 = op1 + "";
        operando2 = op2 + "";
        switch (opera) {
            case 0:
                operacao = "+";
                break;
            case 1:
                operacao = "-";
                break;
            case 2:
                operacao = "*";
                break;
            case 3:
                operacao = "/";
                break;
        }

    }

}
