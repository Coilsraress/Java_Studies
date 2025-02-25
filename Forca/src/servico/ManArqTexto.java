package servico;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManArqTexto {

    private Scanner leitor;

    public ManArqTexto() {
        try {
            leitor = new Scanner(new File("palavras.txt"));
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo nao encontrado");
        }
    }

    public ArrayList<String> lerPalavras() {
        ArrayList<String> palavras = new ArrayList<>();
        String[] linha = leitor.nextLine().split(" ");

        for (String palavra : linha) {
            palavras.add(palavra);
        }
        leitor.close();
        return palavras;
    }

}
