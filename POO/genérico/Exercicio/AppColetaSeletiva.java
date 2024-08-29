package genericos.Exercicio;


import java.util.ArrayList;
import java.util.Collections;

public class AppColetaSeletiva {

    public static void main(String[] args) {
        ArrayList<Coleta> coletas = new ArrayList<Coleta>();


        Collections.sort(coletas,new ColetaComparaCodLogradouro());


        imprime(coletas);

    }

    public static void imprime(ArrayList<Coleta> coletas) {
        for(Coleta c : coletas) {
            System.out.println("Coleta: " + c);
        }
    }

}
