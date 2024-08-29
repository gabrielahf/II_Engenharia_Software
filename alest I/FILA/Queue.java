
public class Queue {

    // Atributos
    private DoubleLinkedListOfInteger fila; //estrutura duplamente encadeada se aplica na fila

    public Queue() {
        fila = new DoubleLinkedListOfInteger();
    }

    // insere o elemento e no final da fila
    public void enqueue(Integer element) {
        fila.add(element);
    }

// remove e retorna o elemento e do início da fila, 
// e dá erro se a fila estiver vazia
    public Integer dequeue() {
        if (fila.isEmpty()) {
            throw new RuntimeException("A fila esta vazia!"); // erro
        }
        return fila.removeByIndex(0);
    }

    // retorna, mas não remove, o primeiro elemento da fila, 
    // e dá erro se a fila estiver vazia
    public Integer head() {
        if (fila.isEmpty()) {
            throw new RuntimeException("A fila esta vazia!"); // erro
        }
        return fila.get(0);
    }

    // retorna o número de elementos da fila
    public int size() {
        return fila.size();
    }

    //retorna true se a fila estiver vazia, e false caso contrário
    public boolean isEmpty() {
        return fila.isEmpty();
    }

    //esvazia a fila
    public void clear() {
        fila.clear();
    }

}
