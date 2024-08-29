

public class App {
    public static void main(String[] args) {
        ListArrayOfInteger lista = new ListArrayOfInteger();
        lista.add(2);
        lista.add(4);
        lista.add(6);
        lista.add(8);

        System.out.println(lista);

        System.out.println("Adicionar em primeiro: ");
       lista.addFirst(7);
        System.out.println(lista);

        System.out.println("Remover o primeiro: ");
        lista.removeFirst(7);
        System.out.println(lista);

        System.out.println("Elemento trocado: " + lista.set(1,3));
        System.out.println(lista);

        lista.add(0,0);
        lista.add(3,5);
        System.out.println(lista);

        System.out.println("Lista contains 6? " + lista.contains(6));
        System.out.println("Lista contains 66? " + lista.contains(66));
        System.out.println("indexOf 2? " + lista.indexOf(2));
        System.out.println("indexOf 8? " + lista.indexOf(8));
        System.out.println("indexOf 22? " + lista.indexOf(22));

        System.out.println("Removeu o numero " + lista.removeByIndex(2));
        System.out.println(lista);

        Integer a[] = lista.subList(1,3);
        for(Integer i : a){
            System.out.println(i);
        }




    }
}
