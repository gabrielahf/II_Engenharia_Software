
import java.util.EmptyStackException;


public class StackLinked {
    private class Node {
        public Integer element;
        public Node next;
        public Node(Integer elem) {
            element = elem;
            next = null;
        }
    }

    // Atributos
    private int count;
    private Node topo; // referencia para o topo da pilha

    // Metodos
    public StackLinked() {
        topo = null;
        count = 0;
    }
    // insere o elemento e no topo da pilha
    public void push(Integer element) {
        Node n = new Node(element);
        if (isEmpty()) // se pilha vazia
            topo = n;
        else {
            n.next = topo;
            topo = n;
        }
        count++;
    }

    // Remove e retorna o elemento do topo da pilha 
    // (erro se a pilha estiver vazia)
    public Integer pop() {
        if(isEmpty()) { // se pilha vazia
            throw new EmptyStackException();
        }
        // Retorna o elemento do topo da pilha
        Integer elemRemovido = topo.element;
        topo = topo.next;
        count--;
        return elemRemovido;
    }

    // Retorna, mas não remove, o elemento do topo da pilha 
    // (erro se a pilha estiver vazia)
    public Integer top() {
        if(isEmpty()) { // se pilha vazia
            throw new EmptyStackException();
        }
        return topo.element;
    }

    // Retorna o numero de elementos da pilha.
    public int size() {
        return count;
    }

    // Retorna true se a pilha estiver vazia, e false caso contrário
    public boolean isEmpty() {
        return count == 0;
    }

    // Esvazia a pilha
    public void clear() {
        topo = null;
        count = 0;
    }

}