package genericos.produtosG2;

import genericos.produtosG.Codigo;

import java.util.ArrayList;

public class AppProdutoG2P {
    public static void main(String[] args) {
        ProdutoG2P<Integer, Float> p1 = new ProdutoG2P<>(112, "Pera", 10F);     // Float
        ProdutoG2P<String, Integer> p2 = new ProdutoG2P<>("AB", "Uva", 0x10);   // Hexadecimal
        System.out.println("P1");
        System.out.println(p1);
        System.out.println("P2");
        System.out.println(p2);

        ProdutoG2P<Codigo, Valor> p3 =
                new ProdutoG2P<>(new Codigo("ELET",1), "TV", new Valor("R$", 2987,55));
        ProdutoG2P<Codigo, Valor> p4 =
                new ProdutoG2P<>(new Codigo("ELET",2), "Blue Ray", new Valor("US$",010,00));  // Octal
        ProdutoG2P<Codigo, Valor> p5 =
                new ProdutoG2P<>(new Codigo("ALIM",1), "Banana", new Valor("EU$","1","0"));
        
        System.out.println("P3");
        System.out.println(p3);
        
        System.out.println("P4");
        System.out.println(p4);   
        
        System.out.println("P5");
        System.out.println(p5);          
    }
}
