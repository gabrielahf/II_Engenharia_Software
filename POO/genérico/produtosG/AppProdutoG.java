package genericos.produtosG;

import java.util.ArrayList;

public class AppProdutoG {
    public static void main(String[] args) {

        // Cria lista com produtos com codigo String
        ArrayList<ProdutoG<String>> lista1 = new ArrayList<>();
        lista1.add(new ProdutoG<>("AA1", "Radio", 138.00));
        lista1.add(new ProdutoG<>("BB2", "BD", 438.00));
        lista1.add(new ProdutoG<>("CC3", "PS Lego Batman", 119.99));
        ProdutoG<String> ps1 = new ProdutoG<>("DD4", "XBOX Lego Batman", 121.99);
        ProdutoG<String> ps2 = new ProdutoG<>("EE5", "XBOX PES 2020", 151.90);
        lista1.add(ps1);
        lista1.add(ps2);
        System.out.println("Produtos com codigo String");
        for(ProdutoG p : lista1)
            System.out.println(p);

        // Cria lista com produtos com codigo de campos (atributos) especificados
        ArrayList<ProdutoG<Codigo>> lista2 = new ArrayList<>();
        lista2.add(new ProdutoG<>(new Codigo("Auto",11), "Ferrari Sergio Pininfarina", 11300000.00));
        lista2.add(new ProdutoG<>(new Codigo("Auto",22), "Bugatti Chiron Sport", 12300000.00));
        lista2.add(new ProdutoG<>(new Codigo("Auto",33), "Lamborghini Veneno", 17000000.00));
        ProdutoG<Codigo> p1 = new ProdutoG<>(new Codigo("Auto",44), "Mercedes-Maybach Exelero", 30200000.00);
        ProdutoG<Codigo> p2 = new ProdutoG<>(new Codigo("Auto",55), "Bugatti La Voiture Noire", 70000000.00);
        lista2.add(p1);
        lista2.add(p2);
        System.out.println();
        System.out.println("Produtos com codigo (objetos Codigo)");
        for(ProdutoG p : lista2)
            System.out.println(p);


        // Cria lista com produtos com codigo de campos (atributos) genericos
        ArrayList<ProdutoG<CodigoG<String,Integer>>> lista3 = new ArrayList<>();
        lista3.add(new ProdutoG<>(new CodigoG<>("ALIM",1), "Feijão", 4.00));
        lista3.add(new ProdutoG<>(new CodigoG<>("ALIM",2), "Arroz", 2.00));
        lista3.add(new ProdutoG<>(new CodigoG<>("ALIM",3), "Farinha", 1.89));
        ProdutoG<CodigoG<String,Integer>> pg1 = new ProdutoG<>(new CodigoG<>("ALIM",4), "Açúcar", 1.50);
        ProdutoG<CodigoG<String,Integer>> pg2 = new ProdutoG<>(new CodigoG<>("ALIM",5), "Massa", 3.38);
        lista3.add(pg1);
        lista3.add(pg2);
        System.out.println();
        System.out.println("Produtos com codigo (objetos CodigoG)");
        for(ProdutoG p : lista3)
            System.out.println(p);        
        
    }

}
