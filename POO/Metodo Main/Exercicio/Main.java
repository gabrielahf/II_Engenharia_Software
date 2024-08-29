import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        System.out.print("DIVIDENDO:");
        int d = leitor.nextInt();

        System.out.print("DIVISOR:");
        int div = leitor.nextInt();

        System.out.print("PRECISAO:");
        int p = leitor.nextInt();

        Matematica resp = new Matematica();

        String resultado = Matematica.realizarDivisao(d,div,p);
        
        
        if (resultado != null) {
            System.out.println("RESULTADO: " + resultado);
        } else {
            System.out.println("NÃO FOI POSSÍVEL REALIZAR A DIVISÃO");
        }
    }
}


