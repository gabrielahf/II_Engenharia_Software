package genericos.pares;

import java.util.ArrayList;

public class AppPares {

    public static void main(String[] args) {
        // Cria pares de tipos diferentes
        Par<String, Double> pa1 = new Par<>("Fulano",8.9); //(nome e nota de um aluno)
        Par<Integer,String> pa2 = new Par<>(1234, "Ciclano"); //(codigo e nome de um funcionario)
        Par<Float,Float> pa3 = new Par<>(7.0f,8.6f); //(coordenadas x e y)
        System.out.println(pa1);
        System.out.println(pa2);
        System.out.println("Ponto(" + pa3.getFirst() + "," + pa3.getSecond() + ")");
        
        // Cria uma lista de pares de numeros inteiros
        ArrayList<Par<Integer,Integer>> lista = new ArrayList<>();
        lista.add(new Par<>(1,1));
        lista.add(new Par<>(22,22));
        lista.add(new Par<>(333,333));
        lista.add(new Par<>(4444,4444));
        System.out.println(lista);
        
    }
}
