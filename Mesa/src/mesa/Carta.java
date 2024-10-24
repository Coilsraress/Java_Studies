package mesa;

public class Carta {
    private String naipe;
    private int numero;
    public Carta() {
        naipe="";
        numero=0;
    }
    public Carta(String naipe, int numero) {
        this.naipe = naipe;
        this.numero = numero;
    }
    public String getNaipe() {
        return naipe;
    }
    public void setNaipe(String naipe) {
        this.naipe = naipe;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public int ehMaior(Carta carta){
        if(this.numero>carta.getNumero()){
            return 1;
        } else {
            if (this.numero < carta.getNumero()) {
                return -1;
            }
        }
        return 0;
    }


}
