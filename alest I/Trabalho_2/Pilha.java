import java.util.EmptyStackException;

public class Pilha {

    // Atributos
    private int count;
    private Node topo;

    private class Node {
        public double element;
        public Node next;

        public Node(double elem) {
            element = elem;
            next = null;
        }
    }

    // Metodos
    public Pilha() {
        topo = null;
        count = 0;
    }

    // insere o elemento e no topo da pilha
    public void push(double element) {
        Node n = new Node(element);
        if (isEmpty())
            topo = n;
        else {
            n.next = topo;
            topo = n;
        }
        count++;
    }

    // Remove e retorna o elemento do topo da pilha
    public double pop() {
        if(isEmpty()) { // se pilha vazia
            throw new EmptyStackException();
        }
        double elemRemovido = topo.element;
        topo = topo.next;
        count--;
        return elemRemovido;
    }

    // Retorna, mas não remove, o elemento do topo da pilha
    public double top() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return topo.element;
    }


    // Retorna o numero de elementos da pilha.
    public int size() {
        return count;
    }

    // Esvazia a pilha
    public void clear() {
        topo = null;
        count = 0;
    }

    // Retorna true se a pilha estiver vazia, e false caso contrário
    public boolean isEmpty() {
        return count == 0;
    }

    

}
