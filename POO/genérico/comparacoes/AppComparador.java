package genericos.Exercicio;

import java.util.ArrayList;
import java.util.Collections;

public class AppColetaSeletiva {

    public static void main(String[] args) {
        ArrayList<Coleta> coletas = new ArrayList<Coleta>();
        //coletas.add(new Coleta("Brasil"   ,8515767));
        //coletas.add(new Coleta("Argentina",2780400));
        //coletas.add(new Coleta("Chile"    , 756950));
        //System.out.println("Paises conforme ordem de insercao: ");
        imprime(coletas);
        Collections.sort(coletas,new ColetaComparaCodLogradouro());
        //System.out.println("Coleta conforme ordem de cod_logradouro: ");
        imprime(coletas);

    }

    public static void imprime(ArrayList<Coleta> coletas) {
        for(Coleta c : coletas) {
            System.out.println("Coleta: " + c);
        }
    }

}
