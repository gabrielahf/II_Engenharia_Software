import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Exercicio4 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        try {
            int x = s.nextInt();
            List<Integer> a = new ArrayList<>(x);

            int y = s.nextInt();
            a.set(y, x);
            System.out.println(x / y);

        }catch(InputMismatchException e){
            System.out.println("Erro de tipo invalido.");
        }catch(ArithmeticException e){
        System.out.println("Erro de divisao por zero.");
    }catch(IndexOutOfBoundsException e){
            System.out.println("Erro de indice invalido.");

        }finally{
            s.close();
        }
    }

}
