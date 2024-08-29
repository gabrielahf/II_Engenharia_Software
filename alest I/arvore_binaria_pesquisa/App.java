
public class App {
    public static void main(String[] args) {
        BinarySearchTreeOfInteger b = new BinarySearchTreeOfInteger();
        b.add(15);
        b.add(23);
        b.add(9);
        b.add(11);
        b.add(2);
        b.add(20);
        b.add(38);
        b.GeraDOT();
        
        System.out.println(b.positionsCentral());
        System.out.println("Contem 9? " + b.contains(9));
        System.out.println("Contem 38? " + b.contains(38));
        System.out.println("Contem 99? " + b.contains(99));
        System.out.println("Contem 8? " + b.contains(8));
     }
   
}
