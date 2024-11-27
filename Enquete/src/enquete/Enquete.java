package enquete;

public class Enquete {
    private int[] nota;

    public Enquete() {
        nota = new int[10];
        for (int i = 0; i < 10; i++) {
        nota[i] = 0;
        }
    }

    public void resgistraNota(int num){
        nota[num-1]++;
    }

    public int frequenciaNota(int num){
        return nota[num-1];
    }


    public int numeroEntrevistados(){
        int total = 0;
        for( int i = 0; i < nota.length; i++){
            total += nota[i];
        }
        return total;
    }

    public double calcularMedia(){
        double media = 0;
        for( int i = 0; i < nota.length; i++){
            media += (i+1)*nota[i];
        }
        media /= this.numeroEntrevistados();
        return media;
    }

}
