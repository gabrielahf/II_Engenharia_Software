public class Soma {

    public static int somaArray(int vetor[]){
        return somaArray(vetor, 0);
    }

    public static int somaArray(int vetor[], int i){
        if (i == vetor.length - 1){
            return vetor[i];
        } else{
            return vetor[i] + somaArray(vetor, i + 1);
        }
    }

    public static void main(String[]args){
        int vetor[] = {1, 2, 3, 4, 5, 6};
        System.out.println("Soma vetor = " + Soma.somaArray(vetor));
    }
}
