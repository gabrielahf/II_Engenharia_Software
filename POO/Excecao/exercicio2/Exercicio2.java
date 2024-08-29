package exercicio2;

import java.util.*;

public class Exercicio2 {

    public static void main(String args[]) {
        int a,b,c;
        double d;
        double e[];
        e = new double[10];

        Scanner sc = new Scanner(System.in);

        try {
        
        System.out.print("Valor de a: ");
        a = sc.nextInt();   // Possibilidade de excecao de tipo invalido
        System.out.print("Valor de b: ");
        b = sc.nextInt();   // Possibilidade de excecao de tipo invalido
        c = a / b;          // Possibilidade de excecao de divisao por zero
        d = e[a];           // Possibilidade de excecao de indice invalido
        System.out.println("Valor de a/b: " + c);
        System.out.println("Valor no vetor: " + d);     
        }
        catch(InputMismatchException e1) { // a, b
            System.out.println("Erro: tipo invalido!");
            System.out.println("Mensagem da excecao: " + e1.getMessage());
        }
        catch(ArithmeticException e2) { // c
            System.out.println("Erro: Divisao por zero!");
            System.out.println("Mensagem da excecao: " + e2.getMessage());
        }
        catch(ArrayIndexOutOfBoundsException e3) { // d
            System.out.println("Erro: Indice invalido!");
            System.out.println("Mensagem da excecao: " + e3.getMessage());
        }
        catch(Exception e4) {
            System.out.println("Excecao: " + e4.getMessage());
        }
    }

}


/*
OUTRA OPÇÃO DE RESOLUÇÃO

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercicio2 {

    public static void main(String args[]) {
        int a=0,b=1,c=2;
        double d;
        double e[];

        e = new double[10];

        Scanner sc = new Scanner(System.in);
        boolean ok = false;
        while(!ok) {
            try {
                System.out.print("Valor de a: ");
                a = sc.nextInt();
                ok = true;
            } catch (InputMismatchException e1) {
                System.out.println("Valor invalido. Redigite!");
                sc.nextLine();
            }
        }

        try {
            System.out.print("Valor de b: ");
            b = sc.nextInt();
            c = a / b;
        }

        catch(ArithmeticException e2) {
            System.out.println("Divisao por zero!");
        }
        d = e[a];
        System.out.println("Valor de a/b: " + c);
        System.out.println("Valor no vetor: " + d);
    }

}
 */
