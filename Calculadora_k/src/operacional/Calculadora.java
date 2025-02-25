package operacional;

import javax.swing.JOptionPane;
import java.math.BigDecimal;

public class Calculadora {
    private String visor;
    private String operando1;
    private String operando2;
    private String operacao;

    public Calculadora(){
        visor = "";
        operando1 = "";
        operando2 = "";
        operacao = "";
    }

    public void atualizaVisor(){
        visor = operando1 + operacao + operando2;
    }

    public void concatenaOperando1(String face){
        operando1 += face;
    }

    public void concatenaOperando2(String face){
        operando2 += face;
    }

    public void buscarResultado() throws ArithmeticException {
        BigDecimal valor1 = new BigDecimal(operando1);
        BigDecimal valor2 = new BigDecimal(operando2);
        BigDecimal resultadoBig;

        switch (operacao) {
            case "/" -> {
                if (valor2.compareTo(BigDecimal.ZERO) == 0) {
                    throw new ArithmeticException();
                } else {
                    resultadoBig = valor1.divide(valor2);
                }
            }
            case "*" -> {
                resultadoBig = valor1.multiply(valor2);
                if(resultadoBig.equals(new BigDecimal(69))){
                    JOptionPane.showMessageDialog(null,
                            "hummm safadinho...");
                }
            }
            case "-" -> resultadoBig = valor1.subtract(valor2);
            case "+" -> resultadoBig = valor1.add(valor2);
            default -> throw new IllegalStateException("Operação inválida: " + operacao);
        }
        operando1 = formatarResultado(resultadoBig);
        operacao = "";
        operando2 = "";
    }

    public void calcularPotencia() {
        BigDecimal valor = new BigDecimal(operando1);
        BigDecimal resultadoBig = valor.multiply(valor);
        operando1 = formatarResultado(resultadoBig);
        operacao = "";
        operando2 = "";
    }

    public void calcularPorcentagem(){
        BigDecimal valor = new BigDecimal(operando1);
        BigDecimal resultadoBig = valor.divide(new BigDecimal(100));
        operando1 = formatarResultado(resultadoBig);
        operacao = "";
        operando2 = "";
    }

    public void operacaoIlegal(){
        operando1 = "";
        operando2 = "";
        operacao = "";
        visor = "Err";
    }

    public void condicaoInicial(){
        operando1 = "0";
        operando2 = "";
        operacao = "";
        visor = "0";
    }

    public boolean jaTemPontoOperando1(){
        return operando1.contains(".");
    }
    public boolean jaTemPontoOperando2(){
        return operando2.contains(".");
    }

    private String formatarResultado(BigDecimal resultado) {
        resultado = resultado.setScale(10, BigDecimal.ROUND_DOWN); // Limita a 5 casas decimais
        if (resultado.stripTrailingZeros().scale() <= 0) {
            // Remove o ponto decimal se o número for inteiro
            return resultado.stripTrailingZeros().toPlainString();
        } else {
            // Exibe o número com até 5 casas decimais
            return resultado.stripTrailingZeros().toPlainString();
        }
    }

    // sets

    public void setOperando1(String operando1) {
        this.operando1 = operando1;
    }

    public void setOperando2(String operando2) {
        this.operando2 = operando2;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    // gets
    public String getVisor() {
        return visor;
    }

    public String getOperando1() {
        return operando1;
    }

    public String getOperando2() {
        return operando2;
    }

    public String getOperacao() {
        return operacao;
    }
}
