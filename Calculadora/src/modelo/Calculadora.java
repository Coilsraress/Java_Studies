package modelo;

public class Calculadora {
    private String visor;
    private String operando1;
    private String operando2;
    private String resultado;
    private String operacao;


    public Calculadora(){
        visor="";
        operando1="";
        operando2="";
        resultado="";
        operacao="";
    }
    public void concatenarOperando1(String valor){
        operando1 = operando1 + valor;
        visor = operando1;
    }
    public void concatenarOperando2(String valor){
        operando2 = operando2 + valor;
        visor = operando1 + operacao + operando2;
    }

    public void definirOperacao(String valor) {
        operacao = valor;
        visor = operando1 + operacao;
    }

    public void exibirResultado(){
        double op1 = Double.parseDouble(operando1);
        double op2 = Double.parseDouble(operando2);
        switch (operacao){
            case "/":
                if (op2 == 0) {
                    resultado = "Erro: Divisão por zero";
                } else {
                    resultado = String.valueOf(op1 / op2);
                }
                visor = resultado;
                break;
            case "*":
                resultado = String.valueOf(op1*op2);
                visor = resultado;
                break;
            case "+":
                resultado = String.valueOf(op1+op2);
                visor = resultado;
                break;
            case "-":
                resultado = String.valueOf(op1-op2);
                visor = resultado;
                break;
            case "^":
                resultado = String.valueOf(Math.pow(op1, op2));
                visor = resultado;
                break;
            case "%":
                resultado = String.valueOf(op1/100 * op2);
                visor = resultado;
                break;

        }

    }
    public String getVisor() {
        return visor;
    }

    public void setVisor(String visor) {
        this.visor = visor;
    }

    public String getOperando1() {
        return operando1;
    }

    public void setOperando1(String operando1) {
        this.operando1 = operando1;
    }

    public String getOperando2() {
        return operando2;
    }

    public void setOperando2(String operando2) {
        this.operando2 = operando2;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }
}

