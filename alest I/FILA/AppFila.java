
public class AppFila {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);

        Queue cloneDaFila = q.clone();
        System.out.println("Clone da fila:");
        while(!cloneDaFila.isEmpty()) {
            System.out.println(cloneDaFila.dequeue());
        }

        DoubleLinkedListOfInteger lista = new DoubleLinkedListOfInteger();
        lista.add(1); lista.add(2); lista.add(3);
        copiaParaLista(lista,q);
        System.out.println("Conteudo da lista: \n"+lista);

        System.out.println("Primeiro elemento da fila: " + q.head());
        System.out.println("Total de elementos da fila: " + q.size());

        System.out.println("Elementos da fila: ");
        while(!q.isEmpty())
            System.out.println(q.dequeue());

        System.out.println("Total de elementos da fila: " + q.size());

    }

    /**
     * Apresentar o algoritmo de um método que recebe uma lista 
     * e uma fila de inteiros por parâmetro. Este método deve 
     * copiar o conteúdo da fila no final da lista, mas no final 
     * a fila deve estar com o seu conteúdo original, isto é, 
     * ela não deve ser alterada.
     */
    public static void copiaParaLista(DoubleLinkedListOfInteger lista, Queue fila) {
        for(int i=0; i<fila.size(); i++) {
            Integer elem = fila.dequeue(); // Tira da fila
            lista.add(elem); // coloca na lista
            fila.enqueue(elem); // coloca de volta na fila
        }
    }

    /**
     * Copia o conteúdo da pilha para a fila, mas no final a 
     * pilha deve estar com os mesmos elementos, na mesma ordem.
     */
    public static void copiaParaFila(Queue fila, StackArray pilha) {
        StackArray paux = new StackArray();

        // Copia o conteudo da pilha para paux e para a fila
        while(!pilha.isEmpty()) {
            Integer elem = pilha.pop(); // remove o elemento do topo da pilha p1
            paux.push(elem);
            fila.enqueue(elem);
        }
        // "Devolve" os elementos para a pilha
        while (!paux.isEmpty()) {
            pilha.push(paux.pop());
        }
    }

    /**
     * Recebe duas pilhas por parâmetro e retorna uma lista 
     * concatenando o conteudo das duas pilhas, mas no final 
     * as pilhas devem estar com o seu conteúdo original, isto é, 
     * com os mesmos elementos na mesma ordem.
     */
    public DoubleLinkedListOfInteger concatena(StackArray p1, StackArray p2) {
        DoubleLinkedListOfInteger lista = new DoubleLinkedListOfInteger();
        StackArray paux = new StackArray();

        // Copia o conteudo da p1 para paux e para a lista
        while(!p1.isEmpty()) {
            Integer topo = p1.pop(); // remove o elemento do topo da pilha p1
            paux.push(topo);
            lista.add(topo);
        }
        // "Devolve" os elementos para a p1
        while (!paux.isEmpty()) {
            p1.push(paux.pop());
        }

        // Copia o conteudo da p2 para paux e para a lista
        while(!p2.isEmpty()) {
            Integer topo = p2.pop(); // remove o elemento do topo da pilha p2
            paux.push(topo);
            lista.add(topo);
        }
        // "Devolve" os elementos para a p2
        while (!paux.isEmpty()) {
            p2.push(paux.pop());
        }

        return lista;
    }

}