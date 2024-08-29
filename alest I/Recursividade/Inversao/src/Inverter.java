public class Inverter {

    public static void inverterArray(int vetor[]){
        inverterArray(vetor, 0, vetor.length - 1);
    }

    public static void inverterArray(int vetor[], int init, int fin){
        if(init < fin){
            int aux = vetor[init];
            vetor[init] = vetor[fin];
            vetor[fin] = aux;
            inverterArray(vetor, init + 1, fin - 1);
        }
    }

    public static void main(String[]args){
        int vetor[] = {1, 2, 3, 4, 5, 6};
        Inverter.inverterArray(vetor);

        for (int i= 0; i < vetor.length; i++){
            System.out.println("vetor[" + i +"] = " + vetor[i]);
        }

    }
}
