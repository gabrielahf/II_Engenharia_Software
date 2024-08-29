
public class App {
    public static void main(String[] args) {
        LinkedListOfInteger lista = new LinkedListOfInteger();
        lista.add(2);
        lista.add(4);
        lista.add(6);
        lista.add(8);
        lista.add(10);
        lista.add(12);

        lista.add(0,0);
        lista.add(4,7);
        lista.add(lista.size(),14);



        System.out.println(lista);
        System.out.println("Elemento da posiçao 3: " + lista.get(3));

        lista.remove(2);
        lista.remove(12);
        lista.remove(6);
        System.out.println(lista);

        System.out.println("Elemento removido da posiçao 8: "+ lista.removeByIndex(8));
        System.out.println("Elemento removido da posiçao 0: "+ lista.removeByIndex(0));
        System.out.println("Elemento removido da posiçao 4: "+ lista.removeByIndex(4));

        System.out.println(lista);

        System.out.println("Elemento da posiçao 3: " + lista.contains(4)); //true
        System.out.println("Elemento da posiçao 3: " + lista.contains(1)); //false




    }
}
